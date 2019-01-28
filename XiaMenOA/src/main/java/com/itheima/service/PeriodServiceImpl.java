package com.itheima.service;

import com.itheima.domain.TbExceptionMsg;
import com.itheima.domain.TbExceptionMsgExample;
import com.itheima.domain.TbPeriod;
import com.itheima.domain.TbPeriodExample;
import com.itheima.mapper.TbExceptionMsgMapper;
import com.itheima.mapper.TbPeriodMapper;
import com.mchange.v2.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor=Exception.class)
public class PeriodServiceImpl implements PeriodService{

    @Autowired
    private TbPeriodMapper periodMapper;

    @Autowired
    private TbExceptionMsgMapper msgMapper;

    @Override
    public List<TbPeriod> findList() {
        TbPeriodExample example = new TbPeriodExample();
        example.createCriteria().andUsableFlagEqualTo(0);
        return periodMapper.selectByExample(example);
    }

    @Override
    public List<TbPeriod> findByPage() {
        List<TbPeriod> periods = periodMapper.selectByExample(null);
        return periods;
    }

    @Override
    public TbPeriod findOne(Integer pid) {
        return periodMapper.selectByPrimaryKey(pid);
    }

    /**
     * 新增单个阶段信息
     * @param period
     */
    @Override
    public void savePeriod(TbPeriod period) {
        if (period.getPeriodId()!=null){
            //进行更新操作
            //先查询出修改后的阶段名称是否存在,如果存在则修改失败
            TbPeriodExample periodExample = new TbPeriodExample();
            periodExample.createCriteria().andPeriodNameEqualTo(period.getPeriodName());
            List<TbPeriod> periods = periodMapper.selectByExample(periodExample);
            if (periods.size()>0){
                throw new RuntimeException("修改后的阶段名称已经存在,无法继续修改!");
            }

            TbPeriod tbPeriod = periodMapper.selectByPrimaryKey(period.getPeriodId());

            tbPeriod.setPeriodName(period.getPeriodName());
//            tbPeriod.setModifyPerson();
            tbPeriod.setLastUpdateTime(new Date());
            periodMapper.updateByPrimaryKey(tbPeriod);
        }else{
            //非法更新操作
            throw new RuntimeException("更新的信息缺失ID标识!");
        }
    }

    /**
     * 批量上传
     * @param excelFile
     * @param period
     */
    @Override
    public void addPeriod(MultipartFile excelFile, TbPeriod period) throws Exception {

            if(excelFile.getSize()==0&&!StringUtils.nonEmptyString(period.getPeriodName())){
                //
                throw new RuntimeException("未上传文件或新增的信息不完善!");
            }
            //判断是否有上传文件
            if (excelFile.getSize()==0){
                //未上传文件
                //先查询出新增的阶段名称是否存在,如果存在则新增失败
                TbPeriodExample periodExample = new TbPeriodExample();
                periodExample.createCriteria().andPeriodNameEqualTo(period.getPeriodName());
                List<TbPeriod> periods = periodMapper.selectByExample(periodExample);
                if (periods.size()>0){
                    throw new RuntimeException("新增的阶段名称已经存在,无法进行新增操作!");
                }
                periodMapper.insert(period);
            }else{

                //已经上传文件,将之前的记录删除
                periodMapper.truncateTable();
                //异常信息对应的阶段对应的处理
                if (excelFile.getOriginalFilename().endsWith("xls")) {

                    //上传的文件格式是xls类型格式,用hssf进行解析
                    HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
                    HSSFSheet sheet = workbook.getSheetAt(0);

                    //根据excel表格设置班级的相关信息,要求excel格式统一!!
                    for (Row row : sheet) {
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        if (row.getRowNum() < 3) {
                            continue;
                        }
                        if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                            break;
                        }

                        TbPeriod tbPeriod = new TbPeriod();
                        tbPeriod.setPeriodName(row.getCell(1).getStringCellValue());
                        int flag = 0;
                        String usableFlag = row.getCell(2).getStringCellValue();
                        if ("可用".equals(usableFlag)) {
                            flag = 0;
                        } else if ("不可用".equals(usableFlag)) {
                            flag = 1;
                        }
                        tbPeriod.setUsableFlag(flag);
                        tbPeriod.setLastUpdateTime(new Date());
                        //先查询出新增的阶段名称是否存在,如果存在则新增失败
                        TbPeriodExample periodExample = new TbPeriodExample();
                        periodExample.createCriteria().andPeriodNameEqualTo(tbPeriod.getPeriodName());
                        List<TbPeriod> periods = periodMapper.selectByExample(periodExample);
                        if (periods.size()>0){
                            throw new RuntimeException("新增的阶段名称已经存在,无法进行新增操作!");
                        }
                        periodMapper.insert(tbPeriod);
                    }


                }else if(excelFile.getOriginalFilename().endsWith("xlsx")){
                    //上传的文件格式是类型格式,用xssf进行解析
                    XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
                    XSSFSheet sheet = workbook.getSheetAt(0);

                    //根据excel表格设置班级的相关信息,要求excel格式统一!!
                    for (Row row : sheet) {
                        if (row.getRowNum() < 3) {
                            continue;
                        }
                        row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                        if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                            break;
                        }

                        TbPeriod tbPeriod = new TbPeriod();
                        tbPeriod.setPeriodName(row.getCell(1).getStringCellValue());
                        int flag = 0;
                        String usableFlag = row.getCell(2).getStringCellValue();
                        if ("可用".equals(usableFlag)) {
                            flag = 0;
                        } else if ("不可用".equals(usableFlag)) {
                            flag = 1;
                        }
                        tbPeriod.setUsableFlag(flag);
                        tbPeriod.setLastUpdateTime(new Date());
                        //先查询出新增的阶段名称是否存在,如果存在则新增失败
                        TbPeriodExample periodExample = new TbPeriodExample();
                        periodExample.createCriteria().andPeriodNameEqualTo(tbPeriod.getPeriodName());
                        List<TbPeriod> periods = periodMapper.selectByExample(periodExample);
                        if (periods.size()>0){
                            throw new RuntimeException("新增的阶段名称已经存在,无法进行新增操作!");
                        }
                        periodMapper.insert(tbPeriod);
                    }


                }
            }


    }

    @Override
    public int delperiod(Integer bid) {

        //查询bug信息是否包含该阶段
        TbExceptionMsgExample example = new TbExceptionMsgExample();
        example.createCriteria().andPeriodIdEqualTo(bid);
        List<TbExceptionMsg> list = msgMapper.selectByExample(example);

        TbPeriod tbPeriod = periodMapper.selectByPrimaryKey(bid);
        if (tbPeriod.getUsableFlag()==0&&list.size()>0){
            return -1;
        }

        //修改某个阶段的可用状态
        int num=0;
        if (tbPeriod.getUsableFlag()==0){
            num=1;
        }
        tbPeriod.setUsableFlag(num);
        //将bug信息为该阶段的阶段id置为null
        msgMapper.updateByPeriodId(bid);
        periodMapper.updateByPrimaryKey(tbPeriod);
        return num;
    }
}

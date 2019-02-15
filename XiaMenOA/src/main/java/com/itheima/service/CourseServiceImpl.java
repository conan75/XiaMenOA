package com.itheima.service;

import com.itheima.domain.TbCourseTemp;
import com.itheima.mapper.TbCourseTempMapper;
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

import java.io.IOException;
import java.util.Date;

@Service
//这个类里面的方法抛出异常，就会回滚，数据库里面的数据也会回滚
@Transactional(rollbackFor=Exception.class)
public class CourseServiceImpl implements CourseService {

    @Autowired
    private TbCourseTempMapper CourseTempMapper;

    @Override
    public void addPeriod(MultipartFile excelFile) throws IOException {

        if(excelFile.getSize()==0){
            //
            throw new RuntimeException("未上传文件或新增的信息不完善!");
        }
            //已经上传文件,将之前的记录删除
        CourseTempMapper.truncateTable();
            //异常信息对应的阶段对应的处理
            if (excelFile.getOriginalFilename().endsWith("xls")) {

                //上传的文件格式是xls类型格式,用hssf进行解析
                HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
                HSSFSheet sheet = workbook.getSheetAt(0);

                //根据excel表格设置班级的相关信息,要求excel格式统一!!
                for (Row row : sheet) {
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    if (row.getRowNum() < 2) {
                        continue;
                    }
                    if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                        break;
                    }

                    TbCourseTemp tbCourseTemp = new TbCourseTemp();
                    if (row.getCell(2).getStringCellValue().length()>0){
                        //如果阶段id不为空,进行存值操作
                        tbCourseTemp.setPeriodId(Integer.parseInt(row.getCell(2).getStringCellValue()));
                    }
                    //设置课程名称
                    tbCourseTemp.setCourseName(row.getCell(3).getStringCellValue());

                    //设置是否课程大纲
                    if (row.getCell(4).getStringCellValue().length()>0){
                        int isOutline=0;
                        if ("否".equals(row.getCell(4).getStringCellValue())){
                            isOutline=1;
                        }
                        tbCourseTemp.setIsOutline(isOutline);
                    }

                    //设置是否阶段考试
                    if (row.getCell(5).getStringCellValue().length()>0){
                        int isPeriodExam=0;
                        if ("否".equals(row.getCell(5).getStringCellValue())){
                            isPeriodExam=1;
                        }
                        tbCourseTemp.setIsPeriodexam(isPeriodExam);
                    }

                    //设置备注
                    tbCourseTemp.setRemarks(row.getCell(8).getStringCellValue());
                    tbCourseTemp.setCreateTime(new Date());
                    tbCourseTemp.setLastUpdateTime(new Date());
                    tbCourseTemp.setUsableFlag(0);

                    CourseTempMapper.insert(tbCourseTemp);
                }


            }else if(excelFile.getOriginalFilename().endsWith("xlsx")){
                //上传的文件格式是类型格式,用xssf进行解析
                XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
                XSSFSheet sheet = workbook.getSheetAt(0);

                //根据excel表格设置班级的相关信息,要求excel格式统一!!
                for (Row row : sheet) {
                    row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                    row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                    if (row.getRowNum() < 2) {
                        continue;
                    }
                    if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                        break;
                    }

                    TbCourseTemp tbCourseTemp = new TbCourseTemp();
                    if (row.getCell(2).getStringCellValue().length()>0){
                        //如果阶段id不为空,进行存值操作
                        tbCourseTemp.setPeriodId(Integer.parseInt(row.getCell(2).getStringCellValue()));
                    }
                    //设置课程名称
                    tbCourseTemp.setCourseName(row.getCell(3).getStringCellValue());

                    //设置是否课程大纲
                    if (row.getCell(4).getStringCellValue().length()>0){
                        int isOutline=0;
                        if ("否".equals(row.getCell(4).getStringCellValue())){
                            isOutline=1;
                        }
                        tbCourseTemp.setIsOutline(isOutline);
                    }

                    //设置是否阶段考试
                    if (row.getCell(5).getStringCellValue().length()>0){
                        int isPeriodExam=0;
                        if ("否".equals(row.getCell(5).getStringCellValue())){
                            isPeriodExam=1;
                        }
                        tbCourseTemp.setIsPeriodexam(isPeriodExam);
                    }

                    //设置备注
                    tbCourseTemp.setRemarks(row.getCell(8).getStringCellValue());
                    tbCourseTemp.setCreateTime(new Date());
                    tbCourseTemp.setLastUpdateTime(new Date());
                    tbCourseTemp.setUsableFlag(0);
                    CourseTempMapper.insert(tbCourseTemp);

                }

        }
    }
}

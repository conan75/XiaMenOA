package com.itheima.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.util.StringUtil;
import com.itheima.domain.TbAsset;
import com.itheima.domain.TbAssetExample;
import com.itheima.domain.TbAssetType;
import com.itheima.domain.TbAssetTypeExample;
import com.itheima.mapper.TbAssetMapper;
import com.itheima.mapper.TbAssetTypeMapper;
import com.itheima.utils.AssetMsgs;
import com.itheima.utils.AssetSearch;
import com.itheima.utils.PageResult;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AssetServiceImpl implements AssetService {

    @Autowired
    private TbAssetMapper tbAssetMapper;

    @Autowired
    private TbAssetTypeMapper assetTypeMapper;

    @Override
    public PageResult findByPage() {
        TbAssetExample example = new TbAssetExample();
//        example.createCriteria().andUsableFlagEqualTo(0);
        example.setOrderByClause("purchase_date desc");
        Page page = (Page) tbAssetMapper.selectByExample(example);
        List assetMsgs = findAssetMsgs(page.getResult());
        return new PageResult(page.getTotal(),assetMsgs);
    }

    /**
     * 导入固定资产
     *
     * @param excelFile
     */
    @Override
    public void fixedAssetImport(MultipartFile excelFile) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        //固定资产id为1
        int parentId=1;
        //判断文件类型
        if (excelFile.getOriginalFilename().endsWith("xls")) {

            //上传的文件格式是xls类型格式,用hssf进行解析
            HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
            HSSFSheet sheet = workbook.getSheetAt(0);

            //根据excel表格设置班级的相关信息,要求excel格式统一!!
            for (Row row : sheet) {
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
                if (row.getRowNum() < 2) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }

                TbAsset asset = new TbAsset();
                //类别名称
                asset.setTypeName(row.getCell(1).getStringCellValue());
                //设置类型id
                Integer typeId=assetTypeMapper.selectIdByTypeName(row.getCell(1).getStringCellValue(),parentId);
                asset.setTypeId(typeId);

                //资产编号
                asset.setAssetCode(row.getCell(2).getStringCellValue());
                //资产名称
                asset.setAssetName(row.getCell(3).getStringCellValue());
                //购置日期
                try {
                    asset.setPurchaseDate(dateFormat.parse(row.getCell(4).getStringCellValue()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //规格类型
                asset.setModelNum(row.getCell(5).getStringCellValue());
                //数量
                asset.setPurchaseNumber(Integer.parseInt(row.getCell(6).getStringCellValue()));
                //计量单位
                asset.setUnit(row.getCell(7).getStringCellValue());
                //单价
                asset.setPrice(BigDecimal.valueOf(Double.parseDouble(row.getCell(8).getStringCellValue())));
                //金额
                asset.setTotalMoney(BigDecimal.valueOf(Double.parseDouble(row.getCell(9).getStringCellValue())));
                //使用部门
                asset.setUseDepartment(row.getCell(10).getStringCellValue());
                //使用人
                asset.setUsePerson(row.getCell(11).getStringCellValue());
                //使用状态
                String useStatus = row.getCell(12).getStringCellValue();
                if ("未使用".equals(useStatus)) {
                    asset.setUseStatus(0);
                } else {
                    asset.setUseStatus(1);
                }
                //存放位置
                asset.setDepositPlace(row.getCell(13).getStringCellValue());
                //备注
                asset.setRemarks(row.getCell(14).getStringCellValue());
                asset.setLastUpdateTime(new Date());
                asset.setUsableFlag(0);
                tbAssetMapper.insert(asset);
            }

        } else if (excelFile.getOriginalFilename().endsWith("xlsx")) {
            //上传的文件格式是类型格式,用xssf进行解析
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            //根据excel表格设置班级的相关信息,要求excel格式统一!!
            //根据excel表格设置班级的相关信息,要求excel格式统一!!
            for (Row row : sheet) {
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);
                if (row.getRowNum() < 2) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }

                TbAsset asset = new TbAsset();
                //类别名称
                asset.setTypeName(row.getCell(1).getStringCellValue());

                //设置类型id
                Integer typeId=assetTypeMapper.selectIdByTypeName(row.getCell(1).getStringCellValue(),parentId);
                asset.setTypeId(typeId);
                //资产编号
                asset.setAssetCode(row.getCell(2).getStringCellValue());
                //资产名称
                asset.setAssetName(row.getCell(3).getStringCellValue());
                //购置日期
                try {
                    asset.setPurchaseDate(dateFormat.parse(row.getCell(4).getStringCellValue()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //规格类型
                asset.setModelNum(row.getCell(5).getStringCellValue());
                //数量
                asset.setPurchaseNumber(Integer.parseInt(row.getCell(6).getStringCellValue()));
                //计量单位
                asset.setUnit(row.getCell(7).getStringCellValue());
                //单价
                asset.setPrice(BigDecimal.valueOf(Double.parseDouble(row.getCell(8).getStringCellValue())));
                //金额
                asset.setTotalMoney(BigDecimal.valueOf(Double.parseDouble(row.getCell(9).getStringCellValue())));
                //使用部门
                asset.setUseDepartment(row.getCell(8).getStringCellValue());
                //使用人
                asset.setUsePerson(row.getCell(9).getStringCellValue());
                //使用状态
                String useStatus = row.getCell(10).getStringCellValue();
                if ("未使用".equals(useStatus)) {
                    asset.setUseStatus(0);
                } else {
                    asset.setUseStatus(1);
                }
                //存放位置
                asset.setDepositPlace(row.getCell(11).getStringCellValue());
                //备注
                asset.setRemarks(row.getCell(12).getStringCellValue());
                asset.setLastUpdateTime(new Date());
                asset.setUsableFlag(0);
                tbAssetMapper.insert(asset);
            }
        }
    }

    /**
     * 导入低值资产
     *
     * @param excelFile
     */
    @Override
    public void lowAssetImport(MultipartFile excelFile) throws IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int parentId=2;
        //判断文件类型
        if (excelFile.getOriginalFilename().endsWith("xls")) {

            //上传的文件格式是xls类型格式,用hssf进行解析
            HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
                if (row.getRowNum() < 3) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }

                TbAsset asset = new TbAsset();
                //类别名称
                asset.setTypeName(row.getCell(2).getStringCellValue());
                //设置类型id
                Integer typeId=assetTypeMapper.selectIdByTypeName(row.getCell(2).getStringCellValue(),parentId);
                asset.setTypeId(typeId);
                //资产编号
                asset.setAssetCode(row.getCell(3).getStringCellValue());
                //资产名称
                asset.setAssetName(row.getCell(4).getStringCellValue());
                //规格类型
                asset.setModelNum(row.getCell(5).getStringCellValue());
                //使用部门
                asset.setUseDepartment(row.getCell(6).getStringCellValue());
                //使用状态
                String useStatus = row.getCell(7).getStringCellValue();
                if ("未使用".equals(useStatus)) {
                    asset.setUseStatus(0);
                } else {
                    asset.setUseStatus(1);
                }
                //购置日期
                try {
                    asset.setPurchaseDate(dateFormat.parse(row.getCell(8).getStringCellValue()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //计量单位
                asset.setUnit(row.getCell(9).getStringCellValue());
                //单价
                asset.setPrice(BigDecimal.valueOf(Double.parseDouble(row.getCell(10).getStringCellValue())));

                //备注
                asset.setRemarks(row.getCell(11).getStringCellValue());
                asset.setLastUpdateTime(new Date());
                asset.setUsableFlag(0);
                tbAssetMapper.insert(asset);
            }

        } else if (excelFile.getOriginalFilename().endsWith("xlsx")) {
            //上传的文件格式是类型格式,用xssf进行解析
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);

            //根据excel表格设置班级的相关信息,要求excel格式统一!!
            for (Row row : sheet) {
                row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);
                row.getCell(11).setCellType(Cell.CELL_TYPE_STRING);
                if (row.getRowNum() < 3) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }

                TbAsset asset = new TbAsset();
                //类别名称
                asset.setTypeName(row.getCell(2).getStringCellValue());
                //设置类型id
                Integer typeId=assetTypeMapper.selectIdByTypeName(row.getCell(2).getStringCellValue(),parentId);
                asset.setTypeId(typeId);
                //资产编号
                asset.setAssetCode(row.getCell(3).getStringCellValue());
                //资产名称
                asset.setAssetName(row.getCell(4).getStringCellValue());
                //规格类型
                asset.setModelNum(row.getCell(5).getStringCellValue());
                //使用部门
                asset.setUseDepartment(row.getCell(6).getStringCellValue());
                //使用状态
                String useStatus = row.getCell(7).getStringCellValue();
                if ("未使用".equals(useStatus)) {
                    asset.setUseStatus(0);
                } else {
                    asset.setUseStatus(1);
                }
                //购置日期
                try {
                    asset.setPurchaseDate(dateFormat.parse(row.getCell(8).getStringCellValue()));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                //计量单位
                asset.setUnit(row.getCell(9).getStringCellValue());
                //单价
                asset.setPrice(BigDecimal.valueOf(Double.parseDouble(row.getCell(10).getStringCellValue())));

                //备注
                asset.setRemarks(row.getCell(11).getStringCellValue());
                asset.setLastUpdateTime(new Date());
                asset.setUsableFlag(0);
                tbAssetMapper.insert(asset);
            }
        }
    }

    /**
     * 导入资产类别
     * @param excelFile
     * @throws IOException
     */
    @Override
    public void assetTypeImport(MultipartFile excelFile) throws IOException {
        //判断文件类型
        if (excelFile.getOriginalFilename().endsWith("xls")) {

            //上传的文件格式是xls类型格式,用hssf进行解析
            HSSFWorkbook workbook = new HSSFWorkbook(excelFile.getInputStream());
            //开始导入固定资产类别明细
            HSSFSheet sheet = workbook.getSheetAt(0);
            assetTypeMapper.truncate();
            int maxId=0;
            //初始化两大分支(固定资产/低值资产)
            TbAssetType tbassetType=new TbAssetType();
            tbassetType.setTypeName("固定资产");
            tbassetType.setUsableFlag(0);
            tbassetType.setLastUpdateTime(new Date());
            assetTypeMapper.insert(tbassetType);
            tbassetType=new TbAssetType();
            tbassetType.setTypeName("低值资产");
            tbassetType.setUsableFlag(0);
            tbassetType.setLastUpdateTime(new Date());
            assetTypeMapper.insert(tbassetType);

            for (Row row : sheet) {
                if (row.getRowNum() < 2) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }


                //
                String typeName = row.getCell(0).getStringCellValue();
                int count=assetTypeMapper.selectTypeName(typeName,1);
                if (count==0){
                    //该二级标题为第一次添加
                    TbAssetType assetType=new TbAssetType();
                    assetType.setTypeName(typeName);
                    assetType.setParentId(1);
                    assetType.setUsableFlag(0);
                    assetType.setLastUpdateTime(new Date());
                    assetTypeMapper.insert(assetType);
                    maxId=assetTypeMapper.selectMaxId();
                }

                TbAssetType assetType=new TbAssetType();
                //类别名称
                assetType.setTypeName(row.getCell(1).getStringCellValue());
                //设置父类id
                assetType.setParentId(maxId);
                assetType.setUsableFlag(0);
                assetType.setLastUpdateTime(new Date());
                assetTypeMapper.insert(assetType);
            }
            //开始导入低值资产类别明细
            sheet = workbook.getSheetAt(1);
            maxId=0;

            for (Row row : sheet) {
                if (row.getRowNum() < 2) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }


                //
                String typeName = row.getCell(0).getStringCellValue();
                int count=assetTypeMapper.selectTypeName(typeName,2);
                if (count==0){
                    //该二级标题为第一次添加
                    TbAssetType assetType=new TbAssetType();
                    assetType.setTypeName(typeName);
                    assetType.setParentId(2);
                    assetType.setUsableFlag(0);
                    assetType.setLastUpdateTime(new Date());
                    assetTypeMapper.insert(assetType);
                    maxId=assetTypeMapper.selectMaxId();
                }

                TbAssetType assetType=new TbAssetType();
                //类别名称
                assetType.setTypeName(row.getCell(1).getStringCellValue());
                //设置父类id
                assetType.setParentId(maxId);
                assetType.setUsableFlag(0);
                assetType.setLastUpdateTime(new Date());
                assetTypeMapper.insert(assetType);
            }

        } else if (excelFile.getOriginalFilename().endsWith("xlsx")) {
            //上传的文件格式是类型格式,用xssf进行解析
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream());
            XSSFSheet sheet = workbook.getSheetAt(0);
            assetTypeMapper.truncate();
            int maxId=0;

            //初始化两大分支(固定资产/低值资产)
            TbAssetType tbassetType=new TbAssetType();
            tbassetType.setTypeName("固定资产");
            tbassetType.setUsableFlag(0);
            tbassetType.setLastUpdateTime(new Date());
            assetTypeMapper.insert(tbassetType);
            tbassetType=new TbAssetType();
            tbassetType.setTypeName("低值资产");
            tbassetType.setUsableFlag(0);
            tbassetType.setLastUpdateTime(new Date());
            assetTypeMapper.insert(tbassetType);

            for (Row row : sheet) {
                if (row.getRowNum() < 2) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }


                //
                String typeName = row.getCell(0).getStringCellValue();
                int count=assetTypeMapper.selectTypeName(typeName,1);
                if (count==0){
                    //该二级标题为第一次添加
                    TbAssetType assetType=new TbAssetType();
                    assetType.setTypeName(typeName);
                    assetType.setParentId(1);
                    assetType.setUsableFlag(0);
                    assetType.setLastUpdateTime(new Date());
                    assetTypeMapper.insert(assetType);
                    maxId=assetTypeMapper.selectMaxId();
                }

                TbAssetType assetType=new TbAssetType();
                //类别名称
                assetType.setTypeName(row.getCell(1).getStringCellValue());
                //设置父类id
                assetType.setParentId(maxId);
                assetType.setUsableFlag(0);
                assetType.setLastUpdateTime(new Date());
                assetTypeMapper.insert(assetType);
            }
            //开始导入低值资产类别明细
            sheet = workbook.getSheetAt(1);
            maxId=0;

            for (Row row : sheet) {
                if (row.getRowNum() < 2) {
                    continue;
                }
                if (row.getCell(0) == null || !StringUtils.nonEmptyString(row.getCell(0).getStringCellValue())) {
                    break;
                }


                //
                String typeName = row.getCell(0).getStringCellValue();
                int count=assetTypeMapper.selectTypeName(typeName,2);
                if (count==0){
                    //该二级标题为第一次添加
                    TbAssetType assetType=new TbAssetType();
                    assetType.setTypeName(typeName);
                    assetType.setParentId(2);
                    assetType.setUsableFlag(0);
                    assetType.setLastUpdateTime(new Date());
                    assetTypeMapper.insert(assetType);
                    maxId=assetTypeMapper.selectMaxId();
                }

                TbAssetType assetType=new TbAssetType();
                //类别名称
                assetType.setTypeName(row.getCell(1).getStringCellValue());
                //设置父类id
                assetType.setParentId(maxId);
                assetType.setUsableFlag(0);
                assetType.setLastUpdateTime(new Date());
                assetTypeMapper.insert(assetType);
            }
        }
    }

    /**
     * 与findPage方法对应,是为了找出资产所属的类别
     * @param oldList
     * @return
     */
    @Override
    public List findAssetMsgs(List<TbAsset> oldList) {
        List list = new ArrayList<>();
        for (TbAsset asset : oldList) {
            AssetMsgs assetMsgs = new AssetMsgs();
            assetMsgs.setAsset(asset);
            //找出该资产的二级所属类型
            Integer parentId=assetTypeMapper.selectParentIdById(asset.getTypeId());
            TbAssetTypeExample example = new TbAssetTypeExample();
            example.createCriteria().andTypeIdEqualTo(parentId);
            TbAssetType assetType=assetTypeMapper.selectByExample(example).get(0);
            assetMsgs.setAssetType(assetType);
            list.add(assetMsgs);
        }
        return list;
    }

    @Override
    public PageResult search(AssetSearch assetSearch, List<Integer> idList) {
        TbAssetExample assetExample = new TbAssetExample();
        TbAssetExample.Criteria criteria = assetExample.createCriteria();
        assetExample.setOrderByClause("purchase_date desc");
//        criteria.andUsableFlagEqualTo(0);
        if (!StringUtil.isEmpty(assetSearch.getUseDepartment())&&!"-1".equals(assetSearch.getUseDepartment())){
            //使用部门不为空
            criteria.andUseDepartmentEqualTo(assetSearch.getUseDepartment());
        }
        if (!StringUtil.isEmpty(assetSearch.getTypeName())&&!"-1".equals(assetSearch.getTypeName())){
            //类型名称不为空(固定资产,低值资产)
            criteria.andTypeIdIn(idList);
        }
        if (assetSearch.getUseStatus()!=null&&assetSearch.getUseStatus()!=-1){
            //使用状态不为空
            criteria.andUseStatusEqualTo(assetSearch.getUseStatus());
        }
        if(!StringUtil.isEmpty(assetSearch.getAssetCode())){
            //资产编码不为空
            criteria.andAssetCodeEqualTo(assetSearch.getAssetCode().trim());
        }
        if (!StringUtil.isEmpty(assetSearch.getAssetName())){
            //资产名称不为空
            criteria.andAssetNameLike("%"+assetSearch.getAssetName().trim()+"%");
        }
        if (!StringUtil.isEmpty(assetSearch.getUsePerson())){
            //使用人不为空
            criteria.andUsePersonLike("%"+assetSearch.getUsePerson().trim()+"%");
        }
        if (assetSearch.getStartDate()!=null){
            //开始日期不为空
            criteria.andPurchaseDateGreaterThan(assetSearch.getStartDate());
        }
        if (assetSearch.getEndDate()!=null){
            //结束日期不为空
            criteria.andPurchaseDateLessThan(assetSearch.getEndDate());
        }
        if (!StringUtil.isEmpty(assetSearch.getModelNum())){
            //型号不为空
            criteria.andModelNumLike("%"+assetSearch.getModelNum().trim()+"%");
        }
        Page page = (Page) tbAssetMapper.selectByExample(assetExample);
        List assetMsgs = findAssetMsgs(page.getResult());
        return new PageResult(page.getTotal(),assetMsgs);
    }

    /**
     * 该方法与search方法对应,是为了消除搜索无法分页的bug
     * @param
     * @return
     */
    @Override
    public List<Integer> selectAllByParentId(String typeName) {
        TbAssetTypeExample typeExample = new TbAssetTypeExample();
        if("固定资产".equals(typeName)){
            typeExample.createCriteria().andParentIdEqualTo(1);
        }else if("低值资产".equals(typeName)){
            typeExample.createCriteria().andParentIdEqualTo(2);
        }
        //先查出所有的二级类别,并存储id于新的集合中
        List<TbAssetType> assetTypes = assetTypeMapper.selectByExample(typeExample);
        ArrayList<Integer> list = new ArrayList<>();
        for (TbAssetType assetType : assetTypes) {
            list.add(assetType.getTypeId());
        }
        return list;
    }

    /**
     * 根据类型Id获取类型列表
     * @param idList
     * @return
     */
    @Override
    public List<TbAssetType> selectAllByIdList(List<Integer> idList) {
        List<TbAssetType> list = new ArrayList<>();
        for (Integer typeId : idList) {
            TbAssetTypeExample typeExample = new TbAssetTypeExample();
            typeExample.createCriteria().andTypeIdEqualTo(typeId);
            TbAssetType assetType = assetTypeMapper.selectByExample(typeExample).get(0);
            list.add(assetType);
        }
        return list;
    }

    /**
     * 获取三级类别名称
     * @param secondList
     * @param secondTypeName
     * @return
     */
    @Override
    public List<TbAssetType> selectAllByIdList(List<TbAssetType> secondList, Integer secondTypeName) {
        List<TbAssetType> list=new ArrayList<>();
        for (TbAssetType assetType : secondList) {
            if (assetType.getTypeId()==secondTypeName){
                TbAssetTypeExample typeExample = new TbAssetTypeExample();
                typeExample.createCriteria().andParentIdEqualTo(assetType.getTypeId());
                list = assetTypeMapper.selectByExample(typeExample);
                break;
            }
        }
        return list;
    }

    /**
     * 新增资产信息
     * @param asset
     */
    @Override
    public void assetAdd(TbAsset asset) {
        if (asset.getPurchaseNumber()!=null){
            asset.setTotalMoney(asset.getPrice().multiply(new BigDecimal(asset.getPurchaseNumber())));
        }else{
            asset.setTotalMoney(asset.getPrice());
        }
        asset.setUsableFlag(0);
        asset.setLastUpdateTime(new Date());
        if (asset.getId()!=null){
            tbAssetMapper.updateByPrimaryKey(asset);
        }else{
            tbAssetMapper.insert(asset);
        }

    }

    /**
     * 根据id查找资产信息
     * @param id
     * @return
     */
    @Override
    public TbAsset findOne(Integer id) {
        return tbAssetMapper.selectByPrimaryKey(id);
    }

    /**
     * 查找单个资产信息的资产类别以及其他资产信息
     * @param asset
     * @return
     */
    @Override
    public AssetMsgs findAssetMsgs(TbAsset asset) {
        List list = new ArrayList<>();
        AssetMsgs assetMsgs = new AssetMsgs();
        assetMsgs.setAsset(asset);
        //找出该资产的二级所属类型
        Integer parentId=assetTypeMapper.selectParentIdById(asset.getTypeId());
        TbAssetTypeExample example = new TbAssetTypeExample();
        example.createCriteria().andTypeIdEqualTo(parentId);
        TbAssetType assetType=assetTypeMapper.selectByExample(example).get(0);
        assetMsgs.setAssetType(assetType);
        return assetMsgs;
    }

    /**
     * 修改资产状态
     * @param id
     * @param useableFlag
     */
    @Override
    public void del(Integer id, Integer useableFlag) {
        TbAsset asset = tbAssetMapper.selectByPrimaryKey(id);
        if (useableFlag == 0) {
            asset.setUsableFlag(1);
        } else {
            asset.setUsableFlag(0);
        }
        asset.setLastUpdateTime(new Date());
        tbAssetMapper.updateByPrimaryKey(asset);
    }
}

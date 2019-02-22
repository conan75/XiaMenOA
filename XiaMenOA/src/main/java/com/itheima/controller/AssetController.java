package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.itheima.domain.TbAsset;
import com.itheima.domain.TbAssetType;
import com.itheima.service.AssetService;
import com.itheima.utils.AssetMsgs;
import com.itheima.utils.AssetSearch;
import com.itheima.utils.AssetTypeVo;
import com.itheima.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/asset")
public class AssetController {

    @Autowired
    private AssetService assetService;

    /**
     * 分页展示所有资产信息,默认分页数为10
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/findByPage.do")
    public PageResult findByPage(@RequestParam(required = false, defaultValue = "1", value = "page") Integer page,Integer rows) {
        PageHelper.startPage(page, rows);
        //pageHelper默认只对上述语句进行分页,需要设置完pageInfo后再修改里面存放的list,否则pageInfo中的total属性会存在问题(也就是说pagehelper只会对上述语句后的第一条查询进行分页)
        PageResult pageResult = assetService.findByPage();
        return pageResult;
    }

    /**
     * 导入固定资产模板
     * @param excelFile
     * @return
     */
    @ResponseBody
    @RequestMapping("/fixedAssetImport.do")
    public String fixedAssetImport(MultipartFile excelFile){
        try {
            assetService.fixedAssetImport(excelFile);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 导入低资产模板
     * @param excelFile
     * @return
     */
    @ResponseBody
    @RequestMapping("/lowAssetImport.do")
    public String lowAssetImport(MultipartFile excelFile){
        try {
            assetService.lowAssetImport(excelFile);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 资产类别初始化
     * @param excelFile
     * @return
     */
    @ResponseBody
    @RequestMapping("/assetTypeImport.do")
    public String assetTypeImport(MultipartFile excelFile){
        try {
            assetService.assetTypeImport(excelFile);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 查找二级分类
     * @return
     */
    @ResponseBody
    @RequestMapping("/findSecondType.do")
    public List<TbAssetType> findSecondType(String typeName){
        try {
            List<Integer> idList=assetService.selectAllByParentId(typeName);
            List<TbAssetType> list=assetService.selectAllByIdList(idList);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查找三级分类
     * @return
     */
    @ResponseBody
    @RequestMapping("/findThirdType.do")
    public List<TbAssetType> findThirdType(AssetTypeVo assetTypeVo, Integer secondTypeName){
        try {
            List<TbAssetType> list=assetService.selectAllByIdList(assetTypeVo.getSecondList(),secondTypeName);
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 新增资产
     * @return
     */
    @ResponseBody
    @RequestMapping("/assetAdd.do")
    public String assetAdd(TbAsset asset){
        try {
            assetService.assetAdd(asset);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 更改资产状态
     * @return
     */
    @ResponseBody
    @RequestMapping("/del.do")
    public String assetAdd(Integer id,Integer useableFlag){
        try {
            assetService.del(id,useableFlag);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 查找单个资产信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/findOne.do")
    public AssetMsgs findOne(Integer id){
        try {
            TbAsset asset=assetService.findOne(id);
            AssetMsgs assetMsgs = assetService.findAssetMsgs(asset);
            return assetMsgs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据条件进行搜索
     * @return
     */
    @ResponseBody
    @RequestMapping("/search.do")
    public PageResult search(@RequestBody AssetSearch assetSearch, @RequestParam(required = false, defaultValue = "1", value = "page") Integer page, Integer rows){
        List<Integer> idList=assetService.selectAllByParentId(assetSearch.getTypeName());
        PageHelper.startPage(page, rows);
        //pageHelper默认只对上述语句后的第一条sql进行分页
        PageResult pageResult = assetService.search(assetSearch ,idList);
        return pageResult;
    }

}

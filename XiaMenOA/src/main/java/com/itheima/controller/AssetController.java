package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.itheima.domain.TbAsset;
import com.itheima.service.AssetService;
import com.itheima.utils.AssetSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn) {
        PageHelper.startPage(pn, 10);
        //pageHelper默认只对上述语句进行分页,需要设置完pageInfo后再修改里面存放的list,否则pageInfo中的total属性会存在问题(也就是说pagehelper只会对上述语句后的第一条查询进行分页)
        List<TbAsset> list = assetService.findByPage();
        PageInfo pageInfo = new PageInfo<>(list, 10);
        pageInfo.setList(assetService.findAssetMsgs(list));
        model.addAttribute("assets", pageInfo);
        return "assetPage";
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
     * 根据条件进行搜索
     * @return
     */
    @ResponseBody
    @RequestMapping("/search.do")
    public String search(AssetSearch assetSearch){
        assetSearch.setAssetCode(assetSearch.getAssetCode().trim());
        assetSearch.setAssetName(assetSearch.getAssetName().trim());
        assetSearch.setUsePerson(assetSearch.getUsePerson().trim());
        assetSearch.setModelNum(assetSearch.getModelNum().trim());
        if ("-1".equals(assetSearch.getUseDepartment())
                &&"-1".equals(assetSearch.getTypeName())
                &&assetSearch.getUseStatus()==-1
                &&StringUtil.isEmpty(assetSearch.getAssetCode())
                &&StringUtil.isEmpty(assetSearch.getAssetName())
                &&StringUtil.isEmpty(assetSearch.getUsePerson())
                &&assetSearch.getStartDate()==null
                &&assetSearch.getEndDate()==null
                &&StringUtil.isEmpty(assetSearch.getModelNum())
                ){
            //当查询条件为空时,重定向去查询全部
            return "redirect:/asset/findByPage.do";
        }
//        PageHelper.startPage(pn, 10);
//        //pageHelper默认只对上述语句进行分页,需要设置完pageInfo后再修改里面存放的list,否则pageInfo中的total属性会存在问题
//        List<TbExceptionMsg> list = bugMsgService.search(bugSearch);
//        PageInfo pageInfo = new PageInfo<>(list, 10);
//        pageInfo.setList(bugMsgService.findBugMsgs(list));
//        model.addAttribute("bugMsgs", pageInfo);
//        model.addAttribute("bugSearch",bugSearch);
//        return "bugMsgPage";
        return null;
    }

}

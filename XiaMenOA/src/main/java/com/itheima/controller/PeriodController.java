package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.domain.TbPeriod;
import com.itheima.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/period")
public class PeriodController {

    @Autowired
    private PeriodService periodService;

    @RequestMapping("/findList.do")
    @ResponseBody
    public List<TbPeriod> findList(){
        return periodService.findList();
    }

    /**
     * 分页查询阶段信息
     * @param model
     * @param pn
     * @return
     */
    @RequestMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn){
        PageHelper.startPage(pn, 10);
        List<TbPeriod> list = periodService.findByPage();
        PageInfo pageInfo = new PageInfo(list,10);
        model.addAttribute("periods", pageInfo);
        return "periodPage";
    }

    @ResponseBody
    @RequestMapping("/findOne.do")
    public TbPeriod findOne(Integer pid){
           return periodService.findOne(pid);
    }

    /**
     * 更新
     * @param period
     * @return
     */
    @ResponseBody
    @RequestMapping("/savePeriod.do")
    public String savePeriod(TbPeriod period){
        try {
            periodService.savePeriod(period);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 保存,更新
     * @param period
     * @return
     */
    @ResponseBody
    @RequestMapping("/addPeriod.do")
    public String addPeriod(MultipartFile excelFile, TbPeriod period){
        try {
            periodService.addPeriod(excelFile,period);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping("/del.do")
    public String delperiod(Integer bid) {
        try {
            int num=periodService.delperiod(bid);
            return num+"";
        } catch (Exception e) {
            return "-1";
        }
    }
}

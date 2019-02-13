package com.itheima.controller;

import com.itheima.service.CourseService;
import com.itheima.utils.CourseImport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    /**
     * 分页查询课程表信息
     * @param model
     * @param pn
     * @return
     */
    @RequestMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn){
//        PageHelper.startPage(pn, 10);
//        List<TbPeriod> list = periodService.findByPage();
//        PageInfo pageInfo = new PageInfo(list,10);
//        model.addAttribute("periods", pageInfo);
        return "coursePage";
    }

    /**
     * 导入课程表模板信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/modelImport.do")
    public String modelImport(MultipartFile excelFile){
        try {
            courseService.addPeriod(excelFile);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 新增课程表模板信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/courseAdd.do")
    public String courseAdd(CourseImport courseImport){
        try {
            System.out.println(courseImport);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "";
        }
    }

}

package com.itheima.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.itheima.domain.TbExceptionMsg;
import com.itheima.service.BugMsgService;
import com.itheima.utils.BugMsgs;
import com.itheima.utils.BugSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/bug")
public class BugMsgController {

    @Autowired
    private BugMsgService bugMsgService;

    @Autowired
    ArrayList<String> list;

    @RequestMapping("/findList.do")
    public String findList() {
        return "bugMsgPage";
    }

    /**
     * 分页展示所有Bug信息,默认分页数为10
     *
     * @return
     */
    @RequestMapping("/findByPage.do")
    public String findByPage(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn) {
        PageHelper.startPage(pn, 10);
        //pageHelper默认只对上述语句进行分页,需要设置完pageInfo后再修改里面存放的list,否则pageInfo中的total属性会存在问题
        List<TbExceptionMsg> list = bugMsgService.findByPage();
        PageInfo pageInfo = new PageInfo<>(list, 10);
        pageInfo.setList(bugMsgService.findBugMsgs(list));
        model.addAttribute("bugMsgs", pageInfo);
        return "bugMsgPage";
    }

    /**
     * 根据Bug信息的Id查找指定信息
     *
     * @param bid
     * @return
     */
    @ResponseBody
    @RequestMapping("/findOne.do")
    public BugMsgs findOne(Integer bid) {
        list.clear();
        return bugMsgService.findOne(bid);
    }

    /**
     * 保存相关bug信息
     *
     * @param exceptionMsg
     * @return
     */
    @ResponseBody
    @RequestMapping("/savebugMsg.do")
    public String savebugMsg(TbExceptionMsg exceptionMsg) {
        list.clear();
//        System.out.println(exceptionMsg);
        try {
            bugMsgService.savebugMsg(exceptionMsg);
            return "true";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 删除指定id信息
     * @param bid
     * @return
     */
    @ResponseBody
    @RequestMapping("/del.do")
    public String delbugMsg(Integer bid) {
        try {
            bugMsgService.delbugMsg(bid);
            return "success";
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 分页展示所有Bug信息,默认分页数为10
     *
     * @return
     */
    @RequestMapping("/search.do")
    public String search(Model model, @RequestParam(required = false, defaultValue = "1", value = "pn") Integer pn, BugSearch bugSearch) {

        bugSearch.setExceptionCondition(bugSearch.getExceptionCondition().trim());
        if ("-1".equals(bugSearch.getPeriodCondition())&& StringUtil.isEmpty(bugSearch.getExceptionCondition())){
            //当查询条件为空时,重定向去查询全部
            return "redirect:/bug/findByPage.do";
        }
        PageHelper.startPage(pn, 10);
        //pageHelper默认只对上述语句进行分页,需要设置完pageInfo后再修改里面存放的list,否则pageInfo中的total属性会存在问题
        List<TbExceptionMsg> list = bugMsgService.search(bugSearch);
        PageInfo pageInfo = new PageInfo<>(list, 10);
        pageInfo.setList(bugMsgService.findBugMsgs(list));
        model.addAttribute("bugMsgs", pageInfo);
        model.addAttribute("bugSearch",bugSearch);
        return "bugMsgPage";
    }

}

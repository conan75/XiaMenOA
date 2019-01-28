package com.itheima.service;

import com.itheima.domain.TbExceptionMsg;
import com.itheima.utils.BugMsgs;
import com.itheima.utils.BugSearch;

import java.util.List;

public interface BugMsgService {
    List<TbExceptionMsg> findByPage();

    BugMsgs findOne(Integer bid);

    void savebugMsg(TbExceptionMsg exceptionMsg);

    void delbugMsg(Integer bid);

    List findBugMsgs(List<TbExceptionMsg> list);

    List<TbExceptionMsg> search(BugSearch bugSearch);
}

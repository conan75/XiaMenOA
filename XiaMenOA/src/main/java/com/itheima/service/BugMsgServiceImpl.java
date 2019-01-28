package com.itheima.service;

import com.github.pagehelper.util.StringUtil;
import com.itheima.domain.TbExceptionMsg;
import com.itheima.domain.TbExceptionMsgExample;
import com.itheima.domain.TbPeriod;
import com.itheima.mapper.TbExceptionMsgMapper;
import com.itheima.mapper.TbPeriodMapper;
import com.itheima.utils.BugMsgs;
import com.itheima.utils.BugSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BugMsgServiceImpl implements BugMsgService {

    @Autowired
    private TbExceptionMsgMapper msgMapper;

    @Autowired
    private TbPeriodMapper periodMapper;

    @Override
    public List<TbExceptionMsg> findByPage() {
        TbExceptionMsgExample msgExample = new TbExceptionMsgExample();
        msgExample.createCriteria().andUsableFlagEqualTo(0);
        msgExample.setOrderByClause("create_time desc");
        //查找所有可用的Bug信息
        List<TbExceptionMsg> msgs = msgMapper.selectByExample(msgExample);

        return msgs;
    }

    /**
     * 根据bug信息的Id查找相关的信息包括阶段信息
     *
     * @param bid
     * @return
     */
    @Override
    public BugMsgs findOne(Integer bid) {
        BugMsgs bugMsgs = new BugMsgs();
        TbExceptionMsg exceptionMsg = msgMapper.selectByPrimaryKey(bid);
        bugMsgs.setExceptionMsg(exceptionMsg);
        if (exceptionMsg.getPeriodId() != null) {
            //当数据已经指定相关阶段时进行查询
            TbPeriod tbPeriod = periodMapper.selectByPrimaryKey(exceptionMsg.getPeriodId());
            bugMsgs.setPeriod(tbPeriod);
        }
        return bugMsgs;
    }

    @Override
    public void savebugMsg(TbExceptionMsg bugMsgs) {

        if (bugMsgs.getMessageId() != null) {
            //进行更新操作
            //根据bug信息id查询出之前的信息,进行相关的修改操作
            TbExceptionMsg exceptionMsg = msgMapper.selectByPrimaryKey(bugMsgs.getMessageId());
            //修改人信息,由权限控制获取登录人信息进行修改
//        exceptionMsg.setUpdatePerson();
            //修改对应阶段的id
            exceptionMsg.setPeriodId(bugMsgs.getPeriodId());
            //修改异常描述
            exceptionMsg.setExceptionDesc(bugMsgs.getExceptionDesc());
            //修改异常原因
            exceptionMsg.setExceptionReason(bugMsgs.getExceptionReason());
            //修改处理方式
            exceptionMsg.setResolveWay(bugMsgs.getResolveWay());
            //修改图片
            exceptionMsg.setRelatePic(bugMsgs.getRelatePic());
            //修改变更日期
            exceptionMsg.setLastUpdateTime(new Date());
            msgMapper.updateByPrimaryKey(exceptionMsg);
        } else {
            //将信息上传至搜索服务器
//            ....
            //获取当前登录人的信息,设置新增人信息
//            bugMsgs.setCreatePerson();
            //设置新增日期
            bugMsgs.setCreateTime(new Date());
            //设置可用标记为0(可用)
            bugMsgs.setUsableFlag(0);
            //进行新增操作
            msgMapper.insert(bugMsgs);
        }

    }

    /**
     * 根据指定id删除bug信息(将可用标记置为1)
     *
     * @param bid
     */
    @Override
    public void delbugMsg(Integer bid) {
        TbExceptionMsg tbExceptionMsg = msgMapper.selectByPrimaryKey(bid);
        tbExceptionMsg.setUsableFlag(1);
        msgMapper.updateByPrimaryKey(tbExceptionMsg);
    }

    /**
     * 与findByPage方法对应,是为了查出相对应的阶段信息
     *
     * @param oldList
     * @return
     */
    @Override
    public List findBugMsgs(List<TbExceptionMsg> oldList) {
        //查找出Bug对应的阶段信息,并进行封装
        ArrayList<BugMsgs> list = new ArrayList<>();
        for (TbExceptionMsg msg : oldList) {
            BugMsgs bugMsgs = new BugMsgs();
            bugMsgs.setExceptionMsg(msg);
            if (msg.getPeriodId() != null) {
                //当数据已经指定相关阶段时进行查询
                TbPeriod tbPeriod = periodMapper.selectByPrimaryKey(msg.getPeriodId());
                bugMsgs.setPeriod(tbPeriod);
            }
            list.add(bugMsgs);
        }
        return list;
    }

    @Override
    public List<TbExceptionMsg> search(BugSearch bugSearch) {
        List<TbExceptionMsg> exceptionMsgs = new ArrayList<>();
        TbExceptionMsgExample example = new TbExceptionMsgExample();
        TbExceptionMsgExample.Criteria criteria = example.createCriteria();
        criteria.andUsableFlagEqualTo(0);
        if (StringUtil.isNotEmpty(bugSearch.getExceptionCondition())) {
            criteria.andExceptionDescLike("%"+bugSearch.getExceptionCondition()+"%");
        }
        if (!"-1".equals(bugSearch.getPeriodCondition())) {
            criteria.andPeriodIdEqualTo(Integer.parseInt(bugSearch.getPeriodCondition()));
        }
        exceptionMsgs = msgMapper.selectByExample(example);
        return exceptionMsgs;
    }
}

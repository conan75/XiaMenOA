package com.itheima.mapper;

import com.itheima.domain.TbExceptionMsg;
import com.itheima.domain.TbExceptionMsgExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TbExceptionMsgMapper {
    int countByExample(TbExceptionMsgExample example);

    int deleteByExample(TbExceptionMsgExample example);

    int deleteByPrimaryKey(Integer messageId);

    int insert(TbExceptionMsg record);

    int insertSelective(TbExceptionMsg record);

    List<TbExceptionMsg> selectByExample(TbExceptionMsgExample example);

    TbExceptionMsg selectByPrimaryKey(Integer messageId);

    int updateByExampleSelective(@Param("record") TbExceptionMsg record, @Param("example") TbExceptionMsgExample example);

    int updateByExample(@Param("record") TbExceptionMsg record, @Param("example") TbExceptionMsgExample example);

    int updateByPrimaryKeySelective(TbExceptionMsg record);

    int updateByPrimaryKey(TbExceptionMsg record);

    @Update("update tb_exception_msg set period_id=null where period_id=#{bid}")
    void updateByPeriodId(Integer bid);
}
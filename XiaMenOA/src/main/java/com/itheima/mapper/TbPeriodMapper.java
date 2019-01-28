package com.itheima.mapper;

import com.itheima.domain.TbPeriod;
import com.itheima.domain.TbPeriodExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TbPeriodMapper {
    int countByExample(TbPeriodExample example);

    int deleteByExample(TbPeriodExample example);

    int deleteByPrimaryKey(Integer periodId);

    int insert(TbPeriod record);

    int insertSelective(TbPeriod record);

    List<TbPeriod> selectByExample(TbPeriodExample example);

    TbPeriod selectByPrimaryKey(Integer periodId);

    int updateByExampleSelective(@Param("record") TbPeriod record, @Param("example") TbPeriodExample example);

    int updateByExample(@Param("record") TbPeriod record, @Param("example") TbPeriodExample example);

    int updateByPrimaryKeySelective(TbPeriod record);

    int updateByPrimaryKey(TbPeriod record);

    @Update("truncate table tb_period")
    int truncateTable();
}
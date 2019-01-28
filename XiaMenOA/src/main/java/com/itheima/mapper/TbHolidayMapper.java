package com.itheima.mapper;

import com.itheima.domain.TbHoliday;
import com.itheima.domain.TbHolidayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbHolidayMapper {
    int countByExample(TbHolidayExample example);

    int deleteByExample(TbHolidayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbHoliday record);

    int insertSelective(TbHoliday record);

    List<TbHoliday> selectByExample(TbHolidayExample example);

    TbHoliday selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbHoliday record, @Param("example") TbHolidayExample example);

    int updateByExample(@Param("record") TbHoliday record, @Param("example") TbHolidayExample example);

    int updateByPrimaryKeySelective(TbHoliday record);

    int updateByPrimaryKey(TbHoliday record);
}
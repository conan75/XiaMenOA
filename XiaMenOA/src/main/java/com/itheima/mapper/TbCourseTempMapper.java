package com.itheima.mapper;

import com.itheima.domain.TbCourseTemp;
import com.itheima.domain.TbCourseTempExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TbCourseTempMapper {
    int countByExample(TbCourseTempExample example);

    int deleteByExample(TbCourseTempExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCourseTemp record);

    int insertSelective(TbCourseTemp record);

    List<TbCourseTemp> selectByExample(TbCourseTempExample example);

    TbCourseTemp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCourseTemp record, @Param("example") TbCourseTempExample example);

    int updateByExample(@Param("record") TbCourseTemp record, @Param("example") TbCourseTempExample example);

    int updateByPrimaryKeySelective(TbCourseTemp record);

    int updateByPrimaryKey(TbCourseTemp record);

    @Update("truncate table tb_course_temp")
    void truncateTable();
}
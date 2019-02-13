package com.itheima.utils;

import java.util.Arrays;
import java.util.Date;

public class CourseImport {

    //阶段id
    private String periodIds;

    //课程老师id
    private String[] teacherIds;

    //班级id
    private String courseName;

    //基础班开班日期
    private Date courseDate;

    @Override
    public String toString() {
        return "CourseImport{" +
                "periodIds='" + periodIds + '\'' +
                ", teacherIds=" + Arrays.toString(teacherIds) +
                ", courseName='" + courseName + '\'' +
                ", courseDate=" + courseDate +
                '}';
    }

    public String getPeriodIds() {
        return periodIds;
    }

    public void setPeriodIds(String periodIds) {
        this.periodIds = periodIds;
    }

    public String[] getTeacherIds() {
        return teacherIds;
    }

    public void setTeacherIds(String[] teacherIds) {
        this.teacherIds = teacherIds;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
    }
}

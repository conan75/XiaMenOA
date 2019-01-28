package com.itheima.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TbCourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbCourseExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPeriodIdIsNull() {
            addCriterion("period_id is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIdIsNotNull() {
            addCriterion("period_id is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodIdEqualTo(Integer value) {
            addCriterion("period_id =", value, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdNotEqualTo(Integer value) {
            addCriterion("period_id <>", value, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdGreaterThan(Integer value) {
            addCriterion("period_id >", value, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("period_id >=", value, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdLessThan(Integer value) {
            addCriterion("period_id <", value, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdLessThanOrEqualTo(Integer value) {
            addCriterion("period_id <=", value, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdIn(List<Integer> values) {
            addCriterion("period_id in", values, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdNotIn(List<Integer> values) {
            addCriterion("period_id not in", values, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdBetween(Integer value1, Integer value2) {
            addCriterion("period_id between", value1, value2, "periodId");
            return (Criteria) this;
        }

        public Criteria andPeriodIdNotBetween(Integer value1, Integer value2) {
            addCriterion("period_id not between", value1, value2, "periodId");
            return (Criteria) this;
        }

        public Criteria andCourseDateIsNull() {
            addCriterion("course_date is null");
            return (Criteria) this;
        }

        public Criteria andCourseDateIsNotNull() {
            addCriterion("course_date is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDateEqualTo(Date value) {
            addCriterionForJDBCDate("course_date =", value, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("course_date <>", value, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("course_date >", value, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("course_date >=", value, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateLessThan(Date value) {
            addCriterionForJDBCDate("course_date <", value, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("course_date <=", value, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateIn(List<Date> values) {
            addCriterionForJDBCDate("course_date in", values, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("course_date not in", values, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("course_date between", value1, value2, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("course_date not between", value1, value2, "courseDate");
            return (Criteria) this;
        }

        public Criteria andCourseWeekIsNull() {
            addCriterion("course_week is null");
            return (Criteria) this;
        }

        public Criteria andCourseWeekIsNotNull() {
            addCriterion("course_week is not null");
            return (Criteria) this;
        }

        public Criteria andCourseWeekEqualTo(String value) {
            addCriterion("course_week =", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotEqualTo(String value) {
            addCriterion("course_week <>", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekGreaterThan(String value) {
            addCriterion("course_week >", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekGreaterThanOrEqualTo(String value) {
            addCriterion("course_week >=", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekLessThan(String value) {
            addCriterion("course_week <", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekLessThanOrEqualTo(String value) {
            addCriterion("course_week <=", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekLike(String value) {
            addCriterion("course_week like", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotLike(String value) {
            addCriterion("course_week not like", value, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekIn(List<String> values) {
            addCriterion("course_week in", values, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotIn(List<String> values) {
            addCriterion("course_week not in", values, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekBetween(String value1, String value2) {
            addCriterion("course_week between", value1, value2, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseWeekNotBetween(String value1, String value2) {
            addCriterion("course_week not between", value1, value2, "courseWeek");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andIsOutlineIsNull() {
            addCriterion("is_outline is null");
            return (Criteria) this;
        }

        public Criteria andIsOutlineIsNotNull() {
            addCriterion("is_outline is not null");
            return (Criteria) this;
        }

        public Criteria andIsOutlineEqualTo(Integer value) {
            addCriterion("is_outline =", value, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineNotEqualTo(Integer value) {
            addCriterion("is_outline <>", value, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineGreaterThan(Integer value) {
            addCriterion("is_outline >", value, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_outline >=", value, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineLessThan(Integer value) {
            addCriterion("is_outline <", value, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineLessThanOrEqualTo(Integer value) {
            addCriterion("is_outline <=", value, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineIn(List<Integer> values) {
            addCriterion("is_outline in", values, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineNotIn(List<Integer> values) {
            addCriterion("is_outline not in", values, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineBetween(Integer value1, Integer value2) {
            addCriterion("is_outline between", value1, value2, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsOutlineNotBetween(Integer value1, Integer value2) {
            addCriterion("is_outline not between", value1, value2, "isOutline");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamIsNull() {
            addCriterion("is_periodExam is null");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamIsNotNull() {
            addCriterion("is_periodExam is not null");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamEqualTo(Integer value) {
            addCriterion("is_periodExam =", value, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamNotEqualTo(Integer value) {
            addCriterion("is_periodExam <>", value, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamGreaterThan(Integer value) {
            addCriterion("is_periodExam >", value, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_periodExam >=", value, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamLessThan(Integer value) {
            addCriterion("is_periodExam <", value, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamLessThanOrEqualTo(Integer value) {
            addCriterion("is_periodExam <=", value, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamIn(List<Integer> values) {
            addCriterion("is_periodExam in", values, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamNotIn(List<Integer> values) {
            addCriterion("is_periodExam not in", values, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamBetween(Integer value1, Integer value2) {
            addCriterion("is_periodExam between", value1, value2, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andIsPeriodexamNotBetween(Integer value1, Integer value2) {
            addCriterion("is_periodExam not between", value1, value2, "isPeriodexam");
            return (Criteria) this;
        }

        public Criteria andClazzIdIsNull() {
            addCriterion("clazz_id is null");
            return (Criteria) this;
        }

        public Criteria andClazzIdIsNotNull() {
            addCriterion("clazz_id is not null");
            return (Criteria) this;
        }

        public Criteria andClazzIdEqualTo(Integer value) {
            addCriterion("clazz_id =", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdNotEqualTo(Integer value) {
            addCriterion("clazz_id <>", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdGreaterThan(Integer value) {
            addCriterion("clazz_id >", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("clazz_id >=", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdLessThan(Integer value) {
            addCriterion("clazz_id <", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdLessThanOrEqualTo(Integer value) {
            addCriterion("clazz_id <=", value, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdIn(List<Integer> values) {
            addCriterion("clazz_id in", values, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdNotIn(List<Integer> values) {
            addCriterion("clazz_id not in", values, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdBetween(Integer value1, Integer value2) {
            addCriterion("clazz_id between", value1, value2, "clazzId");
            return (Criteria) this;
        }

        public Criteria andClazzIdNotBetween(Integer value1, Integer value2) {
            addCriterion("clazz_id not between", value1, value2, "clazzId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNull() {
            addCriterion("teacher_id is null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIsNotNull() {
            addCriterion("teacher_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherIdEqualTo(Integer value) {
            addCriterion("teacher_id =", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotEqualTo(Integer value) {
            addCriterion("teacher_id <>", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThan(Integer value) {
            addCriterion("teacher_id >", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_id >=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThan(Integer value) {
            addCriterion("teacher_id <", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_id <=", value, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdIn(List<Integer> values) {
            addCriterion("teacher_id in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotIn(List<Integer> values) {
            addCriterion("teacher_id not in", values, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andTeacherIdNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_id not between", value1, value2, "teacherId");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNull() {
            addCriterion("last_update_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIsNotNull() {
            addCriterion("last_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeEqualTo(Date value) {
            addCriterion("last_update_time =", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotEqualTo(Date value) {
            addCriterion("last_update_time <>", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThan(Date value) {
            addCriterion("last_update_time >", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update_time >=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThan(Date value) {
            addCriterion("last_update_time <", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_update_time <=", value, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeIn(List<Date> values) {
            addCriterion("last_update_time in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotIn(List<Date> values) {
            addCriterion("last_update_time not in", values, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("last_update_time between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_update_time not between", value1, value2, "lastUpdateTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUsableFlagIsNull() {
            addCriterion("usable_flag is null");
            return (Criteria) this;
        }

        public Criteria andUsableFlagIsNotNull() {
            addCriterion("usable_flag is not null");
            return (Criteria) this;
        }

        public Criteria andUsableFlagEqualTo(Integer value) {
            addCriterion("usable_flag =", value, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagNotEqualTo(Integer value) {
            addCriterion("usable_flag <>", value, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagGreaterThan(Integer value) {
            addCriterion("usable_flag >", value, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("usable_flag >=", value, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagLessThan(Integer value) {
            addCriterion("usable_flag <", value, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagLessThanOrEqualTo(Integer value) {
            addCriterion("usable_flag <=", value, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagIn(List<Integer> values) {
            addCriterion("usable_flag in", values, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagNotIn(List<Integer> values) {
            addCriterion("usable_flag not in", values, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagBetween(Integer value1, Integer value2) {
            addCriterion("usable_flag between", value1, value2, "usableFlag");
            return (Criteria) this;
        }

        public Criteria andUsableFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("usable_flag not between", value1, value2, "usableFlag");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
package com.itheima.domain;

import java.util.ArrayList;
import java.util.List;

public class TbHolidayExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbHolidayExample() {
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

        public Criteria andHolidayNameIsNull() {
            addCriterion("holiday_name is null");
            return (Criteria) this;
        }

        public Criteria andHolidayNameIsNotNull() {
            addCriterion("holiday_name is not null");
            return (Criteria) this;
        }

        public Criteria andHolidayNameEqualTo(String value) {
            addCriterion("holiday_name =", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotEqualTo(String value) {
            addCriterion("holiday_name <>", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameGreaterThan(String value) {
            addCriterion("holiday_name >", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameGreaterThanOrEqualTo(String value) {
            addCriterion("holiday_name >=", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameLessThan(String value) {
            addCriterion("holiday_name <", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameLessThanOrEqualTo(String value) {
            addCriterion("holiday_name <=", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameLike(String value) {
            addCriterion("holiday_name like", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotLike(String value) {
            addCriterion("holiday_name not like", value, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameIn(List<String> values) {
            addCriterion("holiday_name in", values, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotIn(List<String> values) {
            addCriterion("holiday_name not in", values, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameBetween(String value1, String value2) {
            addCriterion("holiday_name between", value1, value2, "holidayName");
            return (Criteria) this;
        }

        public Criteria andHolidayNameNotBetween(String value1, String value2) {
            addCriterion("holiday_name not between", value1, value2, "holidayName");
            return (Criteria) this;
        }

        public Criteria andVacationDaysIsNull() {
            addCriterion("vacation_days is null");
            return (Criteria) this;
        }

        public Criteria andVacationDaysIsNotNull() {
            addCriterion("vacation_days is not null");
            return (Criteria) this;
        }

        public Criteria andVacationDaysEqualTo(String value) {
            addCriterion("vacation_days =", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysNotEqualTo(String value) {
            addCriterion("vacation_days <>", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysGreaterThan(String value) {
            addCriterion("vacation_days >", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysGreaterThanOrEqualTo(String value) {
            addCriterion("vacation_days >=", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysLessThan(String value) {
            addCriterion("vacation_days <", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysLessThanOrEqualTo(String value) {
            addCriterion("vacation_days <=", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysLike(String value) {
            addCriterion("vacation_days like", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysNotLike(String value) {
            addCriterion("vacation_days not like", value, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysIn(List<String> values) {
            addCriterion("vacation_days in", values, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysNotIn(List<String> values) {
            addCriterion("vacation_days not in", values, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysBetween(String value1, String value2) {
            addCriterion("vacation_days between", value1, value2, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDaysNotBetween(String value1, String value2) {
            addCriterion("vacation_days not between", value1, value2, "vacationDays");
            return (Criteria) this;
        }

        public Criteria andVacationDateIsNull() {
            addCriterion("vacation_date is null");
            return (Criteria) this;
        }

        public Criteria andVacationDateIsNotNull() {
            addCriterion("vacation_date is not null");
            return (Criteria) this;
        }

        public Criteria andVacationDateEqualTo(String value) {
            addCriterion("vacation_date =", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateNotEqualTo(String value) {
            addCriterion("vacation_date <>", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateGreaterThan(String value) {
            addCriterion("vacation_date >", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateGreaterThanOrEqualTo(String value) {
            addCriterion("vacation_date >=", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateLessThan(String value) {
            addCriterion("vacation_date <", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateLessThanOrEqualTo(String value) {
            addCriterion("vacation_date <=", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateLike(String value) {
            addCriterion("vacation_date like", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateNotLike(String value) {
            addCriterion("vacation_date not like", value, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateIn(List<String> values) {
            addCriterion("vacation_date in", values, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateNotIn(List<String> values) {
            addCriterion("vacation_date not in", values, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateBetween(String value1, String value2) {
            addCriterion("vacation_date between", value1, value2, "vacationDate");
            return (Criteria) this;
        }

        public Criteria andVacationDateNotBetween(String value1, String value2) {
            addCriterion("vacation_date not between", value1, value2, "vacationDate");
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
package com.itheima.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbTeacherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbTeacherExample() {
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

        public Criteria andTeacherCodeIsNull() {
            addCriterion("teacher_code is null");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeIsNotNull() {
            addCriterion("teacher_code is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeEqualTo(Integer value) {
            addCriterion("teacher_code =", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeNotEqualTo(Integer value) {
            addCriterion("teacher_code <>", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeGreaterThan(Integer value) {
            addCriterion("teacher_code >", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("teacher_code >=", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeLessThan(Integer value) {
            addCriterion("teacher_code <", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeLessThanOrEqualTo(Integer value) {
            addCriterion("teacher_code <=", value, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeIn(List<Integer> values) {
            addCriterion("teacher_code in", values, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeNotIn(List<Integer> values) {
            addCriterion("teacher_code not in", values, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeBetween(Integer value1, Integer value2) {
            addCriterion("teacher_code between", value1, value2, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("teacher_code not between", value1, value2, "teacherCode");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNull() {
            addCriterion("teacher_name is null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIsNotNull() {
            addCriterion("teacher_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherNameEqualTo(String value) {
            addCriterion("teacher_name =", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotEqualTo(String value) {
            addCriterion("teacher_name <>", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThan(String value) {
            addCriterion("teacher_name >", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_name >=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThan(String value) {
            addCriterion("teacher_name <", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLessThanOrEqualTo(String value) {
            addCriterion("teacher_name <=", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameLike(String value) {
            addCriterion("teacher_name like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotLike(String value) {
            addCriterion("teacher_name not like", value, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameIn(List<String> values) {
            addCriterion("teacher_name in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotIn(List<String> values) {
            addCriterion("teacher_name not in", values, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameBetween(String value1, String value2) {
            addCriterion("teacher_name between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherNameNotBetween(String value1, String value2) {
            addCriterion("teacher_name not between", value1, value2, "teacherName");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNull() {
            addCriterion("teacher_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIsNotNull() {
            addCriterion("teacher_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneEqualTo(String value) {
            addCriterion("teacher_phone =", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotEqualTo(String value) {
            addCriterion("teacher_phone <>", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThan(String value) {
            addCriterion("teacher_phone >", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_phone >=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThan(String value) {
            addCriterion("teacher_phone <", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLessThanOrEqualTo(String value) {
            addCriterion("teacher_phone <=", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneLike(String value) {
            addCriterion("teacher_phone like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotLike(String value) {
            addCriterion("teacher_phone not like", value, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneIn(List<String> values) {
            addCriterion("teacher_phone in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotIn(List<String> values) {
            addCriterion("teacher_phone not in", values, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneBetween(String value1, String value2) {
            addCriterion("teacher_phone between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherPhoneNotBetween(String value1, String value2) {
            addCriterion("teacher_phone not between", value1, value2, "teacherPhone");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressIsNull() {
            addCriterion("teacher_address is null");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressIsNotNull() {
            addCriterion("teacher_address is not null");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressEqualTo(String value) {
            addCriterion("teacher_address =", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotEqualTo(String value) {
            addCriterion("teacher_address <>", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressGreaterThan(String value) {
            addCriterion("teacher_address >", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressGreaterThanOrEqualTo(String value) {
            addCriterion("teacher_address >=", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressLessThan(String value) {
            addCriterion("teacher_address <", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressLessThanOrEqualTo(String value) {
            addCriterion("teacher_address <=", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressLike(String value) {
            addCriterion("teacher_address like", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotLike(String value) {
            addCriterion("teacher_address not like", value, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressIn(List<String> values) {
            addCriterion("teacher_address in", values, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotIn(List<String> values) {
            addCriterion("teacher_address not in", values, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressBetween(String value1, String value2) {
            addCriterion("teacher_address between", value1, value2, "teacherAddress");
            return (Criteria) this;
        }

        public Criteria andTeacherAddressNotBetween(String value1, String value2) {
            addCriterion("teacher_address not between", value1, value2, "teacherAddress");
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
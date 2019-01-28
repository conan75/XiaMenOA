package com.itheima.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPeriodExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPeriodExample() {
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

        public Criteria andPeriodNameIsNull() {
            addCriterion("period_name is null");
            return (Criteria) this;
        }

        public Criteria andPeriodNameIsNotNull() {
            addCriterion("period_name is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodNameEqualTo(String value) {
            addCriterion("period_name =", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameNotEqualTo(String value) {
            addCriterion("period_name <>", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameGreaterThan(String value) {
            addCriterion("period_name >", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameGreaterThanOrEqualTo(String value) {
            addCriterion("period_name >=", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameLessThan(String value) {
            addCriterion("period_name <", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameLessThanOrEqualTo(String value) {
            addCriterion("period_name <=", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameLike(String value) {
            addCriterion("period_name like", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameNotLike(String value) {
            addCriterion("period_name not like", value, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameIn(List<String> values) {
            addCriterion("period_name in", values, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameNotIn(List<String> values) {
            addCriterion("period_name not in", values, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameBetween(String value1, String value2) {
            addCriterion("period_name between", value1, value2, "periodName");
            return (Criteria) this;
        }

        public Criteria andPeriodNameNotBetween(String value1, String value2) {
            addCriterion("period_name not between", value1, value2, "periodName");
            return (Criteria) this;
        }

        public Criteria andModifyPersonIsNull() {
            addCriterion("modify_person is null");
            return (Criteria) this;
        }

        public Criteria andModifyPersonIsNotNull() {
            addCriterion("modify_person is not null");
            return (Criteria) this;
        }

        public Criteria andModifyPersonEqualTo(String value) {
            addCriterion("modify_person =", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonNotEqualTo(String value) {
            addCriterion("modify_person <>", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonGreaterThan(String value) {
            addCriterion("modify_person >", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonGreaterThanOrEqualTo(String value) {
            addCriterion("modify_person >=", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonLessThan(String value) {
            addCriterion("modify_person <", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonLessThanOrEqualTo(String value) {
            addCriterion("modify_person <=", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonLike(String value) {
            addCriterion("modify_person like", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonNotLike(String value) {
            addCriterion("modify_person not like", value, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonIn(List<String> values) {
            addCriterion("modify_person in", values, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonNotIn(List<String> values) {
            addCriterion("modify_person not in", values, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonBetween(String value1, String value2) {
            addCriterion("modify_person between", value1, value2, "modifyPerson");
            return (Criteria) this;
        }

        public Criteria andModifyPersonNotBetween(String value1, String value2) {
            addCriterion("modify_person not between", value1, value2, "modifyPerson");
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
package com.itheima.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbExceptionMsgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbExceptionMsgExample() {
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

        public Criteria andMessageIdIsNull() {
            addCriterion("message_id is null");
            return (Criteria) this;
        }

        public Criteria andMessageIdIsNotNull() {
            addCriterion("message_id is not null");
            return (Criteria) this;
        }

        public Criteria andMessageIdEqualTo(Integer value) {
            addCriterion("message_id =", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotEqualTo(Integer value) {
            addCriterion("message_id <>", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThan(Integer value) {
            addCriterion("message_id >", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("message_id >=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThan(Integer value) {
            addCriterion("message_id <", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdLessThanOrEqualTo(Integer value) {
            addCriterion("message_id <=", value, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdIn(List<Integer> values) {
            addCriterion("message_id in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotIn(List<Integer> values) {
            addCriterion("message_id not in", values, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdBetween(Integer value1, Integer value2) {
            addCriterion("message_id between", value1, value2, "messageId");
            return (Criteria) this;
        }

        public Criteria andMessageIdNotBetween(Integer value1, Integer value2) {
            addCriterion("message_id not between", value1, value2, "messageId");
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

        public Criteria andExceptionDescIsNull() {
            addCriterion("exception_desc is null");
            return (Criteria) this;
        }

        public Criteria andExceptionDescIsNotNull() {
            addCriterion("exception_desc is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionDescEqualTo(String value) {
            addCriterion("exception_desc =", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotEqualTo(String value) {
            addCriterion("exception_desc <>", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescGreaterThan(String value) {
            addCriterion("exception_desc >", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescGreaterThanOrEqualTo(String value) {
            addCriterion("exception_desc >=", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescLessThan(String value) {
            addCriterion("exception_desc <", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescLessThanOrEqualTo(String value) {
            addCriterion("exception_desc <=", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescLike(String value) {
            addCriterion("exception_desc like", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotLike(String value) {
            addCriterion("exception_desc not like", value, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescIn(List<String> values) {
            addCriterion("exception_desc in", values, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotIn(List<String> values) {
            addCriterion("exception_desc not in", values, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescBetween(String value1, String value2) {
            addCriterion("exception_desc between", value1, value2, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionDescNotBetween(String value1, String value2) {
            addCriterion("exception_desc not between", value1, value2, "exceptionDesc");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonIsNull() {
            addCriterion("exception_reason is null");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonIsNotNull() {
            addCriterion("exception_reason is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonEqualTo(String value) {
            addCriterion("exception_reason =", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonNotEqualTo(String value) {
            addCriterion("exception_reason <>", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonGreaterThan(String value) {
            addCriterion("exception_reason >", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonGreaterThanOrEqualTo(String value) {
            addCriterion("exception_reason >=", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonLessThan(String value) {
            addCriterion("exception_reason <", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonLessThanOrEqualTo(String value) {
            addCriterion("exception_reason <=", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonLike(String value) {
            addCriterion("exception_reason like", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonNotLike(String value) {
            addCriterion("exception_reason not like", value, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonIn(List<String> values) {
            addCriterion("exception_reason in", values, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonNotIn(List<String> values) {
            addCriterion("exception_reason not in", values, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonBetween(String value1, String value2) {
            addCriterion("exception_reason between", value1, value2, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andExceptionReasonNotBetween(String value1, String value2) {
            addCriterion("exception_reason not between", value1, value2, "exceptionReason");
            return (Criteria) this;
        }

        public Criteria andResolveWayIsNull() {
            addCriterion("resolve_way is null");
            return (Criteria) this;
        }

        public Criteria andResolveWayIsNotNull() {
            addCriterion("resolve_way is not null");
            return (Criteria) this;
        }

        public Criteria andResolveWayEqualTo(String value) {
            addCriterion("resolve_way =", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayNotEqualTo(String value) {
            addCriterion("resolve_way <>", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayGreaterThan(String value) {
            addCriterion("resolve_way >", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayGreaterThanOrEqualTo(String value) {
            addCriterion("resolve_way >=", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayLessThan(String value) {
            addCriterion("resolve_way <", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayLessThanOrEqualTo(String value) {
            addCriterion("resolve_way <=", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayLike(String value) {
            addCriterion("resolve_way like", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayNotLike(String value) {
            addCriterion("resolve_way not like", value, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayIn(List<String> values) {
            addCriterion("resolve_way in", values, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayNotIn(List<String> values) {
            addCriterion("resolve_way not in", values, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayBetween(String value1, String value2) {
            addCriterion("resolve_way between", value1, value2, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andResolveWayNotBetween(String value1, String value2) {
            addCriterion("resolve_way not between", value1, value2, "resolveWay");
            return (Criteria) this;
        }

        public Criteria andRelatePicIsNull() {
            addCriterion("relate_pic is null");
            return (Criteria) this;
        }

        public Criteria andRelatePicIsNotNull() {
            addCriterion("relate_pic is not null");
            return (Criteria) this;
        }

        public Criteria andRelatePicEqualTo(String value) {
            addCriterion("relate_pic =", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicNotEqualTo(String value) {
            addCriterion("relate_pic <>", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicGreaterThan(String value) {
            addCriterion("relate_pic >", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicGreaterThanOrEqualTo(String value) {
            addCriterion("relate_pic >=", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicLessThan(String value) {
            addCriterion("relate_pic <", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicLessThanOrEqualTo(String value) {
            addCriterion("relate_pic <=", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicLike(String value) {
            addCriterion("relate_pic like", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicNotLike(String value) {
            addCriterion("relate_pic not like", value, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicIn(List<String> values) {
            addCriterion("relate_pic in", values, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicNotIn(List<String> values) {
            addCriterion("relate_pic not in", values, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicBetween(String value1, String value2) {
            addCriterion("relate_pic between", value1, value2, "relatePic");
            return (Criteria) this;
        }

        public Criteria andRelatePicNotBetween(String value1, String value2) {
            addCriterion("relate_pic not between", value1, value2, "relatePic");
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

        public Criteria andCreatePersonIsNull() {
            addCriterion("create_person is null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIsNotNull() {
            addCriterion("create_person is not null");
            return (Criteria) this;
        }

        public Criteria andCreatePersonEqualTo(String value) {
            addCriterion("create_person =", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotEqualTo(String value) {
            addCriterion("create_person <>", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThan(String value) {
            addCriterion("create_person >", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("create_person >=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThan(String value) {
            addCriterion("create_person <", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLessThanOrEqualTo(String value) {
            addCriterion("create_person <=", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonLike(String value) {
            addCriterion("create_person like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotLike(String value) {
            addCriterion("create_person not like", value, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonIn(List<String> values) {
            addCriterion("create_person in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotIn(List<String> values) {
            addCriterion("create_person not in", values, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonBetween(String value1, String value2) {
            addCriterion("create_person between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andCreatePersonNotBetween(String value1, String value2) {
            addCriterion("create_person not between", value1, value2, "createPerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNull() {
            addCriterion("update_person is null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIsNotNull() {
            addCriterion("update_person is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonEqualTo(String value) {
            addCriterion("update_person =", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotEqualTo(String value) {
            addCriterion("update_person <>", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThan(String value) {
            addCriterion("update_person >", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonGreaterThanOrEqualTo(String value) {
            addCriterion("update_person >=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThan(String value) {
            addCriterion("update_person <", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLessThanOrEqualTo(String value) {
            addCriterion("update_person <=", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonLike(String value) {
            addCriterion("update_person like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotLike(String value) {
            addCriterion("update_person not like", value, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonIn(List<String> values) {
            addCriterion("update_person in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotIn(List<String> values) {
            addCriterion("update_person not in", values, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonBetween(String value1, String value2) {
            addCriterion("update_person between", value1, value2, "updatePerson");
            return (Criteria) this;
        }

        public Criteria andUpdatePersonNotBetween(String value1, String value2) {
            addCriterion("update_person not between", value1, value2, "updatePerson");
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
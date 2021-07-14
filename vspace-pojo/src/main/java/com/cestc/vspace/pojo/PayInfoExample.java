package com.cestc.vspace.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PayInfoExample implements Serializable{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayInfoExample() {
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

        public Criteria andPidIsNull() {
            addCriterion("PID is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("PID is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(Integer value) {
            addCriterion("PID =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(Integer value) {
            addCriterion("PID <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(Integer value) {
            addCriterion("PID >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PID >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(Integer value) {
            addCriterion("PID <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(Integer value) {
            addCriterion("PID <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<Integer> values) {
            addCriterion("PID in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<Integer> values) {
            addCriterion("PID not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(Integer value1, Integer value2) {
            addCriterion("PID between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(Integer value1, Integer value2) {
            addCriterion("PID not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPayPlatformIsNull() {
            addCriterion("PAY_PLATFORM is null");
            return (Criteria) this;
        }

        public Criteria andPayPlatformIsNotNull() {
            addCriterion("PAY_PLATFORM is not null");
            return (Criteria) this;
        }

        public Criteria andPayPlatformEqualTo(Integer value) {
            addCriterion("PAY_PLATFORM =", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformNotEqualTo(Integer value) {
            addCriterion("PAY_PLATFORM <>", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformGreaterThan(Integer value) {
            addCriterion("PAY_PLATFORM >", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformGreaterThanOrEqualTo(Integer value) {
            addCriterion("PAY_PLATFORM >=", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformLessThan(Integer value) {
            addCriterion("PAY_PLATFORM <", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformLessThanOrEqualTo(Integer value) {
            addCriterion("PAY_PLATFORM <=", value, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformIn(List<Integer> values) {
            addCriterion("PAY_PLATFORM in", values, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformNotIn(List<Integer> values) {
            addCriterion("PAY_PLATFORM not in", values, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformBetween(Integer value1, Integer value2) {
            addCriterion("PAY_PLATFORM between", value1, value2, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPayPlatformNotBetween(Integer value1, Integer value2) {
            addCriterion("PAY_PLATFORM not between", value1, value2, "payPlatform");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberIsNull() {
            addCriterion("PLATFORM_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberIsNotNull() {
            addCriterion("PLATFORM_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberEqualTo(String value) {
            addCriterion("PLATFORM_NUMBER =", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotEqualTo(String value) {
            addCriterion("PLATFORM_NUMBER <>", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberGreaterThan(String value) {
            addCriterion("PLATFORM_NUMBER >", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberGreaterThanOrEqualTo(String value) {
            addCriterion("PLATFORM_NUMBER >=", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberLessThan(String value) {
            addCriterion("PLATFORM_NUMBER <", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberLessThanOrEqualTo(String value) {
            addCriterion("PLATFORM_NUMBER <=", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberLike(String value) {
            addCriterion("PLATFORM_NUMBER like", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotLike(String value) {
            addCriterion("PLATFORM_NUMBER not like", value, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberIn(List<String> values) {
            addCriterion("PLATFORM_NUMBER in", values, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotIn(List<String> values) {
            addCriterion("PLATFORM_NUMBER not in", values, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberBetween(String value1, String value2) {
            addCriterion("PLATFORM_NUMBER between", value1, value2, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformNumberNotBetween(String value1, String value2) {
            addCriterion("PLATFORM_NUMBER not between", value1, value2, "platformNumber");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNull() {
            addCriterion("PLATFORM_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIsNotNull() {
            addCriterion("PLATFORM_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusEqualTo(String value) {
            addCriterion("PLATFORM_STATUS =", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotEqualTo(String value) {
            addCriterion("PLATFORM_STATUS <>", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThan(String value) {
            addCriterion("PLATFORM_STATUS >", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusGreaterThanOrEqualTo(String value) {
            addCriterion("PLATFORM_STATUS >=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThan(String value) {
            addCriterion("PLATFORM_STATUS <", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLessThanOrEqualTo(String value) {
            addCriterion("PLATFORM_STATUS <=", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusLike(String value) {
            addCriterion("PLATFORM_STATUS like", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotLike(String value) {
            addCriterion("PLATFORM_STATUS not like", value, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusIn(List<String> values) {
            addCriterion("PLATFORM_STATUS in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotIn(List<String> values) {
            addCriterion("PLATFORM_STATUS not in", values, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusBetween(String value1, String value2) {
            addCriterion("PLATFORM_STATUS between", value1, value2, "platformStatus");
            return (Criteria) this;
        }

        public Criteria andPlatformStatusNotBetween(String value1, String value2) {
            addCriterion("PLATFORM_STATUS not between", value1, value2, "platformStatus");
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
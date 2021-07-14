package com.cestc.vspace.pojo;

import java.util.ArrayList;
import java.util.List;

public class ClothesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClothesExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("CID is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("CID is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("CID =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("CID <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("CID >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CID >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("CID <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("CID <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("CID in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("CID not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("CID between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("CID not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("CNAME is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("CNAME is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("CNAME =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("CNAME <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("CNAME >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("CNAME >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("CNAME <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("CNAME <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("CNAME like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("CNAME not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("CNAME in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("CNAME not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("CNAME between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("CNAME not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("PRICE is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Integer value) {
            addCriterion("PRICE =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Integer value) {
            addCriterion("PRICE <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Integer value) {
            addCriterion("PRICE >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICE >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Integer value) {
            addCriterion("PRICE <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Integer value) {
            addCriterion("PRICE <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Integer> values) {
            addCriterion("PRICE in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Integer> values) {
            addCriterion("PRICE not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Integer value1, Integer value2) {
            addCriterion("PRICE between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICE not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIsNull() {
            addCriterion("DISCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIsNotNull() {
            addCriterion("DISCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andDiscriptionEqualTo(String value) {
            addCriterion("DISCRIPTION =", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotEqualTo(String value) {
            addCriterion("DISCRIPTION <>", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionGreaterThan(String value) {
            addCriterion("DISCRIPTION >", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionGreaterThanOrEqualTo(String value) {
            addCriterion("DISCRIPTION >=", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLessThan(String value) {
            addCriterion("DISCRIPTION <", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLessThanOrEqualTo(String value) {
            addCriterion("DISCRIPTION <=", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionLike(String value) {
            addCriterion("DISCRIPTION like", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotLike(String value) {
            addCriterion("DISCRIPTION not like", value, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionIn(List<String> values) {
            addCriterion("DISCRIPTION in", values, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotIn(List<String> values) {
            addCriterion("DISCRIPTION not in", values, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionBetween(String value1, String value2) {
            addCriterion("DISCRIPTION between", value1, value2, "discription");
            return (Criteria) this;
        }

        public Criteria andDiscriptionNotBetween(String value1, String value2) {
            addCriterion("DISCRIPTION not between", value1, value2, "discription");
            return (Criteria) this;
        }

        public Criteria andPicAddrIsNull() {
            addCriterion("PIC_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andPicAddrIsNotNull() {
            addCriterion("PIC_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andPicAddrEqualTo(String value) {
            addCriterion("PIC_ADDR =", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotEqualTo(String value) {
            addCriterion("PIC_ADDR <>", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrGreaterThan(String value) {
            addCriterion("PIC_ADDR >", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrGreaterThanOrEqualTo(String value) {
            addCriterion("PIC_ADDR >=", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrLessThan(String value) {
            addCriterion("PIC_ADDR <", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrLessThanOrEqualTo(String value) {
            addCriterion("PIC_ADDR <=", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrLike(String value) {
            addCriterion("PIC_ADDR like", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotLike(String value) {
            addCriterion("PIC_ADDR not like", value, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrIn(List<String> values) {
            addCriterion("PIC_ADDR in", values, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotIn(List<String> values) {
            addCriterion("PIC_ADDR not in", values, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrBetween(String value1, String value2) {
            addCriterion("PIC_ADDR between", value1, value2, "picAddr");
            return (Criteria) this;
        }

        public Criteria andPicAddrNotBetween(String value1, String value2) {
            addCriterion("PIC_ADDR not between", value1, value2, "picAddr");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNull() {
            addCriterion("MERCHANT is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNotNull() {
            addCriterion("MERCHANT is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantEqualTo(String value) {
            addCriterion("MERCHANT =", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotEqualTo(String value) {
            addCriterion("MERCHANT <>", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThan(String value) {
            addCriterion("MERCHANT >", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThanOrEqualTo(String value) {
            addCriterion("MERCHANT >=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThan(String value) {
            addCriterion("MERCHANT <", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThanOrEqualTo(String value) {
            addCriterion("MERCHANT <=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLike(String value) {
            addCriterion("MERCHANT like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotLike(String value) {
            addCriterion("MERCHANT not like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantIn(List<String> values) {
            addCriterion("MERCHANT in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotIn(List<String> values) {
            addCriterion("MERCHANT not in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantBetween(String value1, String value2) {
            addCriterion("MERCHANT between", value1, value2, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotBetween(String value1, String value2) {
            addCriterion("MERCHANT not between", value1, value2, "merchant");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("SIZE is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("SIZE =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("SIZE <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("SIZE >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("SIZE >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("SIZE <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("SIZE <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("SIZE like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("SIZE not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("SIZE in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("SIZE not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("SIZE between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("SIZE not between", value1, value2, "size");
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
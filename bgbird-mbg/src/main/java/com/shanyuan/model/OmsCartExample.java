package com.shanyuan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OmsCartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OmsCartExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Integer value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Integer value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Integer value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Integer value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Integer value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Integer> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Integer> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Integer value1, Integer value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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

        public Criteria andDeleteStatusIsNull() {
            addCriterion("delete_status is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("delete_status =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("delete_status <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("delete_status >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delete_status >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("delete_status <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delete_status <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Integer> values) {
            addCriterion("delete_status in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Integer> values) {
            addCriterion("delete_status not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("delete_status between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delete_status not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNull() {
            addCriterion("buy_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountIsNotNull() {
            addCriterion("buy_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountEqualTo(Integer value) {
            addCriterion("buy_count =", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotEqualTo(Integer value) {
            addCriterion("buy_count <>", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThan(Integer value) {
            addCriterion("buy_count >", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_count >=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThan(Integer value) {
            addCriterion("buy_count <", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountLessThanOrEqualTo(Integer value) {
            addCriterion("buy_count <=", value, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountIn(List<Integer> values) {
            addCriterion("buy_count in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotIn(List<Integer> values) {
            addCriterion("buy_count not in", values, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountBetween(Integer value1, Integer value2) {
            addCriterion("buy_count between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andBuyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_count not between", value1, value2, "buyCount");
            return (Criteria) this;
        }

        public Criteria andSpecDescIsNull() {
            addCriterion("spec_desc is null");
            return (Criteria) this;
        }

        public Criteria andSpecDescIsNotNull() {
            addCriterion("spec_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSpecDescEqualTo(String value) {
            addCriterion("spec_desc =", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotEqualTo(String value) {
            addCriterion("spec_desc <>", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescGreaterThan(String value) {
            addCriterion("spec_desc >", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescGreaterThanOrEqualTo(String value) {
            addCriterion("spec_desc >=", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescLessThan(String value) {
            addCriterion("spec_desc <", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescLessThanOrEqualTo(String value) {
            addCriterion("spec_desc <=", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescLike(String value) {
            addCriterion("spec_desc like", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotLike(String value) {
            addCriterion("spec_desc not like", value, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescIn(List<String> values) {
            addCriterion("spec_desc in", values, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotIn(List<String> values) {
            addCriterion("spec_desc not in", values, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescBetween(String value1, String value2) {
            addCriterion("spec_desc between", value1, value2, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSpecDescNotBetween(String value1, String value2) {
            addCriterion("spec_desc not between", value1, value2, "specDesc");
            return (Criteria) this;
        }

        public Criteria andSp1IsNull() {
            addCriterion("sp1 is null");
            return (Criteria) this;
        }

        public Criteria andSp1IsNotNull() {
            addCriterion("sp1 is not null");
            return (Criteria) this;
        }

        public Criteria andSp1EqualTo(String value) {
            addCriterion("sp1 =", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1NotEqualTo(String value) {
            addCriterion("sp1 <>", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1GreaterThan(String value) {
            addCriterion("sp1 >", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1GreaterThanOrEqualTo(String value) {
            addCriterion("sp1 >=", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1LessThan(String value) {
            addCriterion("sp1 <", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1LessThanOrEqualTo(String value) {
            addCriterion("sp1 <=", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1Like(String value) {
            addCriterion("sp1 like", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1NotLike(String value) {
            addCriterion("sp1 not like", value, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1In(List<String> values) {
            addCriterion("sp1 in", values, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1NotIn(List<String> values) {
            addCriterion("sp1 not in", values, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1Between(String value1, String value2) {
            addCriterion("sp1 between", value1, value2, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp1NotBetween(String value1, String value2) {
            addCriterion("sp1 not between", value1, value2, "sp1");
            return (Criteria) this;
        }

        public Criteria andSp2IsNull() {
            addCriterion("sp2 is null");
            return (Criteria) this;
        }

        public Criteria andSp2IsNotNull() {
            addCriterion("sp2 is not null");
            return (Criteria) this;
        }

        public Criteria andSp2EqualTo(String value) {
            addCriterion("sp2 =", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2NotEqualTo(String value) {
            addCriterion("sp2 <>", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2GreaterThan(String value) {
            addCriterion("sp2 >", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2GreaterThanOrEqualTo(String value) {
            addCriterion("sp2 >=", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2LessThan(String value) {
            addCriterion("sp2 <", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2LessThanOrEqualTo(String value) {
            addCriterion("sp2 <=", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2Like(String value) {
            addCriterion("sp2 like", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2NotLike(String value) {
            addCriterion("sp2 not like", value, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2In(List<String> values) {
            addCriterion("sp2 in", values, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2NotIn(List<String> values) {
            addCriterion("sp2 not in", values, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2Between(String value1, String value2) {
            addCriterion("sp2 between", value1, value2, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp2NotBetween(String value1, String value2) {
            addCriterion("sp2 not between", value1, value2, "sp2");
            return (Criteria) this;
        }

        public Criteria andSp3IsNull() {
            addCriterion("sp3 is null");
            return (Criteria) this;
        }

        public Criteria andSp3IsNotNull() {
            addCriterion("sp3 is not null");
            return (Criteria) this;
        }

        public Criteria andSp3EqualTo(String value) {
            addCriterion("sp3 =", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3NotEqualTo(String value) {
            addCriterion("sp3 <>", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3GreaterThan(String value) {
            addCriterion("sp3 >", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3GreaterThanOrEqualTo(String value) {
            addCriterion("sp3 >=", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3LessThan(String value) {
            addCriterion("sp3 <", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3LessThanOrEqualTo(String value) {
            addCriterion("sp3 <=", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3Like(String value) {
            addCriterion("sp3 like", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3NotLike(String value) {
            addCriterion("sp3 not like", value, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3In(List<String> values) {
            addCriterion("sp3 in", values, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3NotIn(List<String> values) {
            addCriterion("sp3 not in", values, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3Between(String value1, String value2) {
            addCriterion("sp3 between", value1, value2, "sp3");
            return (Criteria) this;
        }

        public Criteria andSp3NotBetween(String value1, String value2) {
            addCriterion("sp3 not between", value1, value2, "sp3");
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
package com.shanyuan.model;

import java.util.ArrayList;
import java.util.List;

public class AmsActiveDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AmsActiveDetailExample() {
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

        public Criteria andActiveIdIsNull() {
            addCriterion("active_id is null");
            return (Criteria) this;
        }

        public Criteria andActiveIdIsNotNull() {
            addCriterion("active_id is not null");
            return (Criteria) this;
        }

        public Criteria andActiveIdEqualTo(Integer value) {
            addCriterion("active_id =", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotEqualTo(Integer value) {
            addCriterion("active_id <>", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThan(Integer value) {
            addCriterion("active_id >", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("active_id >=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThan(Integer value) {
            addCriterion("active_id <", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdLessThanOrEqualTo(Integer value) {
            addCriterion("active_id <=", value, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdIn(List<Integer> values) {
            addCriterion("active_id in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotIn(List<Integer> values) {
            addCriterion("active_id not in", values, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdBetween(Integer value1, Integer value2) {
            addCriterion("active_id between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveIdNotBetween(Integer value1, Integer value2) {
            addCriterion("active_id not between", value1, value2, "activeId");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureIsNull() {
            addCriterion("active_detail_picture is null");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureIsNotNull() {
            addCriterion("active_detail_picture is not null");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureEqualTo(String value) {
            addCriterion("active_detail_picture =", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureNotEqualTo(String value) {
            addCriterion("active_detail_picture <>", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureGreaterThan(String value) {
            addCriterion("active_detail_picture >", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureGreaterThanOrEqualTo(String value) {
            addCriterion("active_detail_picture >=", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureLessThan(String value) {
            addCriterion("active_detail_picture <", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureLessThanOrEqualTo(String value) {
            addCriterion("active_detail_picture <=", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureLike(String value) {
            addCriterion("active_detail_picture like", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureNotLike(String value) {
            addCriterion("active_detail_picture not like", value, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureIn(List<String> values) {
            addCriterion("active_detail_picture in", values, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureNotIn(List<String> values) {
            addCriterion("active_detail_picture not in", values, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureBetween(String value1, String value2) {
            addCriterion("active_detail_picture between", value1, value2, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDetailPictureNotBetween(String value1, String value2) {
            addCriterion("active_detail_picture not between", value1, value2, "activeDetailPicture");
            return (Criteria) this;
        }

        public Criteria andActiveDateIsNull() {
            addCriterion("active_date is null");
            return (Criteria) this;
        }

        public Criteria andActiveDateIsNotNull() {
            addCriterion("active_date is not null");
            return (Criteria) this;
        }

        public Criteria andActiveDateEqualTo(String value) {
            addCriterion("active_date =", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateNotEqualTo(String value) {
            addCriterion("active_date <>", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateGreaterThan(String value) {
            addCriterion("active_date >", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateGreaterThanOrEqualTo(String value) {
            addCriterion("active_date >=", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateLessThan(String value) {
            addCriterion("active_date <", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateLessThanOrEqualTo(String value) {
            addCriterion("active_date <=", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateLike(String value) {
            addCriterion("active_date like", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateNotLike(String value) {
            addCriterion("active_date not like", value, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateIn(List<String> values) {
            addCriterion("active_date in", values, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateNotIn(List<String> values) {
            addCriterion("active_date not in", values, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateBetween(String value1, String value2) {
            addCriterion("active_date between", value1, value2, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveDateNotBetween(String value1, String value2) {
            addCriterion("active_date not between", value1, value2, "activeDate");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalIsNull() {
            addCriterion("active_time_interval is null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalIsNotNull() {
            addCriterion("active_time_interval is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalEqualTo(String value) {
            addCriterion("active_time_interval =", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalNotEqualTo(String value) {
            addCriterion("active_time_interval <>", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalGreaterThan(String value) {
            addCriterion("active_time_interval >", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalGreaterThanOrEqualTo(String value) {
            addCriterion("active_time_interval >=", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalLessThan(String value) {
            addCriterion("active_time_interval <", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalLessThanOrEqualTo(String value) {
            addCriterion("active_time_interval <=", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalLike(String value) {
            addCriterion("active_time_interval like", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalNotLike(String value) {
            addCriterion("active_time_interval not like", value, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalIn(List<String> values) {
            addCriterion("active_time_interval in", values, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalNotIn(List<String> values) {
            addCriterion("active_time_interval not in", values, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalBetween(String value1, String value2) {
            addCriterion("active_time_interval between", value1, value2, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveTimeIntervalNotBetween(String value1, String value2) {
            addCriterion("active_time_interval not between", value1, value2, "activeTimeInterval");
            return (Criteria) this;
        }

        public Criteria andActiveAddressIsNull() {
            addCriterion("active_address is null");
            return (Criteria) this;
        }

        public Criteria andActiveAddressIsNotNull() {
            addCriterion("active_address is not null");
            return (Criteria) this;
        }

        public Criteria andActiveAddressEqualTo(String value) {
            addCriterion("active_address =", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressNotEqualTo(String value) {
            addCriterion("active_address <>", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressGreaterThan(String value) {
            addCriterion("active_address >", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressGreaterThanOrEqualTo(String value) {
            addCriterion("active_address >=", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressLessThan(String value) {
            addCriterion("active_address <", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressLessThanOrEqualTo(String value) {
            addCriterion("active_address <=", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressLike(String value) {
            addCriterion("active_address like", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressNotLike(String value) {
            addCriterion("active_address not like", value, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressIn(List<String> values) {
            addCriterion("active_address in", values, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressNotIn(List<String> values) {
            addCriterion("active_address not in", values, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressBetween(String value1, String value2) {
            addCriterion("active_address between", value1, value2, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andActiveAddressNotBetween(String value1, String value2) {
            addCriterion("active_address not between", value1, value2, "activeAddress");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleIsNull() {
            addCriterion("recommend_people is null");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleIsNotNull() {
            addCriterion("recommend_people is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleEqualTo(String value) {
            addCriterion("recommend_people =", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleNotEqualTo(String value) {
            addCriterion("recommend_people <>", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleGreaterThan(String value) {
            addCriterion("recommend_people >", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_people >=", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleLessThan(String value) {
            addCriterion("recommend_people <", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleLessThanOrEqualTo(String value) {
            addCriterion("recommend_people <=", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleLike(String value) {
            addCriterion("recommend_people like", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleNotLike(String value) {
            addCriterion("recommend_people not like", value, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleIn(List<String> values) {
            addCriterion("recommend_people in", values, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleNotIn(List<String> values) {
            addCriterion("recommend_people not in", values, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleBetween(String value1, String value2) {
            addCriterion("recommend_people between", value1, value2, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andRecommendPeopleNotBetween(String value1, String value2) {
            addCriterion("recommend_people not between", value1, value2, "recommendPeople");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNull() {
            addCriterion("welfare is null");
            return (Criteria) this;
        }

        public Criteria andWelfareIsNotNull() {
            addCriterion("welfare is not null");
            return (Criteria) this;
        }

        public Criteria andWelfareEqualTo(String value) {
            addCriterion("welfare =", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotEqualTo(String value) {
            addCriterion("welfare <>", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThan(String value) {
            addCriterion("welfare >", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareGreaterThanOrEqualTo(String value) {
            addCriterion("welfare >=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThan(String value) {
            addCriterion("welfare <", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLessThanOrEqualTo(String value) {
            addCriterion("welfare <=", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareLike(String value) {
            addCriterion("welfare like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotLike(String value) {
            addCriterion("welfare not like", value, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareIn(List<String> values) {
            addCriterion("welfare in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotIn(List<String> values) {
            addCriterion("welfare not in", values, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareBetween(String value1, String value2) {
            addCriterion("welfare between", value1, value2, "welfare");
            return (Criteria) this;
        }

        public Criteria andWelfareNotBetween(String value1, String value2) {
            addCriterion("welfare not between", value1, value2, "welfare");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowIsNull() {
            addCriterion("apply_need_know is null");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowIsNotNull() {
            addCriterion("apply_need_know is not null");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowEqualTo(String value) {
            addCriterion("apply_need_know =", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowNotEqualTo(String value) {
            addCriterion("apply_need_know <>", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowGreaterThan(String value) {
            addCriterion("apply_need_know >", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowGreaterThanOrEqualTo(String value) {
            addCriterion("apply_need_know >=", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowLessThan(String value) {
            addCriterion("apply_need_know <", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowLessThanOrEqualTo(String value) {
            addCriterion("apply_need_know <=", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowLike(String value) {
            addCriterion("apply_need_know like", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowNotLike(String value) {
            addCriterion("apply_need_know not like", value, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowIn(List<String> values) {
            addCriterion("apply_need_know in", values, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowNotIn(List<String> values) {
            addCriterion("apply_need_know not in", values, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowBetween(String value1, String value2) {
            addCriterion("apply_need_know between", value1, value2, "applyNeedKnow");
            return (Criteria) this;
        }

        public Criteria andApplyNeedKnowNotBetween(String value1, String value2) {
            addCriterion("apply_need_know not between", value1, value2, "applyNeedKnow");
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
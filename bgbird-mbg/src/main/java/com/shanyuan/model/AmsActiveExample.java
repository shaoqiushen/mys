package com.shanyuan.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AmsActiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AmsActiveExample() {
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

        public Criteria andActiveNameIsNull() {
            addCriterion("active_name is null");
            return (Criteria) this;
        }

        public Criteria andActiveNameIsNotNull() {
            addCriterion("active_name is not null");
            return (Criteria) this;
        }

        public Criteria andActiveNameEqualTo(String value) {
            addCriterion("active_name =", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotEqualTo(String value) {
            addCriterion("active_name <>", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameGreaterThan(String value) {
            addCriterion("active_name >", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameGreaterThanOrEqualTo(String value) {
            addCriterion("active_name >=", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLessThan(String value) {
            addCriterion("active_name <", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLessThanOrEqualTo(String value) {
            addCriterion("active_name <=", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameLike(String value) {
            addCriterion("active_name like", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotLike(String value) {
            addCriterion("active_name not like", value, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameIn(List<String> values) {
            addCriterion("active_name in", values, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotIn(List<String> values) {
            addCriterion("active_name not in", values, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameBetween(String value1, String value2) {
            addCriterion("active_name between", value1, value2, "activeName");
            return (Criteria) this;
        }

        public Criteria andActiveNameNotBetween(String value1, String value2) {
            addCriterion("active_name not between", value1, value2, "activeName");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceIsNull() {
            addCriterion("active_introduce is null");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceIsNotNull() {
            addCriterion("active_introduce is not null");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceEqualTo(String value) {
            addCriterion("active_introduce =", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceNotEqualTo(String value) {
            addCriterion("active_introduce <>", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceGreaterThan(String value) {
            addCriterion("active_introduce >", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("active_introduce >=", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceLessThan(String value) {
            addCriterion("active_introduce <", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceLessThanOrEqualTo(String value) {
            addCriterion("active_introduce <=", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceLike(String value) {
            addCriterion("active_introduce like", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceNotLike(String value) {
            addCriterion("active_introduce not like", value, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceIn(List<String> values) {
            addCriterion("active_introduce in", values, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceNotIn(List<String> values) {
            addCriterion("active_introduce not in", values, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceBetween(String value1, String value2) {
            addCriterion("active_introduce between", value1, value2, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActiveIntroduceNotBetween(String value1, String value2) {
            addCriterion("active_introduce not between", value1, value2, "activeIntroduce");
            return (Criteria) this;
        }

        public Criteria andActivePictureIsNull() {
            addCriterion("active_picture is null");
            return (Criteria) this;
        }

        public Criteria andActivePictureIsNotNull() {
            addCriterion("active_picture is not null");
            return (Criteria) this;
        }

        public Criteria andActivePictureEqualTo(String value) {
            addCriterion("active_picture =", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureNotEqualTo(String value) {
            addCriterion("active_picture <>", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureGreaterThan(String value) {
            addCriterion("active_picture >", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureGreaterThanOrEqualTo(String value) {
            addCriterion("active_picture >=", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureLessThan(String value) {
            addCriterion("active_picture <", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureLessThanOrEqualTo(String value) {
            addCriterion("active_picture <=", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureLike(String value) {
            addCriterion("active_picture like", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureNotLike(String value) {
            addCriterion("active_picture not like", value, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureIn(List<String> values) {
            addCriterion("active_picture in", values, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureNotIn(List<String> values) {
            addCriterion("active_picture not in", values, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureBetween(String value1, String value2) {
            addCriterion("active_picture between", value1, value2, "activePicture");
            return (Criteria) this;
        }

        public Criteria andActivePictureNotBetween(String value1, String value2) {
            addCriterion("active_picture not between", value1, value2, "activePicture");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Integer value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Integer value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Integer value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Integer value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Integer value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Integer> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Integer> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Integer value1, Integer value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNull() {
            addCriterion("integration is null");
            return (Criteria) this;
        }

        public Criteria andIntegrationIsNotNull() {
            addCriterion("integration is not null");
            return (Criteria) this;
        }

        public Criteria andIntegrationEqualTo(Integer value) {
            addCriterion("integration =", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotEqualTo(Integer value) {
            addCriterion("integration <>", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThan(Integer value) {
            addCriterion("integration >", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationGreaterThanOrEqualTo(Integer value) {
            addCriterion("integration >=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThan(Integer value) {
            addCriterion("integration <", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationLessThanOrEqualTo(Integer value) {
            addCriterion("integration <=", value, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationIn(List<Integer> values) {
            addCriterion("integration in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotIn(List<Integer> values) {
            addCriterion("integration not in", values, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationBetween(Integer value1, Integer value2) {
            addCriterion("integration between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andIntegrationNotBetween(Integer value1, Integer value2) {
            addCriterion("integration not between", value1, value2, "integration");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andActiveTitleIsNull() {
            addCriterion("active_title is null");
            return (Criteria) this;
        }

        public Criteria andActiveTitleIsNotNull() {
            addCriterion("active_title is not null");
            return (Criteria) this;
        }

        public Criteria andActiveTitleEqualTo(String value) {
            addCriterion("active_title =", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleNotEqualTo(String value) {
            addCriterion("active_title <>", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleGreaterThan(String value) {
            addCriterion("active_title >", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleGreaterThanOrEqualTo(String value) {
            addCriterion("active_title >=", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleLessThan(String value) {
            addCriterion("active_title <", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleLessThanOrEqualTo(String value) {
            addCriterion("active_title <=", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleLike(String value) {
            addCriterion("active_title like", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleNotLike(String value) {
            addCriterion("active_title not like", value, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleIn(List<String> values) {
            addCriterion("active_title in", values, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleNotIn(List<String> values) {
            addCriterion("active_title not in", values, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleBetween(String value1, String value2) {
            addCriterion("active_title between", value1, value2, "activeTitle");
            return (Criteria) this;
        }

        public Criteria andActiveTitleNotBetween(String value1, String value2) {
            addCriterion("active_title not between", value1, value2, "activeTitle");
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
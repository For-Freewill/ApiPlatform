package cn.springmvc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestResultCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TestResultCriteria() {
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

        public Criteria andRuntimeIsNull() {
            addCriterion("runtime is null");
            return (Criteria) this;
        }

        public Criteria andRuntimeIsNotNull() {
            addCriterion("runtime is not null");
            return (Criteria) this;
        }

        public Criteria andRuntimeEqualTo(Date value) {
            addCriterion("runtime =", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotEqualTo(Date value) {
            addCriterion("runtime <>", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeGreaterThan(Date value) {
            addCriterion("runtime >", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeGreaterThanOrEqualTo(Date value) {
            addCriterion("runtime >=", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeLessThan(Date value) {
            addCriterion("runtime <", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeLessThanOrEqualTo(Date value) {
            addCriterion("runtime <=", value, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeIn(List<Date> values) {
            addCriterion("runtime in", values, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotIn(List<Date> values) {
            addCriterion("runtime not in", values, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeBetween(Date value1, Date value2) {
            addCriterion("runtime between", value1, value2, "runtime");
            return (Criteria) this;
        }

        public Criteria andRuntimeNotBetween(Date value1, Date value2) {
            addCriterion("runtime not between", value1, value2, "runtime");
            return (Criteria) this;
        }

        public Criteria andSucessIsNull() {
            addCriterion("sucess is null");
            return (Criteria) this;
        }

        public Criteria andSucessIsNotNull() {
            addCriterion("sucess is not null");
            return (Criteria) this;
        }

        public Criteria andSucessEqualTo(Integer value) {
            addCriterion("sucess =", value, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessNotEqualTo(Integer value) {
            addCriterion("sucess <>", value, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessGreaterThan(Integer value) {
            addCriterion("sucess >", value, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessGreaterThanOrEqualTo(Integer value) {
            addCriterion("sucess >=", value, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessLessThan(Integer value) {
            addCriterion("sucess <", value, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessLessThanOrEqualTo(Integer value) {
            addCriterion("sucess <=", value, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessIn(List<Integer> values) {
            addCriterion("sucess in", values, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessNotIn(List<Integer> values) {
            addCriterion("sucess not in", values, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessBetween(Integer value1, Integer value2) {
            addCriterion("sucess between", value1, value2, "sucess");
            return (Criteria) this;
        }

        public Criteria andSucessNotBetween(Integer value1, Integer value2) {
            addCriterion("sucess not between", value1, value2, "sucess");
            return (Criteria) this;
        }

        public Criteria andFailIsNull() {
            addCriterion("fail is null");
            return (Criteria) this;
        }

        public Criteria andFailIsNotNull() {
            addCriterion("fail is not null");
            return (Criteria) this;
        }

        public Criteria andFailEqualTo(Integer value) {
            addCriterion("fail =", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotEqualTo(Integer value) {
            addCriterion("fail <>", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailGreaterThan(Integer value) {
            addCriterion("fail >", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailGreaterThanOrEqualTo(Integer value) {
            addCriterion("fail >=", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailLessThan(Integer value) {
            addCriterion("fail <", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailLessThanOrEqualTo(Integer value) {
            addCriterion("fail <=", value, "fail");
            return (Criteria) this;
        }

        public Criteria andFailIn(List<Integer> values) {
            addCriterion("fail in", values, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotIn(List<Integer> values) {
            addCriterion("fail not in", values, "fail");
            return (Criteria) this;
        }

        public Criteria andFailBetween(Integer value1, Integer value2) {
            addCriterion("fail between", value1, value2, "fail");
            return (Criteria) this;
        }

        public Criteria andFailNotBetween(Integer value1, Integer value2) {
            addCriterion("fail not between", value1, value2, "fail");
            return (Criteria) this;
        }

        public Criteria andSkipIsNull() {
            addCriterion("skip is null");
            return (Criteria) this;
        }

        public Criteria andSkipIsNotNull() {
            addCriterion("skip is not null");
            return (Criteria) this;
        }

        public Criteria andSkipEqualTo(Integer value) {
            addCriterion("skip =", value, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipNotEqualTo(Integer value) {
            addCriterion("skip <>", value, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipGreaterThan(Integer value) {
            addCriterion("skip >", value, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipGreaterThanOrEqualTo(Integer value) {
            addCriterion("skip >=", value, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipLessThan(Integer value) {
            addCriterion("skip <", value, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipLessThanOrEqualTo(Integer value) {
            addCriterion("skip <=", value, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipIn(List<Integer> values) {
            addCriterion("skip in", values, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipNotIn(List<Integer> values) {
            addCriterion("skip not in", values, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipBetween(Integer value1, Integer value2) {
            addCriterion("skip between", value1, value2, "skip");
            return (Criteria) this;
        }

        public Criteria andSkipNotBetween(Integer value1, Integer value2) {
            addCriterion("skip not between", value1, value2, "skip");
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
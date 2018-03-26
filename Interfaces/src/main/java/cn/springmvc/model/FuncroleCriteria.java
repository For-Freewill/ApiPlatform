package cn.springmvc.model;

import java.util.ArrayList;
import java.util.List;

public class FuncroleCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FuncroleCriteria() {
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

        public Criteria andFuncroleidIsNull() {
            addCriterion("funcroleid is null");
            return (Criteria) this;
        }

        public Criteria andFuncroleidIsNotNull() {
            addCriterion("funcroleid is not null");
            return (Criteria) this;
        }

        public Criteria andFuncroleidEqualTo(String value) {
            addCriterion("funcroleid =", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidNotEqualTo(String value) {
            addCriterion("funcroleid <>", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidGreaterThan(String value) {
            addCriterion("funcroleid >", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidGreaterThanOrEqualTo(String value) {
            addCriterion("funcroleid >=", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidLessThan(String value) {
            addCriterion("funcroleid <", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidLessThanOrEqualTo(String value) {
            addCriterion("funcroleid <=", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidLike(String value) {
            addCriterion("funcroleid like", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidNotLike(String value) {
            addCriterion("funcroleid not like", value, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidIn(List<String> values) {
            addCriterion("funcroleid in", values, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidNotIn(List<String> values) {
            addCriterion("funcroleid not in", values, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidBetween(String value1, String value2) {
            addCriterion("funcroleid between", value1, value2, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncroleidNotBetween(String value1, String value2) {
            addCriterion("funcroleid not between", value1, value2, "funcroleid");
            return (Criteria) this;
        }

        public Criteria andFuncidIsNull() {
            addCriterion("funcid is null");
            return (Criteria) this;
        }

        public Criteria andFuncidIsNotNull() {
            addCriterion("funcid is not null");
            return (Criteria) this;
        }

        public Criteria andFuncidEqualTo(String value) {
            addCriterion("funcid =", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotEqualTo(String value) {
            addCriterion("funcid <>", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidGreaterThan(String value) {
            addCriterion("funcid >", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidGreaterThanOrEqualTo(String value) {
            addCriterion("funcid >=", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidLessThan(String value) {
            addCriterion("funcid <", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidLessThanOrEqualTo(String value) {
            addCriterion("funcid <=", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidLike(String value) {
            addCriterion("funcid like", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotLike(String value) {
            addCriterion("funcid not like", value, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidIn(List<String> values) {
            addCriterion("funcid in", values, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotIn(List<String> values) {
            addCriterion("funcid not in", values, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidBetween(String value1, String value2) {
            addCriterion("funcid between", value1, value2, "funcid");
            return (Criteria) this;
        }

        public Criteria andFuncidNotBetween(String value1, String value2) {
            addCriterion("funcid not between", value1, value2, "funcid");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNull() {
            addCriterion("roleid is null");
            return (Criteria) this;
        }

        public Criteria andRoleidIsNotNull() {
            addCriterion("roleid is not null");
            return (Criteria) this;
        }

        public Criteria andRoleidEqualTo(String value) {
            addCriterion("roleid =", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotEqualTo(String value) {
            addCriterion("roleid <>", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThan(String value) {
            addCriterion("roleid >", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidGreaterThanOrEqualTo(String value) {
            addCriterion("roleid >=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThan(String value) {
            addCriterion("roleid <", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLessThanOrEqualTo(String value) {
            addCriterion("roleid <=", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidLike(String value) {
            addCriterion("roleid like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotLike(String value) {
            addCriterion("roleid not like", value, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidIn(List<String> values) {
            addCriterion("roleid in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotIn(List<String> values) {
            addCriterion("roleid not in", values, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidBetween(String value1, String value2) {
            addCriterion("roleid between", value1, value2, "roleid");
            return (Criteria) this;
        }

        public Criteria andRoleidNotBetween(String value1, String value2) {
            addCriterion("roleid not between", value1, value2, "roleid");
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
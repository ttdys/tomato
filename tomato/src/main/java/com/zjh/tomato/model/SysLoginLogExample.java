package com.zjh.tomato.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysLoginLogExample() {
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

        public Criteria andLoginIdIsNull() {
            addCriterion("login_id is null");
            return (Criteria) this;
        }

        public Criteria andLoginIdIsNotNull() {
            addCriterion("login_id is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIdEqualTo(Integer value) {
            addCriterion("login_id =", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotEqualTo(Integer value) {
            addCriterion("login_id <>", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThan(Integer value) {
            addCriterion("login_id >", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("login_id >=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThan(Integer value) {
            addCriterion("login_id <", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdLessThanOrEqualTo(Integer value) {
            addCriterion("login_id <=", value, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdIn(List<Integer> values) {
            addCriterion("login_id in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotIn(List<Integer> values) {
            addCriterion("login_id not in", values, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdBetween(Integer value1, Integer value2) {
            addCriterion("login_id between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginIdNotBetween(Integer value1, Integer value2) {
            addCriterion("login_id not between", value1, value2, "loginId");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameIsNull() {
            addCriterion("login_username is null");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameIsNotNull() {
            addCriterion("login_username is not null");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameEqualTo(String value) {
            addCriterion("login_username =", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameNotEqualTo(String value) {
            addCriterion("login_username <>", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameGreaterThan(String value) {
            addCriterion("login_username >", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("login_username >=", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameLessThan(String value) {
            addCriterion("login_username <", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameLessThanOrEqualTo(String value) {
            addCriterion("login_username <=", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameLike(String value) {
            addCriterion("login_username like", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameNotLike(String value) {
            addCriterion("login_username not like", value, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameIn(List<String> values) {
            addCriterion("login_username in", values, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameNotIn(List<String> values) {
            addCriterion("login_username not in", values, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameBetween(String value1, String value2) {
            addCriterion("login_username between", value1, value2, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginUsernameNotBetween(String value1, String value2) {
            addCriterion("login_username not between", value1, value2, "loginUsername");
            return (Criteria) this;
        }

        public Criteria andLoginAddrIsNull() {
            addCriterion("login_addr is null");
            return (Criteria) this;
        }

        public Criteria andLoginAddrIsNotNull() {
            addCriterion("login_addr is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAddrEqualTo(String value) {
            addCriterion("login_addr =", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrNotEqualTo(String value) {
            addCriterion("login_addr <>", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrGreaterThan(String value) {
            addCriterion("login_addr >", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrGreaterThanOrEqualTo(String value) {
            addCriterion("login_addr >=", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrLessThan(String value) {
            addCriterion("login_addr <", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrLessThanOrEqualTo(String value) {
            addCriterion("login_addr <=", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrLike(String value) {
            addCriterion("login_addr like", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrNotLike(String value) {
            addCriterion("login_addr not like", value, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrIn(List<String> values) {
            addCriterion("login_addr in", values, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrNotIn(List<String> values) {
            addCriterion("login_addr not in", values, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrBetween(String value1, String value2) {
            addCriterion("login_addr between", value1, value2, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginAddrNotBetween(String value1, String value2) {
            addCriterion("login_addr not between", value1, value2, "loginAddr");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginSystemIsNull() {
            addCriterion("login_system is null");
            return (Criteria) this;
        }

        public Criteria andLoginSystemIsNotNull() {
            addCriterion("login_system is not null");
            return (Criteria) this;
        }

        public Criteria andLoginSystemEqualTo(String value) {
            addCriterion("login_system =", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemNotEqualTo(String value) {
            addCriterion("login_system <>", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemGreaterThan(String value) {
            addCriterion("login_system >", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemGreaterThanOrEqualTo(String value) {
            addCriterion("login_system >=", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemLessThan(String value) {
            addCriterion("login_system <", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemLessThanOrEqualTo(String value) {
            addCriterion("login_system <=", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemLike(String value) {
            addCriterion("login_system like", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemNotLike(String value) {
            addCriterion("login_system not like", value, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemIn(List<String> values) {
            addCriterion("login_system in", values, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemNotIn(List<String> values) {
            addCriterion("login_system not in", values, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemBetween(String value1, String value2) {
            addCriterion("login_system between", value1, value2, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginSystemNotBetween(String value1, String value2) {
            addCriterion("login_system not between", value1, value2, "loginSystem");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserIsNull() {
            addCriterion("login_browser is null");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserIsNotNull() {
            addCriterion("login_browser is not null");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserEqualTo(String value) {
            addCriterion("login_browser =", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotEqualTo(String value) {
            addCriterion("login_browser <>", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserGreaterThan(String value) {
            addCriterion("login_browser >", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserGreaterThanOrEqualTo(String value) {
            addCriterion("login_browser >=", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserLessThan(String value) {
            addCriterion("login_browser <", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserLessThanOrEqualTo(String value) {
            addCriterion("login_browser <=", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserLike(String value) {
            addCriterion("login_browser like", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotLike(String value) {
            addCriterion("login_browser not like", value, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserIn(List<String> values) {
            addCriterion("login_browser in", values, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotIn(List<String> values) {
            addCriterion("login_browser not in", values, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserBetween(String value1, String value2) {
            addCriterion("login_browser between", value1, value2, "loginBrowser");
            return (Criteria) this;
        }

        public Criteria andLoginBrowserNotBetween(String value1, String value2) {
            addCriterion("login_browser not between", value1, value2, "loginBrowser");
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
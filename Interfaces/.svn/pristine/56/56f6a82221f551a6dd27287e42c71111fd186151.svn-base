package cn.springmvc.model;

import java.io.Serializable;
import java.util.Date;

public class TestResultDetailKey implements Serializable {
    private Date runtime;

    private String caseid;

    private static final long serialVersionUID = 1L;

    public Date getRuntime() {
        return runtime;
    }

    public void setRuntime(Date runtime) {
        this.runtime = runtime;
    }

    public String getCaseid() {
        return caseid;
    }

    public void setCaseid(String caseid) {
        this.caseid = caseid == null ? null : caseid.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TestResultDetailKey other = (TestResultDetailKey) that;
        return (this.getRuntime() == null ? other.getRuntime() == null : this.getRuntime().equals(other.getRuntime()))
            && (this.getCaseid() == null ? other.getCaseid() == null : this.getCaseid().equals(other.getCaseid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuntime() == null) ? 0 : getRuntime().hashCode());
        result = prime * result + ((getCaseid() == null) ? 0 : getCaseid().hashCode());
        return result;
    }
}
package cn.springmvc.model;

import java.io.Serializable;
import java.util.Date;

public class TestResult implements Serializable {
    private Date runtime;

    private Integer sucess;

    private Integer fail;

    private Integer skip;

    private static final long serialVersionUID = 1L;

    public Date getRuntime() {
        return runtime;
    }

    public void setRuntime(Date runtime) {
        this.runtime = runtime;
    }

    public Integer getSucess() {
        return sucess;
    }

    public void setSucess(Integer sucess) {
        this.sucess = sucess;
    }

    public Integer getFail() {
        return fail;
    }

    public void setFail(Integer fail) {
        this.fail = fail;
    }

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
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
        TestResult other = (TestResult) that;
        return (this.getRuntime() == null ? other.getRuntime() == null : this.getRuntime().equals(other.getRuntime()))
            && (this.getSucess() == null ? other.getSucess() == null : this.getSucess().equals(other.getSucess()))
            && (this.getFail() == null ? other.getFail() == null : this.getFail().equals(other.getFail()))
            && (this.getSkip() == null ? other.getSkip() == null : this.getSkip().equals(other.getSkip()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuntime() == null) ? 0 : getRuntime().hashCode());
        result = prime * result + ((getSucess() == null) ? 0 : getSucess().hashCode());
        result = prime * result + ((getFail() == null) ? 0 : getFail().hashCode());
        result = prime * result + ((getSkip() == null) ? 0 : getSkip().hashCode());
        return result;
    }
}
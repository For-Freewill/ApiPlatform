package cn.springmvc.model;

import java.io.Serializable;

public class TestResultDetail extends TestResultDetailKey implements Serializable {
    private String result;

    private Long taketime;

    private String system;

    private String detailmsg;

    private static final long serialVersionUID = 1L;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Long getTaketime() {
        return taketime;
    }

    public void setTaketime(Long taketime) {
        this.taketime = taketime;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public String getDetailmsg() {
        return detailmsg;
    }

    public void setDetailmsg(String detailmsg) {
        this.detailmsg = detailmsg == null ? null : detailmsg.trim();
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
        TestResultDetail other = (TestResultDetail) that;
        return (this.getRuntime() == null ? other.getRuntime() == null : this.getRuntime().equals(other.getRuntime()))
            && (this.getCaseid() == null ? other.getCaseid() == null : this.getCaseid().equals(other.getCaseid()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getTaketime() == null ? other.getTaketime() == null : this.getTaketime().equals(other.getTaketime()))
            && (this.getSystem() == null ? other.getSystem() == null : this.getSystem().equals(other.getSystem()))
            && (this.getDetailmsg() == null ? other.getDetailmsg() == null : this.getDetailmsg().equals(other.getDetailmsg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuntime() == null) ? 0 : getRuntime().hashCode());
        result = prime * result + ((getCaseid() == null) ? 0 : getCaseid().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getTaketime() == null) ? 0 : getTaketime().hashCode());
        result = prime * result + ((getSystem() == null) ? 0 : getSystem().hashCode());
        result = prime * result + ((getDetailmsg() == null) ? 0 : getDetailmsg().hashCode());
        return result;
    }
}
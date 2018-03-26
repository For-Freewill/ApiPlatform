package cn.springmvc.model;

import java.io.Serializable;

public class Funcrole implements Serializable {
    private String funcroleid;

    private String funcid;

    private String roleid;

    private static final long serialVersionUID = 1L;

    public String getFuncroleid() {
        return funcroleid;
    }

    public void setFuncroleid(String funcroleid) {
        this.funcroleid = funcroleid == null ? null : funcroleid.trim();
    }

    public String getFuncid() {
        return funcid;
    }

    public void setFuncid(String funcid) {
        this.funcid = funcid == null ? null : funcid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
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
        Funcrole other = (Funcrole) that;
        return (this.getFuncroleid() == null ? other.getFuncroleid() == null : this.getFuncroleid().equals(other.getFuncroleid()))
            && (this.getFuncid() == null ? other.getFuncid() == null : this.getFuncid().equals(other.getFuncid()))
            && (this.getRoleid() == null ? other.getRoleid() == null : this.getRoleid().equals(other.getRoleid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFuncroleid() == null) ? 0 : getFuncroleid().hashCode());
        result = prime * result + ((getFuncid() == null) ? 0 : getFuncid().hashCode());
        result = prime * result + ((getRoleid() == null) ? 0 : getRoleid().hashCode());
        return result;
    }
}
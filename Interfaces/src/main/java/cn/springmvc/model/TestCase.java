package cn.springmvc.model;

import java.io.Serializable;

public class TestCase implements Serializable {
    private String uuid;

    private String run;

    private String system;
    private String systemname;
    

    private String casename;

    private String method;

    private String url;

    private String type;

    private String header;

    private String checkpoint;

    private String correlation;

    private String params;

    private static final long serialVersionUID = 1L;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run == null ? null : run.trim();
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public String getCasename() {
        return casename;
    }

    public void setCasename(String casename) {
        this.casename = casename == null ? null : casename.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint == null ? null : checkpoint.trim();
    }

    public String getCorrelation() {
        return correlation;
    }

    public void setCorrelation(String correlation) {
        this.correlation = correlation == null ? null : correlation.trim();
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params == null ? null : params.trim();
    }
    

    public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
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
        TestCase other = (TestCase) that;
        return (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getRun() == null ? other.getRun() == null : this.getRun().equals(other.getRun()))
            && (this.getSystem() == null ? other.getSystem() == null : this.getSystem().equals(other.getSystem()))
            && (this.getCasename() == null ? other.getCasename() == null : this.getCasename().equals(other.getCasename()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getHeader() == null ? other.getHeader() == null : this.getHeader().equals(other.getHeader()))
            && (this.getCheckpoint() == null ? other.getCheckpoint() == null : this.getCheckpoint().equals(other.getCheckpoint()))
            && (this.getCorrelation() == null ? other.getCorrelation() == null : this.getCorrelation().equals(other.getCorrelation()))
            && (this.getParams() == null ? other.getParams() == null : this.getParams().equals(other.getParams()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getRun() == null) ? 0 : getRun().hashCode());
        result = prime * result + ((getSystem() == null) ? 0 : getSystem().hashCode());
        result = prime * result + ((getCasename() == null) ? 0 : getCasename().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getHeader() == null) ? 0 : getHeader().hashCode());
        result = prime * result + ((getCheckpoint() == null) ? 0 : getCheckpoint().hashCode());
        result = prime * result + ((getCorrelation() == null) ? 0 : getCorrelation().hashCode());
        result = prime * result + ((getParams() == null) ? 0 : getParams().hashCode());
        return result;
    }
}
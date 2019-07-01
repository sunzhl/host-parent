package cn.com.hosp.www.dao.entry;

import java.io.Serializable;
import java.util.Date;

public class WorkerLog implements Serializable {
    private Long id;

    private String logNumber;

    private Long workerId;

    private String workerName;

    private Boolean logType;

    private Date logTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogNumber() {
        return logNumber;
    }

    public void setLogNumber(String logNumber) {
        this.logNumber = logNumber == null ? null : logNumber.trim();
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public Boolean getLogType() {
        return logType;
    }

    public void setLogType(Boolean logType) {
        this.logType = logType;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }
}
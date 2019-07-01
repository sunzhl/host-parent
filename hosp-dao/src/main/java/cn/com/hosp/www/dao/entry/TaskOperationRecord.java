package cn.com.hosp.www.dao.entry;

import java.io.Serializable;
import java.util.Date;

public class TaskOperationRecord implements Serializable {
    private Long id;

    private String recNumber;

    private String taskNumber;

    private Long operationId;

    private String operationMan;

    private Date operationTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecNumber() {
        return recNumber;
    }

    public void setRecNumber(String recNumber) {
        this.recNumber = recNumber == null ? null : recNumber.trim();
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber == null ? null : taskNumber.trim();
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getOperationMan() {
        return operationMan;
    }

    public void setOperationMan(String operationMan) {
        this.operationMan = operationMan == null ? null : operationMan.trim();
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
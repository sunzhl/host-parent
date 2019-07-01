package cn.com.hosp.www.sys.web.form;

/**
 * @ClassName CancelResonForm
 * @Description TODO
 * @Author tome
 * @Date 19-6-29 上午11:13
 * @Version 1.0
 */

public class CancelReasonForm {

    private String cancelCode;

    private String cancelName;

    private Long proId;

    public String getCancelCode() {
        return cancelCode;
    }

    public void setCancelCode(String cancelCode) {
        this.cancelCode = cancelCode;
    }

    public String getCancelName() {
        return cancelName;
    }

    public void setCancelName(String cancelName) {
        this.cancelName = cancelName;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }
}

package cn.com.hosp.www.dao.entry;

import java.io.Serializable;

public class DictSex implements Serializable {
    private Long id;

    private Boolean sexNumber;

    private String sexName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSexNumber() {
        return sexNumber;
    }

    public void setSexNumber(Boolean sexNumber) {
        this.sexNumber = sexNumber;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName == null ? null : sexName.trim();
    }
}
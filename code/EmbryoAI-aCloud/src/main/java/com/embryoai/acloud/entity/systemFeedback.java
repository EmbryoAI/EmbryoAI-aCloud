package com.embryoai.acloud.entity;

import java.util.Date;

public class systemFeedback {
    private String procedureId;

    private String orgId;

    private Integer biochemPregnancy;

    private Integer clinicalPregnancy;

    private Integer fetusCount;

    private String userId;

    private Date createTime;

    private Date updateTime;

    private Integer delFlag;

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId == null ? null : procedureId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public Integer getBiochemPregnancy() {
        return biochemPregnancy;
    }

    public void setBiochemPregnancy(Integer biochemPregnancy) {
        this.biochemPregnancy = biochemPregnancy;
    }

    public Integer getClinicalPregnancy() {
        return clinicalPregnancy;
    }

    public void setClinicalPregnancy(Integer clinicalPregnancy) {
        this.clinicalPregnancy = clinicalPregnancy;
    }

    public Integer getFetusCount() {
        return fetusCount;
    }

    public void setFetusCount(Integer fetusCount) {
        this.fetusCount = fetusCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
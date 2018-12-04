package com.embryoai.acloud.entity;

import java.util.Date;

public class SystemProcedure {
    private String id;

    private String orgId;

    private String patientId;

    private String userId;

    private Integer patientAge;

    private Double patientHeight;

    private Double patientWeight;

    private String patientHeightUnit;

    private String patientWeightUnit;

    private String cycleTypeId;

    private Integer freshCycleCount;

    private Date ecTime;

    private String ecCount;

    private Date insemiTime;

    private String insemiTypeId;

    private String memo;

    private String medicalRecordNo;

    private Integer isSmoking;

    private Integer isDrinking;

    private Integer delFlag;

    private String embryoScoreId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId == null ? null : patientId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    public Double getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(Double patientHeight) {
        this.patientHeight = patientHeight;
    }

    public Double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(Double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientHeightUnit() {
        return patientHeightUnit;
    }

    public void setPatientHeightUnit(String patientHeightUnit) {
        this.patientHeightUnit = patientHeightUnit == null ? null : patientHeightUnit.trim();
    }

    public String getPatientWeightUnit() {
        return patientWeightUnit;
    }

    public void setPatientWeightUnit(String patientWeightUnit) {
        this.patientWeightUnit = patientWeightUnit == null ? null : patientWeightUnit.trim();
    }

    public String getCycleTypeId() {
        return cycleTypeId;
    }

    public void setCycleTypeId(String cycleTypeId) {
        this.cycleTypeId = cycleTypeId == null ? null : cycleTypeId.trim();
    }

    public Integer getFreshCycleCount() {
        return freshCycleCount;
    }

    public void setFreshCycleCount(Integer freshCycleCount) {
        this.freshCycleCount = freshCycleCount;
    }

    public Date getEcTime() {
        return ecTime;
    }

    public void setEcTime(Date ecTime) {
        this.ecTime = ecTime;
    }

    public String getEcCount() {
        return ecCount;
    }

    public void setEcCount(String ecCount) {
        this.ecCount = ecCount == null ? null : ecCount.trim();
    }

    public Date getInsemiTime() {
        return insemiTime;
    }

    public void setInsemiTime(Date insemiTime) {
        this.insemiTime = insemiTime;
    }

    public String getInsemiTypeId() {
        return insemiTypeId;
    }

    public void setInsemiTypeId(String insemiTypeId) {
        this.insemiTypeId = insemiTypeId == null ? null : insemiTypeId.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getMedicalRecordNo() {
        return medicalRecordNo;
    }

    public void setMedicalRecordNo(String medicalRecordNo) {
        this.medicalRecordNo = medicalRecordNo == null ? null : medicalRecordNo.trim();
    }

    public Integer getIsSmoking() {
        return isSmoking;
    }

    public void setIsSmoking(Integer isSmoking) {
        this.isSmoking = isSmoking;
    }

    public Integer getIsDrinking() {
        return isDrinking;
    }

    public void setIsDrinking(Integer isDrinking) {
        this.isDrinking = isDrinking;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getEmbryoScoreId() {
        return embryoScoreId;
    }

    public void setEmbryoScoreId(String embryoScoreId) {
        this.embryoScoreId = embryoScoreId == null ? null : embryoScoreId.trim();
    }
}
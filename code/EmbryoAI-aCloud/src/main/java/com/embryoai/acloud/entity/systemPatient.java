package com.embryoai.acloud.entity;

import java.util.Date;

public class systemPatient {
    private String id;

    private String idcardNo;

    private String idcardTypeId;

    private String patientName;

    private Date birthdate;

    private String country;

    private String locationId;

    private String address;

    private String email;

    private String mobile;

    private Date createTime;

    private Date updateTime;

    private Integer delFlag;

    private Integer isDrinking;

    private Integer isSmoking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    public String getIdcardTypeId() {
        return idcardTypeId;
    }

    public void setIdcardTypeId(String idcardTypeId) {
        this.idcardTypeId = idcardTypeId == null ? null : idcardTypeId.trim();
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId == null ? null : locationId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
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

    public Integer getIsDrinking() {
        return isDrinking;
    }

    public void setIsDrinking(Integer isDrinking) {
        this.isDrinking = isDrinking;
    }

    public Integer getIsSmoking() {
        return isSmoking;
    }

    public void setIsSmoking(Integer isSmoking) {
        this.isSmoking = isSmoking;
    }
}
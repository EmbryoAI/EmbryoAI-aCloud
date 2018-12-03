package com.embryoai.acloud.entity;

import java.util.Date;

public class sysOrg {
    private String id;

    private String orgName;

    private String orgDistrict;

    private String orgDepartment;

    private String orgAddress;

    private Date createTime;

    private Date updateTime;

    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getOrgDistrict() {
        return orgDistrict;
    }

    public void setOrgDistrict(String orgDistrict) {
        this.orgDistrict = orgDistrict == null ? null : orgDistrict.trim();
    }

    public String getOrgDepartment() {
        return orgDepartment;
    }

    public void setOrgDepartment(String orgDepartment) {
        this.orgDepartment = orgDepartment == null ? null : orgDepartment.trim();
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
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

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
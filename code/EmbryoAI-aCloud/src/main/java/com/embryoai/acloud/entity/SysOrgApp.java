package com.embryoai.acloud.entity;

public class SysOrgApp {
    private String acloudId;

    private String acloudKey;

    private String orgId;

    private String s3Username;

    private String s3Password;

    public String getAcloudId() {
        return acloudId;
    }

    public void setAcloudId(String acloudId) {
        this.acloudId = acloudId == null ? null : acloudId.trim();
    }

    public String getAcloudKey() {
        return acloudKey;
    }

    public void setAcloudKey(String acloudKey) {
        this.acloudKey = acloudKey == null ? null : acloudKey.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }

    public String getS3Username() {
        return s3Username;
    }

    public void setS3Username(String s3Username) {
        this.s3Username = s3Username == null ? null : s3Username.trim();
    }

    public String getS3Password() {
        return s3Password;
    }

    public void setS3Password(String s3Password) {
        this.s3Password = s3Password == null ? null : s3Password.trim();
    }
}
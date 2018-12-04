package com.embryoai.acloud.entity;

public class SysLocation {
    private String id;

    private String locationName;

    private String soleName;

    private String parentId;

    private Boolean locationLevel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName == null ? null : locationName.trim();
    }

    public String getSoleName() {
        return soleName;
    }

    public void setSoleName(String soleName) {
        this.soleName = soleName == null ? null : soleName.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Boolean getLocationLevel() {
        return locationLevel;
    }

    public void setLocationLevel(Boolean locationLevel) {
        this.locationLevel = locationLevel;
    }
}
package com.embryoai.acloud.entity;

public class SystemMilestone {
    private String id;

    private String embryoId;

    private String milestoneId;

    private String milestoneTime;

    private Integer milestoneElapse;

    private String userId;

    private Integer milestoneType;

    private String milestonePath;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEmbryoId() {
        return embryoId;
    }

    public void setEmbryoId(String embryoId) {
        this.embryoId = embryoId == null ? null : embryoId.trim();
    }

    

    public String getMilestoneId() {
		return milestoneId;
	}

	public void setMilestoneId(String milestoneId) {
		this.milestoneId = milestoneId;
	}

	public String getMilestoneTime() {
        return milestoneTime;
    }

    public void setMilestoneTime(String milestoneTime) {
        this.milestoneTime = milestoneTime == null ? null : milestoneTime.trim();
    }

    public Integer getMilestoneElapse() {
        return milestoneElapse;
    }

    public void setMilestoneElapse(Integer milestoneElapse) {
        this.milestoneElapse = milestoneElapse;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getMilestoneType() {
        return milestoneType;
    }

    public void setMilestoneType(Integer milestoneType) {
        this.milestoneType = milestoneType;
    }

    public String getMilestonePath() {
        return milestonePath;
    }

    public void setMilestonePath(String milestonePath) {
        this.milestonePath = milestonePath == null ? null : milestonePath.trim();
    }
}
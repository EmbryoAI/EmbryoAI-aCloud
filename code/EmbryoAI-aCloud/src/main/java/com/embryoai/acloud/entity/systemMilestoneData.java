package com.embryoai.acloud.entity;

public class systemMilestoneData {
    private String milestoneId;

    private Integer milestoneStage;

    private String pnId;

    private Integer cellCount;

    private String evenId;

    private String fragmentId;

    private String gradeId;

    private Double milestoneScore;

    private String userId;

    private String memo;

    public String getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(String milestoneId) {
        this.milestoneId = milestoneId == null ? null : milestoneId.trim();
    }

    public Integer getMilestoneStage() {
        return milestoneStage;
    }

    public void setMilestoneStage(Integer milestoneStage) {
        this.milestoneStage = milestoneStage;
    }

    public String getPnId() {
        return pnId;
    }

    public void setPnId(String pnId) {
        this.pnId = pnId == null ? null : pnId.trim();
    }

    public Integer getCellCount() {
        return cellCount;
    }

    public void setCellCount(Integer cellCount) {
        this.cellCount = cellCount;
    }

    public String getEvenId() {
        return evenId;
    }

    public void setEvenId(String evenId) {
        this.evenId = evenId == null ? null : evenId.trim();
    }

    public String getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(String fragmentId) {
        this.fragmentId = fragmentId == null ? null : fragmentId.trim();
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId == null ? null : gradeId.trim();
    }

    public Double getMilestoneScore() {
        return milestoneScore;
    }

    public void setMilestoneScore(Double milestoneScore) {
        this.milestoneScore = milestoneScore;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}
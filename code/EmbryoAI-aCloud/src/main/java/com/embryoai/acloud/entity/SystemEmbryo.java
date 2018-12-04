package com.embryoai.acloud.entity;

public class SystemEmbryo {
    private String id;

    private Integer embryoIndex;

    private String procedureId;

    private String cellId;

    private Double embryoScore;

    private String embryoFateId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getEmbryoIndex() {
        return embryoIndex;
    }

    public void setEmbryoIndex(Integer embryoIndex) {
        this.embryoIndex = embryoIndex;
    }

    public String getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(String procedureId) {
        this.procedureId = procedureId == null ? null : procedureId.trim();
    }

    public String getCellId() {
        return cellId;
    }

    public void setCellId(String cellId) {
        this.cellId = cellId == null ? null : cellId.trim();
    }

    public Double getEmbryoScore() {
        return embryoScore;
    }

    public void setEmbryoScore(Double embryoScore) {
        this.embryoScore = embryoScore;
    }

    public String getEmbryoFateId() {
        return embryoFateId;
    }

    public void setEmbryoFateId(String embryoFateId) {
        this.embryoFateId = embryoFateId == null ? null : embryoFateId.trim();
    }
}
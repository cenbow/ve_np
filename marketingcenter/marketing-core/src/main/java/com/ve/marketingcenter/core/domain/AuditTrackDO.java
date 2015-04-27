package com.ve.marketingcenter.core.domain;

import java.util.Date;

public class AuditTrackDO{
    private Long id;

    private Long recordedId;

    private Integer recordedType;

    private Integer auditType;

    private Long operatorId;

    private Date gmtCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRecordedId() {
        return recordedId;
    }

    public void setRecordedId(Long recordedId) {
        this.recordedId = recordedId;
    }

    public Integer getRecordedType() {
        return recordedType;
    }

    public void setRecordedType(Integer recordedType) {
        this.recordedType = recordedType;
    }

    public Integer getAuditType() {
        return auditType;
    }

    public void setAuditType(Integer auditType) {
        this.auditType = auditType;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }
}
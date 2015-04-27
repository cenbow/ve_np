package com.ve.marketingcenter.core.domain;

import java.util.Date;

public class ToolDO{
    private Long id;

    private String toolCode;

    private String toolName;

    private Integer implType;
    //spring管理的bean的name
    private String implContent;

    private Integer provType;

    private String provAppcode;

    private Long provUserId;

    private Integer status;

    private Integer deleteFlag;

    private Date gmtCreated;

    private Date gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolCode() {
        return toolCode;
    }

    public void setToolCode(String toolCode) {
        this.toolCode = toolCode == null ? null : toolCode.trim();
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName == null ? null : toolName.trim();
    }

    public Integer getImplType() {
        return implType;
    }

    public void setImplType(Integer implType) {
        this.implType = implType;
    }

    public String getImplContent() {
        return implContent;
    }

    public void setImplContent(String implContent) {
        this.implContent = implContent == null ? null : implContent.trim();
    }

    public Integer getProvType() {
        return provType;
    }

    public void setProvType(Integer provType) {
        this.provType = provType;
    }

    public String getProvAppcode() {
        return provAppcode;
    }

    public void setProvAppcode(String provAppcode) {
        this.provAppcode = provAppcode == null ? null : provAppcode.trim();
    }

    public Long getProvUserId() {
        return provUserId;
    }

    public void setProvUserId(Long provUserId) {
        this.provUserId = provUserId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
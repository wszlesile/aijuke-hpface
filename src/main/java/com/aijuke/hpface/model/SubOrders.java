package com.aijuke.hpface.model;

import java.io.Serializable;
import java.util.Date;

public class SubOrders implements Serializable {
    private Long id;

    private String subOrderCode;

    private Long customerId;

    private String orderCode;

    private Long houseId;

    private Long hotelId;

    private Date orderTime;

    private String fee;

    private String depositFee;

    private String totalFee;

    private Date inTime;

    private Date leaveTime;

    private Date latestHoldTime;

    private Date latestLeaveTime;

    private Date cancleTime;

    private Integer status;

    private String judgeContent;

    private String judgePictures;

    private Integer isDelete;

    private Date gmtCreate;

    private Long createUserId;

    private Date gmtModify;

    private Long modifyUserId;

    private Integer whetherCheck;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubOrderCode() {
        return subOrderCode;
    }

    public void setSubOrderCode(String subOrderCode) {
        this.subOrderCode = subOrderCode == null ? null : subOrderCode.trim();
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee == null ? null : fee.trim();
    }

    public String getDepositFee() {
        return depositFee;
    }

    public void setDepositFee(String depositFee) {
        this.depositFee = depositFee == null ? null : depositFee.trim();
    }

    public String getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(String totalFee) {
        this.totalFee = totalFee == null ? null : totalFee.trim();
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public Date getLatestHoldTime() {
        return latestHoldTime;
    }

    public void setLatestHoldTime(Date latestHoldTime) {
        this.latestHoldTime = latestHoldTime;
    }

    public Date getLatestLeaveTime() {
        return latestLeaveTime;
    }

    public void setLatestLeaveTime(Date latestLeaveTime) {
        this.latestLeaveTime = latestLeaveTime;
    }

    public Date getCancleTime() {
        return cancleTime;
    }

    public void setCancleTime(Date cancleTime) {
        this.cancleTime = cancleTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getJudgeContent() {
        return judgeContent;
    }

    public void setJudgeContent(String judgeContent) {
        this.judgeContent = judgeContent == null ? null : judgeContent.trim();
    }

    public String getJudgePictures() {
        return judgePictures;
    }

    public void setJudgePictures(String judgePictures) {
        this.judgePictures = judgePictures == null ? null : judgePictures.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public Long getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Long modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Integer getWhetherCheck() {
        return whetherCheck;
    }

    public void setWhetherCheck(Integer whetherCheck) {
        this.whetherCheck = whetherCheck;
    }
}
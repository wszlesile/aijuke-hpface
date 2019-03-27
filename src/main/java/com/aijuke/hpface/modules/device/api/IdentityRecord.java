package com.aijuke.hpface.modules.device.api;

import lombok.Data;


import java.util.Date;

@Data

public class IdentityRecord {

    private Long id;

    /**
     * 设备id
     */

    private Long deviceId;

    /**
     * 区域id
     */

    private Long areaId;
    /**
     * 区域名称
     */

    private String areaName;
    /**
     * 区域编号
     */
    private String areaNumber;

    /**
     * 区域id
     */

    private Long communityId;
    /**
     * 社区名称
     */
    private String communityName;
    /**
     * 社区编号
     */

    private String communityNumber;
    /**
     * 位置id
     */

    private Long locationId;
    /**
     * 位置名称
     */

    private String locationName;
    /**
     * 单元楼id
     */

    private Long unitId;
    /**
     * 单元楼名称
     */

    private String unitName;

    /**
     * 人员类型id
     */
    private String personTypeId;

    /**
     * 人员类型id
     */
    private String personTypeName;

    /**
     * 识别时间
     */
    private Date identityTime;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别  0：男   1：女
     */
    private Byte sex;

    /**
     * 身份证
     */
    private String identityNumber;

    /**
     * 民族
     */
    private String national;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 有效期限-开始
     */
    private Date expirationDateStart;

    /**
     * 有效期限-结束
     */
    private Date expirationDateEnd;

    /**
     * 签发机关
     */
    private String issue;

    /**
     * 地址
     */
    private String address;
    /**
     * 身份证照片
     */
    private String identityImages;

    /**
     * 抓拍照片
     */
    private String photo;
    /**
     * 开门方式 0、刷脸 1、刷证
     */
    private Byte openDoorType;

    /**
     * 识别状态 1、成功 2、失败
     */
    private Byte status;

    /**
     * 相似度
     */
    private String simDegree;

    /**
     * ic卡
     */
    private String ic;

    /**
     * 创建时间
     */
    private Date createTime;

    private Byte enterOrLeave;


    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取设备id
     *
     * @return device_id - 设备id
     */
    public Long getDeviceId() {
        return deviceId;
    }

    /**
     * 设置设备id
     *
     * @param deviceId 设备id
     */
    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    /**
     * 获取识别时间
     *
     * @return identity_time - 识别时间
     */
    public Date getIdentityTime() {
        return identityTime;
    }

    /**
     * 设置识别时间
     *
     * @param identityTime 识别时间
     */
    public void setIdentityTime(Date identityTime) {
        this.identityTime = identityTime;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证号
     *
     * @return identity_number - 身份证号
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * 设置身份证号
     *
     * @param identityNumber 身份证号
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    /**
     * 获取开门方式 0、刷脸 1、刷证
     *
     * @return open_door_type - 开门方式 0、刷脸 1、刷证
     */
    public Byte getOpenDoorType() {
        return openDoorType;
    }

    /**
     * 设置开门方式 0、刷脸 1、刷证
     *
     * @param openDoorType 开门方式 0、刷脸 1、刷证
     */
    public void setOpenDoorType(Byte openDoorType) {
        this.openDoorType = openDoorType;
    }

    /**
     * 获取识别状态 1、成功 2、失败
     *
     * @return status - 识别状态 1、成功 2、失败
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置识别状态 1、成功 2、失败
     *
     * @param status 识别状态 1、成功 2、失败
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取身份证照片
     *
     * @return identity_images - 身份证照片
     */
    public String getIdentityImages() {
        return identityImages;
    }

    /**
     * 设置身份证照片
     *
     * @param identityImages 身份证照片
     */
    public void setIdentityImages(String identityImages) {
        this.identityImages = identityImages;
    }

    /**
     * 获取抓拍照片
     *
     * @return photo - 抓拍照片
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 设置抓拍照片
     *
     * @param photo 抓拍照片
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 获取ic卡
     *
     * @return ic - ic卡
     */
    public String getIc() {
        return ic;
    }

    /**
     * 设置ic卡
     *
     * @param ic ic卡
     */
    public void setIc(String ic) {
        this.ic = ic;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private String uuid;


    private String mac;
    /**
     * 上报时间
     */

    private String date;


    private Integer pageNum;


    private Integer pageSize;


    private String identityDate;

    /**
     * 文字颜色
     */

    private String fontColor;


    private String backgroundColor;


    private String types;


}
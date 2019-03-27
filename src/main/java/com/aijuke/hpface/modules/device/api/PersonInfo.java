package com.aijuke.hpface.modules.device.api;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PersonInfo {
    /**
     * 身份证图片
     */
    private MultipartFile idenImg;
    /**
     * 人脸图片
     */
    private MultipartFile faceImg;
    /**
     * 身份证号码
     */
    private String identityNum;
    /**
     * 身份证用户姓名
     */
    private String customerName;
    /**
     * 身份证有效期
     */
    private String indate;
    /**
     * 身份证上的地址
     */
    private String address;
    /**
     * 身份证生日
     */
    private String birthDate;
    /**
     * 身份证性别  0：男   1：女
     */
    private String sex;
    /**
     * 身份证民族
     */
    private String nationality;
    /**
     * 身份证办证机关
     */
    private String issuingOrgan;
    /**
     * 区域编号
     */
    private String areaNum;
    /**
     * 布控点编号
     */
    private String devNo;

    private String mac;


    /**
     * 比对结果 0：成功 1：失败
     */
    private Integer result;
}

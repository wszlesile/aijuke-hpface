package com.aijuke.hpface.modules.device.api;

import lombok.Data;

import java.util.Date;

@Data
public class Device {
    private Long id;

    /**
     * 项目id
     */
    private Long deptId;

    /**
     * 位置id
     */
    private Long locationId;

    /**
     * 编号
     */
    private String number;

    /**
     * 版本号
     */
    private String version;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 厂商
     */
    private String firmType;

    /**
     * 型号
     */
    private String model;

    /**
     * 设备唯一码
     */
    private String deviceKey;

    /**
     * 位置
     */
    private String position;

    /**
     * ip
     */
    private String ip;

    /**
     * 端口
     */
    private String port;

    /**
     * mac地址
     */
    private String mac;

    /**
     * 网关
     */
    private String gateway;

    /**
     * 子网掩码
     */
    private String netmask;

    /**
     * dns
     */
    private String dns;

    /**
     * 机器码
     */
    private String machineCode;

    /**
     * 用户名
     */
    private String username;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 开门密码
     */
    private String doorPassword;

    /**
     * 授权类型 1、已授权 2、未授权 3、临时授权
     */
    private Byte authType;

    /**
     * 注册人数
     */
    private Long regmen;

    /**
     * 授权开始时间
     */
    private Date authStartTime;

    /**
     * 授权结束时间
     */
    private Date authEndTime;

    /**
     * 方向 0：进 1：出
     */
    private Byte enterOrLeave;

    /**
     * 0：在线 1：离线
     */
    private Byte onlineFlag;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 启用标识 0：启用 1：禁用
     */
    private Byte stateFlag;
    /**
     * 注册人数
     */
    private Long registeredNum;
    /**
     * 呼叫号码
     */
    private Integer callNumber;

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
     * 获取项目id
     *
     * @return dept_id - 项目id
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     * 设置项目id
     *
     * @param deptId 项目id
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     * 获取编号
     *
     * @return number - 编号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置编号
     *
     * @param number 编号
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取类型
     *
     * @return type - 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型
     *
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取厂商
     *
     * @return firm_type - 厂商
     */
    public String getFirmType() {
        return firmType;
    }

    /**
     * 设置厂商
     *
     * @param firmType 厂商
     */
    public void setFirmType(String firmType) {
        this.firmType = firmType;
    }

    /**
     * 获取型号
     *
     * @return model - 型号
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置型号
     *
     * @param model 型号
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * 获取位置
     *
     * @return position - 位置
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置位置
     *
     * @param position 位置
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取ip
     *
     * @return ip - ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置ip
     *
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取端口
     *
     * @return port - 端口
     */
    public String getPort() {
        return port;
    }

    /**
     * 设置端口
     *
     * @param port 端口
     */
    public void setPort(String port) {
        this.port = port;
    }

    /**
     * 获取mac地址
     *
     * @return mac - mac地址
     */
    public String getMac() {
        return mac;
    }

    /**
     * 设置mac地址
     *
     * @param mac mac地址
     */
    public void setMac(String mac) {
        this.mac = mac;
    }

    /**
     * 获取网关
     *
     * @return gateway - 网关
     */
    public String getGateway() {
        return gateway;
    }

    /**
     * 设置网关
     *
     * @param gateway 网关
     */
    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    /**
     * 获取子网掩码
     *
     * @return netmask - 子网掩码
     */
    public String getNetmask() {
        return netmask;
    }

    /**
     * 设置子网掩码
     *
     * @param netmask 子网掩码
     */
    public void setNetmask(String netmask) {
        this.netmask = netmask;
    }

    /**
     * 获取dns
     *
     * @return dns - dns
     */
    public String getDns() {
        return dns;
    }

    /**
     * 设置dns
     *
     * @param dns dns
     */
    public void setDns(String dns) {
        this.dns = dns;
    }

    /**
     * 获取机器码
     *
     * @return machine_code - 机器码
     */
    public String getMachineCode() {
        return machineCode;
    }

    /**
     * 设置机器码
     *
     * @param machineCode 机器码
     */
    public void setMachineCode(String machineCode) {
        this.machineCode = machineCode;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取开门密码
     *
     * @return door_password - 开门密码
     */
    public String getDoorPassword() {
        return doorPassword;
    }

    /**
     * 设置开门密码
     *
     * @param doorPassword 开门密码
     */
    public void setDoorPassword(String doorPassword) {
        this.doorPassword = doorPassword;
    }

    /**
     * 获取授权类型 1、已授权 2、未授权 3、临时授权
     *
     * @return auth_type - 授权类型 1、已授权 2、未授权 3、临时授权
     */
    public Byte getAuthType() {
        return authType;
    }

    /**
     * 设置授权类型 1、已授权 2、未授权 3、临时授权
     *
     * @param authType 授权类型 1、已授权 2、未授权 3、临时授权
     */
    public void setAuthType(Byte authType) {
        this.authType = authType;
    }

    /**
     * 获取注册人数
     *
     * @return regmen - 注册人数
     */
    public Long getRegmen() {
        return regmen;
    }

    /**
     * 设置注册人数
     *
     * @param regmen 注册人数
     */
    public void setRegmen(Long regmen) {
        this.regmen = regmen;
    }

    /**
     * 获取授权开始时间
     *
     * @return auth_start_time - 授权开始时间
     */
    public Date getAuthStartTime() {
        return authStartTime;
    }

    /**
     * 设置授权开始时间
     *
     * @param authStartTime 授权开始时间
     */
    public void setAuthStartTime(Date authStartTime) {
        this.authStartTime = authStartTime;
    }

    /**
     * 获取授权结束时间
     *
     * @return auth_end_time - 授权结束时间
     */
    public Date getAuthEndTime() {
        return authEndTime;
    }

    /**
     * 设置授权结束时间
     *
     * @param authEndTime 授权结束时间
     */
    public void setAuthEndTime(Date authEndTime) {
        this.authEndTime = authEndTime;
    }

    /**
     * 获取方向 0：进 1：出
     *
     * @return enter_or_leave - 方向 0：进 1：出
     */
    public Byte getEnterOrLeave() {
        return enterOrLeave;
    }

    /**
     * 设置方向 0：进 1：出
     *
     * @param enterOrLeave 方向 0：进 1：出
     */
    public void setEnterOrLeave(Byte enterOrLeave) {
        this.enterOrLeave = enterOrLeave;
    }

    /**
     * 获取0：在线 1：离线
     *
     * @return online_flag - 0：在线 1：离线
     */
    public Byte getOnlineFlag() {
        return onlineFlag;
    }

    /**
     * 设置0：在线 1：离线
     *
     * @param onlineFlag 0：在线 1：离线
     */
    public void setOnlineFlag(Byte onlineFlag) {
        this.onlineFlag = onlineFlag;
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

    /**
     * 获取启用标识 0：启用 1：禁用
     *
     * @return state_flag - 启用标识 0：启用 1：禁用
     */
    public Byte getStateFlag() {
        return stateFlag;
    }

    /**
     * 设置启用标识 0：启用 1：禁用
     *
     * @param stateFlag 启用标识 0：启用 1：禁用
     */
    public void setStateFlag(Byte stateFlag) {
        this.stateFlag = stateFlag;
    }

    /**
     * 一级标识
     */
    
    private String primaryIdentifier;
    /**
     * 二级标识
     */
    
    private String secondaryIdentifier;

    
    private Long optDeptId;
    
    private Long optUserId;

    
    private Long unitId;

    
    private Integer pageNum;

    
    private Integer pageSize;

    /**
     * 设备编号或mac地址
     */
    
    private String key;


    private String loginUsername;

    private Byte isSelect;

    private String deviceIds;

    private String typeName;

}
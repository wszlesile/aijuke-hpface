package com.aijuke.hpface.modules.device.socket;

import lombok.Data;

@Data
public class SyncPerson2Device {
    public SyncPerson2Device(){};

    public SyncPerson2Device(String uuid, String name, String faceImg, String userType, String idCardNum, String icCardNum) {
        this.uuid = uuid;
        this.name = name;
        this.faceImg = faceImg;
        this.userType = userType;
        this.idCardNum = idCardNum;
        this.icCardNum = icCardNum;
    }

    private String uuid;
    private String name;
    private String faceImg;
    private String userType;
    private String idCardNum;
    private String icCardNum;
}

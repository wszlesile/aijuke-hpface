package com.aijuke.hpface.modules.device.api;

import com.aijuke.hpface.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * 人证通设备上报接口
 */
@Slf4j
@RestController
@RequestMapping("/app/api")
public class RztApi {

    /**
     * 人证通推送人员信息
     *
     * @param personInfo
     * @return
     * @throws IOException
     */
    @RequestMapping("pushMessage")
    public Object activation(PersonInfo personInfo) {
        //log.info("接收到注册设备推送注册数据");
        //log.info(JSON.toJSONString(personInfo));
        return ResultEntity.success();

    }

    /**
     * 人证通心跳接口
     *
     * @return
     */
    @RequestMapping("testNet")
    public Object testNet() {
        //log.info("接收到注册设备发送心跳");
        return ResultEntity.success();
    }

    /**
     * 设备上传抓拍照片
     */
    @RequestMapping("linkagePhoto")
    public Object linkagePhoto(PersonInfo personInfo) throws IOException {
        //log.info("接收到注册上传抓拍照片");
        return ResultEntity.success();
    }

}

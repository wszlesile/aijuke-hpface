package com.aijuke.hpface.modules.device.api;

import com.aijuke.hpface.entity.ResultEntity;
import com.aijuke.hpface.service.IdentityPersonService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/rest/v1/device")
public class DeviceApi {
    @Autowired
    private IdentityPersonService identityPersonService;
    private static final Logger log = LoggerFactory.getLogger(DeviceApi.class);
    /**
     * 注册设备信息
     * @param device
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Object register(@RequestBody Device device) {
         log.info("接收上报注册信息");
         log.info(JSON.toJSONString(device));
         // 注册设备
         boolean flag=identityPersonService.registerDevice(device);
         if(flag){
            return ResultEntity.success();
         }else{
             return ResultEntity.fail("注册设备失败");
         }
    }
    @ResponseBody
    @RequestMapping("/updateDeviceInfo")
    public Object updateDeviceInfo(@RequestBody Device device) {
        log.info("接收设备修改信息");
        return ResultEntity.success();
    }

}

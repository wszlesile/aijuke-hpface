package com.aijuke.hpface.modules.device.api;

import com.aijuke.hpface.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("deviceTime")
public class DeviceTimeApi {

    /**
     * 设备同步平台时间
     * @return
     */
    @RequestMapping("check")
    public Object getCurrentTime() {
        log.info("设备同步平台时间");
        long aa=System.currentTimeMillis();
        return ResultEntity.success(aa);
    }
}

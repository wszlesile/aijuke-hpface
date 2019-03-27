package com.aijuke.hpface.modules.device.api;

import com.aijuke.hpface.entity.ResultEntity;
import com.aijuke.hpface.service.IdentityPersonService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * 识别记录api
 */
@Slf4j
@RestController
@RequestMapping("/rest/v1/identityRecord")
public class IdentityRecordApi {
   @Autowired
   private IdentityPersonService identityPersonService;
    /**
     * 设备推送识别记录
     * @param identityRecord
     * @return
     */
    @RequestMapping("/save")
    public Object save(IdentityRecord identityRecord){
        log.info("接收到设备推送识别记录数据");
        log.info(JSON.toJSONString(identityRecord));

        Map<String, Object> resultMap = identityPersonService.checkAllocationAndCheckIn(identityRecord);
        return ResultEntity.success(resultMap);
    }
}

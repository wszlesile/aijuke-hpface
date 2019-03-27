package com.aijuke.hpface.modules.device.api;

import com.aijuke.hpface.entity.ResultEntity;
import com.aijuke.hpface.mapper.IdentityFacePersonExtendsMapper;
import com.aijuke.hpface.model.IdentityFacePerson;
import com.aijuke.hpface.modules.device.socket.DeviceWebSocketHandler;
import com.aijuke.hpface.modules.device.socket.SyncPerson2Device;
import com.aijuke.hpface.service.IdentityPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Controller
@RequestMapping("/aijuke/hpface")
public class IdentifyUserController {
   @Autowired
   private IdentityPersonService identityPersonService;
   @Autowired
   private IdentityFacePersonExtendsMapper identityFacePersonExtendsMapper;
   @Autowired
   private DeviceWebSocketHandler deviceWebSocketHandler;
    // 新增或更新人员
    @RequestMapping("/addOrUpdate")
    @ResponseBody
    public Object addOrUpdate(long houseId,String uuid,String name ,String faceImg,@RequestParam(required = false,defaultValue = "2")String userType,String idCardNum,@RequestParam(required = false,defaultValue = "") String icCardNum) {
        Map<String,Object> resultMap = identityPersonService.addOrUpdate(houseId,
                new SyncPerson2Device( uuid,  name,  faceImg,  userType,  idCardNum,  icCardNum));
        return resultMap;
    }
    @RequestMapping("/test")
    @ResponseBody
    public Object test(){
        Map<String,Object> resultMap = new HashMap<>();
        long id =301044993132625952L;
        IdentityFacePerson identityFacePerson=identityFacePersonExtendsMapper.selectByPrimaryKey(id);
        SyncPerson2Device person=new SyncPerson2Device( id+"",  identityFacePerson.getName(),  identityFacePerson.getFaceImg(),  "2",  identityFacePerson.getIdCardNum(),  "");
        // 推送到设备上
        String mac = "8c:14:7d:d0:f4:f5";
        List<SyncPerson2Device> syncPerson2DeviceList = new ArrayList<>();
        syncPerson2DeviceList.add(person);
        boolean r = deviceWebSocketHandler.sendUser(syncPerson2DeviceList,mac);
        if(!r){
            resultMap.put("success",false);
            resultMap.put("msg","推送人员信息失败");
            return resultMap;
        }
        // 通知设备刷新
        boolean r1 = deviceWebSocketHandler.flushDevice(mac);
        if(!r1){
            resultMap.put("success",false);
            resultMap.put("msg","通知设备刷新信息失败");
            return resultMap;
        }
        resultMap.put("success",true);
        resultMap.put("msg","成功");
        return resultMap;
    }
    // 删除人员
    @RequestMapping("/del")
    @ResponseBody
    public Object del(long houseId,String idCardNum){
        Map<String,Object> resultMap = identityPersonService.del(houseId,idCardNum);
        return resultMap;
    }
    // 开门
    @RequestMapping("/openDoor")
    @ResponseBody
    public Object openDoor(String mac){
        Map<String,Object> resultMap = identityPersonService.openDoor(mac);
        return resultMap;
    }
}

package com.aijuke.hpface.service.impl;

import com.aijuke.hpface.common.GenerateIdUtil;
import com.aijuke.hpface.mapper.*;
import com.aijuke.hpface.model.*;
import com.aijuke.hpface.modules.device.api.Device;
import com.aijuke.hpface.modules.device.api.DeviceApi;
import com.aijuke.hpface.modules.device.api.IdentityRecord;
import com.aijuke.hpface.modules.device.socket.DeviceWebSocketHandler;
import com.aijuke.hpface.modules.device.socket.SyncPerson2Device;
import com.aijuke.hpface.service.IdentityPersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class IdentityPersonServiceImpl implements IdentityPersonService {
    @Autowired
    private CustomerAllocationRecordExtendsMapper customerAllocationRecordExtendsMapper;
    @Autowired
    private IdentityFaceDeviceExtendsMapper identityFaceDeviceExtendsMapper;
    @Autowired
    private DeviceWebSocketHandler deviceWebSocketHandler;
    @Autowired
    private IdentityFacePersonExtendsMapper identityFacePersonExtendsMapper;
    @Autowired
    private IdentityPersonHouseExtendsMapper identityPersonHouseExtendsMapper;
    @Autowired
    private CustomerExtendsMapper customerExtendsMapper;
    private static final Logger log = LoggerFactory.getLogger(DeviceApi.class);
    @Override
    public boolean registerDevice(Device device) {
        String mac = device.getMac();
        String deviceKey = device.getDeviceKey();
        Map<String,Object> params = new HashMap<>();
        params.put("mac",mac);
        params.put("deviceId",deviceKey);
        IdentityFaceDevice data = identityFaceDeviceExtendsMapper.selectOneByParams(params);
        if(data==null){
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Object> addOrUpdate(long houseId, SyncPerson2Device person) {
        Map<String,Object> resultMap = new HashMap<>();
        // 参数验证
        if(houseId == 0 ){
            resultMap.put("success",false);
            resultMap.put("msg","参数[houseId]不能为空");
            return resultMap;
        }
        if(person.getName()==null || person.getName().equals("")){
            resultMap.put("success",false);
            resultMap.put("msg","参数[name]不能为空");
            return resultMap;
        }
        if(person.getIdCardNum()==null || person.getIdCardNum().equals("")){
            resultMap.put("success",false);
            resultMap.put("msg","参数[idCardNum]不能为空");
            return resultMap;
        }
        if(person.getFaceImg()==null || person.getFaceImg().equals("")){
            resultMap.put("success",false);
            resultMap.put("msg","参数[faceImg]不能为空");
            return resultMap;
        }

        Map<String,Object> params = new HashMap<>();
        params.put("houseId",houseId);
        IdentityFaceDevice device = identityFaceDeviceExtendsMapper.selectOneByParams(params);
        if(device==null){
            resultMap.put("success",false);
            resultMap.put("msg","没有找到该房间绑定的设备信息");
            return resultMap;
        }

        params.put("name",person.getName());
        params.put("idCardNum",person.getIdCardNum());
        params.put("uuid",person.getUuid());
        IdentityFacePerson identityFacePerson = identityFacePersonExtendsMapper.selectOneByParams(params);
        // 将用户保存或更新
        if(identityFacePerson == null){
            // 保存
            IdentityFacePerson item = new IdentityFacePerson();
            item.setId(Long.parseLong(person.getUuid()));
            item.setName(person.getName());
            item.setIdCardNum(person.getIdCardNum());
            item.setIcCardNum(person.getIcCardNum());
            item.setUserType(person.getUserType());
            item.setFaceImg(person.getFaceImg());
            item.setSource(0);

            identityFacePersonExtendsMapper.insertSelective(item);
        }else{
            // 更新
            identityFacePerson.setName(person.getName());
            identityFacePerson.setIdCardNum(person.getIdCardNum());
            identityFacePerson.setIcCardNum(person.getIcCardNum());
            identityFacePerson.setUserType(person.getUserType());
            identityFacePerson.setFaceImg(person.getFaceImg());

            identityFacePersonExtendsMapper.updateByPrimaryKeySelective(identityFacePerson);
        }
        IdentityPersonHouse identityPersonHouse = identityPersonHouseExtendsMapper.selectOneByParams(params);
        if(identityPersonHouse == null){
            // 插入关系绑定表数据
            identityPersonHouse = new IdentityPersonHouse();
            identityPersonHouse.setHouseId(houseId);
            identityPersonHouse.setUuid(Long.parseLong(person.getUuid()));
            identityPersonHouse.setSource(0);
            identityPersonHouseExtendsMapper.insertSelective(identityPersonHouse);
        }

        // 推送到设备上
        String mac = device.getMac();
        List<SyncPerson2Device> syncPerson2DeviceList = new ArrayList<>();
        person.setUuid(person.getUuid());
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
        resultMap.put("msg","success");
        return resultMap;
    }

    @Override
    public Map<String, Object> del(long houseId, String idCardNum) {
        Map<String,Object> resultMap = new HashMap<>();
        // 参数验证
        if(houseId == 0){
            resultMap.put("success",false);
            resultMap.put("msg","参数[houseId]不能为空");
            return resultMap;
        }
        if(idCardNum == null || idCardNum.equals("")){
            resultMap.put("success",false);
            resultMap.put("msg","参数[idCardNum]不能为空");
            return resultMap;
        }

        Map<String,Object> params = new HashMap<>();
        params.put("houseId",houseId);
        IdentityFaceDevice device = identityFaceDeviceExtendsMapper.selectOneByParams(params);
        if(device==null){
            resultMap.put("success",false);
            resultMap.put("msg","没有找到该房间绑定的设备信息");
            return resultMap;
        }

        // 获取uuid
        params.put("idCardNum",idCardNum);
        IdentityFacePerson identityFacePerson = identityFacePersonExtendsMapper.selectOneByParams(params);
        if(identityFacePerson==null){
            resultMap.put("success",false);
            resultMap.put("msg","没有找到该用户信息");
            return resultMap;
        }
        long uid = identityFacePerson.getId();
        String uuid = String.valueOf(uid);
        String mac = device.getMac();
        boolean r = deviceWebSocketHandler.deleteUser(mac,idCardNum,uuid);
        if(!r){
            resultMap.put("success",false);
            resultMap.put("msg","删除人员信息失败");
            return resultMap;
        }
        params.put("uuid",uid);
        // 删除关系表数据
        IdentityPersonHouse identityPersonHouse = identityPersonHouseExtendsMapper.selectOneByParams(params);
        if(identityPersonHouse==null){
            resultMap.put("success",false);
            resultMap.put("msg","没有用户房间绑定关系，删除失败");
            return resultMap;
        }
        identityPersonHouseExtendsMapper.deleteByPrimaryKey(identityPersonHouse.getId());
        resultMap.put("success",true);
        resultMap.put("msg","success");
        return resultMap;
    }

    @Override
    public Map<String, Object> openDoor(String mac) {
        Map<String,Object> resultMap = new HashMap<>();
        deviceWebSocketHandler.openDoor(mac);
        resultMap.put("success",true);
        resultMap.put("msg","success");
        return resultMap;
    }

    @Override
    public Map<String, Object> checkAllocationAndCheckIn(IdentityRecord identityRecord) {
        Map<String, Object> resultMap = new HashMap<>(2);
        int openDoorCommand=0;// 0 不开门，1 开门 默认不开门
        String mac = identityRecord.getMac();
        // 根据mac地址查出房间信息
        Map<String,Object> params = new HashMap<>();
        params.put("mac",mac);
        IdentityFaceDevice identityFaceDevice = identityFaceDeviceExtendsMapper.selectOneByParams(params);
        if(identityFaceDevice == null){
            resultMap.put("openDoorCommand", openDoorCommand);
            resultMap.put("openDoorNotice", "没有该设备信息");
            return resultMap;
        }
        long houseId = identityFaceDevice.getHouseId();

        String name = identityRecord.getName();
        String idCardNum = identityRecord.getIdentityNumber();
        params.put("name",name);
        params.put("cardNo",idCardNum);
        Customer customer = customerExtendsMapper.selectOneByParams(params);
        if(customer == null){
            resultMap.put("openDoorCommand", openDoorCommand);
            resultMap.put("openDoorNotice", "没有该用户信息");
            return resultMap;
        }
        long customerId = customer.getId();

        params.put("houseId",houseId);
        params.put("customerId",customerId);
        params.put("houseId", houseId);
        params.put("status", 0);
        params.put("whetherCheck", 1);
        CustomerAllocationRecord allocationRecord = customerAllocationRecordExtendsMapper.selectTodayByParams(params);
        if(allocationRecord == null){
            resultMap.put("openDoorCommand", openDoorCommand);
            resultMap.put("openDoorNotice", "没有该用户入住信息");
            return resultMap;
        }
        // 入住
        allocationRecord.setStatus(1);
        customerAllocationRecordExtendsMapper.updateByPrimaryKeySelective(allocationRecord);
        openDoorCommand=1;// 入住成功 开门
        resultMap.put("openDoorCommand", openDoorCommand);
        resultMap.put("openDoorNotice", "欢迎入住");
        return  resultMap;
    }
}

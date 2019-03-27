package com.aijuke.hpface.service;

import com.aijuke.hpface.modules.device.api.Device;
import com.aijuke.hpface.modules.device.api.IdentityRecord;
import com.aijuke.hpface.modules.device.socket.SyncPerson2Device;

import java.util.Map;
public interface IdentityPersonService {
    boolean registerDevice(Device device);
    Map<String,Object> addOrUpdate(long houseId,SyncPerson2Device person);
    Map<String,Object> del(long houseId,String idCardNum);
    Map<String,Object> openDoor(String mac);
    Map<String,Object> checkAllocationAndCheckIn(IdentityRecord identityRecord);
}

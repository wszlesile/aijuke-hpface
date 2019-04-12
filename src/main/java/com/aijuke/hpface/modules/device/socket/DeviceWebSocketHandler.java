package com.aijuke.hpface.modules.device.socket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Slf4j
public class DeviceWebSocketHandler extends BinaryWebSocketHandler {
    public static final Map<String, WebSocketSession> USERS;
    public static final Map<String, WebSocketSession> SCREENS;

    static {
        USERS = new ConcurrentHashMap<>();
        SCREENS = new ConcurrentHashMap<>();
    }

    private void remove(WebSocketSession session) {
        Iterator<Map.Entry<String, WebSocketSession>> iterator = USERS.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WebSocketSession> entry = iterator.next();
            if (entry.getValue() == session) {
                iterator.remove();
            }
        }

        iterator = SCREENS.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, WebSocketSession> entry = iterator.next();
            if (entry.getValue() == session) {
                iterator.remove();
            }
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        this.remove(session);
    }

    /**
     * 接收消息
     * @param session
     * @param message
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        String msg = message.getPayload();
        log.info("socket accept:"+msg);
        JSONObject accept = JSON.parseObject(msg);
        String mac = accept.getString("mac");
        if(!USERS.containsKey(mac)){
            // 加入
            USERS.put(mac,session);
        }
        this.sendMessage(session,"");
    }

    /**
     * 推送人员新增信息
     *
     */
    public Boolean sendUser(List<SyncPerson2Device> personList, String mac) {
        if (mac != null ) {
            WebSocketSession session = USERS.get(mac);
            if (session != null) {
                if (session.isOpen()) {
                    Map<String, Object> msg = new HashMap<>(3);
                    msg.put("flag", "101");
                    msg.put("mac", mac);
                    msg.put("data", personList);
                    //log.info("sendUser params "+JSONObject.toJSONString(msg));
                    Boolean flag = this.sendMessage(session, JSONObject.toJSONString(msg));
                    return flag;
                }
            }
        }
        return false;
    }

    /**
     * 在设备上删除人员信息
     */
    public boolean deleteUser(String mac,String idCardNum,String uuid) {
        boolean flag = false;
        WebSocketSession session = USERS.get(mac);
        if (session != null) {
            if (session.isOpen()) {
                Map<String, Object> msg = new HashMap<>(3);
                msg.put("flag", "102");
                msg.put("mac", mac);

                Map<String, Object> person = new HashMap<>(2);
                person.put("idCardNum", idCardNum);
                person.put("uuid", uuid);
                msg.put("data", person);
                log.info("sendUser params "+JSONObject.toJSONString(msg));
                flag = this.sendMessage(session, JSONObject.toJSONString(msg));
            }
        }
        return flag;
    }

    // 开门
     public boolean openDoor(String mac){
         boolean flag = false;
         WebSocketSession session = USERS.get(mac);
         if (session != null) {
             if (session.isOpen()) {
                 Map<String, Object> msg = new HashMap<>(3);
                 msg.put("flag", "6");
                 msg.put("mac", mac);
                 msg.put("data", "");
                 flag = this.sendMessage(session, JSONObject.toJSONString(msg));
             }
         }
         return flag;
     }
    // 通知设备刷新
    public boolean flushDevice(String mac){
        boolean flag = false;
        WebSocketSession session = USERS.get(mac);
        if (session != null) {
            if (session.isOpen()) {
                Map<String, Object> msg = new HashMap<>(3);
                msg.put("flag", "104");
                msg.put("mac", mac);
                msg.put("data", "");
                flag = this.sendMessage(session, JSONObject.toJSONString(msg));
            }
        }
        return flag;
    }
    /**
     * 平台往客户端发送消息
     *
     * @param session 客户端链接session
     * @param message 消息字符串
     */
    public Boolean sendMessage(WebSocketSession session, String message) {
        TextMessage textMessage = new TextMessage(message);
        try {
            synchronized (session) {
                session.sendMessage(textMessage);
            }
            return true;
        } catch (Exception e) {

            return false;
        }
    }

}

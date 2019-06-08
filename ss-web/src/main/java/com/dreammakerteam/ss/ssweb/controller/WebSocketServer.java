package com.dreammakerteam.ss.ssweb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/ws")
@Component
@Slf4j
public class WebSocketServer {

    private static String msg = null;

    private static CopyOnWriteArraySet<Session> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("sid") String sid) {
        webSocketSet.add(session);
        try {
            sendMessage(session, new MsgBean<>("msg", msg));

            for (Session item : webSocketSet) {
                try {
                    sendMessage(item, new MsgBean<>("userNum", webSocketSet.size()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            log.error("websocket IO异常");
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(session);

        for (Session item : webSocketSet) {
            try {
                sendMessage(item, new MsgBean<>("userNum", webSocketSet.size()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(Session session, MsgBean<?> message) throws IOException {
        session.getBasicRemote().sendText(message.toJson());
    }
    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息*/
    @OnMessage
    public void onMessage(String message, Session session) {
        msg = message;
        //群发消息
        for (Session item : webSocketSet) {
            if (item.equals(session)) {
                continue;
            }
            try {
                sendMessage(item, new MsgBean<>("msg", message));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        webSocketSet.remove(session);
        error.printStackTrace();

        for (Session item : webSocketSet) {
            if (item.equals(session)) {
                continue;
            }
            try {
                sendMessage(session, new MsgBean<>("userNum", webSocketSet.size()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    @Getter
    @Setter
    @AllArgsConstructor
    private class MsgBean<T> {
        private String type;
        private T data;

        public String toJson() {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writeValueAsString(this);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return "";
            }
        }
    }
}

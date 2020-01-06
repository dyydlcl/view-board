package bozecps.viewBoard.config.websocket;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static bozecps.viewBoard.utils.WebSocketCustom.*;

@Component
@ServerEndpoint(value = "/productWebSocket/{userId}",configurator = EndpointConfigure.class)
public class ProductWebSocket {
    //静态变量，用来记录当前在线连接数。应当设计为线程安全的
    private static final AtomicInteger OnlineCount = new AtomicInteger(0);
    //concurrent包的线程安全Map，用来存放每个客户端对应的ProductWebSocket对象
    private static ConcurrentHashMap<String,Session> webSocketMap = new ConcurrentHashMap<>();
    //与某个客户端的连接对话，需要通过他来给客户端发送数据
    private Session session;
    private Logger logger = LoggerFactory.getLogger(ProductWebSocket.class);

    /**
     * 连接建立成功调用的方法
     * @param userId
     * @param session
     */
    @OnOpen
    public void onOpen(@PathParam("userId")String userId,Session session){
        logger.info("new client connect, user id: "+userId);
        this.setSession(session);
        webSocketMap.put(userId,getSession());
        addOnlineCount();
        List<String> totalPushMessages = new ArrayList<>();
        if (StringUtils.equalsAnyIgnoreCase(userId,LINE1)||StringUtils.equalsAnyIgnoreCase(userId,LINE2)){
            if(webSocketMap.get(CLEANER1)==null){
                return;
            }
            totalPushMessages.add("read");
            if (!totalPushMessages.isEmpty()){
                totalPushMessages.forEach(e->sendMessage(e,webSocketMap.get(CLEANER1)));
            }
        }
    }

    /**
     * 连接关闭调用方法
     */
    @OnClose
    public void onClose() throws IOException {
        logger.info("A connect has closed");
        Collection<Session> collection = webSocketMap.values();
        while (collection.contains(getSession())){
            collection.remove(getSession());
        }
        getSession().close();
        subOnlineCount();
    }

    /**
     * 收到客户端消息后调用的方法
     * @param message
     * @param session
     */
    @OnMessage
    public void onMessage(String message,Session session){
        logger.info("received messages are "+message);
    }

    /**
     * 发生错误时调用
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session,Throwable throwable){
        logger.error("websocket has error");
        throwable.printStackTrace();
    }

    private static synchronized void subOnlineCount() {
        OnlineCount.decrementAndGet();
    }

    private void sendMessage(String message,Session session) {
        try{
            session.getBasicRemote().sendText(message);
            logger.info("send message successfully,message is "+message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static synchronized int getOnlineCount() {
        return  OnlineCount.get();
    }

    private static synchronized void addOnlineCount() {
        OnlineCount.incrementAndGet();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}

package assignment2.endpoints;

import assignment2.model.Message;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@ServerEndpoint(value = "/chess")
public class ChessEndpoint {
    private Session session = null;
    private static List<Session> sessionList = new LinkedList<>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        sessionList.add(session);
    }

    @OnClose
    public void onClose(Session session){
        sessionList.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        throwable.printStackTrace();
    }

    @OnMessage
    public void onMessage(Session session, String string){
        sessionList.forEach( item -> {
            if (item == this.session) return;
            try {
                item.getBasicRemote().sendText(string);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

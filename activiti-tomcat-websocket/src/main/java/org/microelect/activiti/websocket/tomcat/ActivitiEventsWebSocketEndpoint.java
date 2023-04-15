package org.microelect.activiti.websocket.tomcat;

import org.springframework.stereotype.Component;

import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(ActivitiEventsWebSocketEndpoint.ENDPOINT_URI)
@Component
public class ActivitiEventsWebSocketEndpoint {
    public static final String ENDPOINT_URI = "/ws/activiti-events";

    @OnOpen
    public void onOpen() {

    }

    @OnError
    public void onError() {

    }

    @OnMessage
    public void onMessage() {

    }
}

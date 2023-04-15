package org.microelect.activiti.websocket.tomcat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import javax.websocket.DeploymentException;
import javax.websocket.server.ServerContainer;
import javax.websocket.server.ServerEndpointConfig;

@Configuration
public class ActivitiTomcatWebsocketConfiguration {

    private final ServletContext servletContext;
    public ActivitiTomcatWebsocketConfiguration(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Bean
    public ActivitiEventsWebSocketEndpoint getActivitiEventsWebSocketEndpoint() {
        return new ActivitiEventsWebSocketEndpoint();
    }

    @PostConstruct
    public void configureWebSocketResources(ActivitiEventsWebSocketEndpoint activitiEventsWebSocketEndpoint) {
        final ServerContainer  webSocketServerContainer = (ServerContainer) this.servletContext
                .getAttribute("javax.websocket.server.ServerContainer");
        try {
            webSocketServerContainer.addEndpoint(addActivitiEventsEndpoint(activitiEventsWebSocketEndpoint));
        } catch (DeploymentException exception) {
            throw new IllegalStateException(exception);
        }
    }

    private ServerEndpointConfig addActivitiEventsEndpoint(ActivitiEventsWebSocketEndpoint activitiEventsWebSocketEndpoint) {
        return ServerEndpointConfig.Builder
                .create(ActivitiEventsWebSocketEndpoint.class, ActivitiEventsWebSocketEndpoint.ENDPOINT_URI)
                .configurator(createConfigurator(activitiEventsWebSocketEndpoint))
                .build();
    }

    private ServerEndpointConfig.Configurator createConfigurator(ActivitiEventsWebSocketEndpoint activitiEventsWebSocketEndpoint) {
        return new ServerEndpointConfig.Configurator() {
            @Override
            public <T> T getEndpointInstance(Class<T> endpointClass) {
                return (T) activitiEventsWebSocketEndpoint;
            }
        };
    }
}

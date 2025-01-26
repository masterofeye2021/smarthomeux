package de.smarthome.smartux;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import de.smarthome.smartux.eventSystem.MessageDecoder;
import de.smarthome.smartux.eventSystem.MessageEncoder;
import de.smarthome.smartux.eventSystem.OpenhabEndpoint;
import de.smarthome.smartux.eventSystem.PingEncoder;
import jakarta.annotation.PostConstruct;
import jakarta.websocket.ClientEndpointConfig;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.WebSocketContainer;

@Service
public class WebSocket {

    @Autowired
    OpenhabEndpoint client;

    @PostConstruct
    public void init() {

        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://192.168.178.232:8080/ws";

        try {
            ClientEndpointConfig config = ClientEndpointConfig.Builder.create()
                    .encoders(List.of(MessageEncoder.class, PingEncoder.class)) // Encoder registrieren
                    .decoders(List.of(MessageDecoder.class)) // Decoder registrieren
                    .build();

            container.connectToServer(client, config, URI.create(uri));

        } catch (DeploymentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    WebSocket() {

    }
}

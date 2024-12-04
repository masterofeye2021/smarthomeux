package de.smarthome.smartux;

import com.google.gson.Gson;

import de.Message;
import de.Ping;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PingEncoder implements Encoder.Text<Ping> {

    private static Gson gson = new Gson();

    @Override
    public String encode(Ping message) throws EncodeException {
        log.trace("Message: " + message.toString());
        return gson.toJson(message);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}
package de.smarthome.smartux.eventsystem;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import de.Message;
import de.Ping;
import de.smarthome.smartux.OpenhabItemRegister;
import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.CloseReason;
import jakarta.websocket.DecodeException;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.MessageHandler;
import jakarta.websocket.Session;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OpenhabEndpoint extends Endpoint {

    Session currentSession;

    private final MessageEncoder encoder = new MessageEncoder();
    private final MessageDecoder decoder = new MessageDecoder();
    private final PingEncoder pingEncoder = new PingEncoder();

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    OpenhabItemRegister ohItemRegister;

    private static Gson gson = new Gson();

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        currentSession = session;

        encoder.init(config);
        decoder.init(config);
        pingEncoder.init(config);

        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {

                try {
                    if (message.contains("PONG"))
                        return;

                    Message m = decoder.decode(message);
                    log.trace(
                            "Message Type: " + m.getType() + " topic: " + m.getTopic() + " payload: " + m.getPayload());
                    switch (m.getType()) {
                        case "ItemAddedEvent":
                            onItemAddedEvent(session, m);
                        case "ItemRemovedEvent":
                            onItemRemovedEvent(session, m);
                        case "ItemStateUpdatedEvent":
                            onItemStateUpdatedEvent(session, m);
                            break;
                        case "ItemCommandEvent":
                            onItemCommandEvent(session, m);
                            break;
                        case "ItemStateEvent":
                            onItemStateEvent(session, m);
                            break;
                        case "ItemStatePredictedEvent":
                            onItemStatePredictedEvent(session, m);
                            break;
                        case "ItemStateChangedEvent":
                            onItemStateChangedEvent(session, m);
                            break;
                        case "GroupItemStateChangedEvent":
                            onGroupItemStateChangedEvent(session, m);
                            break;
                        case "WebSocketEvent":
                            break;
                        case "ThingStatusInfoEvent":
                            break;
                        default:
                            log.error("THe following event is not part of the Event Handling: " + m.getType(),
                                    new IllegalArgumentException());
                            break;
                    }
                } catch (DecodeException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    public void ping() throws IOException, EncodeException {
        if (currentSession != null) {
            currentSession.getBasicRemote().sendObject(new Ping());
        }
    }

    public void onItemAddedEvent(Session session, Message message) {
        log.trace("[ItemAddedEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
    }

    public void onItemRemovedEvent(Session session, Message message) {
        log.trace("[ItemRemovedEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
    }

    /**
     * @brief The state of an item has changed.
     * @param session
     * @param message
     */
    public void onItemStateUpdatedEvent(Session session, Message message) {
        log.trace("[ItemStateUpdatedEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
        String topic = message.getTopic().split("/")[2];

        if (ohItemRegister.isItemRegistered(topic)) {
            try {
                JsonObject jsonObject = gson.fromJson(message.getPayload(), JsonObject.class);
                if (jsonObject.get("value").isJsonNull())
                    throw new RuntimeException();

                if (!jsonObject.get("type").getAsString().equals("DateTime") &&
                        ohItemRegister.getItem(topic).getStateDescription() != null) {
                    String pattern = ohItemRegister.getItem(topic).getStateDescription().getPattern();
                    String value = jsonObject.get("value").getAsString();
                    String format = String.format(java.util.Locale.US, pattern, Float.parseFloat(value));
                    jsonObject.addProperty("value", format);
                    message.setPayload(jsonObject.toString());
                }

                eventPublisher.publishEvent(new ItemStateUpdatedEvent(this, topic, message.getPayload()));
            } catch (Exception e) {
                log.error("Error in onItemStateEvent: " + message.getTopic(), e);
            }
        } else {
            /* Item is not registered, so we will ignore it */
            return;
        }
    }

    /**
     * @brief A command is sent to an item via a channel.
     * @param session
     * @param message
     */
    public void onItemCommandEvent(Session session, Message message) {
        log.trace("[ItemCommandEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
    }

    /**
     * @brief The state of an item is updated.
     * @param session
     * @param message
     */
    public void onItemStateEvent(Session session, Message message) {
        log.trace("[ItemStateEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
        String topic = message.getTopic().split("/")[2];

        if (ohItemRegister.isItemRegistered(topic)) {
            try {
                JsonObject jsonObject = gson.fromJson(message.getPayload(), JsonObject.class);
                if (jsonObject.get("value").isJsonNull())
                    throw new RuntimeException();

                if (!jsonObject.get("type").getAsString().equals("DateTime") &&
                        ohItemRegister.getItem(topic).getStateDescription() != null) {
                    String pattern = ohItemRegister.getItem(topic).getStateDescription().getPattern();
                    String value = jsonObject.get("value").getAsString();
                    String format = String.format(java.util.Locale.US, pattern, Float.parseFloat(value));
                    jsonObject.addProperty("value", format);
                    message.setPayload(jsonObject.toString());
                }

                eventPublisher.publishEvent(new ItemStateEvent(this, topic, message.getPayload()));
            } catch (Exception e) {
                log.error("Error in onItemStateEvent: " + message.getTopic(), e);
            }
        } else {
            /* Item is not registered, so we will ignore it */
            return;
        }
    }

    /**
     * @brief The state of an item is updated.
     * @param session
     * @param message
     */
    public void onItemStatePredictedEvent(Session session, Message message) {
        log.trace("[ItemStatePredictedEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
    }

    /**
     * @brief The state of an item has changed.
     * @param session
     * @param message
     */
    public void onItemStateChangedEvent(Session session, Message message) {
        log.trace("[ItemStateChangedEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
        String topic = message.getTopic().split("/")[2];

        if (ohItemRegister.isItemRegistered(topic)) {
            try {
                JsonObject jsonObject = gson.fromJson(message.getPayload(), JsonObject.class);
                if (jsonObject.get("value").isJsonNull())
                    throw new RuntimeException();

                if (!jsonObject.get("type").getAsString().equals("DateTime") &&
                        ohItemRegister.getItem(topic).getStateDescription() != null) {
                    String pattern = ohItemRegister.getItem(topic).getStateDescription().getPattern();
                    String value = jsonObject.get("value").getAsString();
                    String format = String.format(java.util.Locale.US, pattern, Float.parseFloat(value));
                    jsonObject.addProperty("value", format);
                    message.setPayload(jsonObject.toString());
                }

                eventPublisher.publishEvent(new ItemStateChangedEvent(this, topic, message.getPayload()));
            } catch (Exception e) {
                log.error("Error in onItemStateEvent: " + message.getTopic(), e);
            }
        } else {
            /* Item is not registered, so we will ignore it */
            return;
        }
    }

    /**
     * @brief The state of an item has changed.
     * @param session
     * @param message
     */
    public void onGroupItemStateChangedEvent(Session session, Message message) {
        log.trace("[GroupItemStateChangedEvent] topic:" + message.getTopic() + " Data: " + message.getPayload());
    }

    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Verbindung geschlossen: " + closeReason.getReasonPhrase());
    }

    @Override
    public void onError(Session session, Throwable throwable) {
        System.err.println("Fehler aufgetreten: " + throwable.getMessage());
    }

}

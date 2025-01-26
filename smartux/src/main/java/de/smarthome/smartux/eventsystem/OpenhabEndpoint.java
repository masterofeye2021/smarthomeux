package de.smarthome.smartux.eventSystem;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import de.Message;
import de.Ping;
import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateChangedEvent;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateEvent;
import de.smarthome.smartux.eventSystem.eventTypes.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.OpenhabItem;
import jakarta.websocket.CloseReason;
import jakarta.websocket.DecodeException;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.MessageHandler;
import jakarta.websocket.Session;
import lombok.extern.slf4j.Slf4j;

/**
 * @brief WebSocket endpoint for handling OpenHAB events.
 */
@Component
@Slf4j
public class OpenhabEndpoint extends Endpoint {

    private static final String ITEM_ADDED_EVENT = "ItemAddedEvent";
    private static final String ITEM_REMOVED_EVENT = "ItemRemovedEvent";
    private static final String ITEM_STATE_UPDATED_EVENT = "ItemStateUpdatedEvent";
    private static final String ITEM_COMMAND_EVENT = "ItemCommandEvent";
    private static final String ITEM_STATE_EVENT = "ItemStateEvent";
    private static final String ITEM_STATE_PREDICTED_EVENT = "ItemStatePredictedEvent";
    private static final String ITEM_STATE_CHANGED_EVENT = "ItemStateChangedEvent";
    private static final String GROUP_ITEM_STATE_CHANGED_EVENT = "GroupItemStateChangedEvent";
    private static final String WEB_SOCKET_EVENT = "WebSocketEvent";
    private static final String THING_STATUS_INFO_EVENT = "ThingStatusInfoEvent";

    private Session currentSession;

    private final MessageEncoder encoder = new MessageEncoder();
    private final MessageDecoder decoder = new MessageDecoder();
    private final PingEncoder pingEncoder = new PingEncoder();

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private OpenhabItemRegister ohItemRegister;

    private static final Gson gson = new Gson();

    /**
     * @brief Called when the WebSocket connection is opened.
     * @param session The WebSocket session.
     * @param config  The endpoint configuration.
     */
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
                    log.trace("Message Type: {} topic: {} payload: {}", m.getType(), m.getTopic(), m.getPayload());
                    handleEvent(session, m);
                } catch (DecodeException e) {
                    log.error("Error decoding message: {}", message, e);
                }
            }
        });
    }

    /**
     * @brief Handles different types of events.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    private void handleEvent(Session session, Message message) {
        switch (message.getType()) {
            case ITEM_ADDED_EVENT -> onItemAddedEvent(session, message);
            case ITEM_REMOVED_EVENT -> onItemRemovedEvent(session, message);
            case ITEM_STATE_UPDATED_EVENT -> onItemStateUpdatedEvent(session, message);
            case ITEM_COMMAND_EVENT -> onItemCommandEvent(session, message);
            case ITEM_STATE_EVENT -> onItemStateEvent(session, message);
            case ITEM_STATE_PREDICTED_EVENT -> onItemStatePredictedEvent(session, message);
            case ITEM_STATE_CHANGED_EVENT -> onItemStateChangedEvent(session, message);
            case GROUP_ITEM_STATE_CHANGED_EVENT -> onGroupItemStateChangedEvent(session, message);
            case WEB_SOCKET_EVENT, THING_STATUS_INFO_EVENT ->
                log.trace("Event type {} is not handled", message.getType());
            default -> log.error("The following event is not part of the Event Handling: {}", message.getType(),
                    new IllegalArgumentException());
        }
    }

    /**
     * @brief Sends a ping message.
     * @throws IOException     If an I/O error occurs.
     * @throws EncodeException If an encoding error occurs.
     */
    public void ping() throws IOException, EncodeException {
        if (currentSession != null) {
            currentSession.getBasicRemote().sendObject(new Ping());
        }
    }

    /**
     * @brief Handles ItemAddedEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onItemAddedEvent(Session session, Message message) {
        log.trace("[ItemAddedEvent] topic: {} Data: {}", message.getTopic(), message.getPayload());
    }

    /**
     * @brief Handles ItemRemovedEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onItemRemovedEvent(Session session, Message message) {
        log.trace("[ItemRemovedEvent] topic: {} Data: {}", message.getTopic(), message.getPayload());
    }

    /**
     * @brief Handles ItemStateUpdatedEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onItemStateUpdatedEvent(Session session, Message message) {
        log.trace("[ItemStateUpdatedEvent] topic: {} Data: {}", message.getTopic(), message.getPayload());
        handleItemStateEvent(session, message, ItemStateUpdatedEvent.class);
    }

    /**
     * @brief Handles ItemCommandEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onItemCommandEvent(Session session, Message message) {
        log.trace("[ItemCommandEvent] topic: {} Data: {}", message.getTopic(), message.getPayload());
    }

    /**
     * @brief Handles ItemStateEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onItemStateEvent(Session session, Message message) {
        log.trace("[ItemStateEvent] topic: {} Data: {}", message.getTopic(), message.getPayload());
        handleItemStateEvent(session, message, ItemStateEvent.class);
    }

    /**
     * @brief Handles ItemStatePredictedEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onItemStatePredictedEvent(Session session, Message message) {
        log.trace("[ItemStatePredictedEvent] topic: {} Data: {}", message.getTopic(), message.getPayload());
    }

    /**
     * @brief Handles ItemStateChangedEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onItemStateChangedEvent(Session session, Message message) {
        log.trace("[ItemStateChangedEvent] topic: {} Data: {} received.", message.getTopic(), message.getPayload());
        handleItemStateEvent(session, message, ItemStateChangedEvent.class);
    }

    /**
     * @brief Handles GroupItemStateChangedEvent.
     * @param session The WebSocket session.
     * @param message The message received.
     */
    public void onGroupItemStateChangedEvent(Session session, Message message) {
        log.trace("[GroupItemStateChangedEvent] topic: {} Data: {}", message.getTopic(), message.getPayload());
    }

    /**
     * @brief Called when the WebSocket connection is closed.
     * @param session     The WebSocket session.
     * @param closeReason The reason for closing the connection.
     */
    @Override
    public void onClose(Session session, CloseReason closeReason) {
        log.warn("Verbindung geschlossen: {}", closeReason.getReasonPhrase());
    }

    /**
     * @brief Called when an error occurs on the WebSocket connection.
     * @param session   The WebSocket session.
     * @param throwable The error that occurred.
     */
    @Override
    public void onError(Session session, Throwable throwable) {
        log.error("Fehler aufgetreten: {}", throwable.getMessage(), throwable);
    }

    /**
     * @brief Handles item state events.
     * @param session   The WebSocket session.
     * @param message   The message received.
     * @param eventType The type of the event.
     */
    private void handleItemStateEvent(Session session, Message message, Class<?> eventType) {
        String topic = message.getTopic().split("/")[2];

        if (ohItemRegister.isItemRegistered(topic)) {
            try {
                JsonObject jsonObject = gson.fromJson(message.getPayload(), JsonObject.class);
                Optional.ofNullable(jsonObject.get("value"))
                        .orElseThrow(() -> new RuntimeException("Value is null"));

                if (jsonObject.get("type").getAsString().equals("Decimal") &&
                        ohItemRegister.getItem(topic).get().getStateDescription() != null) {
                    String format = correctFormat(topic, jsonObject);
                    jsonObject.addProperty("value", format);
                    message.setPayload(jsonObject.toString());
                }

                eventPublisher.publishEvent(eventType.getConstructor(Object.class, String.class, String.class)
                        .newInstance(this, topic, message.getPayload()));
            } catch (Exception e) {
                log.error("Error in {}: {}", eventType.getSimpleName(), message.getTopic(), e);
            }
        } else {
            log.trace("Item {} is not registered, ignoring event", topic);
        }
    }

    /**
     * @brief Corrects the format of the value based on the pattern.
     * @param topic      The topic under which the item is sent from OpenHAB.
     * @param jsonObject The JSON object containing the value.
     * @return The correctly formatted value.
     */
    private String correctFormat(String topic, JsonObject jsonObject) 
    {
        //We need the pattern to format the value correctly, therefore first step is the get the Openhabtem
        Optional<OpenhabItem> ohItem = ohItemRegister.getItem(topic);

        if (!ohItem.isPresent()) {
            //TODO log error
            return "";
        }

        String pattern = ohItem.get().getStateDescription().getPattern();
        String value = jsonObject.get("value").getAsString();

        return String.format(java.util.Locale.US, pattern, Float.parseFloat(value));
    }
}

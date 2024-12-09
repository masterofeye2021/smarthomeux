package de.smarthome.smartux.eventsystem;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

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
                    if(message.contains("PONG"))
                        return;

                    Message m =decoder.decode(message);
                    log.info("Message Type: " + m.getType() + " topic: " + m.getTopic() + " payload: " + m.getPayload());
                    switch (m.getType()) {
                        case "ItemAddedEvent":
                            onItemAddedEvent(session,m);
                        case "ItemRemovedEvent":
                            onItemRemovedEvent(session,m);
                        case "ItemStateUpdatedEvent":
                            onItemStateUpdatedEvent(session,m);
                            break;
                        case "ItemCommandEvent":
                            onItemCommandEvent(session,m);
                            break;
                        case "ItemStateEvent":
                            onItemStateEvent(session,m);
                            break;
                        case "ItemStatePredictedEvent":
                            onItemStatePredictedEvent(session,m);
                            break;
                        case "ItemStateChangedEvent":
                            onItemStateChangedEvent(session,m);
                            break;
                        case "GroupItemStateChangedEvent":
                            onGroupItemStateChangedEvent(session,m);
                            break;
                        case "WebSocketEvent":   
                            break; 
                        default:
                            log.error("THe following event is not part of the Event Handling: " + m.getType(), new IllegalArgumentException());
                            break;
                    }
                } catch (DecodeException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    
    public void ping() throws IOException, EncodeException
    {
        if (currentSession != null)
        {
            currentSession.getBasicRemote().sendObject(new Ping());
        }
    }

    public void onItemAddedEvent(Session session, Message message)
    {
        log.debug("[ItemAddedEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
    }

    public void onItemRemovedEvent(Session session, Message message)
    {
        log.debug("[ItemRemovedEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
    }

    /**
     * @brief The state of an item has changed.
     * @param session
     * @param message
     */
    public void onItemStateUpdatedEvent(Session session, Message message)
    {
        //Extract the item name from the topic
        String topic = message.getTopic().split("/")[2];

        if(ohItemRegister.isItemRegistered(topic))
        {
            log.debug("[ItemStateUpdatedEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
            eventPublisher.publishEvent(new ItemStateUpdatedEvent(this, topic,message.getPayload()));
        }
        else
        {
            /* Item is not registered, so we will ignore it */
            return;
        }
    }

    /**
     * @brief A command is sent to an item via a channel.
     * @param session
     * @param message
     */
    public void onItemCommandEvent(Session session, Message message)
    {
        log.debug("[ItemCommandEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
    }

    /**
     * @brief The state of an item is updated.
     * @param session
     * @param message
     */
    public void onItemStateEvent(Session session, Message message)
    {
        log.debug("[ItemStateEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
    }

    /**
     * @brief The state of an item is updated.
     * @param session
     * @param message
     */
    public void onItemStatePredictedEvent(Session session, Message message)
    {
        log.debug("[ItemStatePredictedEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
    }
  
    /**
     * @brief The state of an item has changed.
     * @param session
     * @param message
     */
    public void onItemStateChangedEvent(Session session, Message message)
    {
        log.debug("[ItemStateChangedEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
        String topic = message.getTopic().split("/")[2];

        if(ohItemRegister.isItemRegistered(topic))
        {

            eventPublisher.publishEvent(new ItemStateChangedEvent(this, topic,message.getPayload()));
        }
        else
        {
            /* Item is not registered, so we will ignore it */
            return;
        }
    }

    /**
     * @brief The state of an item has changed.
     * @param session
     * @param message
     */
    public void onGroupItemStateChangedEvent(Session session, Message message)
    {
        log.debug("[GroupItemStateChangedEvent] topic:" + message.getTopic() + " Data: "+ message.getPayload());
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

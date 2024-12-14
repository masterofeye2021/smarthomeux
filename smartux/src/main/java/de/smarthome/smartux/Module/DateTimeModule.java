package de.smarthome.smartux.Module;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.smarthome.smartux.OpenhabItemRegister;
import de.smarthome.smartux.OpenhabRestService;
import de.smarthome.smartux.eventsystem.ItemStateChangedEvent;
import de.smarthome.smartux.eventsystem.ItemStateUpdatedEvent;
import de.smarthome.smartux.mainDataModel.StompMessage;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class DateTimeModule extends ModuleTemplate {

    public DateTimeModule(OpenhabRestService openhabRestService, OpenhabItemRegister openhabItemRegister,
            SimpMessagingTemplate template) {
        super(openhabRestService, openhabItemRegister, template);
    }

    @Override
    public void deinit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deinit'");
    }

    @EventListener
    public void handleCustomEvent(ItemStateUpdatedEvent event) {
        if (openhabItemList.contains(event.getItem())) {
            log.trace("ItemStateUpdatedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue()
                    + "] empfangen");
            sender.convertAndSend("/ItemStateUpdatedEvent/" + event.getItem(), event.getValue());
        }
    }

    @EventListener
    public void handleCustomEvent(ItemStateChangedEvent event) {
        if (openhabItemList.contains(event.getItem())) {
            log.trace("ItemStateChangedEvent wurde von [" + this.name + "] mit dem Wert [" + event.getValue()
                    + "] empfangen");

            /*ObjectMapper objectMapper = new ObjectMapper();
            try {
                StompMessage msg = objectMapper.readValue(event.getValue(), StompMessage.class);
                String date = extractDate(msg.getValue());
                String time = extractTime(msg.getValue());

                sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem(), event.getValue());

            } catch (JsonMappingException e) {
                //@TODO STORE INTO ERROR LOG TO GET ACCESS FOR ISSUES ON VIEW 
                log.error("JSON Mapping issue in DateTimeModule", e);
            } catch (JsonProcessingException e) {
                //@TODO STORE INTO ERROR LOG TO GET ACCESS FOR ISSUES ON VIEW 
                log.error("JSON Processing issue in DateTimeModule", e);
            }*/ 
            
            sender.convertAndSend("/ItemStateChangedEvent/" + event.getItem(), event.getValue());
        }
    }

    
    private static final DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    private static final DateTimeFormatter DATEFORMAT = DateTimeFormatter.ofPattern("EEEE, dd.MM.yyyy", Locale.GERMAN);
    private static final DateTimeFormatter TIMEFORMAT = DateTimeFormatter.ofPattern("HH:mm",Locale.GERMAN);

    public static String extractDate(String dateTimeString) {
        try {
            // String mit benutzerdefiniertem Formatter parsen
            ZonedDateTime dateTime = ZonedDateTime.parse(dateTimeString, CUSTOM_FORMATTER);
            // Datum im gewünschten Format extrahieren
            return dateTime.format(DATEFORMAT); // Gibt "2024-12-14" zurück
        } catch (DateTimeParseException e) {
            // Fehlerbehandlung, falls das Parsing fehlschlägt
            System.err.println("Ungültiges Datumsformat: " + dateTimeString);
            return "Ungültiges Datum";
        }
    }

    public static String extractTime(String dateTimeString) {
        try {
            // String mit benutzerdefiniertem Formatter parsen
            ZonedDateTime dateTime = ZonedDateTime.parse(dateTimeString, CUSTOM_FORMATTER);
            // Datum im gewünschten Format extrahieren
            return dateTime.format(TIMEFORMAT); // Gibt "2024-12-14" zurück
        } catch (DateTimeParseException e) {
            // Fehlerbehandlung, falls das Parsing fehlschlägt
            System.err.println("Ungültiges Datumsformat: " + dateTimeString);
            return "Ungültiges Datum";
        }
    }

}
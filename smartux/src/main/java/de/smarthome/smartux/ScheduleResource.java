package de.smarthome.smartux;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import de.smarthome.smartux.eventsystem.OpenhabEndpoint;
import jakarta.websocket.EncodeException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduleResource {

    @Autowired
    OpenhabEndpoint client;

    @Scheduled(cron = "*/5 * * * * *")
    public void testSchedule() throws InterruptedException, IOException, EncodeException {
        client.ping();
    }
}
package ru.redsquid.examples.ms.notification.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.redsquid.examples.ms.notification.dto.MessageDTO;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "ms/notification")
@Api(tags = "Notification Service")
@RequiredArgsConstructor
public class NotificationController {

    @PostMapping
    @ApiOperation(value = "Send sms", response = UUID.class)
    public String sendSms(@RequestBody MessageDTO dto) throws UnknownHostException {
        log.trace("sendSms: dto = {}", dto);
        return InetAddress.getLocalHost().getHostName();
    }
}

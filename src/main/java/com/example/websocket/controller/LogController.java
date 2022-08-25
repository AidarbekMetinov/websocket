package com.example.websocket.controller;

import java.util.Arrays;
import java.util.List;

import com.example.websocket.model.Log;
import com.example.websocket.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class LogController {

// При запросе { "command": "addLog", "content": "someText" } сервер должен сохранить значение "content" в БД.
// При запросе { "command": "logs" }, сервер должен передать массив, в котором находятся все предыдущие запросы от клиента.

	private final LogRepository repository;

	@Autowired
	public LogController(LogRepository repository) {
		this.repository = repository;
	}

	@MessageMapping("/log")
	@SendTo("/topic/logs")
	public List<Log> log(Log log) {
		switch (log.getCommand()) {
		case "addLog":
			return Arrays.asList(repository.save(log));
		case "logs":
		default:
			return repository.findAll();
		}
	}

}

package com.feverup.challenge.core.application.ports;

import com.feverup.challenge.core.domain.model.Event;

import java.util.List;

public interface EventProvider {
    List<Event> getEvents();
}

package com.non.profit.service;

import com.non.profit.model.Event;

import java.util.List;

public interface EventServices {
    Event saveEvent(Event event);
    List<Event> getInfo();
    Event getEventById(long id);
    void deleteEvent(long id);
}

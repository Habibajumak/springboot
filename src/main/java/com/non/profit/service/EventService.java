package com.non.profit.service;

import com.non.profit.model.Event;
import com.non.profit.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements EventServices {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public List<Event> getInfo() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(long id) {
        return eventRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEvent(long id) {
        eventRepository.deleteById(id);
    }
}

package com.non.profit.controller;

import com.non.profit.model.Event;
import com.non.profit.service.EventServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin
public class EventController {
    @Autowired
    private EventServices eventServices;

    @PostMapping("/add")
    public Event saveEvent
    (@RequestParam("title") String title,
     @RequestParam("date") String date,
     @RequestParam("description") String description,
     @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        Event event = new Event();
        event.setTitle(title);
        event.setDate(LocalDate.parse(date));
        event.setDescription(description);
        if (image != null) {
            event.setImageUrl(image.getBytes());
        }
        return eventServices.saveEvent(event);
    }

    @PutMapping("/update/{id}")
    public Event updateEvent
    (@PathVariable long id,
     @RequestParam("title") String title,
     @RequestParam("date") String date,
     @RequestParam("description") String description,
     @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        Event event = eventServices.getEventById(id);
        event.setTitle(title);
        event.setDate(LocalDate.parse(date));
        event.setDescription(description);
        if (image != null) {
            event.setImageUrl(image.getBytes());
        }
        return eventServices.saveEvent(event);
    }


    @GetMapping("/get")
    public List<Event> getInfo() {
        return eventServices.getInfo();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(@PathVariable long id) {
        eventServices.deleteEvent(id);
    }
}

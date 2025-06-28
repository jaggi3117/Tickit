package com.jaggi.tickit.services;

import com.jaggi.tickit.domain.CreateEventRequest;
import com.jaggi.tickit.domain.entities.Event;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest event);

    Page<Event> listEventsForOrganizer(UUID organizerId, Pageable pageable);

    Optional<Event> getEventForOrganizer(UUID organizerId, UUID id);

    Event updateEventForOrganizer(UUID organizerId, UUID id, UpdateEventRequest event);

    void deleteEventForOrganizer(UUID organizerId, UUID id);

    Page<Event> listPublishedEvents(Pageable pageable);

    Page<Event> searchPublishedEvents(String query, Pageable pageable);

    Optional<Event> getPublishedEvent(UUID id);
}

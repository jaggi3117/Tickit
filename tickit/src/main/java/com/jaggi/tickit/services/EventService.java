package com.jaggi.tickit.services;

import com.jaggi.tickit.domain.CreateEventRequest;
import com.jaggi.tickit.domain.entities.Event;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface EventService {

    Event createEvent(UUID organizerId, CreateEventRequest event);
}

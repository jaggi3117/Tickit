package com.jaggi.tickit.repositories;

import com.jaggi.tickit.domain.entities.Event;
import com.jaggi.tickit.domain.entities.EventStatusEnum;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EventRepository extends JpaRepository<Event, UUID> {

    Optional<Event> findByIdAndOrganizerId(UUID id, UUID organizerId);

    Page findByStatus(EventStatusEnum status);
}

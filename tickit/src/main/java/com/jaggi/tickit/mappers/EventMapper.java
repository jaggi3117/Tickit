package com.jaggi.tickit.mappers;

import com.jaggi.tickit.domain.CreateEventRequest;
import com.jaggi.tickit.domain.CreateTicketTypeRequest;
import com.jaggi.tickit.domain.dtos.CreateEventRequestDto;
import com.jaggi.tickit.domain.dtos.CreateEventResponseDto;
import com.jaggi.tickit.domain.dtos.CreateTicketTypeRequestDto;
import com.jaggi.tickit.domain.entities.Event;
import com.jaggi.tickit.domain.entities.TicketType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EventMapper {

    CreateTicketTypeRequest fromDto(CreateTicketTypeRequestDto dto);

    CreateEventRequest fromDto(CreateEventRequestDto dto);

    CreateEventResponseDto toDto(Event event);
}

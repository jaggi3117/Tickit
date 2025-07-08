package com.jaggi.tickit.domain.dtos;


import com.jaggi.tickit.domain.entities.TicketValidationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketValidationRequestDto {
  private UUID id;
  private TicketValidationMethod method;
}

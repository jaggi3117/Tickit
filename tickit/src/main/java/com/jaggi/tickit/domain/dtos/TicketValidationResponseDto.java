package com.jaggi.tickit.domain.dtos;

import com.jaggi.tickit.domain.entities.TicketValidationStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketValidationResponseDto {
  private UUID ticketId;
  private com.jaggi.tickit.domain.entities.TicketValidationStatusEnum status;
}

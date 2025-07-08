package com.jaggi.tickit.services;



import com.jaggi.tickit.domain.entities.QrCode;
import com.jaggi.tickit.domain.entities.Ticket;

import java.util.UUID;

public interface QrCodeService {

  QrCode generateQrCode(Ticket ticket);

  byte[] getQrCodeImageForUserAndTicket(UUID userId, UUID ticketId);
}

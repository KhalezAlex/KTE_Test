package org.klozevitz.kte_test.controllers.rest;

import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.model.dao.ticket.IDaoTicket;
import org.klozevitz.kte_test.model.entities.Patient;
import org.klozevitz.kte_test.model.entities.Ticket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketsController {
    IDaoTicket daoTicket;
    @GetMapping("/getTickets")
    public List<Ticket> getTicketsByDateAndDoctorId(LocalDateTime date, int doctorId) {
        return daoTicket.getAllByDateTimeBetweenAndDoctorId(date, doctorId);
    }

    @PostMapping("/takeTicketById")
    public void takeTicketsById(int ticketId, Patient patient) {
        daoTicket.takeTicketById(ticketId, patient);
    }

    @GetMapping("/getTicketsByPatientId")
    public List<Ticket> getTicketsByPatientId(int patientId) {
        return daoTicket.getAllByPatientId(patientId);
    }

    @GetMapping("/getTicketsByPatientUuid")
    public List<Ticket> getTicketsByPatientUuid(String patientUuid) {
        return daoTicket.getAllByPatientUuid(patientUuid);
    }
}

package org.klozevitz.kte_test.model.dao.ticket;

import org.klozevitz.kte_test.model.dao.IDaoDb;
import org.klozevitz.kte_test.model.entities.Patient;
import org.klozevitz.kte_test.model.entities.Ticket;

import java.time.LocalDateTime;
import java.util.List;

public interface IDaoTicket extends IDaoDb<Ticket> {
    List<Ticket> getAllByDateTimeBetweenAndDoctorId(LocalDateTime dateTime, int doctorId);

    void takeTicketById(int ticketId, Patient patient);
    List<Ticket> getAllByPatientId(int patientId);
    List<Ticket> getAllByPatientUuid(String patientUuid);
}

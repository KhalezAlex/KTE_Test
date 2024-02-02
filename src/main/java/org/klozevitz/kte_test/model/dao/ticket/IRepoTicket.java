package org.klozevitz.kte_test.model.dao.ticket;

import org.klozevitz.kte_test.model.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface IRepoTicket extends CrudRepository<Ticket, Integer> {
    List<Ticket> getAllByDateTimeBetweenAndDoctorId(LocalDateTime ldt1, LocalDateTime ldt2, int doctorId);
    List<Ticket> getAllByPatientId(int patientId);
    List<Ticket> getAllByPatientUuid(String patient_uuid);
}

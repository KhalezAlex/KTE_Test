package org.klozevitz.kte_test.model.dao.ticket;

import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.model.entities.Patient;
import org.klozevitz.kte_test.model.entities.Ticket;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbDaoTicket implements IDaoTicket{
    IRepoTicket repo;

    @Override
    public List<Ticket> findAll() {
        return (List<Ticket>) repo.findAll();
    }

    @Override
    public Optional<Ticket> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Ticket save(Ticket ticket) {
        return repo.save(ticket);
    }

    @Override
    public Ticket update(Ticket ticket) {
        return repo.save(ticket);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public List<Ticket> getAllByDateTimeBetweenAndDoctorId(LocalDateTime date, int doctorId) {
        return repo.getAllByDateTimeBetweenAndDoctorId(
                        LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 9, 0),
                        LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(), 20, 0),
                        doctorId)
                .stream()
                .filter(ticket -> ticket.getPatient() == null)
                .toList();
    }

    @Override
    public void takeTicketById(int ticketId, Patient patient) {
        Ticket ticket = repo.findById(ticketId).get();
        ticket.setPatient(patient);
        repo.save(ticket);
    }

    @Override
    public List<Ticket> getAllByPatientId(int patientId) {
        return repo.getAllByPatientId(patientId);
    }

    @Override
    public List<Ticket> getAllByPatientUuid(String patientUuid) {
        return repo.getAllByPatientUuid(patientUuid);
    }
}

package org.klozevitz.kte_test.model.dao.ticket;

import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.model.entities.Ticket;
import org.springframework.stereotype.Service;

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
}

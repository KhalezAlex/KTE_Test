package org.klozevitz.kte_test.model.dao.ticket;

import org.klozevitz.kte_test.model.entities.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface IRepoTicket extends CrudRepository<Ticket, Integer> {
}

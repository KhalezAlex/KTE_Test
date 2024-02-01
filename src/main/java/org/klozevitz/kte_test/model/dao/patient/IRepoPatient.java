package org.klozevitz.kte_test.model.dao.patient;

import org.klozevitz.kte_test.model.entities.Patient;
import org.springframework.data.repository.CrudRepository;

public interface IRepoPatient extends CrudRepository<Patient, Integer> {
}

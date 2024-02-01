package org.klozevitz.kte_test.model.dao.doctor;

import org.klozevitz.kte_test.model.entities.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface IRepoDoctor extends CrudRepository<Doctor, Integer> {

}

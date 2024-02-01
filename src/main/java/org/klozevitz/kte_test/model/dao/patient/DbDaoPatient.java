package org.klozevitz.kte_test.model.dao.patient;

import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.model.entities.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbDaoPatient implements IDaoPatient{
    private final IRepoPatient repo;

    @Override
    public List<Patient> findAll() {
        return (List<Patient>) repo.findAll();
    }

    @Override
    public Optional<Patient> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Patient save(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public Patient update(Patient patient) {
        return repo.save(patient);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}

package org.klozevitz.kte_test.model.dao.doctor;

import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.model.entities.Doctor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbDoctorService implements IDaoDoctor{
    private final IRepoDoctor repo;


    @Override
    public List<Doctor> findAll() {
        return (List<Doctor>) repo.findAll();
    }

    @Override
    public Optional<Doctor> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Doctor save(Doctor doctor) {
        return repo.save(doctor);
    }

    @Override
    public Doctor update(Doctor doctor) {
        return repo.save(doctor);
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}

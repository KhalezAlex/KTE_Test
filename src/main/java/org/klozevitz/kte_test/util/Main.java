package org.klozevitz.kte_test.util;

import org.klozevitz.kte_test.model.entities.Doctor;
import org.klozevitz.kte_test.model.entities.Patient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
//    private static final ArrayList<String> doctors = new ArrayList<>(List.of("педиатр", "педиатр", "невролог", "невролог",
//            "хирург", "хирург", "стоматолог", "стоматолог", "офтальмолог", "офтальмолог",
//            "отоларинголог", "отоларинголог", "психиатр", "психиатр", "акушер-гиниколог", "акушер-гиниколог",
//            "уролог-андролог", "уролог-андролог"));
    public static void main(String[] args) throws IOException {
        String file = "full_base.txt";
        StringBuilder sbP = new StringBuilder("INSERT INTO patients_t (uuid, fio, birthDate, sex) VALUES (\n");
        StringBuilder sbD = new StringBuilder("INSERT INTO doctors_t (uuid, fio, speciality) VALUES (\n");
        try (Stream<String> stream = Files.lines(Path.of(file))) {
            AtomicInteger i = new AtomicInteger();
            AtomicInteger docs = new AtomicInteger(0);
            stream
                    .forEach(s -> {
                        i.getAndIncrement();
                        if (i.get() < 462)
                            sbP.append(generateSQLStringFromPatient(generatePatientFromString(s)));
                        else {
                            sbD.append(generateSQLStringFromDoctor(generateDoctorFromString(s, docs.get())));
                            docs.getAndIncrement();
                        }
                    });
        }
        System.out.println(sbP.substring(0, sbP.length() - 3).concat(";"));
        System.out.println(sbD.substring(0, sbD.length() - 3).concat(";"));
    }

    private static String generateSQLStringFromPatient(Patient patient) {
        return "(" +
                String.format("'%s', %s, '%s', '%s'",
                        patient.getUuid(), patient.getFio(), patient.getBirthdate().toString(), patient.getSex()) +
                "), \n";
    }

    private static Patient generatePatientFromString(String str) {
        str = str.substring(6, str.length() - 2);
        String[] patientFields = str.split(", ");
        return Patient.builder()
                .uuid(UUID.randomUUID().toString())
                .fio(patientFields[1])
                .birthdate(getDateFromString(patientFields[2]))
                .sex(patientFields[3].equals("1") ? "м" : "ж")
                .build();
    }

    private static LocalDate getDateFromString(String date) {
        date = date.substring(1, date.length() - 1);
        String[] dateArr = date.split("-");
        if(Integer.parseInt(dateArr[0]) < 2000) {
            dateArr[0] = String.valueOf(new Random().nextInt(2000, 2023));
        }
        return LocalDate.of(Integer.parseInt(dateArr[0]), Integer.parseInt(dateArr[1]), Integer.parseInt(dateArr[2]));
    }

    private static String generateSQLStringFromDoctor(Doctor doctor) {
        return "(" +
                String.format("'%s', %s, '%s'",
                        doctor.getUuid(), doctor.getFio(), doctor.getSpeciality()) +
                "), \n";
    }

    private static Doctor generateDoctorFromString(String str, int docs) {
        str = str.substring(6, str.length() - 2);
        String[] array = str.split(", ");
        return Doctor.builder()
                .uuid(UUID.randomUUID().toString())
                .fio(array[1])
                .speciality(Specialities.values()[docs / 2].toString())
                .build();
    }
}

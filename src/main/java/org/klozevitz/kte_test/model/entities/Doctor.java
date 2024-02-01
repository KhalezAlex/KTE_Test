package org.klozevitz.kte_test.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Doctor {
    private int id;
    private String uuid;
    private String fio;
    private String speciality;
}

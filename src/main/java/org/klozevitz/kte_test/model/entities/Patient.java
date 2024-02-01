package org.klozevitz.kte_test.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Getter
@Builder
@AllArgsConstructor
public class Patient {
    private Integer id;
    private String uuid;
    private String fio;
    private LocalDate birthdate;
    private String sex;
//    private String anamnesis;
}

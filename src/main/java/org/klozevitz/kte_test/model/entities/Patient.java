package org.klozevitz.kte_test.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients_t")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "fio")
    private String fio;
    @Column(name = "birthdate")
    private LocalDate birthdate;
    @Column(name = "sex")
    private String sex;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}

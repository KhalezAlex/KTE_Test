package org.klozevitz.kte_test.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors_t")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "fio")
    private String fio;
    @Column(name = "speciality")
    private String speciality;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}

package org.klozevitz.kte_test.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets_t")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "datetime")
    private LocalDateTime dateTime;
    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "pat_id")
    private Patient patient;
}

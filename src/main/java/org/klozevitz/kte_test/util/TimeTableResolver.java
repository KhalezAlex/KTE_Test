package org.klozevitz.kte_test.util;

import io.spring.guides.gs_producing_web_service.CreateTimeTableRequest;
import lombok.RequiredArgsConstructor;
import org.klozevitz.kte_test.model.dao.doctor.IRepoDoctor;
import org.klozevitz.kte_test.model.dao.ticket.IRepoTicket;
import org.klozevitz.kte_test.model.entities.Doctor;
import org.klozevitz.kte_test.model.entities.Ticket;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class TimeTableResolver {
    private final IRepoTicket repoT;
    private final IRepoDoctor repoD;
    private boolean isEvenWeek = true;

    public void generate(CreateTimeTableRequest request) {
        String[] date = request.getDate().split("-");
        TimeTableRule rule = TimeTableRule.builder()
                .date(LocalDate.of(
                        Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])))
                .startTime(request.getStartTime())
                .endTime(request.getEndTime())
                .duration(request.getDuration())
                .period(request.getPeriod())
                .build();
        int counter = 0;
        List<Doctor> doctors = (List<Doctor>) repoD.findAll();
        while (counter != rule.getPeriod()) {
            generateDayTimeTable(rule, doctors, counter);
            if (rule.getDate().plusDays(counter).getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
                isEvenWeek = !isEvenWeek;
            }
            counter++;
        }
    }

    private void generateDayTimeTable(TimeTableRule rule, List<Doctor> doctors, int period) {
        LocalDate date = rule.getDate();
        String startTime = rule.getStartTime();
        String endTime = rule.getEndTime();
        LocalDateTime start = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(),
                Integer.parseInt(startTime.split("-")[0]), Integer.parseInt(startTime.split("-")[1]))
                .plusDays(period);
        LocalDateTime end = LocalDateTime.of(date.getYear(), date.getMonth(), date.getDayOfMonth(),
                Integer.parseInt(endTime.split("-")[0]), Integer.parseInt(endTime.split("-")[1]))
                .plusDays(period);
            AtomicInteger counter = new AtomicInteger(0);
        doctors.forEach(d -> {
                setDoctorTimetablePerDay(counter.get() % 2 == 0, d, start, end, rule.getDuration());
                counter.getAndIncrement();
            });
    }

    private void setDoctorTimetablePerDay(boolean evenDoctor, Doctor doctor, LocalDateTime start,
                                          LocalDateTime end, int duration) {
        int diff = getDiff(start, end, duration);
        if (evenDoctor == isEvenWeek) {
            while(start.isBefore(end.minusMinutes(diff / 2))) {
                repoT.save(Ticket.builder()
                        .dateTime(start)
                        .doctor(doctor)
                        .build());
                start = start.plusMinutes(duration);
            }
        } else {
            start = start.plusMinutes(diff / 2);
            while (start.isBefore(end)) {
                repoT.save(Ticket.builder()
                        .dateTime(start)
                        .doctor(doctor)
                        .build());
                start = start.plusMinutes(duration);
            }
        }

    }

    private int getDiff(LocalDateTime start, LocalDateTime end, int duration) {
        int diff = 0;
        while (start.plusMinutes(diff).isBefore(end)) {
            diff += duration;
        }
        return diff;
    }
}

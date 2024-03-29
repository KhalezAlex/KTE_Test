package org.klozevitz.kte_test.util;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Класс, определяющий правило заполнения расписания (тестовый)
 * dateTime- дата и время начала периода, на который составляется расписание
 * timeSlotMinutes- продолжительность слота времени
 * quartzTimesAmount- количество кварцеваний в день (в послений момент, отказался)
 * timeOutAmount- количество перерывов рача в день
 * period- количество дней, на которое составляется расписание
 * */

@Builder
@Getter
@ToString
@RequiredArgsConstructor
public class TimeTableRule {
    private final LocalDate date;
    private final String startTime;
    private final String endTime;
    private final int duration;
//    private final int quartzTimesAmount;
    private final int period;
}

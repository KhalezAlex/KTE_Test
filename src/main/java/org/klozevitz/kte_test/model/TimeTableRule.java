package org.klozevitz.kte_test.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * Класс, определяющий правило заполнения расписания (тестовый)
 * dateTime- дата и время начала периода, на который составляется расписание
 * timeSlotMinutes- продолжительность слота времени
 * quartzTimesAmount- количество кварцеваний в день
 * timeOutAmount- количество перерывов рача в день
 * period- количество дней, на которое составляется расписание
 * */

@Builder
@Getter
@RequiredArgsConstructor
public class TimeTableRule {
    private final LocalDateTime dateTime;
    private final int timeSlotMinutes;
    private final int quartzTimesAmount;
    private final int timeOutAmount;
    private final int period;
}

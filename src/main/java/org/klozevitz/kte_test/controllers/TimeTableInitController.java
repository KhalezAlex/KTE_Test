package org.klozevitz.kte_test.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class TimeTableInitController {
    @GetMapping("/generateTimetable")
    public String generate(@RequestParam String date, @RequestParam String startTime, @RequestParam String endTime,
                           @RequestParam int period, @RequestParam int duration,
                           @RequestParam(required = false) int quartzTimesAmount) {
        System.out.println(LocalDateTime.of(Integer.parseInt(date.split("-")[0]),
                Integer.parseInt(date.split("-")[1]), Integer.parseInt(date.split("-")[2]),
                Integer.parseInt(startTime.split("-")[0]), Integer.parseInt(startTime.split("-")[1])));
        System.out.println(endTime);
        System.out.println(period);
        System.out.println(duration);
        System.out.println(quartzTimesAmount);
        return "";
    }
}

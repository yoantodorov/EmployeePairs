package sirma.academy.employeepairs.service;

import sirma.academy.employeepairs.model.TimeInterval;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class TimeIntervalService {
    public static long getOverlapDays(TimeInterval timeInterval1, TimeInterval timeInterval2) {
        if (doesOverlap(timeInterval1,timeInterval2)){
            LocalDate start = timeInterval1.getDateFrom().isBefore(timeInterval2.getDateFrom()) ?
                    timeInterval2.getDateFrom() : timeInterval1.getDateFrom();
            LocalDate end = timeInterval1.getDateTo().isBefore(timeInterval2.getDateTo()) ?
                    timeInterval1.getDateTo() : timeInterval2.getDateTo();

            return Math.max(ChronoUnit.DAYS.between(start, end), 0);
        }
            return 0;
    }

    public static boolean doesOverlap(TimeInterval timeInterval1, TimeInterval timeInterval2) {
        return timeInterval1.getDateFrom().isBefore(timeInterval2.getDateTo()) &&
                timeInterval2.getDateFrom().isBefore(timeInterval1.getDateTo());
    }

    //sum of overlapped days for each work time interval of a pair of employee for a project
    public static long getTotalOverlapDays(List<TimeInterval> timeIntervalList1, List<TimeInterval> timeIntervalList2) {
        long totalOverlapDays = 0;

        for (TimeInterval timeInterval1 : timeIntervalList1) {
            for (TimeInterval timeInterval2 : timeIntervalList2){
                long overlapDays = getOverlapDays(timeInterval1, timeInterval2);

                totalOverlapDays += overlapDays;
            }
        }
        return totalOverlapDays;
    }
}

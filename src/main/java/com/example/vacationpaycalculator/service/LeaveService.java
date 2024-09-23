package com.example.vacationpaycalculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class LeaveService {
    private final HolidaysService holidaysService;

    public LeaveService(HolidaysService holidaysService) {
        this.holidaysService = holidaysService;
    }

    public BigDecimal calculateLeavePay(double averageSalaryPerMonth, int daysOfLeave, List<Integer> daysInLeave) {
        if (daysOfLeave <= 0 || averageSalaryPerMonth <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        int totalWorkDaysInYear = 365 - holidaysService.getHolidayCount();

        int totalWorkDaysInLeave = calculateTotalWorkDaysInLeave(totalWorkDaysInYear, daysInLeave);

        if (daysInLeave == null) {
            totalWorkDaysInLeave = daysOfLeave;
        }

        return multiplyByAverage(averageSalaryPerMonth, totalWorkDaysInLeave / daysOfLeave);
    }

    /**
     * Рассчитывает общее число рабочих дней в отпуске с учетом праздников и выходных.
     */
    private int calculateTotalWorkDaysInLeave(int totalWorkDaysInYear, List<Integer> daysInLeave) {
        int totalWorkDaysInLeave = 0;
        for (var day : daysInLeave) {
            if (!isWeekendOrHoliday(day)) {
                totalWorkDaysInLeave++;
            }
        }
        return totalWorkDaysInLeave;
    }

    /**
     * Умножает среднюю зарплату на количество рабочих дней, получая сумму отпускных.
     */
    private BigDecimal multiplyByAverage(double averageSalaryPerMonth, double multiplier) {
        return BigDecimal.valueOf(multiplier).multiply(BigDecimal.valueOf(averageSalaryPerMonth));
    }

    /**
     * Определяет, является ли день выходным или праздничным.
     */
    private boolean isWeekendOrHoliday(int day) {
        return Arrays.asList(0, 6).contains(day % 7) || Collections.singleton(day).stream().anyMatch(holidaysService::isHoliday);
    }

}

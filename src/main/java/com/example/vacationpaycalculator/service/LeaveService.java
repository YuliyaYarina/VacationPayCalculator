package com.example.vacationpaycalculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class LeaveService {
//    private final HolidaysService holidaysService;
////    float totalWorkDaysInLeave = 0,00f;
//    int d = 30;
//
//    Logger logger = LoggerFactory.getLogger(LeaveService.class);
//
//    public LeaveService(HolidaysService holidaysService) {
//        this.holidaysService = holidaysService;
//    }
//
//    public double calculateLeavePay(double averageSalaryPerMonth, int daysOfLeave, List<Integer> daysInLeave) {
//
//        if (daysOfLeave <= 0 || averageSalaryPerMonth <= 0) {
//            throw new IllegalArgumentException("Неверный ввод");
//        }
//        int totalWorkDaysInYear = 365 - holidaysService.getHolidayCount();
//        logger.info("totalWorkDaysInYear = " + totalWorkDaysInYear);
//
////        if (daysInLeave != null){
////            totalWorkDaysInLeave = calculateTotalWorkDaysInLeave(totalWorkDaysInYear, daysInLeave);
////            logger.info("Общее число рабочих дней в отпуске с учетом праздников и выходных. " + totalWorkDaysInLeave);
////        } else {
////            totalWorkDaysInLeave = daysOfLeave;
////            logger.info("Общее число рабочих дней в отпуске без учета праздников и выходных. " + totalWorkDaysInLeave);
//        }
//
////        logger.info("totalWork . " + totalWorkDaysInLeave / d);
////        return multiplyByAverage(averageSalaryPerMonth, totalWorkDaysInLeave / d);
//    }
//
//    /**
//     * Рассчитывает общее число рабочих дней в отпуске с учетом праздников и выходных.
//     */
//    private double calculateTotalWorkDaysInLeave(int totalWorkDaysInYear, List<Integer> daysInLeave) {
//        for (var day : daysInLeave) {
////            if (!isWeekendOrHoliday(day)) {
////                totalWorkDaysInLeave++;
////            }
//        }
////        return totalWorkDaysInYear - totalWorkDaysInLeave;
//    }
//
//    /**
//     * Умножает среднюю зарплату на количество рабочих дней, получая сумму отпускных.
//     */
//    private double multiplyByAverage(double averageSalaryPerMonth, double multiplier) {
//        logger.info("средняя зарплата на количество рабочих дней, получаем сумму отпускных. " + BigDecimal.valueOf(multiplier).multiply(BigDecimal.valueOf(averageSalaryPerMonth)));
//        logger.info("cp " + averageSalaryPerMonth * multiplier);
//        return averageSalaryPerMonth * multiplier;
//    }
//
//    /**
//     * Определяет, является ли день выходным или праздничным.
//     */
//    private boolean isWeekendOrHoliday(int day) {
//        logger.info("Arrays.asList(0, 6).contains(day % 7)" + Arrays.asList(0, 6).contains(day % 7));
//        logger.info("Collections.singleton(day).stream().anyMatch(holidaysService::isHoliday)" + Collections.singleton(day).stream().anyMatch(holidaysService::isHoliday));
//        return Arrays.asList(0, 6).contains(day % 7) || Collections.singleton(day).stream().anyMatch(holidaysService::isHoliday);
//    }
//
}

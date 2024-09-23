package com.example.vacationpaycalculator.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeaveServiceTest {

    private final LeaveService service = new LeaveService(new HolidaysService());

    @Test
    void testSimpleCaseWithoutSpecificDays() {
            final double salary = 1000.0;
            final int daysOfLeave = 10;
            final BigDecimal expectedResult = BigDecimal.valueOf(salary).multiply(BigDecimal.valueOf(10));
            assertEquals(expectedResult, service.calculateLeavePay(salary, daysOfLeave, null)); }

    @Test
    void testCaseWithSpecificDaysAndWeekends() {
        final double salary = 1000.0;
        final int daysOfLeave = 10;
        final List<Integer> specificDays = Arrays.asList(1, 3, 5, 7, 9);
        final BigDecimal expectedResult = BigDecimal.valueOf(salary).multiply(BigDecimal.valueOf(7));
        assertEquals(expectedResult, service.calculateLeavePay(salary, daysOfLeave, specificDays));
    }

    @Test
    void testCaseWithSpecificDaysAndHolidays() {
        final double salary = 1000.0;
        final int daysOfLeave = 10;
        final List<Integer> specificDays = Arrays.asList(1, 3, 5, 7, 9, 15);
        final BigDecimal expectedResult = BigDecimal.valueOf(salary).multiply(BigDecimal.valueOf(6));
        assertEquals(expectedResult, service.calculateLeavePay(salary, daysOfLeave, specificDays));
    }

    @Test
    void testZeroInput() {
        final double salary = 0.0;
        final int daysOfLeave = 0;
        try {
            service.calculateLeavePay(salary, daysOfLeave, null);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void testNegativeInput() {
        final double salary = -1000.0;
        final int daysOfLeave = -10;
        try {
            service.calculateLeavePay(salary, daysOfLeave, null);
            fail("Expected exception not thrown.");
        } catch (IllegalArgumentException e) {
        }
    }
}
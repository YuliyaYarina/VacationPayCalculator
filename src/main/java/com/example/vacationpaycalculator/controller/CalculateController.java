package com.example.vacationpaycalculator.controller;

import com.example.vacationpaycalculator.service.LeaveService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class CalculateController {

    @Autowired
    private LeaveService leaveService;

    @Operation(
            summary = "Расчитать отпуск",
            tags = "Калькулятор отпускных"
    )
    @GetMapping("/calculate")
    public double calculate(@RequestParam Double avgSalaryPerMonth,
                                @RequestParam Integer daysOfLeave,
                                @RequestParam(required = false) List<Integer> daysInLeave) {
        return leaveService.calculateLeavePay(avgSalaryPerMonth, daysOfLeave, daysInLeave);
    }
}

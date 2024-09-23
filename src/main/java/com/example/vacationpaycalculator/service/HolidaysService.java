package com.example.vacationpaycalculator.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HolidaysService {
    private Map<Integer, Boolean> holidays;

    public HolidaysService() {
        holidays = createHolidaysMap();
    }

    public int getHolidayCount() {
        return holidays.size();
    }

    public boolean isHoliday(int day) {
        return holidays.getOrDefault(day, false);
    }

    private Map<Integer, Boolean> createHolidaysMap() {
        List<Integer> holidays = new ArrayList<>();
        holidays.add(1); // Новый год
        holidays.add(7); // Рождество
        holidays.add(23); // День защитника Отечества
        holidays.add(8); // Международный женский день
        holidays.add(9); // День Победы
        holidays.add(12); // День России
        holidays.add(4); // День народного единства

        Map<Integer, Boolean> result = new HashMap<>();
        for (int i = 1; i <= 365; i++) {
            result.put(i, holidays.contains(i));
        }
        return result;
    }
}

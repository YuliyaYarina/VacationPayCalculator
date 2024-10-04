package com.example.vacationpaycalculator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HolidaysService {
    private Map<Integer, Boolean> holidays;
    Logger logger = LoggerFactory.getLogger(HolidaysService.class);


    public HolidaysService() {
        holidays = createHolidaysMap();
    }

    public int getHolidayCount() {
        logger.info("holidays.size() = " + holidays.size());
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
//            if(i % 6 == 0 || i % 7 == 0){
//                result.put(i, true);
//            }
            result.put(i, holidays.contains(i));
        }
        return result;
    }
}

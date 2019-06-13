package ru.kvashin.hday.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kvashin.hday.data.DayDescription;

import java.util.Date;

@RestController
public class HDayController {

    @RequestMapping("/today")
    public DayDescription todayDecription(@RequestParam(value = "value", defaultValue = "defaultValue") String name) {
        return new DayDescription(new Date().toString(), "Hi!");
    }
}

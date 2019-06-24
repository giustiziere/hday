package ru.kvashin.hday.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.*;
import ru.kvashin.hday.data.DayDescription;
import ru.kvashin.hday.service.CalendParserService;

import java.time.LocalDate;
import java.util.List;

@EnableResourceServer
@RestController
public class HDayController extends ResourceServerConfigurerAdapter {

    private CalendParserService calendParserService = new CalendParserService();

    @RequestMapping(value = "/today", method = RequestMethod.GET)
    @ResponseBody
    public List<DayDescription> todayDecription() {
        return calendParserService.getDayDescriptionListByDate(LocalDate.now().toString());
    }

    @RequestMapping(value = "/day/{date}", method = RequestMethod.GET)
    @ResponseBody
    public List<DayDescription> customDayDecription(@PathVariable(value = "date") String date) {
        return calendParserService.getDayDescriptionListByDate(date);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/today").permitAll();
        http.requestMatchers().antMatchers("/today")
                .and().authorizeRequests()
                .antMatchers("/today").access("hasRole('USER')");
    }
}

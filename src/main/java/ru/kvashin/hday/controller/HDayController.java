package ru.kvashin.hday.controller;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kvashin.hday.data.DayDescription;
import ru.kvashin.hday.service.CalendParserService;

import java.time.LocalDate;
import java.util.List;

@EnableResourceServer
@RestController
public class HDayController extends ResourceServerConfigurerAdapter {

    CalendParserService calendParserService = new CalendParserService();

    @RequestMapping("/today")
    public List<DayDescription> todayDecription(@RequestParam(value = "value", defaultValue = "defaultValue") String name) {
        return calendParserService.getDayDescriptionListByDate(LocalDate.now().toString());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**", "/today").permitAll();
        http.requestMatchers().antMatchers("/today")
                .and().authorizeRequests()
                .antMatchers("/today").access("hasRole('USER')");
    }
}

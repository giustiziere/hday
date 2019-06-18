package ru.kvashin.hday.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ru.kvashin.hday.data.DayDescription;

import java.util.ArrayList;
import java.util.List;

public class CalendParserService {

    private final String CALEND_URL = "https://www.calend.ru/day/";

    private RestTemplate restTemplate = new RestTemplate();

    private String getBodyByDate(String date) {
        String body = "";
        try {
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(CALEND_URL + date, String.class);
            if (responseEntity.getBody() != null) {
                body = responseEntity.getBody();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return body;
    }

    public List<DayDescription> getDayDescriptionListByDate(String date) {
        List<DayDescription> dayDescriptionList = new ArrayList<>();
        try {
            String body = getBodyByDate(date);
            Document document = Jsoup.parse(body);
            Elements elements = document.getElementsByClass("three-three");
            for (Element element : elements) {
                DayDescription dayDescription = new DayDescription(
                        date,
                        element.getElementsByClass("image").first().getElementsByTag("a").first().getElementsByTag("img").first().attr("alt"),
                        element.getElementsByClass("image").first().getElementsByTag("a").first().attr("href"),
                        element.getElementsByClass("image").first().getElementsByTag("a").first().getElementsByTag("img").first().attr("src")
                );
                dayDescriptionList.add(dayDescription);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dayDescriptionList;
    }
}

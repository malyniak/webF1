package com.app.webf1.news;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsRepository newsRepository;

    @PutMapping
    public void save() {
        var f1News = new F1News();
        f1News.setContent("test");
        f1News.setTitle("test");
        f1News.setContent("test");
        newsRepository.save(f1News
        );
    }
}

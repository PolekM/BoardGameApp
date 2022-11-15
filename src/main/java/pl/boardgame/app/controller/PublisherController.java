package pl.boardgame.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.boardgame.app.entity.Publisher;
import pl.boardgame.app.service.PublisherService;

import java.util.List;

@RestController
public class PublisherController {

    private final PublisherService publisherService;

    @Autowired
    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publisher")
    public List<Publisher> getPublisher(){
        return publisherService.getPublisher();
    }

}

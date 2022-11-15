package pl.boardgame.app.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.boardgame.app.entity.Publisher;
import pl.boardgame.app.repository.PublisherRepository;
import pl.boardgame.app.service.PublisherService;

import java.util.List;

@Service
public class PublisherServiceImp implements PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherServiceImp(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getPublisher() {
        return publisherRepository.findAll();
    }
}

package be.elmeskine.spring5demo.repository;

import be.elmeskine.spring5demo.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}

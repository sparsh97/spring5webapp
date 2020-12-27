package guru.springframework.spring5webapp.domain.repositories;

import guru.springframework.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepositories extends CrudRepository<Book, Long> {
}

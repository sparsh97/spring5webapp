package guru.springframework.spring5webapp.domain.repositories;
import guru.springframework.spring5webapp.domain.author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepositories extends CrudRepository<author, Long> {
}

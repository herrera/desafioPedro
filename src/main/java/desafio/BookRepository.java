package desafio;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findByPriceLessThanEqual(BigDecimal price, Pageable pageable);
    public List<Book> findAllByPriceLessThanEqual(BigDecimal price);
    public List<Book> findAll(Pageable pageable);
}

package university.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {

    Optional<Books> findById(Long id);
    List<Books> findByTitle(String title);
    List<Books> findByAuthor(String author);
    List<Books> findByPublisher(String publisher);
    List<Books> findByQuantity(Integer quantity);

    @Transactional
    @Modifying
    @Query("delete from Books b where b.id = :id")
    int deleteBookById(@Param("id") Long id);
}

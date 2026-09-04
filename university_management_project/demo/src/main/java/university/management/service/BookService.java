package university.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Books;
import university.management.repository.BooksRepository;
import university.management.validation.ServiceValidation;

@Service
public class BookService {


    private BooksRepository booksrepository;

    @Transactional
    public Optional<Books> findById(Long id) {

        ServiceValidation.validateId(id);

       return booksrepository.findById(id);
    }

    @Transactional
    public List<Books> findByTitle(String title){

        ServiceValidation.validateString(title, "title");

        return booksrepository.findByTitle(title);
    }

    @Transactional
    public List<Books> findByAuthor(String author){

        ServiceValidation.validateString(author, "author");

        return booksrepository.findByAuthor(author);
    }

    @Transactional
    public List<Books> findByPublisher(String Publisher){

        ServiceValidation.validateString(Publisher, "Publisher");

        return booksrepository.findByPublisher(Publisher);
    }

    @Transactional
    public List<Books> findByQuantity(Integer quantity){

        return booksrepository.findByQuantity(quantity);
    }
}

package university.management;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;

import university.management.entity.Books;
import university.management.repository.BooksRepository;
import university.management.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BooksRepository repository;

    @InjectMocks
    private BookService service;

    @Test
    void shouldReturnBookWhenIdExist(){
        //arrange
        Books book = new Books();
        book.setId(1L);

        //act 

        when(repository.findById(1L)).thenReturn(Optional.of(book));

        Optional<Books> result = service.findById(1L);

        // assert

        assertEquals(result.get().getId(), book.getId());
    }

@Test
void shouldReturnBookWhenTitleExists() {

    // Arrange
    Books book = new Books();
    book.setTitle("Lenfant-de-sable");

    when(repository.findByTitle("Lenfant-de-sable"))
            .thenReturn(List.of(book));

    // Act
    List<Books> result = service.findByTitle("Lenfant-de-sable");

    // Assert
    assertEquals(book.getTitle(), result.get(0).getTitle());
}

@Test
void shouldReturnBookWhenAuthorExists() {

    // Arrange
    Books book = new Books();
    book.setAuthor("Lenfant-de-sable");

    when(repository.findByAuthor("Lenfant-de-sable"))
            .thenReturn(List.of(book));

    // Act
    List<Books> result = service.findByAuthor("Lenfant-de-sable");

    // Assert
    assertEquals(result.get(0).getAuthor(), book.getAuthor());
}

@Test
void shouldReturnBookWhenPublisherExists() {

    // Arrange
    Books book = new Books();
    book.setPublisher("Lenfant-de-sable");

    when(repository.findByPublisher("Lenfant-de-sable"))
            .thenReturn(List.of(book));

    // Act
    List<Books> result = service.findByPublisher("Lenfant-de-sable");

    // Assert
    assertEquals(result.get(0).getAuthor(), book.getAuthor());
}
    
}

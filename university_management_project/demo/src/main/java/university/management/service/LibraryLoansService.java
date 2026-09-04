package university.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.LibraryLoans;
import university.management.repository.LibraryLoansRepository;
import university.management.validation.ServiceValidation;

@Service
public class LibraryLoansService {

    private final LibraryLoansRepository libraryLoansRepository;

    public LibraryLoansService(LibraryLoansRepository libraryLoansRepository) {
        this.libraryLoansRepository = libraryLoansRepository;
    }

    @Transactional
    public Optional<LibraryLoans> findById(Long id) {
        ServiceValidation.validateId(id);
        return libraryLoansRepository.findById(id);
    }

    @Transactional
    public List<LibraryLoans> findByStudents_Id(Long studentId) {
        ServiceValidation.validateId(studentId);
        return libraryLoansRepository.findByStudents_Id(studentId);
    }

    @Transactional
    public List<LibraryLoans> findByBooks_Id(Long bookId) {
        ServiceValidation.validateId(bookId);
        return libraryLoansRepository.findByBooks_Id(bookId);
    }

    @Transactional
    public List<LibraryLoans> findByIssueDate(LocalDate issueDate) {
        ServiceValidation.validateDate(issueDate);
        return libraryLoansRepository.findByIssueDate(issueDate);
    }

    @Transactional
    public List<LibraryLoans> findByReturnDate(LocalDate returnDate) {
        ServiceValidation.validateDate(returnDate);
        return libraryLoansRepository.findByReturnDate(returnDate);
    }
}

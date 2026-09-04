package university.management.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.LibraryLoans;

@Repository
public interface LibraryLoansRepository extends JpaRepository<LibraryLoans, Long> {

    Optional<LibraryLoans> findById(Long id);
    List<LibraryLoans> findByStudents_Id(Long studentId);
    List<LibraryLoans> findByBooks_Id(Long bookId);
    List<LibraryLoans> findByIssueDate(LocalDate issueDate);
    List<LibraryLoans> findByReturnDate(LocalDate returnDate);

    @Transactional
    @Modifying
    @Query("delete from LibraryLoans l where l.id = :id")
    int deleteLibraryLoanById(@Param("id") Long id);
}

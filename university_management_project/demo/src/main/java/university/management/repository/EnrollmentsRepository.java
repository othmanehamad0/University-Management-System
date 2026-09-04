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

import university.management.entity.Enrollments;
import university.management.entity.Status;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments, Long> {

    Optional<Enrollments> findById(Long id);
    List<Enrollments> findByStudents_Id(Long studentId);
    List<Enrollments> findByCourses_Id(Long courseId);
    List<Enrollments> findByEnrollmentDate(LocalDate enrollmentDate);
    List<Enrollments> findByStatus(Status status);

    @Transactional
    @Modifying
    @Query("delete from Enrollments e where e.id = :id")
    int deleteEnrollmentById(@Param("id") Long id);
}

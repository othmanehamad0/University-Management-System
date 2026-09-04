package university.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Exams;
import university.management.entity.examType;

@Repository
public interface ExamsRepository extends JpaRepository<Exams, Long> {

    Optional<Exams> findById(Long id);
    List<Exams> findByCourses_Id(Long courseId);
    List<Exams> findByExamDate(java.time.LocalDate examDate);
    List<Exams> findByType(examType type);
    List<Exams> findByTotalMarks(Integer totalMarks);

    @Transactional
    @Modifying
    @Query("delete from Exams e where e.id = :id")
    int deleteExamById(@Param("id") Long id);
}

package university.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Grades;

@Repository
public interface GradesRepository extends JpaRepository<Grades, Long> {

    Optional<Grades> findById(Long id);
    List<Grades> findByStudents_Id(Long studentId);
    List<Grades> findByExams_Id(Long examId);
    List<Grades> findByMarks(Double marks);
    List<Grades> findByLetterGrade(String letterGrade);
    List<Grades> findByEnrollments_Id(Long enrollmentId);

    @Transactional
    @Modifying
    @Query("delete from Grades g where g.id = :id")
    int deleteGradeById(@Param("id") Long id);
}

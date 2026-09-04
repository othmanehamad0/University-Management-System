package university.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Scholarships;

@Repository
public interface ScholarshipsRepository extends JpaRepository<Scholarships, Long> {

    Optional<Scholarships> findById(Long id);
    List<Scholarships> findByStudents_Id(Long studentId);
    List<Scholarships> findByAmount(Double amount);
    List<Scholarships> findByReason(String reason);

    @Transactional
    @Modifying
    @Query("delete from Scholarships s where s.id = :id")
    int deleteScholarshipById(@Param("id") Long id);
}

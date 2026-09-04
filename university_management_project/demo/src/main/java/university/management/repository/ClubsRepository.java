package university.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Clubs;

@Repository
public interface ClubsRepository extends JpaRepository<Clubs, Long> {

    Optional<Clubs> findById(Long id);
    List<Clubs> findByClubName(String clubName);
    List<Clubs> findByPresident(String president);
    List<Clubs> findByStudents_Id(Long studentId);

    @Transactional
    @Modifying
    @Query("delete from Clubs c where c.id = :id")
    int deleteClubById(@Param("id") Long id);
}

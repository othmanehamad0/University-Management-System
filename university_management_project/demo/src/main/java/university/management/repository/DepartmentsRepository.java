package university.management.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import university.management.entity.Departments;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments, Long> {

    Optional<Departments> findById(Long id);
    List<Departments> findByDepartmentName(String departmentName);
    List<Departments> findByBuilding(String building);
    List<Departments> findByBudget(Double budget);

    @Transactional
    @Modifying
    @Query("delete from Departments d where d.id = :id")
    int deleteDepartmentById(@Param("id") Long id);
}

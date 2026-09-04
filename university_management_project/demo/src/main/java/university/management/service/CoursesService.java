package university.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Courses;
import university.management.repository.CoursesRepository;
import university.management.validation.ServiceValidation;

@Service
public class CoursesService {

    private final CoursesRepository coursesRepository;

    public CoursesService(CoursesRepository coursesRepository) {
        this.coursesRepository = coursesRepository;
    }

    @Transactional
    public Optional<Courses> findById(Long id) {
        ServiceValidation.validateId(id);
        return coursesRepository.findById(id);
    }

    @Transactional
    public List<Courses> findByCourseName(String courseName) {
        ServiceValidation.validateString(courseName, "course name");
        return coursesRepository.findByCourseName(courseName);
    }

    @Transactional
    public List<Courses> findByCredit(Integer credit) {
        return coursesRepository.findByCredit(credit);
    }

    @Transactional
    public List<Courses> findBySemester(Integer semester) {
        return coursesRepository.findBySemester(semester);
    }

    @Transactional
    public List<Courses> findByProfessors_Id(Long professorId) {
        ServiceValidation.validateId(professorId);
        return coursesRepository.findByProfessors_Id(professorId);
    }

    @Transactional
    public List<Courses> findByDepartments_Id(Long departmentId) {
        ServiceValidation.validateId(departmentId);
        return coursesRepository.findByDepartments_Id(departmentId);
    }
}

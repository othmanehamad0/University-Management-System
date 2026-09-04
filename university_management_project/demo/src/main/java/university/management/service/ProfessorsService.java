package university.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Courses;
import university.management.entity.Departments;
import university.management.entity.Professors;
import university.management.entity.Students;
import university.management.repository.ProfessorsRepository;
import university.management.validation.ServiceValidation;

@Service
public class ProfessorsService {

    private final ProfessorsRepository professorsRepository;

    public ProfessorsService(ProfessorsRepository professorsRepository) {
        this.professorsRepository = professorsRepository;
    }

    @Transactional
    public Optional<Professors> findById(Long id) {
        ServiceValidation.validateId(id);
        return professorsRepository.findById(id);
    }

    @Transactional
    public Optional<Professors> findByEmail(String email) {
        ServiceValidation.validateString(email, "email");
        return professorsRepository.findByEmail(email);
    }

    @Transactional
    public List<Professors> findByFirstName(String firstName) {
        ServiceValidation.validateString(firstName, "first name");
        return professorsRepository.findByFirstName(firstName);
    }

    @Transactional
    public List<Professors> findByLastName(String lastName) {
        ServiceValidation.validateString(lastName, "last name");
        return professorsRepository.findByLastName(lastName);
    }

    @Transactional
    public List<Professors> findByPhone(String phone) {
        ServiceValidation.validateString(phone, "phone");
        return professorsRepository.findByPhone(phone);
    }

    @Transactional
    public List<Professors> findBySalary(Double salary) {
        return professorsRepository.findBySalary(salary);
    }

    @Transactional
    public List<Professors> findByHireDate(LocalDate hireDate) {
        ServiceValidation.validateDate(hireDate);
        return professorsRepository.findByHireDate(hireDate);
    }

    @Transactional
    public List<Professors> findByDepartments(Departments departments) {
        ServiceValidation.validateNotNull(departments, "department");
        return professorsRepository.findByDepartments(departments);
    }

    @Transactional
    public List<Professors> findByCourses(Courses courses) {
        ServiceValidation.validateNotNull(courses, "course");
        return professorsRepository.findByCourses(courses);
    }

    @Transactional
    public List<Professors> findByStudents(Students student) {
        ServiceValidation.validateNotNull(student, "student");
        return professorsRepository.findByStudents(student);
    }
}

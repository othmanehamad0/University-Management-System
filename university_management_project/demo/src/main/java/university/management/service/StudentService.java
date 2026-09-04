package university.management.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Gender;
import university.management.entity.Students;
import university.management.repository.StudentsRepository;
import university.management.validation.ServiceValidation;
import university.management.validation.StudentValidator;

@Service
public class StudentService {

    private final StudentsRepository studentRepository;


    public StudentService(StudentsRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Transactional
    public List<Students> findByEnrollmentDate(LocalDate enrollmentDate) {

        ServiceValidation.validateDate(enrollmentDate);
        return studentRepository.findByEnrollmentDate(enrollmentDate);
    }

    @Transactional
    public List<Students> findByDepartments_Id(Long departmentId) {

        ServiceValidation.validateId(departmentId);

        return studentRepository.findByDepartments_Id(departmentId);
    }

    @Transactional
    public Optional<Students> findStudentById(Long id) {
        ServiceValidation.validateId(id);
        return studentRepository.findStudentById(id);
    }

    @Transactional
    public Optional<Students> findByEmail(String email) {

        StudentValidator.validateEmail(email);

        return studentRepository.findByEmail(email);
    }

    @Transactional
    public List<Students> findByFirstName(String firstName) {

        ServiceValidation.validateString(firstName, "first name");
        
        return studentRepository.findByFirstName(firstName);
    }

    @Transactional
    public List<Students> findByLastName(String lastName) {

        ServiceValidation.validateString(lastName, "last Name");

        return studentRepository.findByLastName(lastName);
    }

    @Transactional
    public List<Students> findByGender(Gender gender) {
        StudentValidator.validateGender(gender);
        return studentRepository.findByGender(gender);
    }

    // ====== UPDATE OPERATIONS ======

    @Transactional
    public void updateStudentFirstName(Long id, String firstName) {
        ServiceValidation.validateId(id);
        ServiceValidation.validateString(firstName, "first name");
        int rowsUpdated = studentRepository.updateStudentFirstName(id, firstName);
        ServiceValidation.validateUpdateResult(rowsUpdated);
    }

    @Transactional
    public void updateStudentLastName(Long id, String lastName) {
        ServiceValidation.validateId(id);
        ServiceValidation.validateString(lastName, "last name");
        int rowsUpdated = studentRepository.updateStudentLastName(id, lastName);
        ServiceValidation.validateUpdateResult(rowsUpdated);
    }

    @Transactional
    public void updateStudentGender(Long id, Gender gender) {
        ServiceValidation.validateId(id);
        StudentValidator.validateGender(gender);
        int rowsUpdated = studentRepository.updateStudentGender(id, gender);
        ServiceValidation.validateUpdateResult(rowsUpdated);
    }

    @Transactional
    public void updateStudentBirthDate(Long id, LocalDate birthDate) {
        ServiceValidation.validateId(id);
        ServiceValidation.validateDate(birthDate);
        int rowsUpdated = studentRepository.updateStudentBirthDate(id, birthDate);
        ServiceValidation.validateUpdateResult(rowsUpdated);
    }

    @Transactional
    public void updateStudentEmail(Long id, String email) {  
        ServiceValidation.validateId(id);
        StudentValidator.validateEmail(email);
        int rowsUpdated = studentRepository.updateStudentEmail(id, email);
        ServiceValidation.validateUpdateResult(rowsUpdated);
    }

}
package university.management;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import university.management.entity.Departments;
import university.management.entity.Gender;
import university.management.entity.Students;
import university.management.repository.StudentsRepository;
import university.management.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentsRepository repository;

    @InjectMocks
    private StudentService service;

    @Test
    void shouldReturnStudentWhenIdExists() {
        
        Students student = new Students();
        student.setId(1L);
        student.setFirstName("John");
        when(repository.findStudentById(1L)).thenReturn(Optional.of(student));

        
        Optional<Students> result = service.findStudentById(1L);

        
        assertTrue(result.isPresent());
        assertEquals(1L, result.get().getId());
        assertEquals("John", result.get().getFirstName());
    }

    @Test
    void shouldReturnStudentsWhenDepartmentIdExists() { 
       
        Students student = new Students();
        student.setId(1L);
        student.setFirstName("John");
        
        Departments department = new Departments();
        department.setId(3L);
        student.setDepartments(department);
        
        when(repository.findByDepartments_Id(3L)).thenReturn(List.of(student));

       
        List<Students> result = service.findByDepartments_Id(3L);

        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(3L, result.get(0).getDepartments().getId());
    }

    @Test
    void shouldReturnStudentWhenEmailExists() { 
        
        Students student = new Students();
        student.setEmail("othmanehamad@gmail.com");
        when(repository.findByEmail("othmanehamad@gmail.com")).thenReturn(Optional.of(student));

        
        Optional<Students> result = service.findByEmail("othmanehamad@gmail.com");

       
        assertTrue(result.isPresent());
        assertEquals("othmanehamad@gmail.com", result.get().getEmail());
    }
    @Test
    void shouldReturnStudentWhenFirstNameExists(){

        Students student = new Students();
        student.setFirstName("othmane");

        when(repository.findByFirstName("othmane")).thenReturn(List.of(student));

        List<Students> results = service.findByFirstName("othmane");

        assertEquals("othmane",results.get(0).getFirstName());
    }
    @Test
    void shouldReturnStudentWhenLastNameExists(){

        Students student = new Students();
        student.setLastName("hamad");

        when(repository.findByLastName("hamad")).thenReturn(List.of(student));

        List<Students> results = service.findByLastName("hamad");

        assertEquals("hamad",results.get(0).getLastName());
    }
    @Test
    void shouldReturnStudentWhenEnrollmentDateExists(){
        
        Students students = new Students();
        LocalDate expectedDate = LocalDate.of(2026, 1, 1);
        students.setEnrollmentDate(expectedDate);

        when(repository.findByEnrollmentDate(expectedDate)).thenReturn(List.of(students));

        List<Students> results = service.findByEnrollmentDate(expectedDate);

        assertEquals(expectedDate, results.get(0).getEnrollmentDate());
    }
    @Test
    void shouldReturnCorrectStudentStatus(){
        Students student1 = new Students();
        Students student2 = new Students();
        student1.setGender(Gender.MALE);
        student2.setGender(Gender.FEMALE);

        when(repository.findByGender(Gender.MALE)).thenReturn(List.of(student1));
        when(repository.findByGender(Gender.FEMALE)).thenReturn(List.of(student2));

        List<Students> result = service.findByGender(Gender.MALE);
        List<Students> result1 = service.findByGender(Gender.FEMALE);

        assertEquals(Gender.MALE,result.get(0).getGender());
        assertEquals(Gender.FEMALE,result1.get(0).getGender());
    }
@Test
void checkupdateStudentFirstName() {
    // 1. Arrange: Tell the repository to return 1 (one row updated)
    // This stops ServiceValidation.validateUpdateResult from throwing an error!
    when(repository.updateStudentFirstName(1L, "anas")).thenReturn(1);

    // 2. Act: Call the service method (It is void, so no variable assignment)
    service.updateStudentFirstName(1L, "anas");

    // 3. Assert: Verify that the repository was called exactly once with the right data
    verify(repository, times(1)).updateStudentFirstName(1L, "anas");
}
@Test
void checkupdateStudentLastName() {
    // 1. Arrange: Tell the repository to return 1 (one row updated)
    // This stops ServiceValidation.validateUpdateResult from throwing an error!
    when(repository.updateStudentLastName(1L, "hamad")).thenReturn(1);

    // 2. Act: Call the service method (It is void, so no variable assignment)
    service.updateStudentLastName(1L, "hamad");

    // 3. Assert: Verify that the repository was called exactly once with the right data
    verify(repository, times(1)).updateStudentLastName(1L, "hamad");
}
@Test
void checkUpdateStudentGender_callsRepositoryCorrectly() {
    // 1. Arrange: tell the mock repo the update "succeeds" (1 row updated)
    when(repository.updateStudentGender(1L, Gender.MALE)).thenReturn(1);

    // 2. Act: call the service method under test
    service.updateStudentGender(1L, Gender.MALE);

    // 3. Assert: verify the service called the repository with the correct arguments
    verify(repository, times(1)).updateStudentGender(1L, Gender.MALE);
}
@Test
void checkupdateStudentBirthDate(){


    LocalDate date = LocalDate.of(2002, 03, 21);

    when(repository.updateStudentBirthDate(1L, date)).thenReturn(1);


    service.updateStudentBirthDate(1L, date);

    verify(repository, times(1)).updateStudentBirthDate(1L, date);

}

@Test
void updateStudentEmail(){

    when(repository.updateStudentEmail(1L, "othmanehamad@gmail.com")).thenReturn(1);

    service.updateStudentEmail(1L, "othmanehamad@gmail.com");

    verify(repository , times(1)).updateStudentEmail(1L, "othmanehamad@gmail.com");
}


}
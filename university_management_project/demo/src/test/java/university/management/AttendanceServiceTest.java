package university.management;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.boot.internal.Extends;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import university.management.entity.Attendance;
import university.management.entity.Courses;
import university.management.entity.Students;
import university.management.repository.AttendanceRepository;
import university.management.service.AttendanceService;

@ExtendWith(MockitoExtension.class)
public class AttendanceServiceTest {
    
    @Mock
    private AttendanceRepository repository;

    @InjectMocks
    private AttendanceService Service;

    @Test
     void shouldReturnStudentWhenAttendanceIdExists(){

        Attendance attendance = new Attendance();
        attendance.setId(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(attendance));

        Optional<Attendance> results = Service.findById(1L);

        assertEquals(results.get().getId(), attendance.getId());
     }
     @Test
     void shouldReturnStudentWhenIdExists(){

        //arrange
        //prepare the data 
        Attendance attendance = new Attendance();
        Students students = new Students();

        students.setId(1L);
        attendance.setStudents(students);

        //act
        when(repository.findByStudents_Id(1L)).thenReturn(List.of(attendance));

        List<Attendance> result = Service.findByStudents_Id(1L);

        //assert

        assertEquals(result.get(0).getStudents().getId(), students.getId());
     }
     @Test
    void shouldReturnAttendancetWhenCourses_IdExists (){
        //arrange 
        //prepare data 
        Courses courses = new Courses();
        courses.setId(1L);
        Attendance attendance = new Attendance();
        attendance.setCourses(courses);

        //act 
        when(repository.findByCourses_Id(1L)).thenReturn(List.of(attendance));

        List<Attendance> result = Service.findByCourses_Id(1L);

        //assert

        assertEquals(result.get(0).getCourses().getId(), attendance.getCourses().getId());
    }
    @Test
    void shouldReturnAttendancetWhenDateExists () {
        //arrange
        LocalDate expectedDate = LocalDate.of(2004, 04, 29);
        Attendance attendance = new Attendance();
        attendance.setDate(expectedDate);

        //act 

        when(repository.findByDate(expectedDate)).thenReturn(List.of(attendance));

        List<Attendance> result = Service.findByDate(expectedDate);

        //assert

        assertEquals(result.get(0).getDate(), attendance.getDate());
    }
}

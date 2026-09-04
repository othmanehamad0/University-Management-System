package university.management.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import university.management.entity.Attendance;
import university.management.entity.AttendanceStatus;
import university.management.repository.AttendanceRepository;
import university.management.validation.ServiceValidation;

@Service
public class AttendanceService {

    
    private AttendanceRepository attendancerepository;

    public AttendanceService(AttendanceRepository attendancerepository) {
        this.attendancerepository = attendancerepository;
    }

 
    // Find attendance by ID

    public Optional<Attendance> findById(Long id){
        ServiceValidation.validateId(id);

        return attendancerepository.findById(id);
    }

    // Find attendance by student ID

    public List<Attendance> findByStudents_Id(Long studentId){

        ServiceValidation.validateId(studentId);

        return attendancerepository.findByStudents_Id(studentId);
    }

    // Find attendance by course ID
    public List<Attendance> findByCourses_Id(Long courseId){

        ServiceValidation.validateId(courseId);

        return attendancerepository.findByCourses_Id(courseId);
    }

    // Find attendance by Date
    public List<Attendance> findByDate(LocalDate date){

        ServiceValidation.validateDate(date);

        return  attendancerepository.findByDate(date);
    }

    }



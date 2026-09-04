package university.management;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import jakarta.inject.Inject;
import university.management.entity.Clubs;
import university.management.entity.Students;
import university.management.repository.StudentClubRepository;
import university.management.service.ClubService;

@ExtendWith(MockitoExtension.class)
public class ClubServiceTest {
    
    @Mock
    private StudentClubRepository repository;

    @InjectMocks
    private ClubService service;

    @Test
    void shouldReturnStudentWhenIdExist(){
    }
    
}

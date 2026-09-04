package university.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Clubs;
import university.management.repository.ClubsRepository;
import university.management.validation.ServiceValidation;

@Service
public class ClubsService {

    private final ClubsRepository clubsRepository;

    public ClubsService(ClubsRepository clubsRepository) {
        this.clubsRepository = clubsRepository;
    }

    @Transactional
    public Optional<Clubs> findById(Long id) {
        ServiceValidation.validateId(id);
        return clubsRepository.findById(id);
    }

    @Transactional
    public List<Clubs> findByClubName(String clubName) {
        ServiceValidation.validateString(clubName, "club name");
        return clubsRepository.findByClubName(clubName);
    }

    @Transactional
    public List<Clubs> findByPresident(String president) {
        ServiceValidation.validateString(president, "president");
        return clubsRepository.findByPresident(president);
    }

    @Transactional
    public List<Clubs> findByStudents_Id(Long studentId) {
        ServiceValidation.validateId(studentId);
        return clubsRepository.findByStudents_Id(studentId);
    }
}

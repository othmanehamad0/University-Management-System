package university.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import university.management.entity.Departments;
import university.management.repository.DepartmentsRepository;
import university.management.validation.ServiceValidation;

@Service
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;

    public DepartmentsService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    @Transactional
    public Optional<Departments> findById(Long id) {
        ServiceValidation.validateId(id);
        return departmentsRepository.findById(id);
    }

    @Transactional
    public List<Departments> findByDepartmentName(String departmentName) {
        ServiceValidation.validateString(departmentName, "department name");
        return departmentsRepository.findByDepartmentName(departmentName);
    }

    @Transactional
    public List<Departments> findByBuilding(String building) {
        ServiceValidation.validateString(building, "building");
        return departmentsRepository.findByBuilding(building);
    }

    @Transactional
    public List<Departments> findByBudget(Double budget) {
        return departmentsRepository.findByBudget(budget);
    }
}

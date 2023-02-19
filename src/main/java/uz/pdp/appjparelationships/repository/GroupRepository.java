package uz.pdp.appjparelationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.appjparelationships.entity.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Integer> {
    List<Group>findAllByFaculty_UniversityId(Integer faculty_university_id);
}

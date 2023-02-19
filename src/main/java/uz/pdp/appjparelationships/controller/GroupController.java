package uz.pdp.appjparelationships.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appjparelationships.entity.Faculty;
import uz.pdp.appjparelationships.entity.Group;
import uz.pdp.appjparelationships.payload.GroupDto;
import uz.pdp.appjparelationships.repository.FacultyRepository;
import uz.pdp.appjparelationships.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    @GetMapping
    public List<Group> getGroups() {
    List<Group> groups=groupRepository.findAll();
    return groups;
    }
    @GetMapping("/byUniversityId/{universityId}")
    public List<Group> getGroupsByUniversityId(@PathVariable Integer universityId){
        List<Group> allByFacultyUniversityId = groupRepository.findAllByFaculty_UniversityId(universityId);
        return allByFacultyUniversityId;
    }
    @PostMapping
    public String addGroup(@RequestBody GroupDto groupDto){
        Group group=new Group();
        group.setName(groupDto.getName());
        Optional<Faculty>optionalFaculty=facultyRepository.findById(groupDto.getFacultyId());
        if (!optionalFaculty.isPresent())
            return "Such faculty not found";
        group.setFaculty(optionalFaculty.get());
        groupRepository.save(group);
          return "Group added";

    }

}

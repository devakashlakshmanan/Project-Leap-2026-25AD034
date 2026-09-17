package AIDSA.project.Services;

import AIDSA.project.Models.Staff;
import AIDSA.project.Models.Student;
import AIDSA.project.Repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServices {
    @Autowired
    private StaffRepository staffRepository;

    public Staff createstaff(Staff data){
        return staffRepository.save(data);
    }
    public List<Staff> getallstaff(){
        return staffRepository.findAll();
    }
    public Staff updatestaff(Staff data){
        return staffRepository.save(data);
    }
    public void deletebyid(Long Id){
        staffRepository.deleteById(Id);
    }
    public Staff getbyid(Long Id){
        return staffRepository.findById(Id).orElseThrow(()-> new RuntimeException(("AIDS Not Found")));
    }
}

package AIDSA.project.Services;

import AIDSA.project.Models.Student;
import AIDSA.project.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServices {
    @Autowired
    private StudentRepository studentRepository;

    public Student createstudent(Student data){
        return studentRepository.save(data);
    }
    public List <Student> getallstudent(){
        return studentRepository.findAll();
    }
    public Student updatestudent(Student data){
        return studentRepository.save(data);
    }
    public Student deletebyid(Long Id){
        return studentRepository.findById(Id).orElseThrow(()-> new RuntimeException(("AIDS Not Found")));
    }
    public Student getbyid(Long Id){
        return studentRepository.findById(Id).orElseThrow(()-> new RuntimeException(("AIDS Not Found")));
    }
}

package AIDSA.project.Controller;

import AIDSA.project.Models.Student;
import AIDSA.project.Services.StudentServices;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student/")
public class StudentController {
    @Autowired
    private StudentServices studentServices;
    @GetMapping("getall")
    ResponseEntity<List<Student>> getall(){
        return new ResponseEntity<>(studentServices.getallstudent(), HttpStatus.OK);
    }
    @PutMapping("update")
    ResponseEntity<Student> updatestudent(@RequestBody Student data){
        return new ResponseEntity<>(studentServices.updatestudent(data), HttpStatus.ACCEPTED);
    }
    @GetMapping("getbyid/{id}")
    ResponseEntity<?> getbyId(@PathVariable long id){
        try{
            Student response=studentServices.getbyid(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(RuntimeException exception){
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("deletebyid/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        try {
            studentServices.deletebyid(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }

    //request body
    @PostMapping("/create")
    ResponseEntity<Student> createAIDS(@RequestBody Student body){
        return new ResponseEntity<>(studentServices.createstudent(body), HttpStatus.CREATED);
    }
    //request param
    @GetMapping
    String getbyIdParam(@RequestBody long i){
        return "AIDS with id"+i;
    }
}

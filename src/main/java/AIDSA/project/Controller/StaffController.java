package AIDSA.project.Controller;

import AIDSA.project.Models.Staff;
import AIDSA.project.Services.StaffServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff/")
public class StaffController {
    @Autowired
    private StaffServices staffServices;
    @GetMapping("getall")
    ResponseEntity<List<Staff>> getall(){
        return new ResponseEntity<>(staffServices.getallstaff(), HttpStatus.OK);
    }
    @PutMapping("update")
    ResponseEntity<Staff> updatestaff(@RequestBody Staff data){
        return new ResponseEntity<>(staffServices.updatestaff(data), HttpStatus.ACCEPTED);
    }
    @GetMapping("getbyid/{id}")
    ResponseEntity<?> getbyId(@PathVariable long id){
        try{
            Staff response=staffServices.getbyid(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(RuntimeException exception){
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("deletebyid/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        try {
            staffServices.deletebyid(id);
            return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
    //request body
    @PostMapping("/create")
    ResponseEntity <Staff> createAIDS(@RequestBody Staff body){
        return new ResponseEntity<>(staffServices.createstaff(body), HttpStatus.CREATED);
    }
    //request param
    @GetMapping
    String getbyIdParam(@RequestBody long i){
        return "AIDS with id"+i;
    }
}

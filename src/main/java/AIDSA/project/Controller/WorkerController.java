package AIDSA.project.Controller;

import AIDSA.project.Models.Worker;
import AIDSA.project.Services.WorkerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker/")
public class WorkerController {
    @Autowired
    private WorkerServices workerServices;
    @GetMapping("getall")
    ResponseEntity<List<Worker>> getall(){
        return new ResponseEntity<>(workerServices.getallworker(), HttpStatus.OK);
    }
    @PutMapping("update")
    ResponseEntity<Worker> updateworker(@RequestBody Worker data){
        return new ResponseEntity<>(workerServices.updateworker(data), HttpStatus.ACCEPTED);
    }
    @GetMapping("getbyid/{id}")
    ResponseEntity<?> getbyId(@PathVariable long id){
        try{
            Worker response=workerServices.getbyid(id);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        catch(RuntimeException exception){
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("deletebyid/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        try {
            Worker response=workerServices.deletebyid(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
        }
    }
    //request body
    @PostMapping("/create")
    ResponseEntity <Worker> createAIDS(@RequestBody Worker body){
        return new ResponseEntity<>(workerServices.createworker(body), HttpStatus.CREATED);
    }
    //request param
    @GetMapping
    String getbyIdParam(@RequestBody long i){
        return "AIDS with id"+i;
    }
}

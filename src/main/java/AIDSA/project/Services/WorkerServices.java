package AIDSA.project.Services;

import AIDSA.project.Models.Worker;
import AIDSA.project.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServices {
    @Autowired
    private WorkerRepository workerRepository;

    public Worker createworker(Worker data){
        return workerRepository.save(data);
    }
    public List<Worker> getallworker(){
        return workerRepository.findAll();
    }
    public Worker updateworker(Worker data){
        return workerRepository.save(data);
    }
    public void deletebyid(Long Id){
        workerRepository.deleteById(Id);
    }
    public Worker getbyid(Long Id){
        return workerRepository.findById(Id).orElseThrow(()-> new RuntimeException(("AIDS Not Found")));
    }

}

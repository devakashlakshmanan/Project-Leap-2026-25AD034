package AIDSA.project.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue
    long Id;
    String Name;
    String RollNo;
    String Dept;
    int Year;
    int DOB;
    float CGPA;
}

package org.copydays.thinking.java.spring.core.technology.aopproxy;

import lombok.Data;
import org.copydays.thinking.java.spring.core.technology.domain.Student;

import java.util.List;

@Data
public class Klass { 
    
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}

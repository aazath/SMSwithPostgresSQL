package lk.ccs.restcontroller;


import lk.ccs.model.Student;
import lk.ccs.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRestController {

    @Autowired
    private IStudentService service;

    @PostMapping("/register")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        String message = service.saveStudent(student);

        return new ResponseEntity<String>(message, HttpStatus.CREATED);

    }

    @GetMapping("/findAll")
    public ResponseEntity<?> displayAllStudents() {
        List<Student> allStudents = service.findAllStudent();
        return new ResponseEntity<List<Student>>(allStudents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> displayStudentdById(@PathVariable Integer id) {
        Student studentById = service.findStudentById(id);
        return new ResponseEntity<Student>(studentById, HttpStatus.OK);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modifyStudent(@RequestBody Student student) {
        String updated = service.updateStudent(student);
        return new ResponseEntity<String>(updated, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeStudentById(@PathVariable Integer id) {
        String msg = service.deleteStudentById(id);

        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }


}

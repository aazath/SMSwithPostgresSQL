package lk.ccs.service;

import lk.ccs.dao.IStudentDao;
import lk.ccs.exception.StudentNotFoundException;
import lk.ccs.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("service")
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentDao dao;
    @Override
    public String saveStudent(Student student) {
        Student saved = dao.save(student);
        return "Student save with the ID ::"+saved.getSid();
    }

    @Override
    public List<Student> findAllStudent() {
        return dao.findAll();
    }

    @Override
    public Student findStudentById(Integer id) {
        return dao.findById(id).
                orElseThrow(() -> new StudentNotFoundException("Student not found for the given ID :" + id));
    }

    @Override
    public String updateStudent(Student student) {
        Student updated = dao.save(student);
        return "Student updated with the ID ::"+updated.getSid();
    }

    @Override
    public String deleteStudentById(Integer id) {
        Student student= dao.findById(id).
                orElseThrow(() -> new StudentNotFoundException("Student not found for the given ID :" + id));
        dao.deleteById(id);
        return "Deleted successfully";
    }
}

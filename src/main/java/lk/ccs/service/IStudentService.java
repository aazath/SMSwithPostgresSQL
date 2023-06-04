package lk.ccs.service;

import lk.ccs.model.Student;

import java.util.List;

public interface IStudentService {
    public String saveStudent(Student student);
    public List<Student> findAllStudent();
    public Student findStudentById(Integer id);
    public String updateStudent(Student student);
    public String deleteStudentById(Integer  id);
}

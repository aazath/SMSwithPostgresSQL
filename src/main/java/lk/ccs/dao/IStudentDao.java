package lk.ccs.dao;

import lk.ccs.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentDao extends JpaRepository<Student, Integer> {

}

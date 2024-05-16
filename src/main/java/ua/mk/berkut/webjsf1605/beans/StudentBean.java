package ua.mk.berkut.webjsf1605.beans;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import ua.mk.berkut.webjsf1605.dao.StudentDao;
import ua.mk.berkut.webjsf1605.data.Student;

import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class StudentBean {

    @EJB
    StudentDao studentDao;

    @Getter
    @Setter
    private Student currentStudent = new Student();

    public List<Student> getStudents() {
        return studentDao.findAll();
//        List<Student> students = new ArrayList<>();
//        students.add(Student.builder().name("John Doe").age(20).build());
//        students.add(Student.builder().name("Jane Doe").rating(76.0).build());
//        students.add(Student.builder().name("Kate").rating(90.0).age(21).build());
//        students.add(Student.builder().name("Ann").rating(85.0).age(20).build());
//        return students;
    }

    public String sayHello() {
        return "hello";
    }

    public void addStudent() {
        studentDao.save(currentStudent);
        currentStudent = new Student();
    }

    public void delete(int id) {
        studentDao.delete(id);
    }
}

package zw.co.afrocodemy;

import zw.co.afrocodemy.dto.StudentRequest;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentRequest student);
    Student updateStudent(Long id, StudentRequest studentRequest);
    Void deleteStudent(Long id);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
}

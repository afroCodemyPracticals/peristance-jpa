package zw.co.afrocodemy;

import zw.co.afrocodemy.dto.StudentRequest;

import java.util.List;

public interface StudentService {
    public Student createStudent(StudentRequest student);
    public Student updateStudent(Long id, StudentRequest studentRequest);
    public Student deleteStudent(Long id);
    public Student getStudentById(Long id);
    public List<Student> getAllStudents();
}

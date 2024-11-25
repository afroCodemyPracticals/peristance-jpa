package zw.co.afrocodemy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.afrocodemy.dto.StudentRequest;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    @Override
    public Student createStudent(StudentRequest student) {

        Student newStudent = Student.builder()
                .nameOfStudent(student.getName())
                .age(student.getAge())
                .build();

        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(
            Long id, StudentRequest studentRequest) {

        var student = getStudentById(id);

        student.setNameOfStudent(studentRequest.getName());
        student.setAge(studentRequest.getAge());

        return studentRepository.save(student);
    }

    @Override
    public Void deleteStudent(Long id) {

        var student = getStudentById(id);

        studentRepository.delete(student);
        return null;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

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
                .name(student.getName())
                .age(student.getAge())
                .build();
        studentRepository.save(newStudent);
        return newStudent;
    }

    @Override
    public Student updateStudent(Long id, StudentRequest studentRequest) {
        Optional<Student> student = studentRepository.findById(id);
        
        if (student.isPresent()) {
            student.get().setName(studentRequest.getName());
            student.get().setAge(studentRequest.getAge());
            studentRepository.save(student.get());
            return student.get();
        }
        throw new RuntimeException("Student Not Found!!");
    }

    @Override
    public Student deleteStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            studentRepository.delete(student.get());
        }

        return student.get();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }
        throw new RuntimeException("Students Not Found!!");
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

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

        return studentRepository.save(newStudent);
    }

    @Override
    public Student updateStudent(
            Long id, StudentRequest studentRequest) {

        var student = getStudentById(id);

        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());

        return studentRepository.save(student);
//        Optional<Student> student = studentRepository
//                .findById(id);
//
//        if (student.isPresent()) {
//            student.get().setName(studentRequest.getName());
//            student.get().setAge(studentRequest.getAge());
//            studentRepository.save(student.get());
//            return student.get();
//        }
//        throw new RuntimeException("Student Not Found!!");
    }

    @Override
    public Void deleteStudent(Long id) {

        var student = getStudentById(id);

        studentRepository.delete(student);

//        Optional<Student> student = studentRepository.findById(id);
//        if (student.isPresent()) {
//            studentRepository.delete(student.get());
//        }
//
//        return student.get();
        return null;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Student not found")
        );
//        Optional<Student> student = studentRepository.findById(id);
//        if (student.isPresent()) {
//            return student.get();
//        }
//        throw new RuntimeException("Students Not Found!!");
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}

package zw.co.afrocodemy;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.PreInsertEvent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import zw.co.afrocodemy.dto.StudentRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")// change to /students
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @Operation(description = "Create Student")
    public ResponseEntity<Student> saveStudent(
            @RequestBody StudentRequest student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

    @PutMapping("{id}")
    @Operation(description = "Update Student")
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentRequest studentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentRequest));
    }
    @GetMapping("{id}")
    @Operation(description = "Get Student By Id")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("{id}")
    @Operation(description = "Delete Student By Id")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping
    @Operation(description = "Get All Students")
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
}

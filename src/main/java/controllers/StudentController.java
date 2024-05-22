
package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.Student;
import services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	private final StudentService studentService;


	@Autowired
	public StudentController(final StudentService studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Student> getAllStudents() {
		return (List<Student>) this.studentService.findAll();
	}
	/*
	 * @RequestMapping("/{id}")
	 * public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
	 * Optional<Student> student = studentService.findById(id);
	 * return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 * }
	 *
	 * @PostMapping
	 * public Student createStudent(@RequestBody Student student) {
	 * return studentService.save(student);
	 * }
	 *
	 * @PutMapping("/{id}")
	 * public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
	 * if (!studentService.findById(id).isPresent()) {
	 * return ResponseEntity.notFound().build();
	 * }
	 * updatedStudent.setId(id);
	 * return ResponseEntity.ok(studentService.save(updatedStudent));
	 * }
	 *
	 * @DeleteMapping("/{id}")
	 * public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
	 * if (!studentService.findById(id).isPresent()) {
	 * return ResponseEntity.notFound().build();
	 * }
	 * studentService.deleteById(id);
	 * return ResponseEntity.noContent().build();
	 * }
	 */
}

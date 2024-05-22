
package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import domain.Course;
import services.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

	private final CourseService courseService;


	@Autowired
	public CourseController(final CourseService courseService) {
		this.courseService = courseService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<Course> getAllCourses() {
		return (List<Course>) this.courseService.findAll();
	}
	/*
	 * @RequestMapping("/{id}")
	 * public ResponseEntity<Academy> getAcademyById(@PathVariable final Long id) {
	 * final Optional<Academy> academy = this.academyService.findById(id);
	 * return academy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	 * }
	 *
	 * @PostMapping
	 * public Academy createAcademy(@RequestBody final Academy academy) {
	 * return this.academyService.save(academy);
	 * }
	 *
	 * @PutMapping("/{id}")
	 * public ResponseEntity<Academy> updateAcademy(@PathVariable final Long id, @RequestBody final Academy updatedAcademy) {
	 * if (!this.academyService.findById(id).isPresent())
	 * return ResponseEntity.notFound().build();
	 * updatedAcademy.setId(id);
	 * return ResponseEntity.ok(this.academyService.save(updatedAcademy));
	 * }
	 *
	 * @DeleteMapping("/{id}")
	 * public ResponseEntity<Void> deleteAcademy(@PathVariable final Long id) {
	 * if (!this.academyService.findById(id).isPresent())
	 * return ResponseEntity.notFound().build();
	 * this.academyService.deleteById(id);
	 * return ResponseEntity.noContent().build();
	 * }
	 */
}

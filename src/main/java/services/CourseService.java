
package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Course;
import repositories.CourseRepository;

@Service
@Transactional
public class CourseService {

	@Autowired
	private final CourseRepository courseRepository;


	@Autowired
	public CourseService(final CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public Collection<Course> findAll() {
		Collection<Course> result;

		result = this.courseRepository.findAll();

		return result;
	}
	/*
	 * public Academy create() {
	 * Academy result;
	 * final String nameGest;
	 * final String nombreComercial;
	 * final String renameGest;
	 *
	 *
	 *
	 *
	 * result = new Academy();
	 * result.setNombreComercial(nombreComercial);
	 * result.setNameGest(nameGest);
	 * result.setRenameGest(renameGest);
	 *
	 * return result;
	 *
	 * }
	 */
	public Course save(final Course course) {
		return this.courseRepository.save(course);
	}

	public Map<String, Double> computeStatistics() {
		Map<String, Double> result;
		double countAll, countShort, countLong;

		countAll = this.courseRepository.countAllShouts();
		countShort = this.courseRepository.countShortShouts();
		countLong = this.courseRepository.countLongShouts();

		result = new HashMap<String, Double>();
		result.put("count.all.courses", countAll);
		result.put("count.short.courses", countShort);
		result.put("count.long.courses", countLong);

		return result;
	}

}

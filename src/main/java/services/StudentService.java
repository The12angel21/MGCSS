
package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Student;
import repositories.StudentRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;


	@Autowired
	public StudentService(final StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Collection<Student> findAll() {
		Collection<Student> result;

		result = this.studentRepository.findAll();

		return result;
	}

	public Student create() {
		Student result;
		UserAccount userAccount;
		String firstName;
		final String email = "";
		final String lastName = "";
		final String tlf = "";
		final String dirPostal = "";

		userAccount = LoginService.getPrincipal();
		firstName = userAccount.getUsername();

		result = new Student();

		result.setEmail(email);

		result.setFirstName(firstName);

		result.setLastName(lastName);

		result.setTlf(tlf);

		result.setDirPostal(dirPostal);

		return result;
	}

	public Student save(final Student student) {
		return this.studentRepository.save(student);
	}

	public Map<String, Double> computeStatistics() {
		Map<String, Double> result;
		double countAll, countShort, countLong;

		countAll = this.studentRepository.countAllShouts();
		countShort = this.studentRepository.countShortShouts();
		countLong = this.studentRepository.countLongShouts();

		result = new HashMap<String, Double>();
		result.put("count.all.shouts", countAll);
		result.put("count.short.shouts", countShort);
		result.put("count.long.shouts", countLong);

		return result;
	}

}

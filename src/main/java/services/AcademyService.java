
package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Academy;
import repositories.AcademyRepository;

@Service
@Transactional
public class AcademyService {

	@Autowired
	private final AcademyRepository academyRepository;


	@Autowired
	public AcademyService(final AcademyRepository academyRepository) {
		this.academyRepository = academyRepository;
	}

	public Collection<Academy> findAll() {
		Collection<Academy> result;

		result = this.academyRepository.findAll();

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
	public Academy save(final Academy academy) {
		return this.academyRepository.save(academy);
	}

	public Map<String, Double> computeStatistics() {
		Map<String, Double> result;
		double countAll, countShort, countLong;

		countAll = this.academyRepository.countAllShouts();
		countShort = this.academyRepository.countShortShouts();
		countLong = this.academyRepository.countLongShouts();

		result = new HashMap<String, Double>();
		result.put("count.all.shouts", countAll);
		result.put("count.short.shouts", countShort);
		result.put("count.long.shouts", countLong);

		return result;
	}

}

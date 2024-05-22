
package services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.Estilo;
import repositories.EstiloRepository;

@Service
@Transactional
public class EstiloService {

	@Autowired
	private final EstiloRepository estiloRepository;


	@Autowired
	public EstiloService(final EstiloRepository estiloRepository) {
		this.estiloRepository = estiloRepository;
	}

	public Collection<Estilo> findAll() {
		Collection<Estilo> result;

		result = this.estiloRepository.findAll();

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
	public Estilo save(final Estilo estilo) {
		return this.estiloRepository.save(estilo);
	}

	public Map<String, Double> computeStatistics() {
		Map<String, Double> result;
		double countAll, countShort, countLong;

		countAll = this.estiloRepository.countAllShouts();
		countShort = this.estiloRepository.countShortShouts();
		countLong = this.estiloRepository.countLongShouts();

		result = new HashMap<String, Double>();
		result.put("count.all.estilos", countAll);
		result.put("count.short.estilos", countShort);
		result.put("count.long.estilos", countLong);

		return result;
	}

}

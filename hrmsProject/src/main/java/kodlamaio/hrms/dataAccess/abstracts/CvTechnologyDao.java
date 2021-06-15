package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.CvTechnology;
import kodlamaio.hrms.entities.dtos.CvTechnologyWithTechnologyDto;

public interface CvTechnologyDao extends JpaRepository<CvTechnology, Integer>{
	
	@Query("Select new kodlamaio.hrms.entities.dtos.CvTechnologyWithTechnologyDto(t.technologyName) "
			+ "From CvTechnology c INNER JOIN c.technology t "
			+ " where c.cv.cvId = ?1")
	List<CvTechnologyWithTechnologyDto> getCvTechnologyWithTechnologydetails(int cvId);

}

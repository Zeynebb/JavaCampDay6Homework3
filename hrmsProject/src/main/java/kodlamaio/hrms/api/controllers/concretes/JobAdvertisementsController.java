package kodlamaio.hrms.api.controllers.concretes;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobPositionDto;

@RestController
@RequestMapping("/api/jobAdvertisement")
@CrossOrigin
public class JobAdvertisementsController {

	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result jobAdvertisementAdd(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.jobAdvertisementAdd(jobAdvertisement);
	}
	@GetMapping("/getByJobAdvertisementId")
	public DataResult<JobAdvertisement> getByJobAdvertisementId(@RequestParam int id){
		return this.jobAdvertisementService.getByJobAdvertisementId(id);
	}

	@GetMapping("/getAllActive")
	public DataResult<List<JobAdvertisement>> getByAdvertisementStatus(@RequestParam boolean status) {
		return this.jobAdvertisementService.getByAdvertisementStatus(status);
	}

	@GetMapping("/getAllSorted")
	public DataResult<List<JobAdvertisement>> getAllSorted() {
		return this.jobAdvertisementService.getAllSorted();
	}

	@GetMapping("/getByEmployerJobAdvertisements")
	public DataResult<List<JobAdvertisement>> getByEmployer_userId(@RequestParam int userId) {
		return this.jobAdvertisementService.getByEmployer_userId(userId);
	}


	@PostMapping("/closeTheJobAdvertisement")
	@Transactional
	public Result updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(
			@RequestParam("jobAdvertisementId") int jobAdvertisementId, @RequestParam("employerId") int employerId) {
		return this.jobAdvertisementService
				.updateJobAdvertisementSetJobAdvertisementStatusForEmployer_userId(jobAdvertisementId, employerId);
	}

	@GetMapping("/getAllActiveSorted")
	public DataResult<List<JobAdvertisement>> getAllActiveSorted() {
		return this.jobAdvertisementService.getAllActiveSorted();
	}
	@GetMapping("/getAllApproveStatus")
	public DataResult<List<JobAdvertisement>> getAllApproveStatus(boolean status){
		return this.jobAdvertisementService.getAllApproveStatus(status);
	}
	
	@GetMapping("/getJobAdvertisementWithEmployerWithJobPositionDetails")
	public DataResult<List<JobAdvertisementWithEmployerWithJobPositionDto>> getJobAdvertisementWithEmployerWithJobPositionDetails() {
		return this.jobAdvertisementService.getJobAdvertisementWithEmployerWithJobPositionDetails();
	}

}

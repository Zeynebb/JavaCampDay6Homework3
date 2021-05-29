package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_advertisement_id")
	private int jobAdvertisementId;
	
	@Column(name ="job_description")
	private String jobDescription;
	
	@Column(name ="max_salary")
	private int maxSalary;
	
	@Column(name ="min_salary")
	private int minSalary;
	
	@Column(name ="position_amount")
	private int positionAmount;
	
	@Column(name ="application_deadline")
	private Date applicationDeadline;
	
	@Column(name ="advertisement_status")
	private boolean advertisementStatus;
	
	@Column(name="release_date")
	private Date releaseDate;
	
	@ManyToOne
	@JoinColumn(name="position_id")
	private JobPosition position;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	public JobAdvertisement(String jobDescription, int maxSalary, int minSalary, int positionAmount,
			Date applicationDeadline, boolean advertisementStatus) {
		super();
		this.jobDescription = jobDescription;
		this.maxSalary = maxSalary;
		this.minSalary = minSalary;
		this.positionAmount = positionAmount;
		this.applicationDeadline = applicationDeadline;
		this.advertisementStatus = advertisementStatus;
	}

}

package tapcoltd.techicaltest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="DRIVER")
public class Driver {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int driverId;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="SURNAME")
	private String surname;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="VEHICLE_TYPE")
	private String vehicleType;
	
	@Column(name="BASE_FARE_PRICE")
	private double baseFarePrice;
	
	@Column(name="BASE_FARE_DISTANCE")
	private int baseFareDistance;

}

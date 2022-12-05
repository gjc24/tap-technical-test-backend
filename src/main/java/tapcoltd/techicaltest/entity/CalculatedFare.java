package tapcoltd.techicaltest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="CALCULATED_FARE")
public class CalculatedFare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="DRIVER_ID")
    private int driverId;

    @Column(name="CSV_DISTANCE_TRAVELED")
    private int csvDistanceTraveled;

    @Column(name="CSV_TRAVEL_UNIT")
    private int csvTravelUnit;

    @Column(name="CSV_COST_PER_DISTANCE_TRAVELED")
    private int csvCostPerDistanceTraveled;

    @Column(name="FINAL_CALCULATED_COST")
    private double finalCalculatedCost;
}

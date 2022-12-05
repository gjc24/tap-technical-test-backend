package tapcoltd.techicaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tapcoltd.techicaltest.entity.CalculatedFare;
import tapcoltd.techicaltest.entity.Driver;

import java.util.List;

@Repository
public interface CalculatedFareRepository extends JpaRepository<CalculatedFare, Integer> {

    @Query(value="SELECT * FROM CALCULATED_FARE cf WHERE cf.DRIVER_ID = ?1", nativeQuery = true)
    List<CalculatedFare> getCalculatedFaresById(Integer driverId);
}

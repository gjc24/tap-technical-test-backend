package tapcoltd.techicaltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tapcoltd.techicaltest.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {}

package com.lushidea.evetools.infrastructure.repository;

import com.lushidea.evetools.infrastructure.entity.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepo extends CrudRepository<Ship, Long> {
    List<Ship> findByEnabled(boolean enabled);
}

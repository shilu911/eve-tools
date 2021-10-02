package com.lushidea.evetools.infrastructure.repository;

import com.lushidea.evetools.infrastructure.entity.ShipBlueprint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipBlueprintRepo extends CrudRepository<ShipBlueprint, Long> {
    List<ShipBlueprint> findAll();
}

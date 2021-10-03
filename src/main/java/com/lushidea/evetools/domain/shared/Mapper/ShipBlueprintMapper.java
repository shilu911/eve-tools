package com.lushidea.evetools.domain.shared.Mapper;

import com.lushidea.evetools.domain.shared.model.entity.ShipBlueprint;

public interface ShipBlueprintMapper {
    static ShipBlueprint shipBlueprintEntityToMap(com.lushidea.evetools.infrastructure.entity.ShipBlueprint shipBlueprint, boolean withShip) {
        if (shipBlueprint == null) return null;
        ShipBlueprint result = ShipBlueprint.builder()
                .id(shipBlueprint.getId())
                .label(LabelMapper.labelEntityToModel(shipBlueprint.getLabel()))
                .techLevel(shipBlueprint.getTechLevel())
                .buildCost(shipBlueprint.getBuildCost())
                .buildTime(shipBlueprint.getBuildTime())
                .build();
        if (withShip) {
            result = result.toBuilder()
                    .ship(ShipMapper.shipEntityToModel(shipBlueprint.getShip(), false))
                    .build();
        }
        return result;
    }
}

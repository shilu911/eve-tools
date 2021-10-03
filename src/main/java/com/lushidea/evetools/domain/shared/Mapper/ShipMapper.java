package com.lushidea.evetools.domain.shared.Mapper;

import com.lushidea.evetools.domain.shared.model.entity.Ship;

public interface ShipMapper {
    static Ship shipEntityToModel(com.lushidea.evetools.infrastructure.entity.Ship ship, boolean withBlueprint) {
        if (ship == null) return null;
        Ship result = Ship.builder()
                .id(ship.getId())
                .label(LabelMapper.labelEntityToModel(ship.getLabel()))
                .group(GroupMapper.groupEntityToModel(ship.getGroup()))
                .techLevel(ship.getTechLevel())
                .enabled(ship.isEnabled())
                .build();
        if (withBlueprint) {
            result = result.toBuilder()
                    .blueprint(ShipBlueprintMapper.shipBlueprintEntityToMap(ship.getShipBlueprint(), false))
                    .build();
        }
        return result;
    }
}

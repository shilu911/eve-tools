package com.lushidea.evetools.controller.ship;

import com.lushidea.evetools.controller.shared.mapper.LabelMapper;
import com.lushidea.evetools.controller.ship.viewobject.ShipBuild;
import com.lushidea.evetools.domain.item.service.interfaces.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/ship-builds")
public class ShipBuildController {
    private ShipService shipService;

    @Autowired
    public ShipBuildController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping(path = "/")
    List<ShipBuild> findAllEnabledShipBuilds() {
        return shipService.getAllEnabledShipCost().stream().map(ship -> ShipBuild.builder()
                .id(ship.getId())
                .techLevel(ship.getTechLevel())
                .buildCost(ship.getBlueprint().getBuildCost())
                .buildTime(ship.getBlueprint().getBuildTime())
                .mineCost(ship.getBlueprint().getMineCost())
                .planetaryResourceCost(ship.getBlueprint().getPlanetaryResourceCost())
                .groupId(ship.getGroup().getId())
                .label(LabelMapper.labelModelToViewObject(ship.getLabel()))
                .blueprintCost(ship.getBlueprint().getBlueprintCost())
                .build()).collect(Collectors.toList());
    }
}

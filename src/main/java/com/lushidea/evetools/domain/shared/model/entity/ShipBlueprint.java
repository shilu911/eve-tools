package com.lushidea.evetools.domain.shared.model.entity;

import com.lushidea.evetools.domain.shared.model.valueobject.Label;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
public class ShipBlueprint {
    long id;
    Label label;
    Ship ship;
    Integer techLevel;
    Long buildCost;
    Long buildTime;
    Long mineCost;
    Long planetaryResourceCost;
    Long blueprintCost;
}

package com.lushidea.evetools.controller.ship.viewobject;

import com.lushidea.evetools.controller.shared.viewobject.Label;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
public class ShipBuild {
    long id;
    Long buildCost;
    Long buildTime;
    Long mineCost;
    Long planetaryResourceCost;
    Long blueprintCost;
    Long groupId;
    Integer techLevel;
    Label label;
}

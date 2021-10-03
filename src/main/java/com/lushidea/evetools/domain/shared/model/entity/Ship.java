package com.lushidea.evetools.domain.shared.model.entity;

import com.lushidea.evetools.domain.shared.model.valueobject.Label;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder(toBuilder = true)
@ToString
public class Ship {
    long id;
    Label label;
    Group group;
    Integer techLevel;
    boolean enabled;
    ShipBlueprint blueprint;
}

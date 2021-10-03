package com.lushidea.evetools.domain.item.service.interfaces;

import com.lushidea.evetools.domain.shared.model.entity.Ship;

import java.util.List;

public interface ShipService {
    List<Ship> getAllEnabledShipCost();
}

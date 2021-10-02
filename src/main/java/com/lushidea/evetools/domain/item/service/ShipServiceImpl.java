package com.lushidea.evetools.domain.item.service;

import com.lushidea.evetools.domain.item.service.interfaces.ShipService;
import com.lushidea.evetools.domain.shared.model.entity.Ship;
import com.lushidea.evetools.infrastructure.repository.ShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {

    private ShipRepo shipRepo;

    @Autowired
    public ShipServiceImpl(ShipRepo shipRepo) {
        this.shipRepo = shipRepo;
    }

    @Override
    public List<Ship> getAllEnabledShipCost() {
        List<com.lushidea.evetools.infrastructure.entity.Ship> shipList = shipRepo.findByEnabled(true);
        final List<Ship> ships = new ArrayList();
        return null;
    }
}

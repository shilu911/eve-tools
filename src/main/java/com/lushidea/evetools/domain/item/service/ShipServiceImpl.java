package com.lushidea.evetools.domain.item.service;

import com.lushidea.evetools.domain.item.service.interfaces.ShipService;
import com.lushidea.evetools.domain.shared.Mapper.ShipMapper;
import com.lushidea.evetools.domain.shared.model.entity.Ship;
import com.lushidea.evetools.infrastructure.entity.MarketData;
import com.lushidea.evetools.infrastructure.repository.MarketDataRepo;
import com.lushidea.evetools.infrastructure.repository.ShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShipServiceImpl implements ShipService {

    private ShipRepo shipRepo;
    private MarketDataRepo marketDataRepo;

    @Autowired
    public ShipServiceImpl(ShipRepo shipRepo, MarketDataRepo marketDataRepo) {
        this.marketDataRepo = marketDataRepo;
        this.shipRepo = shipRepo;
    }

    @Override
    public List<Ship> getAllEnabledShipCost() {
        List<com.lushidea.evetools.infrastructure.entity.Ship> shipList = shipRepo.findByEnabled(true);
        final List<Ship> ships = new ArrayList();
        Map<Long, Long> prices = new HashMap();
        for (int i = 0; i < shipList.size(); i++) {
            com.lushidea.evetools.infrastructure.entity.Ship ship = shipList.get(i);
            com.lushidea.evetools.infrastructure.entity.ShipBlueprint shipBlueprint = ship.getShipBlueprint();
            Ship shipModel = ShipMapper.shipEntityToModel(ship, true);
            // calculating cost
            Map<Long, Long> materials = shipBlueprint.getMaterials();
            long mineCost = 0;
            long prCost = 0;
            if (materials != null) {
                for (Long key: materials.keySet()) {
                    if (materials.get(key) == null) continue;
                    Long price = prices.get(key);
                    if (price == null) {
                        MarketData marketData = marketDataRepo.findFirstByMarketDataPKItemIdOrderByMarketDataPKTimestampDesc(key);
                        prices.put(key, marketData.getLowestSell());
                        price = marketData.getLowestSell();
                    }
                    if (key.toString().startsWith("410")) {
                        mineCost += materials.get(key) * price;
                    } else if (key.toString().startsWith("420")) {
                        prCost += materials.get(key) * price;
                    }
                }
            }
            MarketData blueprint = marketDataRepo.findFirstByMarketDataPKItemIdOrderByMarketDataPKTimestampDesc(shipBlueprint.getId());
            shipModel = shipModel.toBuilder()
                    .blueprint(shipModel.getBlueprint().toBuilder()
                            .mineCost(mineCost)
                            .planetaryResourceCost(prCost)
                            .blueprintCost(blueprint == null ? null : blueprint.getLowestSell())
                            .build())
                    .build();
            ships.add(shipModel);
        }
        return ships;
    }
}

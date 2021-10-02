package com.lushidea.evetools.infrastructure.repository;

import com.lushidea.evetools.infrastructure.entity.MarketData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDataRepo extends CrudRepository<MarketData, MarketData.MarketDataPK> {
    MarketData findFirstByMarketDataPKItemIdOrderByMarketDataPKTimestampDesc(long itemId);
}

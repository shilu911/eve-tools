package com.lushidea.evetools.infrastructure.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "market_data")
public class MarketData extends BaseEntity {
    @EmbeddedId
    private MarketDataPK marketDataPK;

    @Column
    private long sell;

    @Column
    private long buy;

    @Column(name = "lowest_sell")
    private long lowestSell;

    @Column(name = "highest_buy")
    private long highestBuy;

    @Embeddable
    static public class MarketDataPK implements Serializable {
        @Column(name = "item_id")
        private Long itemId;
        private Long timestamp;

        public MarketDataPK() {}

        public MarketDataPK(Long itemId, Long timestamp) {
            this.itemId = itemId;
            this.timestamp = timestamp;
        }
    }
}

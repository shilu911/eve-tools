package com.lushidea.evetools.infrastructure.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Entity
@Table(name = "market_data")
@ToString
public class MarketData extends BaseEntity {
    @EmbeddedId
    private MarketDataPK marketDataPK;

    @Column
    private Long sell;

    @Column
    private Long buy;

    @Column(name = "lowest_sell")
    private Long lowestSell;

    @Column(name = "highest_buy")
    private Long highestBuy;

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

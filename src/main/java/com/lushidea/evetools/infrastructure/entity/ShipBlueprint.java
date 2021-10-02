package com.lushidea.evetools.infrastructure.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "ship_blueprint")
public class ShipBlueprint extends BaseEntity {
    @Id
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json", name = "label")
    private Label label;

    @OneToOne
    @JoinColumn(name = "product")
    private Ship ship;

    @Column(name = "tech_level")
    private int techLevel;

    @Column(name = "build_cost")
    private long buildCost;

    @Column(name = "build_time")
    private long buildTime;

    @Column(columnDefinition = "json", name = "materials")
    @Type( type = "json" )
    private Map<Long, Long> materials;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public int getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(int techLevel) {
        this.techLevel = techLevel;
    }

    public long getBuildCost() {
        return buildCost;
    }

    public void setBuildCost(long buildCost) {
        this.buildCost = buildCost;
    }

    public long getBuildTime() {
        return buildTime;
    }

    public void setBuildTime(long buildTime) {
        this.buildTime = buildTime;
    }

    public Map<Long, Long> getMaterials() {
        return materials;
    }

    public void setMaterials(Map<Long, Long> materials) {
        this.materials = materials;
    }
}

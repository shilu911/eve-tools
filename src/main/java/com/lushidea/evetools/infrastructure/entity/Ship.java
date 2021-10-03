package com.lushidea.evetools.infrastructure.entity;

import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "ship")
@ToString
public class Ship extends BaseEntity {
    @Id
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json", name = "label")
    private Label label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    @Column(name = "tech_level")
    private Integer techLevel;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToOne(mappedBy = "ship")
    private ShipBlueprint shipBlueprint;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Integer getTechLevel() {
        return techLevel;
    }

    public void setTechLevel(Integer techLevel) {
        this.techLevel = techLevel;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public ShipBlueprint getShipBlueprint() {
        return shipBlueprint;
    }

    public void setShipBlueprint(ShipBlueprint shipBlueprint) {
        this.shipBlueprint = shipBlueprint;
    }
}

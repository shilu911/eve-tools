package com.lushidea.evetools.infrastructure.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mine")
public class Mine extends BaseEntity {
    @Id
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json", name = "label")
    private Label label;

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
}

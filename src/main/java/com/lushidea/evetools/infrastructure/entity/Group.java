package com.lushidea.evetools.infrastructure.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "`group`")
public class Group extends BaseEntity {
    @Id
    private Long id;

    @Type(type = "json")
    @Column(columnDefinition = "json", name = "label")
    private Label label;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

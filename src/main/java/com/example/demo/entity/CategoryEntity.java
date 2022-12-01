package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class CategoryEntity {
	@Id
    @Column(name = "CatagoryID")
    private Long CatagoryID;

    @Column(name="Name")
    private String Name;

    @Column(name="Description")
    private String Description;

    @OneToMany(mappedBy="categoryEntity")
    private List<VegetableEntity> litVegetableEntities;

    public Long getCatagoryID() {
        return CatagoryID;
    }

    public void setCatagoryID(Long catagoryID) {
        CatagoryID = catagoryID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<VegetableEntity> getLitVegetableEntities() {
        return litVegetableEntities;
    }

    public void setLitVegetableEntities(List<VegetableEntity> litVegetableEntities) {
        this.litVegetableEntities = litVegetableEntities;
    }
}

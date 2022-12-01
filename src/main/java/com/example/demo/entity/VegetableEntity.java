package com.example.demo.entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "vegetable")
public class VegetableEntity {
    @Id
    @Column(name="VegetableID")
    private Long VegetableID;

    @Column(name = "VegetableNAME")
    private String VegetableName;

    @Column(name="Amount")
    private int Amount;

    @Column(name="Image")
    private String Image;

    @Column(name="Price")
    private int Price;

    @Column(name="Unit")
    private String Unit;

    @ManyToOne
    @JoinColumn(name="CatagoryID")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "vegetableEntity")
    private List<OrderDetailEntity> listOrderDetailEnities;

    public Long getVegetableID() {
        return VegetableID;
    }

    public void setVegetableID(Long vegetableID) {
        VegetableID = vegetableID;
    }

    public String getVegetableName() {
        return VegetableName;
    }

    public void setVegetableName(String vegetableName) {
        VegetableName = vegetableName;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public List<OrderDetailEntity> getListOrderDetailEnities() {
        return listOrderDetailEnities;
    }

    public void setListOrderDetailEnities(List<OrderDetailEntity> listOrderDetailEnities) {
        this.listOrderDetailEnities = listOrderDetailEnities;
    }
    
}

package com.example.demo.dto;

public class CategoryDTO {
    private Long CatagoryID;
    private String Name;
	private String Description;

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
}

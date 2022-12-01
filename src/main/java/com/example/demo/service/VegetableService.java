package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.VegetableDTO;

public interface VegetableService {
    List<VegetableDTO> getAllVegetables();

    VegetableDTO getVegetableById(Long id);
    
    List<VegetableDTO> getVegetableByCatagoryID(String catagoryID);
    
    List<VegetableDTO> getVegetableByVegetableName(String vegetableName);
    List<VegetableDTO> getVegetableByCatagoryIDAndVegetableName(String catagoryID, String vegetableName);
    
    List<VegetableDTO> getSellingVegetable();
    
    void updateQty(List<VegetableDTO> list);
}

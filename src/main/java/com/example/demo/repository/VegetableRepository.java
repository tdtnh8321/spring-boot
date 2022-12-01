package com.example.demo.repository;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VegetableEntity;
@Repository
public interface VegetableRepository extends JpaRepository<VegetableEntity, Long>  {
	//tìm sản phẩm theo catagoryID
	@Query("SELECT v from VegetableEntity v where CatagoryID=?1")
	List<VegetableEntity> findByCatagoryID(String catagoryID);
	//tìm kiếm sản phẩm theo tên
	@Query("SELECT v from VegetableEntity v where VegetableName like %?1%")
	List<VegetableEntity> findByVegetableName(String vegetableName);
	//tìm kiếm sản phẩm theo catagoryID và tên
	@Query("SELECT v from VegetableEntity v where CatagoryID=?1 and VegetableName like %?2%")
	List<VegetableEntity> findByCatagoryIDAndVegetableName(String catagoryID, String vegetableName);
	//Xuất danh sách sản phẩm bán chạy(sản phẩm có số luongj trong kho nhiều nhất)
	@Query(value="SELECT * from vegetable order by Amount DESC Limit 0,2", nativeQuery=true)
	List<VegetableEntity> getSellingVegetable();
	
	//Lấy số lượng của sản phẩm để check
	@Query(value="Select v.Amount from vegetable v where VegetableID=?1 ", nativeQuery=true)
	int getAmount(Long id);
	//Tìm sản phẩm theo VegetableID
	@Query(value="Select * from vegetable v where VegetableID=?1 ", nativeQuery=true)
	VegetableEntity getVegetableByID(Long id);
	
	//Giảm số lượng của sản phẩm
	@Modifying
	@Query(value="UPDATE vegetable v SET v.Amount=?2 where v.VegetableID=?1 ", nativeQuery=true)
	void updateQuantity(int vegetableID, int qty);
	
}

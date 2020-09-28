package com.eval.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eval.coronakit.entity.ProductMaster;

@Repository
public interface ProductMasterRepository extends JpaRepository<ProductMaster, Integer> {

	boolean existsByProductName(String productName);

	@Query(value = "SELECT cost FROM ProductMaster p WHERE p.id=:id")
	Integer getCostById(@Param("id") Integer id);
}

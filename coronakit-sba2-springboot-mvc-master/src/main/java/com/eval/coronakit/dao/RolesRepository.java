package com.eval.coronakit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eval.coronakit.entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, String> {
	List<Roles> findByuserName(String userName);
}

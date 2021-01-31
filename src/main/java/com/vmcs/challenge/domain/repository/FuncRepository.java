package com.vmcs.challenge.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vmcs.challenge.domain.model.Func;

public interface FuncRepository extends JpaRepository<Func, String> {
	
	List<Func> findByName(String name);
	
	
}

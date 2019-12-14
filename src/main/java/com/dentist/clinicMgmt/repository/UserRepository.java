package com.dentist.clinicMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentist.clinicMgmt.model.User;

public interface UserRepository extends JpaRepository<User, Long>
{
	
}

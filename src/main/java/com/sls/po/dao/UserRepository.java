
package com.sls.po.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sls.po.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	 List<User> findByUserName(String userName);

 
}

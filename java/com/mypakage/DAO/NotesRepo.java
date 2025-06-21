package com.mypakage.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;


import com.mypakage.Entity.Notes;
import java.util.List;

@EnableJpaRepositories
public interface NotesRepo extends JpaRepository<Notes,Integer> {
	
	
	
	
	
	
	
     


}

package com.papers_dev.userinfo.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.papers_dev.userinfo.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    
}


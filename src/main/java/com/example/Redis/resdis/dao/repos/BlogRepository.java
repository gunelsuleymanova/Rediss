package com.example.Redis.resdis.dao.repos;

import com.example.Redis.resdis.dao.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity,Long> {
}

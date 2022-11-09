package com.mkj.gtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mkj.gtest.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> 
{

	
}

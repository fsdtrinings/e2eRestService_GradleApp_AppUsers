package com.mkj.gtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mkj.gtest.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> 
{

}

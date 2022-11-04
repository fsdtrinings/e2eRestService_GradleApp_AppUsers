package com.mkj.gtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Post;
import com.mkj.gtest.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService
{

	@Autowired
	PostRepository postRepository;
	
	@Override
	public Post addPost(Post post) {
	
		Post savedPost = postRepository.save(post);
		return savedPost;
	}

		
}

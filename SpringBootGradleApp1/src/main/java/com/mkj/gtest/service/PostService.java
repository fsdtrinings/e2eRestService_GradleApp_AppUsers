package com.mkj.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Post;

@Service
public interface PostService {

	public Post addPost(Post post);
	
	public List<Post> getAllPostsbyUser(String username)throws Exception;
}

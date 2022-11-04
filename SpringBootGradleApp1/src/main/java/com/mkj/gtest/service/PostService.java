package com.mkj.gtest.service;

import org.springframework.stereotype.Service;

import com.mkj.gtest.entity.Post;

@Service
public interface PostService {

	public Post addPost(Post post);
}

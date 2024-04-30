package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Post createNewPost(Post post) {
        // Save the post to the database
        Post savedPost = postRepository.save(post);

        // Make an outbound HTTP call to the World Time API to get the current time
        String response = restTemplate.getForObject("http://worldtimeapi.org/api/timezone/Asia/Kolkata", String.class);

        // Return the ID of the saved post and the HTTP outbound response
        return savedPost;
    }
}

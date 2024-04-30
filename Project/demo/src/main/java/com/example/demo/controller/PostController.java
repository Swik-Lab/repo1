package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;

@RestController
public class PostController {

    @Autowired
    private PostService postService;
    
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/api/createNewPost")
    public ResponseEntity<?> createNewPost(@RequestBody Post post) {
        try {
            // Save the post to the database
            Post savedPost = postService.createNewPost(post);
            
            // Make an outbound HTTP call to the World Time API to get the current time
            String url = "http://worldtimeapi.org/api/timezone/Asia/Kolkata";
            String timeResponse = restTemplate.getForObject(url, String.class);
            
            // Construct the response JSON
            String responseBody = "{ \"db_post\": \"" + savedPost.getId() + "\", \"http_outbound\": \"" + timeResponse + "\" }";

            return ResponseEntity.ok().body(responseBody);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

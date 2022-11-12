package com.nro.god.controller;

import com.nro.god.model.PostQuestion;
import com.nro.god.service.PostQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post-question")
@CrossOrigin("http://localhost")
public class PostQuestionController {
    @Autowired
    PostQuestionService postQuestionService;
    @PostMapping("/save")
    public PostQuestion save(@RequestBody PostQuestion postQuestion) {
        return postQuestionService.save(postQuestion);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        postQuestionService.deleteById(id);
    }
    @GetMapping("/get/{id}")
    public PostQuestion findById(@PathVariable Long id) {
        return postQuestionService.findById(id);
    }
    @GetMapping("/get/{page}/{size}")
    public void findAll(@PathVariable int page,@PathVariable int size) {
        postQuestionService.findAll(page,size);
    }

}

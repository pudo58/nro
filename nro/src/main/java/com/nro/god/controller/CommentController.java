package com.nro.god.controller;

import com.nro.god.model.Comment;
import com.nro.god.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@CrossOrigin("http://localhost")
public class CommentController {
    @Autowired
    CommentService commentService;
    @PostMapping("/save")
    public Comment save(@RequestBody Comment comment) {
        return commentService.save(comment);
    }
    @GetMapping("/get")
    public List<Comment> findAll() {
        return commentService.findAll();
    }
    @GetMapping("/get/{page}/{size}")
    public Page<Comment> findAll(@PathVariable int page,@PathVariable int size) {
        return commentService.findAll(page,size);
    }

}

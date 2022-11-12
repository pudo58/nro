package com.nro.god.service;

import com.nro.god.model.Comment;
import com.nro.god.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
    public Page<Comment> findAll(int page, int size) {
        Sort sort = Sort.sort(Comment.class).by(Comment::getCreated).descending();
        return commentRepository.findAll(PageRequest.of(page,size,sort));
    }

}

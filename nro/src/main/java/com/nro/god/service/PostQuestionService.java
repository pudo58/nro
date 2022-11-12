package com.nro.god.service;

import com.nro.god.model.PostQuestion;
import com.nro.god.repository.PostQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
@Service
public class PostQuestionService {
    @Autowired
    PostQuestionRepository postRepository;
    public PostQuestion save(PostQuestion postQuestion) {
        return postRepository.save(postQuestion);
    }
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
    public PostQuestion findById(Long id) {
        return postRepository.findById(id).get();
    }
    public Page<PostQuestion> findAll(int page, int size) {
        Sort sort = Sort.sort(PostQuestion.class).by(PostQuestion::getCreated).descending();
        return postRepository.findAll(PageRequest.of(page,size,sort));
    }

}

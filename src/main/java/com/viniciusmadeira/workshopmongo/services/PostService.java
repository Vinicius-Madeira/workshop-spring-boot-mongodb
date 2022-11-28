package com.viniciusmadeira.workshopmongo.services;

import com.viniciusmadeira.workshopmongo.domain.Post;
import com.viniciusmadeira.workshopmongo.repository.PostRepository;
import com.viniciusmadeira.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> optionalPost = repo.findById(id);
        return optionalPost.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }
}

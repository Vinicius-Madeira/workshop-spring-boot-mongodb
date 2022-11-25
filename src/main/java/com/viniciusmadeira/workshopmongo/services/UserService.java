package com.viniciusmadeira.workshopmongo.services;

import com.viniciusmadeira.workshopmongo.domain.User;
import com.viniciusmadeira.workshopmongo.repository.UserRepository;
import com.viniciusmadeira.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public Optional<User> findById(String id) {
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()) {
            throw new ObjectNotFoundException("Object not found");
        }
        return user;
    }
}

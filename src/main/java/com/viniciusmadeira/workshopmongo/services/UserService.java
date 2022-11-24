package com.viniciusmadeira.workshopmongo.services;

import com.viniciusmadeira.workshopmongo.domain.User;
import com.viniciusmadeira.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}

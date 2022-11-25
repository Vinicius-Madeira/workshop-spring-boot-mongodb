package com.viniciusmadeira.workshopmongo.services;

import com.viniciusmadeira.workshopmongo.domain.User;
import com.viniciusmadeira.workshopmongo.dto.UserDTO;
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

    public User findById(String id) {
        Optional<User> optionalUser = repo.findById(id);
        return optionalUser.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }


    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}

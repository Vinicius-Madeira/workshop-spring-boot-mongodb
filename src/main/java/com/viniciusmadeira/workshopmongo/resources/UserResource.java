package com.viniciusmadeira.workshopmongo.resources;

import com.viniciusmadeira.workshopmongo.domain.User;
import com.viniciusmadeira.workshopmongo.dto.UserDTO;
import com.viniciusmadeira.workshopmongo.services.UserService;
import com.viniciusmadeira.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(UserDTO::new).toList();
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity <UserDTO> findById(@PathVariable String id) {
        Optional<User> obj = service.findById(id);
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Object not found");
        }
        return ResponseEntity.ok().body(new UserDTO(obj));
    }
}

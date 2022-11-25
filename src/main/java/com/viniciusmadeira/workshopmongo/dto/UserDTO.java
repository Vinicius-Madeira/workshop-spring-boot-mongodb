package com.viniciusmadeira.workshopmongo.dto;

import com.viniciusmadeira.workshopmongo.domain.User;
import com.viniciusmadeira.workshopmongo.services.exception.ObjectNotFoundException;

import java.io.Serializable;
import java.util.Optional;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public UserDTO(Optional<User> obj) {
        if (obj.isEmpty()) {
            throw new ObjectNotFoundException("Object not found");
        }
        id = obj.get().getName();
        name = obj.get().getName();
        email = obj.get().getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

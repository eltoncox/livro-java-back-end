package com.elton.java.back.end.service;

import com.elton.java.back.end.converter.DTOConverter;
import com.elton.java.back.end.dto.UserDTO;
import com.elton.java.back.end.model.User;
import com.elton.java.back.end.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
        .stream()
        .map(UserDTO::convert)
        .collect(Collectors.toList());
    }

    public UserDTO findById(Long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        if(usuario.isPresent()) {
            return UserDTO.convert(usuario.get());
        }
        return null;
    }

    public UserDTO save(UserDTO userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return userDTO.convert(user);
    }

    public UserDTO delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDTO findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDTO.convert(user);
        }
        return null;
    }

    public List<UserDTO> queryByName(String name) {
        List<User> usuarios = userRepository.findByNomeContainingIgnoreCase(name);
        System.out.println("Número de usuários encontrados: " + usuarios.size());
        return usuarios
                .stream()
                .map(DTOConverter::convert)
                .collect(Collectors.toList());
    }


}

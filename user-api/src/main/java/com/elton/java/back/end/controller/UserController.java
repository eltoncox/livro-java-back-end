package com.elton.java.back.end.controller;

import com.elton.java.back.end.converter.DTOConverter;
import com.elton.java.back.end.model.User;
import com.elton.java.back.end.service.UserService;
import com.elton.java.back.end.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;
@RestController

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        List<UserDTO> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("/user/{id}")
    UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }


    @PostMapping("/user")
    public ResponseEntity<UserDTO> newUser(@RequestBody UserDTO userDTO) {
        User user = User.convert(DTOConverter.convert(User.convert(userDTO)));
        user.setDataCadastro(LocalDateTime.now()); // Definindo o valor de data_cadastro
        User savedUser = User.convert(userService.save(UserDTO.convert(user)));
        return ResponseEntity.ok(DTOConverter.convert(savedUser));
    }
    @GetMapping("/user/cpf/{cpf}")
    UserDTO findByCpf(@PathVariable String cpf) {
        return  userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    UserDTO delete(@PathVariable Long id) {
       return userService.delete(id);
    }

    @GetMapping("/user/search")
    public List<UserDTO> queryByName(
            @RequestParam(name = "nome", required = true) String nome) {

        return userService.queryByName(nome.trim()); // Trim para evitar problemas com espaços
    }

}
package com.example.NutreAPP.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.services.UsuarioServicio;

@RequestMapping("/api/v1/usuarios")
@RestController
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio servicio;

    @PostMapping
    public ResponseEntity<Usuario> guardar(@RequestBody Usuario datos){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.servicio.guardar(datos));
    }

}

package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    //Para cocinar necesito las recetas
    //para programar los servicios necesito los repositorios
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private IUsuarioRepositorio repositorio;

     //Metodo para guardar un usuario
     public  Usuario guardar(Usuario datos){
        return this.repositorio.save(datos);
     }
   
    //metodo para buscar por id
    //metodo para buscar todos
    // metodo para modificar
    //metodo para eliminar

    //metodo para buscar por departamento yol
    //metodo para buscar por correo
    //metodo para buscar por rol
    //metodo para verificar correo



}

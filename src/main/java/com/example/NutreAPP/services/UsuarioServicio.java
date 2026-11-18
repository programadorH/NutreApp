package com.example.NutreAPP.services;

import com.example.NutreAPP.repositories.IVideoRepositorio;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;

@Service
public class UsuarioServicio {

    private final repositories.IVideoRepositorio IVideoRepositorio;
    //Para cocinar necesito las recetas
    //para programar los servicios necesito los repositorios
    //INYECCION DE DEPENDENCIAS
    @Autowired
    private IUsuarioRepositorio repositorio;

    UsuarioServicio(repositories.IVideoRepositorio IVideoRepositorio) {
        this.IVideoRepositorio = IVideoRepositorio;
    }

     //Metodo para guardar un usuario
     public  Usuario guardar(Usuario datos){
        return this.repositorio.save(datos);
     }
   
    //metodo para buscar por id
    public Usuario buscarPorId(UUID id){

        Optional<Usuario> usuarioBuscado =this.repositorio.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            return usuarioBuscado.get();
        }
    } 


    //metodo para buscar todos
    public List<Usuario> buscarTodos(){
        return this.repositorio.findAll();
    }


    // metodo para modificar
    public Usuario modificar(UUID id, Usuario datos){

         Optional<Usuario> usuarioBuscado =this.repositorio.findById(id);
        if(!usuarioBuscado.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"id no encontrado");
        }else{
            //1. PRECARGAR LA INFO QUE EXISTE EN LA B.D.
            Usuario usuarioEncontrado=usuarioBuscado.get();

            //2.ESPACIO PARA MODIFICAR SOLO LAS PROPIEDADES PERMITIDAS
            usuarioEncontrado.setNombre(datos.getNombre());
            usuarioEncontrado.setRol(datos.getRol());

            //3. ESPACIO PARA VOLVER A GUARDAR EL USUARIO QUE SE ACABA DE MODIFICAR
            this.repositorio.save(usuarioEncontrado);

        }


    }



    //metodo para eliminar

    //metodo para buscar por departamento yol
    //metodo para buscar por correo
    //metodo para buscar por rol
    //metodo para verificar correo



}

package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dominio.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}

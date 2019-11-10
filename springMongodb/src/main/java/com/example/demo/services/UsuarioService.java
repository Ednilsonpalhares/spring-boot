package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dominio.Usuario;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public List<Usuario> findAll(){
		return repo.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> usuario = repo.findById(id);
	
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Usuario insert(Usuario obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Usuario update(Usuario obj) {
		Usuario usuario = findById(obj.getId());
		updateData(usuario, obj);
		return repo.save(usuario);
	}
		
	private void updateData(Usuario usuario, Usuario obj) {
		usuario.setName(obj.getName());
		usuario.setEmail(obj.getEmail());
	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(),objDto.getName(),objDto.getEmail());
	} 
}

package br.com.senai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.senai.model.Usuario;

public interface UsuarioRespository extends JpaRepository<Usuario, Long>{
    public Usuario findByEmail(String email);
    
}

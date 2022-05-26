package br.com.senai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senai.exception.EmailException;
import br.com.senai.model.Usuario;
import br.com.senai.repository.UsuarioRespository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRespository usuarioRespository;

    @Autowired 
    BCryptPasswordEncoder passwordEncoder;

    public List<Usuario> listar(){
        return usuarioRespository.findAll();
    }

    public Usuario inserir(Usuario user){
        Usuario usuario = usuarioRespository.findByEmail(user.getEmail());
        if(usuario != null){
            throw new EmailException("Email já cadastrado!");
        }
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        return usuarioRespository.save(user);
    }
}

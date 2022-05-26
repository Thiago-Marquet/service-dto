package br.com.senai.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.senai.dto.UsuarioDTO;
import br.com.senai.dto.UsuarioInsertDTO;
import br.com.senai.exception.EmailException;
import br.com.senai.model.Usuario;
import br.com.senai.repository.UsuarioRespository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRespository usuarioRespository;

    @Autowired 
    BCryptPasswordEncoder passwordEncoder;

    public List<UsuarioDTO> listar(){
        List<Usuario> usuarios = usuarioRespository.findAll();
        return usuarios.stream().map(user -> new UsuarioDTO(user)).collect(Collectors.toList());
    }

    public UsuarioDTO inserir(UsuarioInsertDTO userInsertDTO){
        if(usuarioRespository.findByEmail(userInsertDTO.getEmail()) != null){
            throw new EmailException("Email já cadastrado!");
        }
        Usuario user = new Usuario();
        user.setNome(userInsertDTO.getNome());
        user.setEmail(userInsertDTO.getEmail());
        user.setSenha(passwordEncoder.encode(userInsertDTO.getSenha()));
        user = usuarioRespository.save(user);
        return new UsuarioDTO(user);
    }
}
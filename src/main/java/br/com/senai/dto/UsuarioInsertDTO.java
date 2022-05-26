package br.com.senai.dto;

import br.com.senai.model.Usuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioInsertDTO {

    private String nome;
    private String email;
    private String senha;
    
    public UsuarioInsertDTO(Usuario user) {
        this.nome = user.getNome();
        this.email = user.getEmail();
        this.senha = user.getSenha();
    } 
}

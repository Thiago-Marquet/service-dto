package br.com.senai.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfil {

    @EmbeddedId
    private UsuarioPerfilPK usuarioPerfilPK = new UsuarioPerfilPK();
    
    @Column(name = "data_criacao")
    @Getter @Setter
    private LocalDate dataCriacao;  

}

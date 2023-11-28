package com.biblioteca.services;

import com.biblioteca.entities.Professor;
import com.biblioteca.entities.Aluno;
import com.biblioteca.entities.Usuario;
import com.biblioteca.exceptions.UsuarioNaoEncontradoException;

import java.util.List;

public class AutenticacaoService {


    private List<Usuario> usuarios;

    public AutenticacaoService(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario autenticarUsuario(Integer id) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Aluno && ((Aluno) usuario).getMatricula() == id) {
                return usuario;
            } else if (usuario instanceof Professor && ((Professor) usuario).getCodigo() == id) {
                return usuario;
            }
        }

        throw new UsuarioNaoEncontradoException("Usuário não encontrado");
    }
}

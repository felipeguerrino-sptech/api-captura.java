package com.eyesonserver.dao.negocio;

import com.eyesonserver.database.Conexao;
import com.eyesonserver.mapper.negocio.UsuarioRowMapper;
import com.eyesonserver.model.negocio.Usuario;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.HashMap;
import java.util.List;

public class UsuarioDAO {
    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();

    public Usuario getUsuarioPorEmailSenha(String email, String senha) throws EmptyResultDataAccessException {
        Usuario usuario = db.query("SELECT * FROM Usuario WHERE email = ?", new UsuarioRowMapper(), email).get(0);
        String querySenha = db.queryForObject("SELECT senha FROM Login WHERE fk_usuario = ?",
                String.class, usuario.getId());

        if(email.equals(usuario.getEmail()) && senha.equals(querySenha)) {
            usuario.setSenha(senha);
            return usuario;
        }
        return null;
    }
}



package com.eyesonserver.dao.negocio;

import com.eyesonserver.database.Conexao;
import com.eyesonserver.mapper.negocio.UsuarioRowMapper;
import com.eyesonserver.model.negocio.Usuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UsuarioDAO {
    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();

    public Usuario getUsuarioPorEmailSenha(String email, String senha) {
        Usuario usuario = db.queryForObject("SELECT * FROM Usuario WHERE email = ?", new UsuarioRowMapper(), email);
        List<String> querySenha = db.query("SELECT senha FROM Login WHERE fk_usuario = ?",
                new BeanPropertyRowMapper<>(String.class), usuario.getId());

        if(email.equals(usuario.getEmail()) && senha.equals(querySenha.get(0))) {
            usuario.setSenha(senha);
            return usuario;
        }
        return null;
    }
}

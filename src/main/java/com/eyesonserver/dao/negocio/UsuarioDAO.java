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
        List<Usuario> queryUsuario = db.query("SELECT * FROM Usuario WHERE email = %s".formatted(email), new UsuarioRowMapper());
        List<String> querySenha = db.query("SELECT senha FROM Login WHERE fk_usuario = %d".formatted(queryUsuario.get(0).getId()),
                new BeanPropertyRowMapper<>(String.class));

        Usuario usuario = queryUsuario.get(0);
        if(email.equals(usuario.getEmail()) && senha.equals(querySenha.get(0))) {
            usuario.setSenha(senha);
            return usuario;
        }
        return null;
    }
}

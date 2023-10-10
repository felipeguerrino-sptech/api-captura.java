package com.eyesonserver.mapper.negocio;

import com.eyesonserver.model.negocio.Usuario;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRowMapper implements RowMapper<Usuario> {
    @Override
    public Usuario mapRow(ResultSet rs, int i) throws SQLException {
        return new Usuario(
          rs.getInt("id_usuario"),
                rs.getInt("fk_empresa"),
                rs.getString("nome"),
                rs.getString("email"),
                "",
                rs.getInt("cargo")
        );
    }
}

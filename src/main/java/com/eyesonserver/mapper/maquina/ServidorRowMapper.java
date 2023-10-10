package com.eyesonserver.mapper.maquina;

import com.eyesonserver.model.maquina.Servidor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServidorRowMapper implements RowMapper<Servidor> {
    @Override
    public Servidor mapRow(ResultSet rs, int i) throws SQLException {
        return null;
    }
}

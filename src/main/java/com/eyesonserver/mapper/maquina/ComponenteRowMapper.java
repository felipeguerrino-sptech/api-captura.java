package com.eyesonserver.mapper.maquina;

import com.eyesonserver.model.maquina.Componente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComponenteRowMapper implements RowMapper<Componente> {
    @Override
    public Componente mapRow(ResultSet rs, int i) throws SQLException {
        Componente componente = new Componente(rs.getInt("id_componente"), rs.getString("nome_componente"));
        return componente;
    }
}

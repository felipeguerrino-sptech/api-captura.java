package com.eyesonserver.mapper.metrica;

import com.eyesonserver.model.metrica.Medida;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MedidaRowMapper implements RowMapper<Medida> {

    @Override
    public Medida mapRow(ResultSet rs, int i) throws SQLException {
        Medida medida = new Medida(rs.getInt("id_medida"), rs.getString("nome_medida"), rs.getString("simbolo_medida"));
        return medida;
    }
}

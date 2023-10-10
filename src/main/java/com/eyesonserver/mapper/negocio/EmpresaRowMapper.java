package com.eyesonserver.mapper.negocio;

import com.eyesonserver.model.negocio.Empresa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpresaRowMapper implements RowMapper<Empresa> {

    @Override
    public Empresa mapRow(ResultSet rs, int i) throws SQLException {
        Empresa empresa = new Empresa(
                rs.getInt("id_empresa"),
                rs.getString("nomeFantasia"),
                rs.getString("cnpj"),
                rs.getString("email"),
                rs.getString("cep")
        );
        return empresa;
    }
}

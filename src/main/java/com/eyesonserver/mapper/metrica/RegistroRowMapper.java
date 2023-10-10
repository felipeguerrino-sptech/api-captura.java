package com.eyesonserver.mapper.metrica;

import com.eyesonserver.dao.metrica.MedidaDAO;
import com.eyesonserver.model.maquina.Componente;
import com.eyesonserver.model.metrica.Medida;
import com.eyesonserver.model.metrica.Registro;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class RegistroRowMapper implements RowMapper<Registro> {
    @Override
    public Registro mapRow(ResultSet rs, int i) throws SQLException {
        MedidaDAO medidaDAO = new MedidaDAO();
        Medida medida = medidaDAO.getMedidaPorId(rs.getInt("fk_medida"));

        LocalDateTime momento = LocalDateTime.parse( rs.getString("momento_registro"));

        Registro registro = new Registro(rs.getInt("id_registro"),
                medida,
                rs.getString("simbolo_registro"),
                rs.getString("valor_registro"),
                momento
               );
        return registro;
    }
}

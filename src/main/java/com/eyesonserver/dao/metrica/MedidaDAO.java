package com.eyesonserver.dao.metrica;

import com.eyesonserver.database.Conexao;
import com.eyesonserver.mapper.metrica.MedidaRowMapper;
import com.eyesonserver.model.metrica.Medida;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MedidaDAO {
    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();

    public Medida getMedidaPorId(Integer id) {
        List<Medida> query = db.query("SELECT * FROM Medida WHERE id_medida = %d".formatted(id), new MedidaRowMapper())
        return query.get(0);
    }
}

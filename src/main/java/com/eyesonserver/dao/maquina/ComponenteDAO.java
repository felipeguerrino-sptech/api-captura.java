package com.eyesonserver.dao.maquina;

import com.eyesonserver.database.Conexao;
import com.eyesonserver.mapper.maquina.ComponenteRowMapper;
import com.eyesonserver.model.maquina.Componente;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ComponenteDAO {

    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();

    public Componente getComponentePorId(Integer id) {
         return db.queryForObject("SELECT * FROM Componente WHERE id_componente = ?", new ComponenteRowMapper(), id);

    }
}

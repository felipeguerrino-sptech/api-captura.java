package com.eyesonserver.dao.negocio;

import com.eyesonserver.database.Conexao;
import com.eyesonserver.mapper.negocio.EmpresaRowMapper;
import com.eyesonserver.model.negocio.Empresa;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpresaDAO {
    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();

    public Empresa getEmpresaPorId(Integer id) {
        return db.queryForObject("SELECT * FROM Empresa WHERE id_empresa = ?", new EmpresaRowMapper(), id);
    }
}

package com.eyesonserver.dao.metrica;

import com.eyesonserver.database.Conexao;
import com.eyesonserver.model.metrica.Registro;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RegistroDAO {
    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();

    public void insertRegistro(Registro registro) {
        db.update("INSERT INTO Registro VALUES (?, ?, ?, ?, ?, ?)",
                0,
                registro.getFkComponente(),
                registro.getFkMedida(),
                registro.getFkServidor(),
                registro.getValor(),
                registro.getMomento()
                );
    }
}

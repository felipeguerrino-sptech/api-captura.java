package com.eyesonserver.dao.maquina;

import com.eyesonserver.dao.metrica.RegistroDAO;
import com.eyesonserver.database.Conexao;
import com.eyesonserver.mapper.maquina.ServidorRowMapper;
import com.eyesonserver.model.maquina.Servidor;
import com.eyesonserver.model.metrica.Registro;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServidorDAO {
    private Conexao conexao = new Conexao();
    private JdbcTemplate db = conexao.getConexaoDoBanco();

    public Servidor getServidorPorMacAddress(String macAddress) {
        RegistroDAO registroDAO = new RegistroDAO();

        return db.queryForObject("SELECT * FROM Servidor WHERE mac_address = ?", new ServidorRowMapper(), macAddress);

    }

    public void insertServidor(Servidor servidor, Integer fkEmpresa) {
        String descricao = "Esse servidor foi registrado automaticamente.";
        String componentes = "0";

        db.update("INSERT INTO Servidor VALUES (?, ?, ?, ?, ?, ?, ?)",
                servidor.getId(),
                fkEmpresa,
                servidor.getNome(),
                servidor.getLocal(),
                servidor.getIpv6(),
                servidor.getMacAdress(),
                servidor.getSo(),
                descricao,
                componentes
        );
    }
}

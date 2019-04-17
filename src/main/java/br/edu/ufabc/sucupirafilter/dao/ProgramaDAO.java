package br.edu.ufabc.sucupirafilter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ufabc.sucupirafilter.config.ConnectionFactory;
import br.edu.ufabc.sucupirafilter.model.Programa;

public class ProgramaDAO {

    private Connection connection;

    public ProgramaDAO()
        throws ClassNotFoundException, SQLException {

        this.connection = new ConnectionFactory().getConnection();

    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void insert(Programa obj) throws SQLException {

        String sql = "insert into area_avaliacao(nome, codigo, uf, area_conhecimento_id, instituicao_id)"
                        + " values(?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.setString(3, obj.getUf());
        stmt.setLong(4, obj.getAreaConhecimentoId());
        stmt.setLong(5, obj.getInstituicaoId());
        stmt.execute();
        stmt.close();

    }

    public void delete(Long id) throws SQLException {

        String sql = "delete from programa where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

    }

    public void update(Programa obj) throws SQLException {

        String sql = "update programa set nome = ?, codigo = ?, uf = ?, area_conhecimento_id = ?,"
                        + " instituicao_id = ? where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.setString(3, obj.getUf());
        stmt.setLong(4, obj.getAreaConhecimentoId());
        stmt.setLong(5, obj.getInstituicaoId());
        stmt.setLong(6, obj.getId());
        stmt.execute();
        stmt.close();

    }

    public Programa find(Long id) throws SQLException {

        Programa obj = null;

        String sql = "select * from programa where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            obj = new Programa();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            obj.setUf(rs.getString("uf"));
            obj.setAreaConhecimentoId(rs.getLong("area_conhecimento_id"));
            obj.setInstituicaoId(rs.getLong("instituicao_id"));
            break;
        }

        rs.close();
        stmt.close();

        return obj;

    }

    public List<Programa> findAll() throws SQLException {

        List<Programa> objList = new ArrayList<Programa>();

        String sql = "select * from programa";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Programa obj = new Programa();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            obj.setUf(rs.getString("uf"));
            obj.setAreaConhecimentoId(rs.getLong("area_conhecimento_id"));
            obj.setInstituicaoId(rs.getLong("instituicao_id"));
            objList.add(obj);
        }

        rs.close();
        stmt.close();

        return objList;

    }

}


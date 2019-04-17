package br.edu.ufabc.sucupirafilter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ufabc.sucupirafilter.config.ConnectionFactory;
import br.edu.ufabc.sucupirafilter.model.AreaConhecimento;

public class AreaConhecimentoDAO {

    private Connection connection;

    public AreaConhecimentoDAO()
        throws ClassNotFoundException, SQLException {

        this.connection = new ConnectionFactory().getConnection();

    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void insert(AreaConhecimento obj) throws SQLException {

        String sql = "insert into area_conhecimento(nome, codigo, area_avaliacao_id) values(?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.setLong(3, obj.getAreaAvaliacaoId());
        stmt.execute();
        stmt.close();

    }

    public void delete(Long id) throws SQLException {

        String sql = "delete from area_conhecimento where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

    }

    public void update(AreaConhecimento obj) throws SQLException {

        String sql = "update area_conhecimento set nome = ?, codigo = ?,"
                        + " area_avaliacao_id = ? where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.setLong(3, obj.getAreaAvaliacaoId());
        stmt.setLong(4, obj.getId());
        stmt.execute();
        stmt.close();

    }

    public AreaConhecimento find(Long id) throws SQLException {

        AreaConhecimento obj = null;

        String sql = "select * from area_conhecimento where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            obj = new AreaConhecimento();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            obj.setAreaAvaliacaoId(rs.getLong("area_avaliacao_id"));
            break;
        }

        rs.close();
        stmt.close();

        return obj;

    }

    public List<AreaConhecimento> findAll() throws SQLException {

        List<AreaConhecimento> objList = new ArrayList<AreaConhecimento>();

        String sql = "select * from area_conhecimento";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            AreaConhecimento obj = new AreaConhecimento();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            obj.setAreaAvaliacaoId(rs.getLong("area_avaliacao_id"));
            objList.add(obj);
        }

        rs.close();
        stmt.close();

        return objList;

    }

}


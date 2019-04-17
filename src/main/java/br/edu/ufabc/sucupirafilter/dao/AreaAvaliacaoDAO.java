package br.edu.ufabc.sucupirafilter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ufabc.sucupirafilter.config.ConnectionFactory;
import br.edu.ufabc.sucupirafilter.model.AreaAvaliacao;

public class AreaAvaliacaoDAO {

    private Connection connection;

    public AreaAvaliacaoDAO()
        throws ClassNotFoundException, SQLException {

        this.connection = new ConnectionFactory().getConnection();

    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void insert(AreaAvaliacao obj) throws SQLException {

        String sql = "insert into area_avaliacao(nome, codigo) values(?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.execute();
        stmt.close();

    }

    public void delete(Long id) throws SQLException {

        String sql = "delete from area_avaliacao where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

    }

    public void update(AreaAvaliacao obj) throws SQLException {

        String sql = "update area_avaliacao set nome = ?, codigo = ? where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.setLong(3, obj.getId());
        stmt.execute();
        stmt.close();

    }

    public AreaAvaliacao find(Long id) throws SQLException {

        AreaAvaliacao obj = null;

        String sql = "select * from area_avaliacao where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            obj = new AreaAvaliacao();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            break;
        }

        rs.close();
        stmt.close();

        return obj;

    }

    public List<AreaAvaliacao> findAll() throws SQLException {

        List<AreaAvaliacao> objList = new ArrayList<AreaAvaliacao>();

        String sql = "select * from area_avaliacao";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            AreaAvaliacao obj = new AreaAvaliacao();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            objList.add(obj);
        }

        rs.close();
        stmt.close();

        return objList;

    }

}


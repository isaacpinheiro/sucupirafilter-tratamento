package br.edu.ufabc.sucupirafilter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ufabc.sucupirafilter.config.ConnectionFactory;
import br.edu.ufabc.sucupirafilter.model.Instituicao;

public class InstituicaoDAO {

    private Connection connection;

    public InstituicaoDAO()
        throws ClassNotFoundException, SQLException {

        this.connection = new ConnectionFactory().getConnection();

    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void insert(Instituicao obj) throws SQLException {

        String sql = "insert into instituicao(nome, codigo, acronimo, endereco, distrito,"
                        + " cidade, estado, tipo, cep, caixa_postal, url, coordenandas)"
                        + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.setString(3, obj.getAcronimo());
        stmt.setString(4, obj.getEndereco());
        stmt.setString(5, obj.getDistrito());
        stmt.setString(6, obj.getCidade());
        stmt.setString(7, obj.getEstado());
        stmt.setString(8, obj.getTipo());
        stmt.setString(9, obj.getCep());
        stmt.setString(10, obj.getCaixaPostal());
        stmt.setString(11, obj.getUrl());
        stmt.setString(12, obj.getCoordenadas());
        stmt.execute();
        stmt.close();

    }

    public void delete(Long id) throws SQLException {

        String sql = "delete from instituicao where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

    }

    public void update(Instituicao obj) throws SQLException {

        String sql = "update instituicao set nome = ?, codigo = ?, acronimo = ?, endereco = ?,"
                        + " distrito = ?, cidade = ?, estado = ?, tipo = ?, cep = ?,"
                        + "caixa_postal = ?, url = ?, coordenandas = ? where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCodigo());
        stmt.setString(3, obj.getAcronimo());
        stmt.setString(4, obj.getEndereco());
        stmt.setString(5, obj.getDistrito());
        stmt.setString(6, obj.getCidade());
        stmt.setString(7, obj.getEstado());
        stmt.setString(8, obj.getTipo());
        stmt.setString(9, obj.getCep());
        stmt.setString(10, obj.getCaixaPostal());
        stmt.setString(11, obj.getUrl());
        stmt.setString(12, obj.getCoordenadas());
        stmt.setLong(13, obj.getId());
        stmt.execute();
        stmt.close();

    }

    public Instituicao find(Long id) throws SQLException {

        Instituicao obj = null;

        String sql = "select * from instituicao where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            obj = new Instituicao();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            obj.setAcronimo(rs.getString("acronimo"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setDistrito(rs.getString("distrito"));
            obj.setCidade(rs.getString("cidade"));
            obj.setEstado(rs.getString("estado"));
            obj.setTipo(rs.getString("tipo"));
            obj.setCep(rs.getString("cep"));
            obj.setCaixaPostal(rs.getString("caixa_postal"));
            obj.setUrl(rs.getString("url"));
            obj.setCoordenadas(rs.getString("coordenandas"));
            break;
        }

        rs.close();
        stmt.close();

        return obj;

    }

    public List<Instituicao> findAll() throws SQLException {

        List<Instituicao> objList = new ArrayList<Instituicao>();

        String sql = "select * from instituicao";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Instituicao obj = new Instituicao();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setCodigo(rs.getString("codigo"));
            obj.setAcronimo(rs.getString("acronimo"));
            obj.setEndereco(rs.getString("endereco"));
            obj.setDistrito(rs.getString("distrito"));
            obj.setCidade(rs.getString("cidade"));
            obj.setEstado(rs.getString("estado"));
            obj.setTipo(rs.getString("tipo"));
            obj.setCep(rs.getString("cep"));
            obj.setCaixaPostal(rs.getString("caixa_postal"));
            obj.setUrl(rs.getString("url"));
            obj.setCoordenadas(rs.getString("coordenandas"));
            objList.add(obj);
        }

        rs.close();
        stmt.close();

        return objList;

    }

}


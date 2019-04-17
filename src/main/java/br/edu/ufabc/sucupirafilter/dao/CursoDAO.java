package br.edu.ufabc.sucupirafilter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import br.edu.ufabc.sucupirafilter.config.ConnectionFactory;
import br.edu.ufabc.sucupirafilter.model.Curso;

public class CursoDAO {

    private Connection connection;

    public CursoDAO()
        throws ClassNotFoundException, SQLException {

        this.connection = new ConnectionFactory().getConnection();

    }

    public void close() throws SQLException {
        this.connection.close();
    }

    public void insert(Curso obj) throws SQLException {

        String sql = "insert into curso(nome, situacao, nivel, nota_curso, data_recomendacao, data_inicio,"
                        + " programa_id) values(?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getSituacao());
        stmt.setString(3, obj.getNivel());
        stmt.setString(4, obj.getNotaCurso());
        stmt.setString(5, obj.getDataRecomendacao());
        stmt.setString(6, obj.getDataInicio());
        stmt.setLong(7, obj.getProgramaId());
        stmt.execute();
        stmt.close();

    }

    public void delete(Long id) throws SQLException {

        String sql = "delete from curso where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        stmt.execute();
        stmt.close();

    }

    public void update(Curso obj) throws SQLException {

        String sql = "update curso set nome = ?, situacao = ?, nivel = ?, nota_curso = ?, data_recomendacao = ?,"
                        + " data_inicio = ?, programa_id = ? where id = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getSituacao());
        stmt.setString(3, obj.getNivel());
        stmt.setString(4, obj.getNotaCurso());
        stmt.setString(5, obj.getDataRecomendacao());
        stmt.setString(6, obj.getDataInicio());
        stmt.setLong(7, obj.getProgramaId());
        stmt.setLong(8, obj.getId());
        stmt.execute();
        stmt.close();

    }

    public Curso find(Long id) throws SQLException {

        Curso obj = null;

        String sql = "select * from curso where id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            obj = new Curso();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setSituacao(rs.getString("situacao"));
            obj.setNivel(rs.getString("nivel"));
            obj.setNotaCurso(rs.getString("nota_curso"));
            obj.setDataRecomendacao(rs.getString("data_recomendacao"));
            obj.setDataInicio(rs.getString("data_inicio"));
            obj.setProgramaId(rs.getLong("programa_id"));
            break;
        }

        rs.close();
        stmt.close();

        return obj;

    }

    public List<Curso> findAll() throws SQLException {

        List<Curso> objList = new ArrayList<Curso>();

        String sql = "select * from curso";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Curso obj = new Curso();
            obj.setId(rs.getLong("id"));
            obj.setNome(rs.getString("nome"));
            obj.setSituacao(rs.getString("situacao"));
            obj.setNivel(rs.getString("nivel"));
            obj.setNotaCurso(rs.getString("nota_curso"));
            obj.setDataRecomendacao(rs.getString("data_recomendacao"));
            obj.setDataInicio(rs.getString("data_inicio"));
            obj.setProgramaId(rs.getLong("programa_id"));
            objList.add(obj);
        }

        rs.close();
        stmt.close();

        return objList;

    }

}


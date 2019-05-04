package br.edu.ufabc.sucupirafilter;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.sql.SQLException;
import java.util.List;

import br.edu.ufabc.sucupirafilter.model.AreaAvaliacao;
import br.edu.ufabc.sucupirafilter.model.AreaConhecimento;
import br.edu.ufabc.sucupirafilter.model.Instituicao;
import br.edu.ufabc.sucupirafilter.model.Programa;
import br.edu.ufabc.sucupirafilter.model.Curso;

import br.edu.ufabc.sucupirafilter.dao.AreaAvaliacaoDAO;
import br.edu.ufabc.sucupirafilter.dao.AreaConhecimentoDAO;
import br.edu.ufabc.sucupirafilter.dao.InstituicaoDAO;
import br.edu.ufabc.sucupirafilter.dao.ProgramaDAO;
import br.edu.ufabc.sucupirafilter.dao.CursoDAO;

public class App {

    public static String tratamento(String text) {

        Matcher matcher;

        Pattern p1 = Pattern.compile("&Ccedil;");
        matcher = p1.matcher(text);
        text = matcher.replaceAll("Ç");

        Pattern p2 = Pattern.compile("&Atilde;");
        matcher = p2.matcher(text);
        text = matcher.replaceAll("Ã");

        Pattern p3 = Pattern.compile("&Uacute;");
        matcher = p3.matcher(text);
        text = matcher.replaceAll("Ú");

        Pattern p4 = Pattern.compile("&Ecirc;");
        matcher = p4.matcher(text);
        text = matcher.replaceAll("Ê");

        Pattern p5 = Pattern.compile("&Aacute;");
        matcher = p5.matcher(text);
        text = matcher.replaceAll("Á");

        Pattern p6 = Pattern.compile("&Iacute;");
        matcher = p6.matcher(text);
        text = matcher.replaceAll("Í");

        Pattern p7 = Pattern.compile("&Otilde;");
        matcher = p7.matcher(text);
        text = matcher.replaceAll("Õ");

        Pattern p8 = Pattern.compile("&Oacute;");
        matcher = p8.matcher(text);
        text = matcher.replaceAll("Ó");

        Pattern p9 = Pattern.compile("&Acirc;");
        matcher = p9.matcher(text);
        text = matcher.replaceAll("Â");

        Pattern p10 = Pattern.compile("&Eacute;");
        matcher = p10.matcher(text);
        text = matcher.replaceAll("É");

        Pattern p11 = Pattern.compile("&Uuml;");
        matcher = p11.matcher(text);
        text = matcher.replaceAll("Ü");

        Pattern p12 = Pattern.compile("&acirc;");
        matcher = p12.matcher(text);
        text = matcher.replaceAll("â");

        Pattern p13 = Pattern.compile("&atilde;");
        matcher = p13.matcher(text);
        text = matcher.replaceAll("ã");

        Pattern p14 = Pattern.compile("&iacute;");
        matcher = p14.matcher(text);
        text = matcher.replaceAll("í");

        Pattern p15 = Pattern.compile("&oacute;");
        matcher = p15.matcher(text);
        text = matcher.replaceAll("ó");

        Pattern p16 = Pattern.compile("&acute;");
        matcher = p16.matcher(text);
        text = matcher.replaceAll("´");

        Pattern p17 = Pattern.compile("&eacute;");
        matcher = p17.matcher(text);
        text = matcher.replaceAll("é");

        Pattern p18 = Pattern.compile("&aacute;");
        matcher = p18.matcher(text);
        text = matcher.replaceAll("á");

        Pattern p19 = Pattern.compile("&ccedil;");
        matcher = p19.matcher(text);
        text = matcher.replaceAll("ç");

        Pattern p20 = Pattern.compile("&uacute;");
        matcher = p20.matcher(text);
        text = matcher.replaceAll("ú");

        Pattern p21 = Pattern.compile("&ecirc;");
        matcher = p21.matcher(text);
        text = matcher.replaceAll("ê");

        Pattern p22 = Pattern.compile("&ocirc;");
        matcher = p22.matcher(text);
        text = matcher.replaceAll("ô");

        Pattern p23 = Pattern.compile("&otilde;");
        matcher = p23.matcher(text);
        text = matcher.replaceAll("õ");

        Pattern p24 = Pattern.compile("&Agrave;");
        matcher = p24.matcher(text);
        text = matcher.replaceAll("À");

        Pattern p25 = Pattern.compile("&#8211;");
        matcher = p25.matcher(text);
        text = matcher.replaceAll("-");

        Pattern p26 = Pattern.compile("&amp;");
        matcher = p26.matcher(text);
        text = matcher.replaceAll("&");

        Pattern p27 = Pattern.compile("&quot;");
        matcher = p27.matcher(text);
        text = matcher.replaceAll("\"");

        Pattern p28 = Pattern.compile("&deg;");
        matcher = p28.matcher(text);
        text = matcher.replaceAll("°");

        Pattern p29 = Pattern.compile("&ordm;");
        matcher = p29.matcher(text);
        text = matcher.replaceAll("º");
        
        Pattern p30 = Pattern.compile("&Ocirc;");
        matcher = p30.matcher(text);
        text = matcher.replaceAll("Ô");
        
        Pattern p31 = Pattern.compile("&agrave;");
        matcher = p31.matcher(text);
        text = matcher.replaceAll("à");

        return text;

    }
    
    public static void main( String[] args )
        throws ClassNotFoundException, SQLException {

        System.out.println("Sucupira Filter - Tratamento de Dados");
        
        AreaAvaliacaoDAO aaDAO = new AreaAvaliacaoDAO();
        AreaConhecimentoDAO acDAO = new AreaConhecimentoDAO();
        InstituicaoDAO iDAO = new InstituicaoDAO();
        ProgramaDAO pDAO = new ProgramaDAO();
        CursoDAO cDAO = new CursoDAO();
        
        List<AreaAvaliacao> aaList = aaDAO.findAll();
        List<AreaConhecimento> acList = acDAO.findAll();
        List<Instituicao> iList = iDAO.findAll();
        List<Programa> pList = pDAO.findAll();
        List<Curso> cList = cDAO.findAll();
        
        for (AreaAvaliacao aa : aaList) {
            aa.setNome(tratamento(aa.getNome()));
            aaDAO.update(aa);
        }
        
        for (AreaConhecimento ac : acList) {
            ac.setNome(tratamento(ac.getNome()));
            acDAO.update(ac);
        }
        
        for (Instituicao i : iList) {
            
            i.setNome(tratamento(i.getNome()));
            i.setAcronimo(tratamento(i.getAcronimo()));
            
            if (i.getEndereco() != null)
                i.setEndereco(tratamento(i.getEndereco()));
            
            if (i.getCidade() != null)
                i.setCidade(tratamento(i.getCidade()));
            
            if (i.getEstado() != null)
                i.setEstado(tratamento(i.getEstado()));
            
            iDAO.update(i);
        }
        
        for (Programa p : pList) {
            p.setNome(tratamento(p.getNome()));
            pDAO.update(p);
        }
        
        for (Curso c : cList) {
            c.setNome(tratamento(c.getNome()));
            cDAO.update(c);
        }
        
        System.out.println("Concluido.");

    }

}


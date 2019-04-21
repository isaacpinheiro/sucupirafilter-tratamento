package br.edu.ufabc.sucupirafilter;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

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

        return text;

    }
    
    public static void main( String[] args ) {

        System.out.println("Sucupira Filter - Tratamento de Dados");

    }

}


package br.edu.ufabc.sucupirafilter.model;

public class AreaAvaliacao {

    private Long id;
    private String nome;
    private String codigo;

    public AreaAvaliacao() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

}


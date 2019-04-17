package br.edu.ufabc.sucupirafilter.model;

public class Curso {

    private Long id;
    private String nome;
    private String situacao;
    private String nivel;
    private String notaCurso;
    private String dataRecomendacao;
    private String dataInicio;
    private Long programaId;

    public Curso() {

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

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() {
        return this.nivel;
    }

    public void setNotaCurso(String notaCurso) {
        this.notaCurso = notaCurso;
    }

    public String getNotaCurso() {
        return this.notaCurso;
    }

    public void setDataRecomendacao(String dataRecomendacao) {
        this.dataRecomendacao = dataRecomendacao;
    }

    public String getDataRecomendacao() {
        return this.dataRecomendacao;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataInicio() {
        return this.dataInicio;
    }

    public void setProgramaId(Long programaId) {
        this.programaId = programaId;
    }

    public Long getProgramaId() {
        return this.programaId;
    }

}


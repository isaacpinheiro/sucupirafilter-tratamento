package br.edu.ufabc.sucupirafilter.model;

public class Programa {

    private Long id;
    private String nome;
    private String codigo;
    private String uf;
    private Long areaConhecimentoId;
    private Long instituicaoId;

    public Programa() {

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

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getUf() {
        return this.uf;
    }

    public void setAreaConhecimentoId(Long areaConhecimentoId) {
        this.areaConhecimentoId = areaConhecimentoId;
    }

    public Long getAreaConhecimentoId() {
        return this.areaConhecimentoId;
    }

    public void setInstituicaoId(Long instituicaoId) {
        this.instituicaoId = instituicaoId;
    }

    public Long getInstituicaoId() {
        return this.instituicaoId;
    }

}


package model;

public class Curso {
    private int codigo;
    private String nome;
    private String tipo;
    private int vagas;
    private int duracao;
    private String supervisor;
    private Double mensalidade;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public int getDuracao(int duracao) {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Double mensalidade) {
        this.mensalidade = mensalidade;
    }

    public Modalidade getEnsino() {
        return ensino;
    }

    public void setEnsino(Modalidade ensino) {
        this.ensino = ensino;
    }

    private Modalidade ensino;
   
      
    public Modalidade getStatus() {
        return ensino;
    }

    public void setStatus(Modalidade status) {
        
        this.status = status;
        
    }
    
    public enum Modalidade {
        EAD("Ensino a Distancia"), PRESENCIAL("Presencial"), HIBRIDO("Hibrido");

        private Modalidade(String label) {
            this.label = label;
        }

        public String label;

        @SuppressWarnings("unused")
        public String getLabel() {
            return label;
        }
    }

}

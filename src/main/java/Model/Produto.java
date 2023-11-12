package Model;

public abstract class Produto {
    private int id;
    private String descricao;
    private String marca;
    private double valor;

    public Produto(int id, String descricao, String marca, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.marca = marca;
        this.valor = valor;
    }
    
    public Produto() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
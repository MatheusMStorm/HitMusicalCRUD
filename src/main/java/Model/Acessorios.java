package Model;

public class Acessorios extends Produto {
    private String categoria;

    public Acessorios(int id, String descricao, String marca, double valor, String categoria) {
        super(id, descricao, marca, valor);
        this.categoria = categoria;
    }
    
    public Acessorios() {
        
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
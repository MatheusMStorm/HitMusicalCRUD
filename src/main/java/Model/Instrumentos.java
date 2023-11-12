package Model;

public class Instrumentos extends Produto {
    private String categoria;
    
    public Instrumentos(int id, String descricao, String marca, double valor, String categoria) {
        super(id, descricao, marca, valor);
        this.categoria = categoria;
    }
    
    public Instrumentos() {
        
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}

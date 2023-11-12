package Model;

public class Microfones extends Produto {
    private String formato;
    private String tipo;
    private String frequenciaMin;
    private String padraoPolar;

    public Microfones(int id, String descricao, String marca, double valor, String formato, String tipo, String frequenciaMin, String padraoPolar) {
        super(id, descricao, marca, valor);
        this.formato = formato;
        this.tipo = tipo;
        this.frequenciaMin = frequenciaMin;
        this.padraoPolar = padraoPolar;

    }
    
    public Microfones() {
        
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFrequenciaMin() {
        return frequenciaMin;
    }

    public void setFrequenciaMin(String frequenciaMin) {
        this.frequenciaMin = frequenciaMin;
    }

    public String getPadraoPolar() {
        return padraoPolar;
    }

    public void setPadraoPolar(String padraoPolar) {
        this.padraoPolar = padraoPolar;
    }

}
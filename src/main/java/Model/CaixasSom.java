package Model;

public class CaixasSom extends Produto{
   private int potenciaSaida;
   private String tipoAltoFalante;
   private int qtdAltoFalantes;
   private String configCanais;

    public CaixasSom(int id, String descricao, String marca, double valor, int potenciaSaida, String tipoAltoFalante, int qtdAltoFalantes, String configCanais) {
        super(id, descricao, marca, valor);
        this.potenciaSaida = potenciaSaida;
        this.tipoAltoFalante = tipoAltoFalante;
        this.qtdAltoFalantes = qtdAltoFalantes;
        this.configCanais = configCanais;
    }
    
    public CaixasSom() {
        
    }

    public int getPotenciaSaida() {
        return potenciaSaida;
    }

    public void setPotenciaSaida(int potenciaSaida) {
        this.potenciaSaida = potenciaSaida;
    }

    public String getTipoAltoFalante() {
        return tipoAltoFalante;
    }

    public void setTipoAltoFalante(String tipoAltoFalante) {
        this.tipoAltoFalante = tipoAltoFalante;
    }

    public int getQtdAltoFalantes() {
        return qtdAltoFalantes;
    }

    public void setQtdAltoFalantes(int qtdAltoFalantes) {
        this.qtdAltoFalantes = qtdAltoFalantes;
    }

    public String getConfigCanais() {
        return configCanais;
    }

    public void setConfigCanais(String configCanais) {
        this.configCanais = configCanais;
    }
}
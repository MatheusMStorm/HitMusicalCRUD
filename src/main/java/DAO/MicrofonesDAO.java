package DAO;

import Control.Conexao;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MicrofonesDAO {
    
    public void inserir(Microfones microfone) {
        String inserir = "INSERT INTO Microfones (descricaoMicrofone, marcaMicrofone, "
                + "valorMicrofone, formato, tipo, frequenciaMin, padraoPolar) "
                + "VALUES ('" 
                + microfone.getDescricao() + "', '" + microfone.getMarca() + "', " +
                microfone.getValor() + ", '" + microfone.getFormato() + "', '" +
                microfone.getTipo() + "', '" + microfone.getFrequenciaMin() +
                "', '" + microfone.getPadraoPolar() + "')";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(inserir);
    }
    
    public Microfones consultar(String descricao) {
        Conexao conexao = new Conexao();
        Microfones microfone = null;
        
        try {
            String consulta = "SELECT * FROM Microfones WHERE descricaoMicrofone like '%" 
                    + descricao + "%'";
            ResultSet rs = conexao.executarConsulta(consulta);
            
            if (rs.next()) {
                microfone = new Microfones(0, null, null, 0.0, null, null, null, null);
                microfone.setId(rs.getInt("idMicrofone"));
                microfone.setDescricao(rs.getString("descricaoMicrofone"));
                microfone.setMarca(rs.getString("marcaMicrofone"));
                microfone.setValor(rs.getDouble("valorMicrofone"));
                microfone.setFormato(rs.getString("formato"));
                microfone.setTipo(rs.getString("tipo"));
                microfone.setFrequenciaMin(rs.getString("frequenciaMin"));
                microfone.setPadraoPolar(rs.getString("padraoPolar"));
            }
        }
        catch (SQLException ex) {
            System.out.println("Não conseguiu acessar os dados do produto.");
        }
        finally {
            conexao.desconectar();
        }
        
        return microfone;
    }
    
    // Alteração e exclusão são feitas por id, portanto recomendamos que seja feita a consulta prévia
    public void alterar(Microfones microfone) {
        String update = "UPDATE Microfones SET descricaoMicrofone = '" +
                microfone.getDescricao() + "', marcaMicrofone = '" +
                microfone.getMarca() + "', valorMicrofone = " +
                microfone.getValor() + ", formato = '" +
                microfone.getFormato() + "', tipo = '" +
                microfone.getTipo() + "', frequenciaMin = '" +
                microfone.getFrequenciaMin() + "', padraoPolar = '" + 
                microfone.getPadraoPolar() + "' WHERE idMicrofone = " +
                microfone.getId();
        
        Conexao conexao = new Conexao();
        conexao.executarDML(update);
    }
    
    public void excluir(Microfones microfone) {
        String delete = "DELETE FROM Microfones WHERE descricaoMicrofone LIKE '%" + microfone.getDescricao() + "%'";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(delete);
    }
}
package DAO;

import Control.Conexao;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstrumentosDAO {
    
    public void inserir(Instrumentos instrumento) {
        String inserir = "INSERT INTO Instrumentos (descricaoInstrumento, marcaInstrumento, valorInstrumento, categoria) "
                + "VALUES ('" 
                + instrumento.getDescricao() + "', '" + instrumento.getMarca() + "', " +
                instrumento.getValor() + ", '" + instrumento.getCategoria() + "')";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(inserir);
    }
    
    public Instrumentos consultar(String descricao) {
        Conexao conexao = new Conexao();
        Instrumentos instrumento = null;
        
        try {
            String consulta = "SELECT * FROM Instrumentos WHERE descricaoInstrumento like '%" 
                    + descricao + "%'";
            ResultSet rs = conexao.executarConsulta(consulta);
            
            if (rs.next()) {
                instrumento = new Instrumentos(0, null, null, 0.0, null);
                instrumento.setId(rs.getInt("idInstrumento"));
                instrumento.setDescricao(rs.getString("descricaoInstrumento"));
                instrumento.setMarca(rs.getString("marcaInstrumento"));
                instrumento.setValor(rs.getDouble("valorInstrumento"));
                instrumento.setCategoria(rs.getString("categoria"));
            }
        }
        catch (SQLException ex) {
            System.out.println("Não conseguiu acessar os dados do produto.");
        }
        finally {
            conexao.desconectar();
        }
        
        return instrumento;
    }
    
    // Alteração e exclusão são feitas por id, portanto recomendamos que seja feita a consulta prévia
    public void alterar(Instrumentos instrumento) {
        String update = "UPDATE Instrumentos SET descricaoInstrumento = '" +
                instrumento.getDescricao() + "', marcaInstrumento = '" +
                instrumento.getMarca() + "', valorInstrumento = " +
                instrumento.getValor() + ", categoria = '" +
                instrumento.getCategoria() + "' WHERE idInstrumento = " +
                instrumento.getId();
        
        Conexao conexao = new Conexao();
        conexao.executarDML(update);
    }
    
    public void excluir(Instrumentos instrumento) {
        String delete = "DELETE FROM Instrumentos WHERE descricaoInstrumento LIKE '%" + instrumento.getDescricao() + "%'";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(delete);
    }
}
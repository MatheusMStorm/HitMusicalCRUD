package DAO;

import Control.Conexao;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoriosDAO {
    
    public void inserir(Acessorios acessorio) {
        String inserir = "INSERT INTO Acessorios (descricaoAcessorio, marcaAcessorio, valorAcessorio, categoria) VALUES ('" 
                + acessorio.getDescricao() + "', '" + acessorio.getMarca() + "', " +
                acessorio.getValor() + ", '" + acessorio.getCategoria() + "')";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(inserir);
    }
    
    public Acessorios consultar(String descricao) {
        Conexao conexao = new Conexao();
        Acessorios acessorio = null;
        
        try {
            String consulta = "SELECT * FROM Acessorios WHERE descricaoAcessorio like '%" 
                    + descricao + "%'";
            ResultSet rs = conexao.executarConsulta(consulta);
            
            while (rs.next()) {
                acessorio = new Acessorios(0, null, null, 0.0, null);
                acessorio.setId(rs.getInt("idAcessorio"));
                acessorio.setDescricao(rs.getString("descricaoAcessorio"));
                acessorio.setMarca(rs.getString("marcaAcessorio"));
                acessorio.setValor(rs.getDouble("valorAcessorio"));
                acessorio.setCategoria(rs.getString("categoria"));
            }
        }
        catch (SQLException ex) {
            System.out.println("Não conseguiu acessar os dados do produto.");
        }
        finally {
            conexao.desconectar();
        }
        
        return acessorio;
    }
    
    // Alteração e exclusão são feitas por id, portanto recomendamos que seja feita a consulta prévia
    public void alterar(Acessorios acessorio) {
        String update = "UPDATE Acessorios SET descricaoAcessorio = '" +
                acessorio.getDescricao() + "', marcaAcessorio = '" +
                acessorio.getMarca() + "', valorAcessorio = " +
                acessorio.getValor() + ", categoria = '" +
                acessorio.getCategoria() + "' WHERE idAcessorio = " +
                acessorio.getId();
        
        Conexao conexao = new Conexao();
        conexao.executarDML(update);
    }
    
    public void excluir(Acessorios acessorio) {
        String delete = "DELETE FROM Acessorios WHERE descricaoAcessorio LIKE '%" + acessorio.getDescricao() + "%'";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(delete);
    }
}
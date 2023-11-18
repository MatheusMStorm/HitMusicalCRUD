package DAO;

import Control.Conexao;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CaixasSomDAO {
    
    public void inserir(CaixasSom caixaSom) {
        String inserir = "INSERT INTO CaixasSom (descricaoCaixaSom, marcaCaixaSom, "
                + "valorCaixaSom, potenciaSaida, tipoAltoFalante, qtdAltoFalantes, configCanais) "
                + "VALUES ('" 
                + caixaSom.getDescricao() + "', '" + caixaSom.getMarca() + "', " +
                caixaSom.getValor() + ", " + caixaSom.getPotenciaSaida() + ", '" +
                caixaSom.getTipoAltoFalante() + "', " + caixaSom.getQtdAltoFalantes() +
                ", '" + caixaSom.getConfigCanais() + "')";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(inserir);
    }
    
    public CaixasSom consultar(String descricao) {
        Conexao conexao = new Conexao();
        CaixasSom caixaSom = null;
        
        try {
            String consulta = "SELECT * FROM Acessorios WHERE descricaoCaixaSom like '%" 
                    + descricao + "%'";
            ResultSet rs = conexao.executarConsulta(consulta);
            
            if (rs.next()) {
                caixaSom = new CaixasSom(0, null, null, 0.0, 0, null, 0, null);
                caixaSom.setId(rs.getInt("idCaixaSom"));
                caixaSom.setDescricao(rs.getString("descricaoCaixaSom"));
                caixaSom.setMarca(rs.getString("marcaCaixaSom"));
                caixaSom.setValor(rs.getDouble("valorCaixaSom"));
                caixaSom.setPotenciaSaida(rs.getInt("potenciaSaida"));
                caixaSom.setTipoAltoFalante(rs.getString("tipoAltoFalante"));
                caixaSom.setQtdAltoFalantes(rs.getInt("qtdAltoFalantes"));
                caixaSom.setConfigCanais(rs.getString("configCanais"));
            }
        }
        catch (SQLException ex) {
            System.out.println("Não conseguiu acessar os dados do produto.");
        }
        finally {
            conexao.desconectar();
        }
        
        return caixaSom;
    }
    
    // Alteração e exclusão são feitas por id, portanto recomendamos que seja feita a consulta prévia
    public void alterar(CaixasSom caixaSom) {
        String update = "UPDATE CaixasSom SET descricaoCaixaSom = '" +
                caixaSom.getDescricao() + "', marcaCaixaSom = '" +
                caixaSom.getMarca() + "', valorCaixaSom = " +
                caixaSom.getValor() + ", potenciaSaida = " +
                caixaSom.getPotenciaSaida() + ", tipoAltoFalante = '" +
                caixaSom.getTipoAltoFalante() + "', qtdAltoFalantes = " +
                caixaSom.getQtdAltoFalantes() + ", configCanais = '" + 
                caixaSom.getConfigCanais() + "' WHERE idAcessorio = " +
                caixaSom.getId();
        
        Conexao conexao = new Conexao();
        conexao.executarDML(update);
    }
    
    public void excluir(CaixasSom caixaSom) {
        String delete = "DELETE FROM CaixasSom WHERE descricaoCaixaSom LIKE '%" + caixaSom.getDescricao() + "%'";
        
        Conexao conexao = new Conexao();
        conexao.executarDML(delete);
    }
}
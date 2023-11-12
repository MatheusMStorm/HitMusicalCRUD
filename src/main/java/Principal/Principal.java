package Principal;

import Model.*;
import DAO.*;
import javax.swing.JOptionPane;

public class Principal {
    
    public static char menu() {
        char op = ' ';
        
        String menu = "BEM-VINDO AO SISTEMA HIT MUSICAL!" +
                      "\n \n" + 
                      "Selecione uma opção para começar: " +
                      "\n[I]nserir produto" +
                      "\n[C]onsultar produto" +
                      "\n[A]tualizar produto" +
                      "\n[D]eletar produto" +
                      "\n[S]air";
        
        op = JOptionPane.showInputDialog(menu).charAt(0);
        
        return op;
    }
    
    public static char menuProdutos() {
        char opProduto = ' ';
        
        String menu = "Selecione a categoria de produtos que deseja acessar: " +
                      "\n[A]cessórios" +
                      "\n[C]aixas de Som" +
                      "\n[I]nstrumentos" +
                      "\n[M]icrofones";
        
        opProduto = JOptionPane.showInputDialog(menu).charAt(0);
        
        return opProduto;
    }
   
    public static void main(String[] args) {
        char op, opProdutos = ' ';
        
        do {
            op = menu();
            
            switch (op) {
                case 'I':
                    opProdutos = menuProdutos();
                    
                    switch (opProdutos) {
                        case 'A':
                            Acessorios acessorio = new Acessorios(0, null, null, 0.0, null);
                            AcessoriosDAO acessorioDAO = new AcessoriosDAO();
                            
                            acessorio.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                            acessorio.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                            acessorio.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                            acessorio.setCategoria(JOptionPane.showInputDialog("Categoria do produto: "));
                            
                            acessorioDAO.inserir(acessorio);
                            break;
                        case 'C':
                            CaixasSom caixaSom = new CaixasSom(0, null, null, 0.0, 0, null, 0, null);
                            CaixasSomDAO caixaSomDAO = new CaixasSomDAO();
                            
                            caixaSom.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                            caixaSom.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                            caixaSom.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                            caixaSom.setPotenciaSaida(Integer.parseInt("Potência de saída (opcional): "));
                            caixaSom.setTipoAltoFalante(JOptionPane.showInputDialog("Tipo de alto falante (opcional): "));
                            caixaSom.setQtdAltoFalantes(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de alto falantes (opcional): ")));
                            caixaSom.setConfigCanais(JOptionPane.showInputDialog("Configuração de canais (opcional): "));
                            
                            caixaSomDAO.inserir(caixaSom);
                            break;
                        case 'I':
                            Instrumentos instrumento = new Instrumentos(0, null, null, 0.0, null);
                            InstrumentosDAO instrumentoDAO = new InstrumentosDAO();
                            
                            instrumento.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                            instrumento.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                            instrumento.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                            instrumento.setCategoria(JOptionPane.showInputDialog("Categoria do produto: "));
                            
                            instrumentoDAO.inserir(instrumento);
                            break;
                        case 'M':
                            Microfones microfone = new Microfones(0, null, null, 0.0, null, null, null, null);
                            MicrofonesDAO microfoneDAO = new MicrofonesDAO();
                            
                            microfone.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                            microfone.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                            microfone.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                            microfone.setFormato(JOptionPane.showInputDialog("Formato (opcional): "));
                            microfone.setTipo(JOptionPane.showInputDialog("Tipo (opcional): "));
                            microfone.setFrequenciaMin(JOptionPane.showInputDialog("Frequência mínima (opcional): "));
                            microfone.setPadraoPolar(JOptionPane.showInputDialog("Padrão polar (opcional): "));
                            
                            microfoneDAO.inserir(microfone);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Erro");
                            break;
                    }
                    break;
                case 'C':
                    opProdutos = menuProdutos();
                    
                    switch (opProdutos) {
                        case 'A':
                            AcessoriosDAO acessorioDAO = new AcessoriosDAO();
                            Acessorios acessorio = null;
                            
                            String descricao = JOptionPane.showInputDialog("Pesquise o produto: ");
                            acessorio = acessorioDAO.consultar(descricao);
                            
                            // Impressão dos dados
                            if(acessorio != null) {
                                JOptionPane.showMessageDialog(null,
                                    "INFORMAÇÕES DO PRODUTO: \n" +
                                    "ID: " + acessorio.getId() + "\n" +
                                    "Descrição: " + acessorio.getDescricao() + "\n" +
                                    "Marca: " + acessorio.getMarca() + "\n" +
                                    "Valor: " + acessorio.getValor() + "\n" +
                                    "Categoria: " + acessorio.getCategoria());
                            }
                            break;
                        case 'C':
                            CaixasSomDAO caixaSomDAO = new CaixasSomDAO();
                            CaixasSom caixaSom = null;
                            
                            descricao = JOptionPane.showInputDialog("Pesquise o produto: ");
                            caixaSom = caixaSomDAO.consultar(descricao);
                            
                            if(caixaSom != null) {
                                JOptionPane.showMessageDialog(null,
                                    "INFORMAÇÕES DO PRODUTO: \n" +
                                    "ID: " + caixaSom.getId() + "\n" +
                                    "Descrição: " + caixaSom.getDescricao() + "\n" +
                                    "Marca: " + caixaSom.getMarca() + "\n" +
                                    "Valor: " + caixaSom.getValor() + "\n" +
                                    "Potência de saída: " + caixaSom.getPotenciaSaida() + "\n" +
                                    "Tipo de alto falante: " + caixaSom.getTipoAltoFalante() + "\n" +
                                    "Quantidade de alto falantes: " + caixaSom.getQtdAltoFalantes() + "\n" +
                                    "Configuração de canais: " + caixaSom.getConfigCanais());
                            }
                            break;
                        case 'I':
                            InstrumentosDAO instrumentoDAO = new InstrumentosDAO();
                            Instrumentos instrumento = null;
                            
                            descricao = JOptionPane.showInputDialog("Pesquise o produto: ");
                            instrumento = instrumentoDAO.consultar(descricao);
                            
                            // Impressão dos dados
                            if(instrumento != null) {
                                JOptionPane.showMessageDialog(null,
                                    "INFORMAÇÕES DO PRODUTO: \n" +
                                    "ID: " + instrumento.getId() + "\n" +
                                    "Descrição: " + instrumento.getDescricao() + "\n" +
                                    "Marca: " + instrumento.getMarca() + "\n" +
                                    "Valor: " + instrumento.getValor() + "\n" +
                                    "Categoria: " + instrumento.getCategoria());
                            }
                            break;
                        case 'M':
                            MicrofonesDAO microfoneDAO = new MicrofonesDAO();
                            Microfones microfone = null;
                            
                            descricao = JOptionPane.showInputDialog("Pesquise o produto: ");
                            microfone = microfoneDAO.consultar(descricao);
                            
                            // Impressão dos dados
                            if(microfone != null) {
                                JOptionPane.showMessageDialog(null,
                                    "INFORMAÇÕES DO PRODUTO: \n" +
                                    "ID: " + microfone.getId() + "\n" +
                                    "Descrição: " + microfone.getDescricao() + "\n" +
                                    "Marca: " + microfone.getMarca() + "\n" +
                                    "Valor: " + microfone.getValor() + "\n" +
                                    "Formato: " + microfone.getFormato() + "\n" +
                                    "Tipo: " + microfone.getTipo() + "\n" +
                                    "Frequência mínima: " + microfone.getFrequenciaMin() + "\n" +
                                    "Padrão polar: " + microfone.getPadraoPolar());
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Erro.");
                            break;
                    }
                    break;
                case 'A':
                    opProdutos = menuProdutos();
                    
                    switch (opProdutos) {
                       case 'A':
                            AcessoriosDAO acessorioDAO = new AcessoriosDAO();
                            Acessorios acessorio = new Acessorios(0, null, null, 0.0, null);
                            
                            acessorio.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto que você deseja alterar: ")));
                            
                            if (acessorio.getId() != 0) {
                                acessorio.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                                acessorio.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                                acessorio.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                                acessorio.setCategoria(JOptionPane.showInputDialog("Categoria do produto: "));
                            }
                            
                            acessorioDAO.alterar(acessorio);
                            break;
                        case 'C':
                            CaixasSomDAO caixaSomDAO = new CaixasSomDAO();
                            CaixasSom caixaSom = new CaixasSom(0, null, null, 0.0, 0, null, 0, null);
                            
                            caixaSom.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto que você deseja alterar: ")));
                            
                            if (caixaSom.getId() != 0) {
                                caixaSom.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                                caixaSom.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                                caixaSom.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                                caixaSom.setPotenciaSaida(Integer.parseInt("Potência de saída (opcional): "));
                                caixaSom.setTipoAltoFalante(JOptionPane.showInputDialog("Tipo de alto falante (opcional): "));
                                caixaSom.setQtdAltoFalantes(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de alto falantes (opcional): ")));
                                caixaSom.setConfigCanais(JOptionPane.showInputDialog("Configuração de canais (opcional): "));
                            }
                            
                            caixaSomDAO.alterar(caixaSom);
                            break;
                        case 'I':
                            InstrumentosDAO instrumentoDAO = new InstrumentosDAO();
                            Instrumentos instrumento = new Instrumentos(0, null, null, 0.0, null);
                            
                            instrumento.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto que você deseja alterar: ")));
                            
                            if (instrumento.getId() != 0) {
                                instrumento.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                                instrumento.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                                instrumento.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                                instrumento.setCategoria(JOptionPane.showInputDialog("Categoria do produto: "));
                            }
                            
                            instrumentoDAO.alterar(instrumento);
                            break;
                        case 'M':
                            MicrofonesDAO microfoneDAO = new MicrofonesDAO();
                            Microfones microfone = new Microfones(0, null, null, 0.0, null, null, null, null);
                            
                            microfone.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do produto que você deseja alterar: ")));
                            
                            if (microfone.getId() != 0) {
                                microfone.setDescricao(JOptionPane.showInputDialog("Descrição do produto: "));
                                microfone.setMarca(JOptionPane.showInputDialog("Marca do produto: "));
                                microfone.setValor(Double.parseDouble(JOptionPane.showInputDialog("Valor do produto: ")));
                                microfone.setFormato(JOptionPane.showInputDialog("Formato (opcional): "));
                                microfone.setTipo(JOptionPane.showInputDialog("Tipo (opcional): "));
                                microfone.setFrequenciaMin(JOptionPane.showInputDialog("Frequência mínima (opcional): "));
                                microfone.setPadraoPolar(JOptionPane.showInputDialog("Padrão polar (opcional): "));
                            }
                            
                            microfoneDAO.alterar(microfone);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Erro.");
                            break;
                    }
                    break; 
                case 'D':
                    opProdutos = menuProdutos();
                    
                    switch (opProdutos) {
                        case 'A':
                            AcessoriosDAO acessorioDAO = new AcessoriosDAO();
                            Acessorios acessorio = null;
                            
                            String descricao = JOptionPane.showInputDialog("Pesquise o produto que deseja excluir");
                            
                            acessorio = acessorioDAO.consultar(descricao);
                            acessorioDAO.excluir(acessorio);
                            JOptionPane.showConfirmDialog(null, "Excluído com sucesso!");
                            break;
                        case 'C':
                            CaixasSomDAO caixaSomDAO = new CaixasSomDAO();
                            CaixasSom caixaSom = null;
                            
                            descricao = JOptionPane.showInputDialog("Pesquise o produto que deseja excluir");
                            
                            caixaSom = caixaSomDAO.consultar(descricao);
                            caixaSomDAO.excluir(caixaSom);
                            JOptionPane.showConfirmDialog(null, "Excluído com sucesso!");
                            break;
                        case 'I':
                            InstrumentosDAO instrumentoDAO = new InstrumentosDAO();
                            Instrumentos instrumento = null;
                            
                            descricao = JOptionPane.showInputDialog("Pesquise o produto que deseja excluir");
                            
                            instrumento = instrumentoDAO.consultar(descricao);
                            instrumentoDAO.excluir(instrumento);
                            JOptionPane.showConfirmDialog(null, "Excluído com sucesso!");
                            break;
                        case 'M':
                            MicrofonesDAO microfoneDAO = new MicrofonesDAO();
                            Microfones microfone = null;
                            
                            descricao = JOptionPane.showInputDialog("Pesquise o produto que deseja excluir");
                            
                            microfone = microfoneDAO.consultar(descricao);
                            microfoneDAO.excluir(microfone);
                            JOptionPane.showConfirmDialog(null, "Excluído com sucesso!");
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Erro.");
                            break;
                    }
                    break;
                
            }
        } while (op != 'S');
    }
}
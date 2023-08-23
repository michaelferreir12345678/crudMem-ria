import br.com.mferreira.dao.ClienteMapDAO;
import br.com.mferreira.dao.IClienteDAO;
import br.com.mferreira.domain.Cliente;

import javax.swing.*;

public class Main {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {

        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastro, 2 para consultar, 3 para exclusão," +
                " 4 para alteração ou 5 para sair.", "CADASTROS",JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)){
            if("".equals(opcao)){
                sair();
            }
            opcao = JOptionPane.showInputDialog(null,"Opção inválida. Por favor, digite 1 para cadastro, 2 para consultar, 3 para exclusão," +
                    " 4 para alteração ou 5 para sair.", "CADASTROS",JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)){
            if(isOpcaoSair(opcao)){
                sair();
            }
            else if (isOpcaoCadastrar(opcao)){ //michael,146,4567,fghj,4567,dfgh,fgh//
                String dados = JOptionPane.showInputDialog(null,"Digite os dados do cliente separados por vírgula, conforme exemplo: " +
                        "Nome, CPF, Telefone, Endereço, Número, cidade, Estado ", "CADASTROS",JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isOpcaoConsultar(opcao)) {
                String dados = JOptionPane.showInputDialog(null,"Digite o CPF do cliente ", "CONSULTAR",JOptionPane.INFORMATION_MESSAGE);
                consultar(dados);
            }
            opcao = JOptionPane.showInputDialog(null,"Digite 1 para cadastro, 2 para consultar, 3 para exclusão," +
                    " 4 para alteração ou 5 para sair.", "CADASTROS",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isOpcaoCadastrar(String opcao){
        if ("1".equals(opcao)){
            return true;
        }
        return false;
    };

    private static boolean isOpcaoConsultar(String opcao){
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    };

    private static boolean isOpcaoValida(String opcao) {
        if("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static Boolean isOpcaoSair(String opcao){
        if ("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static void cadastrar(String dados) {
        String[] dadosList = dados.split(",");
        Cliente cliente = new Cliente(dadosList[0],dadosList[1],dadosList[2],dadosList[3],dadosList[4],dadosList[5],dadosList[6]);
        Boolean isCadastrado = iClienteDAO.cadatrar(cliente);
        if (isCadastrado){
            JOptionPane.showMessageDialog(null,"Cliente cadastrado com Sucesso", "CADASTROS",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null,"Cliente já encontra-se cadastrado", "CADASTROS",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String dados){
        Cliente cliente = iClienteDAO.consultar(Long.valueOf(dados));
        if (cliente != null){
            JOptionPane.showMessageDialog(null,"Cliente encontrado: " + cliente.toString(), "CADASTROS",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.toString(), "CADASTROS", JOptionPane.INFORMATION_MESSAGE);
        }

    };

    private static void sair(){
        JOptionPane.showMessageDialog(null,"Até logo!!!", "ERRO", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

}
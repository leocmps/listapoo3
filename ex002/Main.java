package listapoo3.ex002;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {

        int opc = 0;
        int codigo, codigov, codigoc;
        String nome, marca, modelo;
        ArrayList<Pessoa> listPessoa = new ArrayList<>();
        Pessoa pessoaSelecionada = null;
        Pessoa vendedorSelecionado = null;
        Pessoa compradorSelecionado = null;

        while (opc != 6) {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                    "1 - Registrar Pessoa" + "\n"
                    + "2 - Registrar Automóvel" + "\n"
                    + "3 - Transferir Automóvel" + "\n"
                    + "4 - Mostrar Pessoas Registradas" + "\n"
                    + "5 - Mostrar Automóvel da Pessoa" + "\n"
                    + "6 - Sair"
            ));

            if (opc == 2 || opc == 5) {
                pessoaSelecionada = null;
                codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da pessoa"));
                for (Pessoa p : listPessoa) {
                    if (p.getCodigo() == codigo) {
                        pessoaSelecionada = p;
                    }
                }
                if (pessoaSelecionada == null) {
                    continue;
                }
            }
            Pessoa pessoa = new Pessoa();
            Automovel automovel = new Automovel();

            switch (opc) {
                case 1:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Código:"));
                    nome = JOptionPane.showInputDialog("Nome:");
                    listPessoa.add(new Pessoa(codigo, nome));
                    break;
                case 2:
                    marca = JOptionPane.showInputDialog("Marca:");
                    modelo = JOptionPane.showInputDialog("Modelo:");
                    pessoaSelecionada.inserirAutomovel(new Automovel(marca, modelo));
                    break;
                case 3:
                    codigov = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do vendedor:"));
                    for (Pessoa p : listPessoa) {
                        if (codigov == p.getCodigo()) {
                            vendedorSelecionado = p;
                        }
                    }

                    int index = 1;
                    String msg = "";
                    for (Automovel a : vendedorSelecionado.getAutomoveis()) {
                        msg += index + " - " + "Marca: " + a.getMarca() + " / " + "Modelo: " + a.getModelo() + "\n";
                        index++;
                    }
                    index = Integer.parseInt(JOptionPane.showInputDialog("Selecione o automóvel:\n" + msg));
                    Automovel auto = vendedorSelecionado.getAutomoveis().get(index - 1);
                    vendedorSelecionado.removerAutomovel(index - 1);

                    codigoc = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do comprador:"));
                    for (Pessoa p : listPessoa) {
                        if (codigoc == p.getCodigo()) {
                            compradorSelecionado = p;
                        }
                    }
                    compradorSelecionado.inserirAutomovel(auto);
                    break;
                case 4:
                    String msg1 = "";
                    int index1 = 1;
                    for (Pessoa p : listPessoa) {
                        msg1 += "Nome: " + p.getNome() + "\n";
                        index1++;
                    }
                    JOptionPane.showMessageDialog(null, msg1);
                    break;
                case 5:
                    int index2 = 1;
                    String msg2 = "";
                    for (Automovel a : pessoaSelecionada.getAutomoveis()) {
                        msg2 += index2 + " - " + "Marca: " + a.getMarca() + " / " + "Modelo: " + a.getModelo() + "\n";
                        index2++;
                    }
                    JOptionPane.showMessageDialog(null, msg2);
                    break;
                case 6:
                    break;
                default:
                    break;

            }
        }
    }
}

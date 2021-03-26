package listapoo3.ex001;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        int opc = 0;
        int codigo, ch;
        String nome, ra;
        ArrayList<Curso> listCurso = new ArrayList<>();
        Curso cursoSelecionado = null;
        while (opc != 6) {
            opc = Integer.parseInt(JOptionPane.showInputDialog(
                      "1 - Criar Curso\n"
                    + "2 - Criar Aluno\n"
                    + "3 - Remover Aluno\n"
                    + "4 - Mostrar todos os cursos\n"
                    + "5 - Mostrar alunos do curso\n"
                    + "6 - Sair"));

            if (opc == 2 || opc == 3 || opc == 5) {
                cursoSelecionado = null;
                codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do curso"));
                for (Curso c : listCurso) {
                    if (c.getCodigo() == codigo) {
                        cursoSelecionado = c;
                    }
                }
                if (cursoSelecionado == null) {
                    continue;
                }
            }

            switch (opc) {
                case 1:
                    codigo = Integer.parseInt(JOptionPane.showInputDialog("Código"));
                    nome = JOptionPane.showInputDialog("Nome");
                    ch = Integer.parseInt(JOptionPane.showInputDialog("Carga Horária"));
                    listCurso.add(new Curso(codigo, nome, ch));
                    break;
                case 2:
                    ra = JOptionPane.showInputDialog("RA");
                    nome = JOptionPane.showInputDialog("Nome");
                    cursoSelecionado.inserirAluno(new Aluno(ra, nome));
                    break;
                case 3:
                    ra = JOptionPane.showInputDialog("Digite o RA");
                    int index = -1;
                    for (Aluno a : cursoSelecionado.getAlunos()) {
                        if (a.getRa().equals(ra)) {
                            index = cursoSelecionado.getAlunos().indexOf(a);
                        }
                    }
                    if (index > -1) {
                        cursoSelecionado.removerAluno(index);
                    }
                    break;
                case 4:
                    String msg = "";
                    for (Curso c : listCurso) {
                        msg += c.imprimir() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, msg);
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, cursoSelecionado.imprimirCompleto());
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }
    }

}
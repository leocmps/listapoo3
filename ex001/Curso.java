package listapoo3.ex001;

import java.util.ArrayList;
import listapoo3.ex001.Aluno;

public class Curso {
    
    private ArrayList<Aluno> alunos;

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    
    private int codigo;
    private String nome;
    private int cargaHoraria;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    public Curso () {
        alunos = new ArrayList<>();
    }
    
    public Curso (int codigo, String nome, int cargaHoraria) {
        this();
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }
    
    public void inserirAluno (Aluno aluno) {
        alunos.add(aluno);
    }
    
    public void removerAluno (int index) {
        alunos.remove(index);
    }
    
    public String imprimir () {
        return "Código: " + codigo +
                "\nNome: " + nome +
                "\n(Carga Horária " + cargaHoraria + ")";
    }
    
    public String imprimirCompleto () {
        String retorno = imprimir() + "\n";
        for (Aluno a : alunos) {
            retorno += a.imprimir() + "\n";
        }
        return retorno;
    }    
}

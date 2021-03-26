package listapoo3.ex002;

import java.util.ArrayList;
import listapoo3.ex002.Automovel;

public class Pessoa {
    
    private int codigo;
    private String nome;
    private ArrayList<Automovel> automoveis;
    
    public Pessoa () {
        automoveis = new ArrayList<Automovel>();
    }

    public Pessoa(int codigo, String nome) {
        this();
        this.codigo = codigo;
        this.nome = nome;
    }
    
    public void inserirAutomovel (Automovel automovel) {
        automoveis.add(automovel);
    }
    
    public void removerAutomovel (int index) {
        automoveis.remove(index);
    }
    
    public String imprimir () {
        return "Código: " + codigo + "\n" +
               "Nome: " + nome;
    }
    public String imprimirCompleto () {
        String retorno = imprimir() + "\n" + "\n";
        for (Automovel a : automoveis) {
            retorno += a.imprimir() + "\n" + "\n";
        }
        return retorno;
    }

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

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomoveis(ArrayList<Automovel> automoveis) {
        this.automoveis = automoveis;
    }
    
}

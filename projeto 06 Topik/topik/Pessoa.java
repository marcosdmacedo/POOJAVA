package topik;

public class Pessoa{
    private String nome;
    private int idade;

    public int getIdade() {
        return idade;
    }
    public String getNome() {
        return nome;
    }
    public Pessoa(String nome, int idade){ //construtor
        this.idade = idade;
        this.nome = nome;
    }
    public String toString(){ 
        return this.nome + ":" + this.idade;
    }
}
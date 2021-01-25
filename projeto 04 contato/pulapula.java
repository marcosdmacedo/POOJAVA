package contato;
import java.util.ArrayList;
import java.util.Scanner;

class Crianca {
    private String nome;
    private int idade;

    Crianca (String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    String getNome() {
        return nome;
    }
    int getIdade() {
        return idade;
    }
    public String toString() {
        return nome + " : " + idade;
    }
}
class CamaElastica {
    ArrayList<Crianca> esperando = new ArrayList<>();
    ArrayList<Crianca> brincando = new ArrayList<>();

    // chegou na Cama Elastica
    void chegar (Crianca crianca) {
        esperando.add(crianca);
    }
    void exibir () {
        System.out.println("aguardando: " + esperando);
        System.out.println("brincando: " + brincando);
    }
    // sair do array esperando para o brincando
    void entrar() {
        brincando.add(esperando.get(0));
        esperando.remove(esperando.get(0));
    }
    // sair do array brincando, para o esperando, (fim da fila) 
    void sair() {
        esperando.add(brincando.get(0));
        brincando.remove(brincando.get(0));
    }
    public static void main(String[] args) {
        CamaElastica Saltar = new Saltar(); 
        Scanner leitor = new Scanner (System.in);
        while (true) {
            String line = leitor.nextLine();
            String [] ui = line.split(" ");
            if (ui[0].equals("fim")) {
                break;
            } else if (ui[0].equals("chegar")) {
                Saltar.chegar(new Crianca(ui[1], Integer.parseInt(ui[2])));
                Saltar.exibir();
            } else if (ui[0].equals("entrar")) {
                Saltar.entrar();
                Saltar.exibir();
            } else if (ui[0].equals("sair")) {
                Saltar.sair();
                Saltar.exibir();
            }
        }
        leitor.close();
    }
}
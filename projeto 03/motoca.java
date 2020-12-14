//MOTOCA
import java.util.Scanner;

class Pessoa{ //CLASSE
    int idade;
    String nome;

    Pessoa(String nome, int idade){ //CONSTRUTOR
        this.idade= idade;
        this.nome= nome;
    }
}
class Moto{
    int potencia;
    int tempo;
    Pessoa Pessoa;

    Moto(int potencia){
        this.potencia= potencia;
        this.tempo = 0;
    }
    void ComprarTempo(int valor, int tempo){
        this.tempo +=valor;
        System.out.println("acabou o tempo :(" + valor);
    } 
    void subir(Pessoa Pessoa){
        if(this.Pessoa == null && Pessoa.idade < 10){
            this.Pessoa = Pessoa;
            System.out.println(Pessoa.nome + " Subiu na motoca, sua idade:" + Pessoa.idade);
            return;
        }
        if(this.Pessoa == null && Pessoa.idade >= 10){
            System.out.println("cê inxerido, tu ja é grande!!!");
            return;
        }
        System.out.println("tem gente na motoca!");
    }
    void descer(Pessoa Pessoa){
        if(this.Pessoa ==  null){
            System.out.println("motoca a disposição!");
            return;
        }
        System.out.println(this.Pessoa.nome + " Desceu da Motoca!");
        this.Pessoa = null;
        return;
    } 
    void dirigir (){ //dirigir tempo
        if(this.Pessoa == null){
            for(int i=0; i<tempo; i++){
                this.tempo -=1;
                if(this.tempo == -1){
                    System.out.println("Andou " + 1 + " e acabou o tempo!");
                    return;
                }
            }
            System.out.println("Andou " + tempo);
            return;
        }
        System.out.println("A motoca está vazia!");
    }

    public String toString() {
        return "Pessoa : Nome:" + Pessoa.nome + " Idade:" + Pessoa.idade + " Tempo:" + tempo;
    }

    public static void main( String[] args) {
        Moto motorista = new Moto( 2 );
        Scanner leitor = new Scanner (System.in);
        
        motorista.potencia = leitor.nextInt();
        motorista.tempo = leitor.nextInt();
        
        leitor.close();

        motorista.ComprarTempo();
        motorista.subir();
        motorista.dirigir();
        System.out.println(motorista);
        motorista.dirigir();
        motorista.descer();
        System.out.println(motorista);
    }
}
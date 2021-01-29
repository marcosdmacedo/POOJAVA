package topik;
import java.util.Scanner;

//-----------------------------------------------------------------------------------------------------    
public class Topiquinha{
    public static void main(String[] args) {
        Scanner leitorScanner = new Scanner(System.in);
        System.out.println("Digite a quantidade máxima de passageiros na Topik!");
        int tamanho = leitorScanner.nextInt();
        System.out.println("Digite a quantidade de cadeiras preferenciais nela!");
        int pref = leitorScanner.nextInt();
        Topik topic = new Topik(tamanho, pref);
        System.out.println("Digite 'subir com o nome e a idade do passageiro' para subir na Topik!");
        System.out.println("Digite 'descer com o nome do passageiro' para desce-lo se ele estiver na TopiK!");
        while(true){
            String op = leitorScanner.nextLine();
            String[] queb = op.split(" ");
            if(queb[0].equalsIgnoreCase("subir")){
                topic.entrar(new Pessoa(queb[1], Integer.parseInt(queb[2])));
                System.out.println(topic);
            }
            else if(queb[0].equalsIgnoreCase("descer")){
                topic.descer(queb[1]);
                System.out.println(topic);
            }
            else if(queb[0].equalsIgnoreCase("encerrar")){
                topic.parar();
                System.out.println("\n" + topic);
                break;
            }
            System.out.println("");
        }
        leitorScanner.close();
    }
}




 


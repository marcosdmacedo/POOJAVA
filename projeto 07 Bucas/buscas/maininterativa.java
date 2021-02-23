import java.util.Scanner;

public class maininterativa {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaContatos agenda = new AgendaContatos();
        while(true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            if (ui[0].equals("adicionarContato")){
                agenda.adicionarContato(ui[1]);
            } else if(ui[0].equals("parar")){
                break;
            } else if(ui[0].equals("removerContato")){
                agenda.removerContato(ui[1]);
            }else if(ui[0].equals("adicionarNum")){
                agenda.adicionarNumero(ui[1], ui[2], ui[3]);;
            } else if (ui[0].equals("removerNum")){
                agenda.removerNumero(ui[1], ui[2]);
            } else if (ui[0].equals("agenda")){
                agenda.agenda();
            } else if (ui[0].equals("buscar")){
                agenda.buscar(ui[1]);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
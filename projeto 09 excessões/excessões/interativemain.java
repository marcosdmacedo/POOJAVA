import java.util.Scanner;

class interativemain {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        String init = scanner.nextLine();
        String[] ui = init.split("");
        Contato contato = new Contato(ui[1]);
        
        while(true){
            String line = scanner.nextLine();
            System.out.println("$ " + line);
            String in[] = line.split(" ");

            if(line.equals("end")){
                break;
            }
            else if(in[0].equals("init")){
                contato = new Contato(in[1]);
            }
            else if(in[0].equals("add")){
                try{
                    contato.addFone(in[1], in[2]);
                }
                catch(IllegalArgumentException e){
                    System.out.println("fail: Número de Telefone Inválido");
                }
            }else if(in[0].equals("remover")){
                try{
                    contato.remover(Integer.parseInt(in[1]));
                }
                catch(NullPointerException n){
                    System.out.println("fail: Telefone Inválido");
                }
            }else if(in[0].equals("show")){
                System.out.println(contato);
            }else{
                System.out.println("fail: Comando Inválido");
            }
        }
    scanner.close();
    }
}
/*
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Contato contato = new Contato("");
    while(true){
        System.out.println("--------------Agenda de Contatos---------------");
        System.out.println("- Iniciar sua lista de contatos: 'init'");
        System.out.println("- Adicionar um numero: 'add'");
        System.out.println("- Remover um numero: 'rm'");
        System.out.println("- Mostrar sua lista: 'show'");
        System.out.println("- Sair da lista: 'end'\n");

        System.out.print("Escolha aqui sua opção: ");
        
        String line = scanner.nextLine();
        System.out.println("$" + line);
        String ui[] = line.split(" ");
        
        if(ui[0].equals("end")){
            break;
        }
        else if(ui[0].equals("init")){
            contato = new Contato(ui[1]);
        }
        else if(ui[0].equals("add")){   
            try{
                contato.addFone(ui[1], ui[2]);
            }
            catch(IllegalArgumentException e){
                System.out.println("fail: Telefone Invalido");
            }
        }    
        else if(ui[0].equals("rm")){
            try{
                contato.removeFone(Integer.parseInt(ui[1]));
            }
            catch(NullPointerException n){
                System.out.println("fail: Telefone Invalido");
            }    
        }
        else if(ui[0].equals("show")){
            System.out.println(contato);
        }
        else{
            System.out.println("Comando Inválido");
        }
    }
    scanner.close();
}
}
*/
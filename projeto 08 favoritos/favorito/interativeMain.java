import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class interativeMain {
 
    public static void main(String[] args) {
        Agendaa telefonica = new Agendaa();
        try (Scanner dados = new Scanner(System.in)){
            while(true){
                try{
                    String novodado = dados.nextLine();
                    String[] dd = novodado.split(" "); 
                    if(dd[0].equals("fim")){
                        break;
                    }else if(dd[0].equals("add")){
                        List<cellFone> fones = new ArrayList<>(); 
                        for(int i=2; i<dd.length; i++){
                            fones.add(new cellFone(dd[i]));
                        }
                        telefonica.add((dd[1]), fones);
                        System.out.println(telefonica);
                    }else if(dd[0].equals("getContatos")){ //mostrar todos os contatos 
                        System.out.println(telefonica);
                    }else if(dd[0].equals("getContato")){ //mostrar contato especifico
                        System.out.print(telefonica.getContato(dd[1]));
                    }else if(dd[0].equals("remover")){ //remover contato
                        telefonica.remover(dd[1]);
                        System.out.print(telefonica);
                    }else if(dd[0].equals("procurar")){ //procurar contato
                        System.out.print(telefonica.procurar(dd[1]));
                    }else if(dd[0].equals("star")){ //favoritar contato
                        telefonica.star(dd[1]);
                        System.out.print(telefonica);
                    }else if(dd[0].equals("unstar")){ //desfavoritar contato
                        telefonica.unstar(dd[1]);
                        System.out.print(telefonica);
                    }else if(dd[0].equals("starred")){ // mostar favoritos
                        System.out.print(telefonica.starredArrayList());
                    }
                }catch(RuntimeException e){
                    System.out.println(e.getMessage());
                }   
            }
        }  
        System.out.println(telefonica);
    }                 
}
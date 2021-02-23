import java.util.ArrayList;

public class Contato {
    String nome; 
    ArrayList<Fone> lista = new ArrayList<Fone>(); //guardar os Fones
    
    Contato (String nome){
        this.nome = nome; 
    }

    boolean verificarNumero (String number){
        boolean result = true;
        String nCerto = "1234567890()."; 

        for(int i = 0; i < number.length(); i++){
            if(result == false){
                break;
            }
            int aux = 0;
            for(int x = 0; x < nCerto.length(); x++){
                if(number.charAt(i) != nCerto.charAt(x)){
                    aux = aux + 1;
                }
                if(aux == nCerto.length()){
                    result = false;
                }
            }
        }
        return result;
    }

    public String toString (){
        String mostrarLista = ""; 
        for(int i = 0; i < lista.size(); i++){
            Fone telefone = lista.get(i);
            mostrarLista += " [" + i + ":" + telefone + "]";
        }
        return this.nome + mostrarLista;
    }
}





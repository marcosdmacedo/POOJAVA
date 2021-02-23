import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


class OrdemAlfa implements Comparator<Contato>{
    public int compare(Contato one, Contato two){
        return one.nome.compareTo(two.nome);
    }
}

public class AgendaContatos {
    ArrayList<Contato> listaDeContatos;
    AgendaContatos (){
        this.listaDeContatos = new ArrayList<Contato>();
    }
    boolean verificarNumero (String number){//verificar se o num é valido, se só tem 123456789().
        boolean result = true;
        String numerosCertos = "1234567890().";
        for(int i = 0; i < number.length(); i++){
            if(result == false){
                break;
            }
            int contagem = 0;
            for(int x = 0; x < numerosCertos.length(); x++){
                if(number.charAt(i) != numerosCertos.charAt(x)){
                    contagem = contagem + 1;
                }
                if(contagem == numerosCertos.length()){
                    result = false;
                }
            }
        }
        return result;
    }
    void adicionarContato(String nome){
        if(verificarContato(nome) == true){
            System.out.println("fail: o contato ja existe");
            return;
        }
        listaDeContatos.add(new Contato(nome));
    }
    void adicionarNumero(String nome, String descricao, String numero){
        if (verificarContato(nome) == true){
            getContato(nome).lista.add(new Fone(numero, descricao));
            return;
        }
        System.out.println("fail: contato não encontrado");
    }
    void removerContato(String entrada){
        listaDeContatos.remove(getContatoPosition(entrada));
    }
    void removerNumero(String nome, String index){
        if (verificarContato(nome) == true){
            getContato(nome).lista.remove(Integer.parseInt(index));
            return;
        }
        System.out.println("fail: contato não encontrado");
    }
    Contato getContato(String nome){
        for(int i = 0; i < listaDeContatos.size(); i++){
            String comparar = listaDeContatos.get(i).nome;
            if(nome.equals(comparar)){
                return listaDeContatos.get(i);
            }
        }
        return null;   
    }
    int getContatoPosition(String nome){
        for(int i = 0; i < listaDeContatos.size(); i++){
            String comparar = listaDeContatos.get(i).nome;
            if(nome.equals(comparar)){
                return i;
            }
        }
        return -1;   
    }
    void agenda(){
        Collections.sort(listaDeContatos, new OrdemAlfa());
        for (Contato contato : listaDeContatos){
            System.out.println("- " + contato);
        }
    }
    boolean verificarContato(String nome){
        for(int i = 0; i < listaDeContatos.size(); i++){
            String comparar = listaDeContatos.get(i).nome;
            if(nome.equals(comparar)){
                return true;
            }
        }
        return false;
    }
    public void buscar (String entrada){
        ArrayList<Contato> aux = new ArrayList<Contato>();
        for (Contato contato : listaDeContatos){
            if (contato.nome.contains(entrada)){
                aux.add(contato);
            }
            ArrayList<Fone> listaFones = contato.lista;
            for(Fone fone : listaFones){
                if (fone.descricao.contains(entrada)){
                    aux.add(contato);
                }
                if (fone.numero.contains(entrada)){
                    aux.add(contato);
                }
            }
        }
        for (Contato contato : aux){
            System.out.println("- " + contato);
        }
    }
}
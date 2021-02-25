import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Agendaa {

    Map <String, Contato> contatos;
    Map <String, Contato> star;

    public Agendaa(){
        contatos = new TreeMap<>();
        star = new TreeMap<>();
    }
    
    public void add(String name, List <cellFone> fones){  //List <Fone> fones
        if(!contatos.containsKey(name)){
            contatos.put(name, new Contato(name));
        } 
        Contato contato = contatos.get(name);
        
        for(cellFone fone : fones){
            contato.addcellFone(fone);
        }
    }
    
    ArrayList <Contato> getContatos(){
        return new ArrayList<Contato>(contatos.values());        
    }

    public boolean remover(String name){
        contatos.remove(name);
        return true;
    }

    Contato getContato(String name){
        Contato contato = contatos.get(name);
        if(contato == null){
            throw new RuntimeException("Fail: contato não existe");
        }   
        return contato;        
    }
    
    ArrayList <Contato> procurar(String padrao){
        ArrayList<Contato> aux= new ArrayList<>();
        for(Contato contato: contatos.values()){
            if(contato.toString().contains(padrao)){
                aux.add(contato);
                return aux;
            }
        }
        return null;
    }

    public void star(String name){
        Contato contato = contatos.get(name);
        if(!contato.getFavorito()){
            contato.setBookmark(true);
            star.put(name, contato);
        }
    }
    
    public void unstar(String name){
        Contato contato = contatos.get(name);
        if(contato.getFavorito()){
            contato.setBookmark(false);
            unstar(name);remove(name, contato);
        }
    }
    
    private void remove(String name, Contato contato) {
    }

    ArrayList<Contato> starredArrayList() {
        return new ArrayList<Contato>(star.values()); 
    }
    
    public String toString(){
        String saida="";
        for(Contato contato : contatos.values()){
            if(!contato.getFavorito()){
                saida += " - " + contato; 
            }
            else{
                saida += " @ " + contato;
            }
        }
        return saida;
    }
}
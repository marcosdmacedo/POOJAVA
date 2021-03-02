import java.util.ArrayList;

//aproveitei "pedaços" dos meus códigos passados aqui!!!
public class Contato{
    String nome;
    ArrayList<Fone> phones;
    int nextFone = 0;
    
    public Contato(String nome){
        this.nome = nome;
        this.phones = new ArrayList<>();
    }

    public void addFone(String label, String number){
        if(Fone.validade(number)){
            phones.add(nextFone,new Fone(label, number));
            nextFone ++;
            return;
        }
        throw new IllegalArgumentException(); 
    }

    //Fone / label
    public Fone getFone(String label){
        for(Fone fone: phones){
            if(fone.label.equals(label)){
                return fone;
            }
        }    
        throw new NullPointerException();
    }

    //Fone / indice
    public Fone getFone(int index){       
        if(index>=0 && index<phones.size()){ //validade 
            return phones.get(index);
        }
        throw new NullPointerException();
    }

    //remover / indice
    public boolean remover(int index){
        if(index>=0 && index<phones.size()){
            phones.remove(index);
            return true;
        }
        throw new NullPointerException();
    }

    //remover / numero 
    public boolean remover(String numero){
        for(Fone fone : phones){
            if(fone.numero.equals(numero)){
                phones.remove(fone);
                return true;
            }
        }
        throw new NullPointerException();
    }
    
    public String toString(){
        String saida = "- "+this.nome;
        for(int i=0; i<phones.size(); i++){
            saida += "["+i+":"+phones.get(i)+"]";
        }
        return saida;
    }
}
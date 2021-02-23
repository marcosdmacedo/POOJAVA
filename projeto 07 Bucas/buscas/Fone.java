public class Fone {
    String descricao; 
    String numero; 

    Fone (String numero, String descricao){ //construtor
        this.numero = numero; 
        this.descricao = descricao; 
    }

    public String toString (){
        return this.descricao + ":" + this.numero;
    }
}
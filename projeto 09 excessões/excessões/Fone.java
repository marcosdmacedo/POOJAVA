//aproveitei "pedaços" dos meus códigos passados aqui!!!
public class Fone{
    String label; 
    String numero;
    
    public Fone(String label, String numero){
        this.label = label;
        this.numero = numero;
    }
  
    public static boolean validade(String numero){
        String validos = "0123456789()-";
        for(int i=0; i<numero.length(); i++){
            char c = numero.charAt(i); 
            if(validos.indexOf(c)==-1){ //indexOf > diz a posição da string caso encontrada no vetor
                return false;
            }
        }
        return true;
    }
    
    public String toString(){
        return label + ":" + numero;
    }
}
import java.util.ArrayList;

class cellFone{
    private String label;
    private String number;
    public cellFone(String label, String number){
        this.label=label;
        this.number=number;
    }
    
    cellFone(String serial){
     String array[]= serial.split(":");
        label=array[0];
        number=array[1];
    }
    
    static public boolean validate(String number){
        String validos = "0123456789()-";
        for(int i = 0; i < number.length(); i++){
            if(!validos.contains("" + number.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public String getNumber(){
        return this.number;
    }
   
    public String toString(){
        return label + number;   
    }

}

class Contato{
    private String name;
    private boolean favorito;
    private ArrayList<cellFone> fones;

    public Contato(String name){
        this.name=name;
        fones = new ArrayList<>();
    }
    
    boolean getFavorito(){
        return favorito;
    }
        
    public void addcellFone(String label, String number){
        if(!cellFone.validate(number)){
            throw new RuntimeException("fail: esse número não é válido");
        }
        fones.add(new cellFone(label, number));     
    }
    
    public void addcellFone(cellFone fone){
        this.addcellFone(fone.getLabel(), fone.getNumber());
    }
    
    public void rmFone(int index){
           fones.remove(fones.get(index));      
    }
    
    public void setBookmark(boolean valor){
        this.favorito = valor;
    }
    
    public String toString(){
        String saida="";
        saida += " " + name + " : " + fones;
        return saida;
    }

	public void setstar(boolean b) {
	}
}
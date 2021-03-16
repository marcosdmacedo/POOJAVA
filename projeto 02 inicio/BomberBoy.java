package bomberboy;

import java.util.Scanner;

public class BomberBoy{
    int vida; 
    int nPassos; 
    int forca;
    // ESTILO BOMBERMAN, s� um pouco menos complexo. :( 

    BomberBoy(int vida, int nPassos , int forca) {
        this.vida = vida;
        this.nPassos = nPassos;
        this.forca = forca;
    }

    void andar() { //metodos -> comportamento 
        if(vida > 0){
            System.out.println("tô vivo meu irmãoo!");
            nPassos -= 1;
            return;
        }
        if(nPassos > 0){
            System.out.println("bora andar!");
        }
        if(forca > 0){
            System.out.println("to com força");
        }
        else{
            System.out.println("to morto"); 
        }
    }
    void bomber(){
        System.out.println("olha a bomba, nem me pega!");
        nPassos -= 2;
        vida -= 1;
    }
    void descansar(){ // O bomberboy vai consseguir recarragar os passos.
        System.out.println("tirar uma sonequinha!");
        nPassos += 1;
        forca += 1;
    }
    void presente(){ // se ganhar o presente, ganha uma vida
        System.out.println("ganhei uma vida!");
        vida += 1;
        nPassos -= 1;
    }
    //metodo que informa como o meu objeto deve ser convertido para Texto
    public String toString() {
        return "BomberBoy : Passos:" + nPassos + " Vidas:" + vida + " For�a:" + forca;
    }

    public static void main( String[]args ) {
        BomberBoy baguera =  new BomberBoy( 2 , 6 ,3 );
       
        Scanner leitor = new Scanner (System.in);
    
        baguera.vida = leitor.nextInt();
        
        baguera.nPassos = leitor.nextInt();
        
        baguera.forca = leitor.nextInt();
        
        leitor.close();
        
        baguera.andar();
        baguera.andar();
        baguera.bomber();
        System.out.println(baguera);
        baguera.descansar();
        baguera.andar();
        baguera.presente();
        baguera.descansar();
        baguera.andar();
        baguera.bomber();
        baguera.descansar();
        baguera.andar();
        System.out.println(baguera);
    }
}
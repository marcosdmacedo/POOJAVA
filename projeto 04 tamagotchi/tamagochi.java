import java.util.Random;
import java.util.Scanner;

class Poderes {
    int energy;
    int energyMax;
    int fome;
    int fomeMax;
    int limpeza;
    int limpezaMax; 
    boolean vivo;

    Poderes (int energy, int fome, int limpeza ){
        this.energy = energy;
        this.energyMax = energy;
        this.fome = fome;
        this.fomeMax = fome;
        this.limpeza = limpeza;
        this.limpezaMax = limpeza;
        this.vivo = true;

    }

    void morreu(){
        if(vivo == false){
        }
    }

    void barrasono(){
    if(energy < energyMax){
            energy = energyMax;
        }
    }
       
    public void comida(){
        Random random = new Random();
        int multicomida = random.nextInt(5);

        if(fome < fomeMax){
            fome += multicomida;
            limpeza -= 2;
            energy -= 1;
        }
    }

    public void brincar(){
        if(energy <= energyMax){
            energy -= 4;
            limpeza -= 3;
            fome -= 2;
        }
    }
 
    public void banho(){
        if(limpeza <= limpezaMax){
            energy -= 3;
            fome -= 1;
            limpeza = limpezaMax;
        }
    }
    public String toString(){
        return "Energia: " + energy + "/" + energyMax + " Fome: " + fome + "/" + fomeMax +  " Limpo: " + limpeza + "/" + limpezaMax;
        
    }
}
 class tamagotchi {


    public static void main (String []args){
        Poderes tamagotchi = new Poderes(20,30,50);
        Scanner scanner = new Scanner (System.in);
        System.out.println("---Ola eu sou seu pet---");
        System.out.println("---Venha cuidar de mim pfv!!!---");
        System.out.println("---Eu preciso COMER, DORMIR, TOMAR BANHO e BRINCAR---");
        System.out.println("---Espero que eu não me machuque :´( ---");
        System.out.println("---Hoje tem !!!---");

        while(true){
            String line = scanner.nextLine();
            String[] command = line.split(" ");

            if(command[0].equals("end")) {
                break;
            }else if(command[0].equals("comer")) {
                tamagotchi.comida();
                System.out.println(tamagotchi);
            }else if(command[0].equals("dormir")) {
                tamagotchi.barrasono();
                System.out.println(tamagotchi);
            }else if(command[0].equals("brincar")) {
                tamagotchi.brincar();
                System.out.println(tamagotchi);
            }else if(command[0].equals("banho")){
                tamagotchi.banhinho();
                System.out.println(tamagotchi);
            } 
        }    
         scanner.close(); 
    }
}
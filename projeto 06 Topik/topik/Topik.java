package topik;
import java.util.ArrayList;

//-------------------------------------------------------------------------------------------------------
public class Topik{
    ArrayList<Pessoa> cadeiras;
    ArrayList<Pessoa> cadeirasPref;

    public Topik(int qmax, int qpref){
        cadeiras = new ArrayList<>();
        cadeirasPref = new ArrayList<>();
        for(int i=0; i<qmax; i++){
            if(i<qpref)
                cadeirasPref.add(null);
            else
                cadeiras.add(null);
        }
        
    }
    public boolean entrar(Pessoa pessoa){
        if(pessoa.getIdade() >= 70){
            for(int i = 0; i < cadeirasPref.size(); i++){
                if(cadeirasPref.get(i) == null){
                    System.out.println("sente-se senhor(a), temos vagas preferenciais!");
                    cadeirasPref.set(i, pessoa);
                    return true;
                }
            }
        }
        
        for(int i=0; i < cadeiras.size(); i++){
            if(cadeiras.get(i) == null){
                System.out.println("Tem vaga nas cadeiras normais, sente-se senhor");
                cadeiras.set(i, pessoa);
                return true;
            }
        }
        for(int i = 0; i < cadeirasPref.size(); i++){
            if(cadeirasPref.get(i) == null){
                System.out.println("Só temos vagas nas prefenciais, mais por enquanto sente-se");
                cadeirasPref.set(i, pessoa);
                return true;
            }
        }
        System.out.println("A Topik está lotada!");
        return false;
        }
    public Pessoa descer(String nome){
        Pessoa pessoaAux;
        for(int i = 0; i < cadeiras.size(); i++){
            if(cadeiras.get(i).getNome().equals(nome)){
                System.out.println("Essa Pessoa está nas cadeiras NÂO prefenrenciais!");
                pessoaAux = cadeiras.get(i);
                cadeiras.remove(i);
                return pessoaAux;
            }
        }
        for(int i = 0; i < cadeirasPref.size(); i++){
            if(cadeirasPref.get(i).getNome().equals(nome)){
                System.out.println("Pessoa encontrada na fila preferencial");
                pessoaAux = cadeirasPref.get(i);
                cadeirasPref.remove(i);
                return pessoaAux;
            }
        }
        System.out.println("Essa pessoa NÂO está nesta Topik!");
        pessoaAux = null;
        return pessoaAux;
        }
    public void parar(){
        System.out.println("Vamos encerrar por hoje!");
        cadeiras.removeAll(cadeiras);
        cadeirasPref.removeAll(cadeirasPref);
        System.out.println("todas as pessoas desceram, as cadeiras estão livres!");
        return;
    }
    public String toString(){
        String saida = "[ ";
        for(Pessoa pessoa : cadeirasPref){
            if(pessoa != null)
                saida += pessoa + " ";
            else
                saida += "@ ";
        }
        for(Pessoa pessoa : cadeiras){
            if(pessoa != null)
                saida += pessoa + " ";
            else
                saida += "= ";
        }
        return saida + "]";
    }
}
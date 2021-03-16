import java.util.ArrayList;

public class Contato {
    private String name;
    private ArrayList<Fone> fones;

    public Contato(String nome) {
        this.name = nome;
        this.fones = new ArrayList<>();
    }

    public Contato(String id, ArrayList<Fone> fones) {
        this.name = id;
        this.fones = fones;
    }

    public ArrayList<Fone> getFones() {
        return fones;
    }

    public String getName() {
        return name;
    }

    public void addFone(String nome, String number) {
        if (!Fone.validaNum(number)) {
            throw new IndexOutOfBoundsException("Número invalido");
        }
        this.fones.add(new Fone(nome, number));
    }

    public void addFones(ArrayList<Fone> fone) {
        for (Fone foness : fone) {
            addFone(foness.getLabel(), foness.getNumber());
        }
    }

    public boolean rmFone(int index) {
        try {
            fones.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro, digite um index valido!");
        }

        return true;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        for (int i = 0; i < fones.size(); i++) {
            saida.append("[").append(i).append(":").append(fones.get(i).getLabel()).append(":")
                    .append(fones.get(i).getNumber()).append("]");
        }
        return saida.toString();
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        AgendaPlus agendaPlus = new AgendaPlus();
        Scanner aux= new Scanner(System.in);
        while (true) {
            String ler = aux.nextLine();
            String[] up = ler.split(" ");
            try {
                if (up[0].equalsIgnoreCase("sair"))
                    break;

                else if (up[0].equalsIgnoreCase("addContato")) {
                    ArrayList<Fone> fones = new ArrayList<>();
                    for (int i = 2; i < up.length; i++) {
                        System.out.println(up);
                        String operadora = up[i].split(":")[0];
                        String numero = up[i].split(":")[1];
                        fones.add(new Fone(operadora, numero));
                    }
                    agendaPlus.addContato(up[1], fones);
                }
                else if (up[0].equalsIgnoreCase("Favoritar"))
                    agendaPlus.bookmark(up[1]);

                else if (up[0].equalsIgnoreCase("Pattern"))
                    System.out.println(agendaPlus.search(up[1]));

                else if (up[0].equalsIgnoreCase("desfavoritar"))
                    agendaPlus.unbookmark(up[1]);

                else if (up[0].equalsIgnoreCase("rmCont"))
                    agendaPlus.RemoveCont(up[1]);

                else if (up[0].equalsIgnoreCase("procurarCont"))
                    System.out.println(agenda.getContatos(up[1]));

                else if (up[0].equalsIgnoreCase("procurarbookmark") || up[0].equalsIgnoreCase("procurarfavorito"))
                    System.out.println(agendaPlus.searchBookmark(up[1]));

                else if (up[0].equalsIgnoreCase("rmFone"))
                    agendaPlus.rmFone(up[1], Integer.parseInt(up[2]));

                else if (up[0].equalsIgnoreCase("mostrar") || up[0].equalsIgnoreCase("show"))
                    System.out.println(agendaPlus);
            } catch (ArrayIndexOutOfBoundsException w) {
                w.printStackTrace();
                System.out.println("Problema nos Arrays"); //tryCatch //se aconter algum erro no array
            } catch (NullPointerException e) {
                System.out.println(e.toString());
            } catch (IndexOutOfBoundsException z) {
                System.out.println(z.toString());
            }
        }
        aux.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Controller controller = new Controller();
        Scanner aux = new Scanner(System.in);
        while (true) {
            String escolha = aux.nextLine();
            String[] up = escolha.split(" ");

            try {
                if (up[0].equalsIgnoreCase("end"))
                    break;

                else if (up[0].equalsIgnoreCase("SendTweet")) {
                    StringBuilder solver = new StringBuilder();
                    for (int i = 2; i < up.length; i++)
                        solver.append(up[i]).append(" ");
                    controller.sendTweet(up[1], solver.toString());
                }

                else if (up[0].equalsIgnoreCase("addUser"))
                    controller.addUser(up[1]);

                else if (up[0].equalsIgnoreCase("getUser"))
                    controller.getUser(up[1]);

                else if (up[0].equalsIgnoreCase("follow"))
                    controller.follow(up[1], up[2]);

                else if (up[0].equalsIgnoreCase("unfollow"))
                    controller.unfollow(up[1], up[2]);

                else if (up[0].equalsIgnoreCase("like"))
                    controller.like(up[1], Integer.parseInt(up[2]));

                else if (up[0].equalsIgnoreCase("unread"))
                    System.out.println(controller.unread(up[1]));

                else if (up[0].equalsIgnoreCase("timeline"))
                    System.out.println(controller.timeLine(up[1]));

                else
                    System.out.println("Opition invalidate");

            } catch (IndexOutOfBoundsException y) {
                System.out.println("Index invalido");
            } catch (Exception z) {
                System.out.println(z.toString());
            }
        }
        aux.close();
    }
}

package feladat01;

        import java.io.DataInputStream;
        import java.io.DataOutputStream;
        import java.io.IOException;
        import java.net.Socket;
        import java.util.Scanner;

public class Kliens {

    public static void main(String[] args) {
        try {
            Socket kapcsolat = new Socket("localhost", 8080);
            DataInputStream szervertol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream szervernek = new DataOutputStream(kapcsolat.getOutputStream());

            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Kérem adja meg a kör sugarát: ");
                int sugar = sc.nextInt();
                szervernek.writeInt(sugar);
                szervernek.flush();
                System.out.printf("Szervertől a kerület: %.2f\n", szervertol.readDouble());
                System.out.printf("Szervertől a terület: %.2f\n\n", szervertol.readDouble());
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

}

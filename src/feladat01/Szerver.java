package feladat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Szerver {

    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8080);
            Socket kapcsolat = socket.accept();
            DataInputStream klienstol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream kliensnek = new DataOutputStream(kapcsolat.getOutputStream());

            while (true) {
                int sugar = klienstol.readInt();
                kliensnek.writeDouble(korKerulete(sugar));
                kliensnek.writeDouble(korTerulete(sugar));
                kliensnek.flush();
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    private static double korKerulete(int sugar) {
        return 2 * sugar * Math.PI;
    }


    private static double korTerulete(int sugar) {
        return sugar * sugar * Math.PI;
    }

}

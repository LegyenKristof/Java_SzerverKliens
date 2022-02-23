package feladat2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class UgyfelKiszolgalo implements Runnable{
    Socket kapcsolat;

    public UgyfelKiszolgalo(Socket kapcsolat) {
        this.kapcsolat = kapcsolat;
    }

    @Override
    public void run() {
        try {
            DataInputStream klienstol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream kliensnek = new DataOutputStream(kapcsolat.getOutputStream());

            while (true) {
                int a = klienstol.readInt();
                int b = klienstol.readInt();
                int menu;
                do {
                    menu = klienstol.readInt();
                    switch (menu) {
                        case 1:
                            kliensnek.writeUTF("A téglalap kerülete: " + ((a + b) * 2));
                            break;
                        case 2:
                            kliensnek.writeUTF("A téglalap területe: " + (a * b));
                            break;
                        case 3:
                            kliensnek.writeUTF((a == b) ? "A téglalap négyzet" : "A téglalap nem négyzet");
                            break;
                        case 4:
                            kliensnek.writeUTF("A téglalap átlójának mérete: " + Math.sqrt(a * a + b * b));
                            break;
                        case 5:
                            kliensnek.writeUTF("Kilépés");
                            break;
                    }
                    kliensnek.flush();
                }
                while (menu != 5);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

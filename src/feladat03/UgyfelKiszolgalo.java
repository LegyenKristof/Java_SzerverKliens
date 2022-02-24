package feladat03;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class UgyfelKiszolgalo implements Runnable{
    Socket kapcsolat;

    public UgyfelKiszolgalo(Socket kapcsolat) {
        this.kapcsolat = kapcsolat;
    }
    private List<Indian> lista;

    @Override
    public void run() {
        beolvas();
        try {
            DataInputStream klienstol = new DataInputStream(kapcsolat.getInputStream());
            DataOutputStream kliensnek = new DataOutputStream(kapcsolat.getOutputStream());

            int menu;
            do {
                menu = klienstol.readInt();
                switch (menu) {
                    case 1:
                        String s = "";
                        for(Indian i : lista) s += i.toString() + "\n";
                        kliensnek.writeUTF(s);
                        break;
                    case 2:
                        kliensnek.writeUTF(lista.size() + "");
                        break;
                }
                kliensnek.flush();
            } while (menu != 0);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void beolvas() {
        lista = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("indianok.txt"));
            String sor = br.readLine();
            while (sor != null){
                lista.add(new Indian(sor));
                sor = br.readLine();
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package feladat03;

import java.util.ArrayList;

public class Indian {
    private String nev;
    private String torzs;
    private String nem;
    private int eletkor;
    private ArrayList<String> tulajdonok;

    public Indian(String sor) {
        String[] adatok = sor.split(";");
        nev = adatok[0];
        torzs = adatok[1];
        nem = adatok[2].equals("n") ? "nő" : "férfi";
        eletkor = Integer.parseInt(adatok[3]);
        tulajdonok = new ArrayList<>();
        for (int i = 4; i < adatok.length; i++) {
            tulajdonok.add(adatok[i]);
        }
    }

    public String getNev() {
        return nev;
    }

    public String getTorzs() {
        return torzs;
    }

    public String getNem() {
        return nem;
    }

    public int getEletkor() {
        return eletkor;
    }

    public ArrayList<String> getTulajdonok() {
        return tulajdonok;
    }

    @Override
    public String toString() {
        String s = "";
        for(String item : tulajdonok) s += " " + item;
        return String.format("%s, %s, %s, %d, tulajdonok: %s", nev, torzs, nem, eletkor, s);
    }
}

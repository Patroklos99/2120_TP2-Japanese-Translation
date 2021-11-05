import java.io.*;
import java.util.ArrayList;

public class Syllabe {
    protected ArrayList<String> tab;
    protected ArrayList<String> tabSyllabes = new ArrayList<>();
    protected ArrayList<String> tabUnicodes = new ArrayList<>();


    public Syllabe(ArrayList<String> tab) {
        this.tab = tab;
        remplirTableaux();
    }

    private void remplirTableaux() {
        System.out.println(tab);
        remplirTabSyllabe();
        trierSyllabesAlphabet();
        ecrireHtml();
    }

    private void ecrireHtml() {
        String htmlDebut = "<!DOCTYPE html>\n<html>\n    <head>\n        <title>TP 2</title>\n" +
                "    </head>\n    <body style=\"writing-mode: vertical-lr; text-orientation: upright;\">" +
                "\n        <hr>\n        <table>\n    <tr>\n        <dt>\n";
        String htmlFin = "\n        </table>\n        <hr>\n    </body>\n</html>";
        File f = new File("./text.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(htmlDebut);
            for (int i = 0; i < tabUnicodes.size(); i++) {
                bw.write(tabUnicodes.get(i) + "\n");
            }
            bw.write(htmlFin);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void trierSyllabesAlphabet() {
        for (String syllabe : tabSyllabes) {
            if (Character.toString(syllabe.charAt(0)).matches("[a-z]")) {
                Hiragana hiragana = new Hiragana(syllabe);
                tabUnicodes.add(hiragana.toString());
            } else {
                Katakana katakana = new Katakana(syllabe);
                tabUnicodes.add(katakana.toString());
            }
        }
    }


    private void remplirTabSyllabe() {
        for (int i = 0; i < tab.size(); i++) {
            String ligne = tab.get(i);
            ligne += "-+";
            for (int j = 0; j + 1 < ligne.length(); j++) {
                if (Character.toString(ligne.charAt(j)).matches("[aeiou]|[-]")) {
                    tabSyllabes.add(Character.toString(ligne.charAt(j)));
                    //System.out.println("" + (ligne.charAt(j)));
                    j++;
                } else if (Character.toString(ligne.charAt(j + 1)).matches("[aeiou]") &&
                        Character.toString(ligne.charAt(j)).matches("[(?![aeiou])[a-zA-Z]]")) {
                    tabSyllabes.add("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)));
                    //System.out.println("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)));
                    j += 2;
                } else if (Character.toString(ligne.charAt(j + 2)).matches("[aeiou]") &&
                        Character.toString(ligne.charAt(j + 1)).matches("[yhs]")) {
                    tabSyllabes.add("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)) + ((ligne.charAt(j + 2))));
                    //System.out.println("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)) + (ligne.charAt(j + 2)));
                    j += 3;
                } else {
                    System.out.println("Il semble avoir une syllabe non valide. Le programme se terminera.");
                    System.exit(-1);
                }
                j--;
            }
        }
        System.out.println(tabSyllabes);
    }

}


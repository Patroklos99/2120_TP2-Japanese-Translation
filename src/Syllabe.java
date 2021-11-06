import java.io.*;
import java.util.ArrayList;

public class Syllabe {
    private static final String HTML_DEBUT = "<!DOCTYPE html>\n<html>\n    <head>\n        <title>TP 2</title>\n" +
            "    </head>\n    <body>\n        <hr>\n        <table>\n    <tr>\n        <dt>\n";
    private static final String HTML_FIN = "\n        </table>\n        <hr>\n    </body>\n</html>";
    protected ArrayList<String> tab;
    protected ArrayList<String> tabSyllabes = new ArrayList<>();
    protected ArrayList<String> tabUnicodes = new ArrayList<>();

    public Syllabe(ArrayList<String> tab) {
        this.tab = tab;
        remplirTableaux();
    }

    private void remplirTableaux() {
        validerTabNonVide();
        trierSyllabeAlphabets();
        ecrireHtml();
    }

    private void ecrireHtml() {
        File f = new File("./text.html");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            bw.write(HTML_DEBUT);
            for (int i = 0; i < tabUnicodes.size(); i++) {
                bw.write(tabUnicodes.get(i) + "\n");
            }
            bw.write(HTML_FIN);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void trierSyllabeAlphabets() {
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

    private void ajouterFinLigne() {
        tabSyllabes.add("-");
    }

    private void validerTabNonVide() {
        while (!elements()) {
            retirerBlocTexte();
            ajouterFinLigne();
        }
        System.out.println(tabSyllabes);
    }

    private void retirerBlocTexte() {
        for (int i = 0; i < tab.size(); i++) {
            if (!(tab.get(i).length() == 0)) {
                String ligne = tab.get(i);
                ajouterBlocSyllabeTab(ligne, i);
            } else
                ajouterEspaceVide();
        }
    }


    private void ajouterBlocSyllabeTab(String ligne, int i) {
        if (Character.toString(ligne.charAt(0)).matches("[aeiou]|[AEIOU]|[-]")) {
            tabSyllabes.add(Character.toString(ligne.charAt(0)));
            reecrireElementTextUn(ligne, i);
        } else if ((Character.toString(ligne.charAt(1)).matches("[aeiou]|[AEIOU]") &&
                Character.toString(ligne.charAt(0)).matches("[(?![aeiou])[a-zA-Z]]")) ||
                (Character.toString(ligne.charAt(1)).matches("[']") &&
                        Character.toString(ligne.charAt(0)).matches("[n]|[N]"))) {
            tabSyllabes.add("" + (ligne.charAt(0)) + (ligne.charAt(1)));
            reecrireElementTextDeux(ligne, i);
        } else if (Character.toString(ligne.charAt(2)).matches("[aeiou]|[AEIOU]") &&
                Character.toString(ligne.charAt(1)).matches("[yhs]|[YHS]")) {
            tabSyllabes.add("" + (ligne.charAt(0)) + (ligne.charAt(1)) + ((ligne.charAt(2))));
            reecrireElementTextTrois(ligne, i);
        } else {
            System.out.println("Il semble avoir une syllabe non valide. Le programme se terminera.");
            System.exit(-1);
        }
    }

    private void reecrireElementTextTrois(String ligne, int i) {
        tab.set(i, ligne.substring(3));
    }

    private void reecrireElementTextDeux(String ligne, int i) {
        tab.set(i, ligne.substring(2));
    }

    private void reecrireElementTextUn(String ligne, int i) {
        tab.set(i, ligne.substring(1));
    }

    private void ajouterEspaceVide() {
        tabSyllabes.add("@");
    }

    private boolean elements() {
        boolean decision = true;
        for (String s : tab) {
            if (!(s.length() == 0)) {
                decision = false;
            }
        }
        return decision;
    }

}


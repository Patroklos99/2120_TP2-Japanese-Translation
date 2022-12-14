import java.io.*;
import java.util.ArrayList;

/**
 * Classe qui contient toutes les methodes se rapportant aux syllabes
 */
public class Syllabe {
    private static final String HTML_DEBUT = "<!DOCTYPE html>\n<html>\n    <head>\n        <title>TP 2</title>\n" +
            "    </head>\n    <body>\n        <hr>\n        <table>\n    <tr>\n";
    private static final String HTML_FIN = "        </table>\n        <hr>\n    </body>\n</html>";
    private ArrayList<String> tab;
    private String nom;
    private ArrayList<String> tabSyllabes = new ArrayList<>();
    private ArrayList<String> tabUnicodes = new ArrayList<>();


    /**
     * Construit la classe syllabe, déclanche la methode primordiale.
     *
     * @param tab tableau contenant les lignes de textes du fichier recu.
     * @param nom var contenant le nom du fichier recu.
     */
    public Syllabe(ArrayList<String> tab, String nom) {
        this.tab = tab;
        this.nom = nom;
        remplirTableaux();

    }

    /**
     * Declanche les methodes principales de la classe. Remplir tab, trier et ecrire html.
     */
    private void remplirTableaux() {
        validerTabNonVide();
        trierSyllabeAlphabets();
        ecrireHtml();
    }

    /**
     * Convertit le nom fichier recu en string "nomDuFichier.html"
     *
     * @param nom nom du fichier recu à modifier
     * @return string de format nomDuFichier.html
     */
    private String obtenirNom(String nom) {
        String nouveauNom = nom.substring(0, nom.indexOf("."));
        return nouveauNom + ".html";
    }


    /**
     * Écrit le fichier de sortie html de bon format et ses unicodes.
     * <code>file var qui aide à l'ecriture des strings dans .html</code>
     */
    private void ecrireHtml() {
        File file = new File(obtenirNom(nom));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(HTML_DEBUT);
            for (String unicode : tabUnicodes) {
                if (!unicode.equals("    </tr>\n    <tr>\n"))
                    bw.write("        <td>" + unicode + "</td>\n");
                else
                    bw.write(unicode);
            }
            bw.write(HTML_FIN);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Trie les syllabes et ecrit leur unicodes dans tabUnicodes
     */
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

    /**
     * Ajoute caractere de repere qui equivaut à fin de ligne dans le HashMap.
     */
    private void ajouterFinLigne() {
        tabSyllabes.add("-");
    }

    /**
     * Valide que le tableau ne soit pas vide, si non declanche retirerBlocTexte
     */
    private void validerTabNonVide() {
        while (!elementVide()) {
            retirerBlocTexte();
            ajouterFinLigne();
        }
        //System.out.println(tabSyllabes);
    }


    /**
     * Retire et transforme en String les element du tableau de textes.
     */
    private void retirerBlocTexte() {
        for (int i = 0; i < tab.size(); i++) {
            if (!(tab.get(i).length() == 0)) {
                String ligne = tab.get(i);
                ajouterBlocSyllabeTab(ligne, i);
            } else
                //ajout du caractere representant un espace vide dans le HashMap
                ajouterEspaceVide();
        }
        //System.out.println(tab);
    }


    /**
     * Ajoute les differents types de syllabes valides dans tabSyllabes.
     *
     * @param ligne String de la ligne de texte utilisée pour trouver les syllabes
     * @param i     position dans l'arraylist du tableau de textes fournis.
     */
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
                Character.toString(ligne.charAt(1)).matches("[yhjs]|[YHJS]")) {
            tabSyllabes.add("" + (ligne.charAt(0)) + (ligne.charAt(1)) + ((ligne.charAt(2))));
            reecrireElementTextTrois(ligne, i);
        } else {
            System.out.println("Il semble avoir une syllabe non valide. Le programme se terminera.");
            System.exit(-1);
        }
    }


    /**
     * Reecrit l'element texte du tableau tab en elevant la syllabe à trois chars valide.
     *
     * @param ligne String (element Tab) à modifier
     * @param i     position de l'element Tab traité.
     */
    private void reecrireElementTextTrois(String ligne, int i) {
        tab.set(i, ligne.substring(3));
    }

    /**
     * Reecrit l'element texte du tableau tab en elevant la syllabe à deux chars valide.
     *
     * @param ligne String (element Tab) à modifier
     * @param i     position de l'element Tab traité.
     */
    private void reecrireElementTextDeux(String ligne, int i) {
        tab.set(i, ligne.substring(2));
    }

    /**
     * Reecrit l'element texte du tableau tab en elevant la syllabe à un char valide.
     *
     * @param ligne String (element Tab) à modifier
     * @param i     position de l'element Tab traité.
     */
    private void reecrireElementTextUn(String ligne, int i) {
        tab.set(i, ligne.substring(1));
    }


    /**
     * Ajout caractere de repere qui equivaut à espace vide dans le HashMap.
     */
    private void ajouterEspaceVide() {
        tabSyllabes.add("@");
    }


    /**
     * Verifie si l'element (i) du tab est vide
     *
     * @return bouleen dependant si l'element est vide
     */
    private boolean elementVide() {
        boolean decision = true;
        for (String s : tab) {
            if (!(s.length() == 0))
                decision = false;
        }
        return decision;
    }

}
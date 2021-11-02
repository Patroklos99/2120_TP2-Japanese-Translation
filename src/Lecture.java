import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


/**
 * Classe ou la lecture et l'ecriture ainsi que les configurations necessaires/liées à ceux-ci se retrouvent.
 */
public class Lecture {

    /**
     * Initialise les configurations pour la lecture et l'ecriture du fichier fourni.
     *
     * @param nom Nom du fichier fourni.
     * @return Arraylist simple contenant les valeurs du fichier lu.
     * <code>var sc, contiendra les valeurs lus. </code>
     */
    public static ArrayList lireFichier(String nom) {
        ArrayList<String> tab = new ArrayList<>();
        try {
            Path path = FileSystems.getDefault().getPath(nom);
            verifierFichier(path);
            Scanner sc = new Scanner(Files.newBufferedReader(path));
            ecrireValeurs(sc, tab);
            verifierSyllabe(tab);
            sc.close();
        } catch (InvalidPathException e) {
            // Traitement d'erreur ici.
        } catch (IOException e) {
            // Traitement d'erreur ici.
        }
        return tab;
    }

    private static void verifierSyllabe(ArrayList tab) {
        String ligne = tab.get(0).toString();;
        ligne = enleverEspaces(ligne);
        System.out.println(ligne.length());
        for (int i = 1; i < ligne.length(); i++) {
            i = validerSyllabeSimple(ligne, i);
            i = validerSyllabecomposé(ligne, i);
            i = validerSyllabeN(ligne, i);
            i = validerSyllabeUnique(ligne, i);
            i++;
        }

    }

    private static int validerSyllabeUnique(String ligne, int i) {
        if (i < ligne.length()-1) {
            if ((String.valueOf(ligne.charAt(i))).matches("[aeiou]") &&
                    (String.valueOf(ligne.charAt(i + 1))).matches("[aeiou]")) {
                System.out.println("silaba unica: " + (ligne.charAt(i)));
                i++;
            }
        }
        return i;
    }

    private static int validerSyllabeN(String ligne, int i) {
        if ((String.valueOf(ligne.charAt(i))).matches("[n]") &&
                (String.valueOf(ligne.charAt(i+1))).matches("[']")){
            i++;
        }
        return i;
    }

    private static int validerSyllabecomposé(String ligne, int i) {

        if ((String.valueOf(ligne.charAt(i))).matches("[yh]")) {
            i++;
            if (!(String.valueOf(ligne.charAt(i))).matches("[aeiouy]")) {
                finirProgramme();
            }
            System.out.print((ligne.charAt(i-2)));
            System.out.print((ligne.charAt(i-1)));
            System.out.print((ligne.charAt(i)));
            System.out.println();
        }
        return i;
    }

    private static int validerSyllabeSimple(String ligne, int i) {
        if (!(String.valueOf(ligne.charAt(i - 1))).matches("[(?![aeiouy])[a-z]]") ||
                !((String.valueOf(ligne.charAt(i))).matches("[aeiouyh']"))) {
            finirProgramme();
        }
        System.out.print((ligne.charAt(i-1)));
        System.out.print((ligne.charAt(i)));
        System.out.println();
        return i++;
    }

    private static String enleverEspaces(String ligne) {
        return ligne.replaceAll(" ", "");
    }

    /**
     * Verifie si le fichier existe, appelle une autre methode pour l'arret du programme s'il n'existe pas!.
     *
     * @param path contient le chemin relatif du fichier fourni.
     *             <code>file, contient le chemin relatif du fichier fourni, sert à verifier l'existance de celui-ci</code>
     */
    private static void verifierFichier(Path path) {
        File file = new File(String.valueOf(path));
        if (!file.exists())
            msgErrFichier();
        if (!file.toString().matches("^.*\\.(txt)$"))
            System.out.println("Le fichier nest pas de format \".txt\" Le programme se terminera, bonne journnée.");
    }


    /**
     * Ecrit les valeurs du fichier fourni dans un seul tableau.
     *
     * @param sc objet de type scanner, sert a verifier le contenu des lignes lues du fichier.
     * @param tab tableau ou les valeurs seront placées.
     */
    public static void ecrireValeurs(Scanner sc, ArrayList tab) {
        while (sc.hasNextLine()) {
            if (sc.hasNextLine())
                tab.add(sc.nextLine());
            else {
                tab.add(sc.nextLine());
                errListe(tab);
            }
        }
    }


    /**
     * Affiche msg d'erreur si le fichier n'existe pas et informe l'usager des possibles erreurs dans la saisie.
     * Termine aussi le programme.
     */
    public static void msgErrFichier() {
        System.out.println("Erreur, le fichier ne semble pas exister, le programme terminera." +
                " S'il existe veuillez le reecrire tout de suite apres le message" +
                " d'entree, sans faire espace ou Enter.");
        System.exit(-1);
    }

    /**
     * Verifie si le contenu du tabValeur est valide, autrement il affiche un message d'erreur et arrete le programme.
     *
     * @param tab tableau ou les valeurs du fichier sont deja placées.
     */
    public static void errListe(ArrayList tab) {
        for (int i = 0; i <= tab.size(); i++) {
            if (!tab.get(i).toString().matches("[0-9]+")) {
                System.out.println("Erreur, Il y a un objet inattendu dans votre liste.");
                System.exit(-1);
            }
        }
    }

    public static void finirProgramme() {
        System.out.println("Erreur, Il y a un objet innattendu dans votre liste, le programme se termineraaa");
        System.exit(-1);
    }

}

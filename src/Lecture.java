import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
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
            ajouterPhrasesTab(sc, tab);
            validerPhrases(tab);
            sc.close();
        } catch (InvalidPathException e) {
            // Traitement d'erreur ici.
        } catch (IOException e) {
            // Traitement d'erreur ici.
        }
        return tab;
    }

    /**
     * Valide que seulement les characteres valides soient présents dans le fichier fourni
     *
     * @param tab tableau contenant les phrases du fichier à verifier.
     */
    private static void validerPhrases(ArrayList tab) {
        enleverEspaces(tab);
        reoordonerTab(tab);
        for (Object o : tab) {
            if (!o.toString().matches("^([a-zA-Z]+([']+|[’]+)?([a-zA-Z]+)?)+") ||
                    Character.toString(o.toString().charAt(0)).matches("[']|[’]"))
                finirProgramme();
        }
    }

    private static void reoordonerTab(ArrayList tab) {
        Collections.reverse(tab);
    }

    /**
     * Enleve les espaces de chaque element(texte) du tableau.
     *
     * @param tab tableau contenant les phrases du fichier à verifier.
     */
    private static void enleverEspaces(ArrayList tab) {
        tab.removeAll(Collections.singleton(""));
        for (int i = 0; i < tab.size(); i++) {
            String ligne = tab.get(i).toString();
            ligne = ligne.replaceAll(" ", "");
            tab.set(i, ligne);
        }
    }

    /**
     * Verifie si fichier existe si bon format, appelle autre methode pour l'arret du programme s'il n'existe pas.
     *
     * @param path contient le chemin relatif du fichier fourni.
     *             <code>file, contient le chemin relatif du fichier fourni, sert à verifier l'existance de celui-ci</code>
     */
    private static void verifierFichier(Path path) {
        File file = new File(String.valueOf(path));
        if (!file.exists())
            msgErrFichier();
        if (!file.toString().matches("^.*\\.(txt)$")) {
            System.out.println("Le fichier nest pas de format \".txt\" Le programme se terminera, bonne journnée.");
            System.exit(-1);
        }
        fichierVide(file);
    }

    /**
     * Ajoute la ligne de texte du fichier fourni dans le tableau.
     *
     * @param sc  var qui aide à la saisie des lignes des textes.
     * @param tab tableau ou les lignes de textes seront stockées.
     */
    public static void ajouterPhrasesTab(Scanner sc, ArrayList tab) {
        while (sc.hasNextLine()) {
            tab.add(sc.nextLine());
        }
    }

    /**
     * Verifie si le fichier est vide, arrête le programme si cest le cas.
     *
     * @param file var utilisée pour verifier si le fichier est vide.
     */
    private static void fichierVide(File file) {
        if (file.length() == 0) {
            System.out.println("Le fichier semble être vide, le programme se terminera.");
            System.exit(-1);
        }
    }

    /**
     * Affiche msg d'erreur si le fichier n'existe pas et termine le programme.
     */
    public static void msgErrFichier() {
        System.out.println("Erreur, le fichier ne semble pas exister, le programme terminera." +
                " S'il existe veuillez le reecrire tout de suite apres le message" +
                " d'entree, sans faire espace ou Enter.");
        System.exit(-1);
    }

    /**
     * Affiche msg d'erreur, Termine le programme.
     */
    public static void finirProgramme() {
        System.out.println("Erreur, Il y a un objet inattendu dans votre liste, le programme se terminera.");
        System.exit(-1);
    }

}

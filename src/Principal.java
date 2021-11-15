import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    /** Lance le programme principal et tous le code source du deroulement
     *
     * @param args
     * <code>var nom, string du nom du fichier ecrit par l'usager</code>
     */
    public static void main(String[] args) {
        msgEntree();
        Scanner clavier = new Scanner( System.in );
        String nom = clavier.nextLine();
        clavier.close();
        ArrayList<String> tab = Lecture.lireFichier(nom);
        Syllabe syllabe = new Syllabe(tab, nom);
        //reechantillonage(tab);
    }

    /**
     * Affiche le message initial informatif pour l'usager.
     */
    public static void msgEntree(){
        System.out.println("\nVeuillez entrer le nom de votre fichier dans le terminal (suivi de son suffixe s'il " +
                " possede un):");
    }

}

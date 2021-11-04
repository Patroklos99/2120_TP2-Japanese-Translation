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
        Syllabe syllabe = new Syllabe(tab);
        //reechantillonage(tab);
    }


    /** Trie le tableau des valeurs du fichier lu vers la classe correspondate.
     *
     * @param tab tableau (arraylist) contenant les valeurs du fichier lu.
     */
    /*public static void reechantillonage(ArrayList<Double> tab){
        if(tab.get(0) == 1)
            creerClasseDegreUn(tab);
        else if(tab.get(0) == 2)
            creerClasseDegreDeux(tab);
        else if(tab.get(0) == 3)
            creerClasseDegreTrois(tab);
        else
            Echantillonage.erreur();
    }*/

    /**
     * Affiche le message initial informatif pour l'usager.
     */
    public static void msgEntree(){
        System.out.println("\nVeuillez entrer le nom de votre fichier dans le terminal (suivi de son suffixe s'il " +
                " possede un):");
    }

}

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
        remplirTabSyllabe();
        trierSyllabesAlphabet();

    }

    private void trierSyllabesAlphabet() {
        for (String syllabe : tabSyllabes) {
            //System.out.println(syllabe);
            if (Character.toString(syllabe.charAt(0)).matches("[a-z]")) {
                Hiragana hiragana = new Hiragana(syllabe);
                tabUnicodes.add(hiragana.toString());
                System.out.println(hiragana);
            }
            else {
                Katakana katakana = new Katakana(syllabe);
            }
        }
        System.out.println(tabUnicodes);

    }

    private void remplirTabSyllabe() {
        System.out.println(tab);

        for (int i = 0; i < tab.size(); i++) {
            String ligne = tab.get(i);
            for (int j = 0; j + 1 < ligne.length(); j++) {
                if (Character.toString(ligne.charAt(j)).matches("[aeiou]")) {
                    tabSyllabes.add(Character.toString(ligne.charAt(j)));
                    System.out.println("" + (ligne.charAt(j)));
                    j++;
                } else if (Character.toString(ligne.charAt(j + 1)).matches("[aeiou]") &&
                        Character.toString(ligne.charAt(j)).matches("[(?![aeiou])[a-zA-Z]]")) {
                    tabSyllabes.add("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)));
                    System.out.println("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)));
                    j += 2;
                } else if (Character.toString(ligne.charAt(j + 2)).matches("[aeiou]") &&
                        Character.toString(ligne.charAt(j + 1)).matches("[yhs]")) {
                    tabSyllabes.add("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)) + ((ligne.charAt(j + 2))));
                    System.out.println("" + (ligne.charAt(j)) + (ligne.charAt(j + 1)) + (ligne.charAt(j + 2)));
                    j += 3;
                } else {
                    System.out.println("pas une syllabe valide");
                    System.exit(-1);
                }
                j--;
            }
        }
    }

}


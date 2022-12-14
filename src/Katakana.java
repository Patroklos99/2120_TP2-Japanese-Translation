import java.util.*;

/**
 * Classe contenant toutes les methodes se rapportant aux syllabes katakana.
 */
public class Katakana {
    private String syllabe;
    private String syllabeUnicode;
    private Map<String, String> tabKatakana = new HashMap<>();

    /**
     * Construit la classe katakana, declanche methodes primordiales.
     *
     * @param syllabe syllabe à structure valide à trouver dans le hashMap.
     */
    public Katakana(String syllabe) {
        this.syllabe = syllabe;
        remplirTabKatakana();
        obtenirUnicode();
    }


    /**
     * Obtient unicode, s'il existe , à partir de la syllabe fournie et le place dans une variable.
     */
    private void obtenirUnicode() {
        syllabe = syllabe.toLowerCase();
        if (tabKatakana.containsKey(syllabe)) {
            syllabeUnicode = tabKatakana.get(syllabe);
        } else {
            System.out.println("La syllabe katakana (" + syllabe + ") nest pas valide, le programme se terminera. じゃあね!");
            System.exit(-1);
        }
    }


    /**
     * Crée un hashmap de toutes les syllabes katakana valides avec leur unicodes.
     */
    private void remplirTabKatakana() {
        tabKatakana.put("a", "&#12450;");
        tabKatakana.put("i", "&#12452;");
        tabKatakana.put("u", "&#12454;");
        tabKatakana.put("e", "&#12456;");
        tabKatakana.put("o", "&#12458;");
        tabKatakana.put("ka", "&#12459;");
        tabKatakana.put("ki", "&#12461;");
        tabKatakana.put("ku", "'&#12463;");
        tabKatakana.put("ke", "&#12465;");
        tabKatakana.put("ko", "&#12467;");
        tabKatakana.put("sa", "&#12469;");
        tabKatakana.put("shi", "&#12471;");
        tabKatakana.put("su", "&#12473;");
        tabKatakana.put("se", "&#12475;");
        tabKatakana.put("so", "&#12477;");
        tabKatakana.put("ta", "&#12479;");
        tabKatakana.put("chi", "&#12481;");
        tabKatakana.put("tsu", "&#12484;");
        tabKatakana.put("te", "&#12486;");
        tabKatakana.put("to", "&#12488;");
        tabKatakana.put("na", "&#12490;");
        tabKatakana.put("ni", "&#12491;");
        tabKatakana.put("nu", "&#12492;");
        tabKatakana.put("ne", "&#12493;");
        tabKatakana.put("no", "&#12494;");
        tabKatakana.put("ha", "&#12495;");
        tabKatakana.put("hi", "&#12498;");
        tabKatakana.put("fu", "&#12501;");
        tabKatakana.put("he", "&#12504;");
        tabKatakana.put("ho", "&#12507;");
        tabKatakana.put("ma", "&#12510;");
        tabKatakana.put("mi", "&#12511;");
        tabKatakana.put("mu", "&#12512;");
        tabKatakana.put("me", "&#12513;");
        tabKatakana.put("mo", "&#12514;");
        tabKatakana.put("ya", "&#12516;");
        tabKatakana.put("yu", "&#12518;");
        tabKatakana.put("yo", "&#12520;");
        tabKatakana.put("ra", "&#12521;");
        tabKatakana.put("ri", "&#12522;");
        tabKatakana.put("ru", "&#12523;");
        tabKatakana.put("re", "&#12524;");
        tabKatakana.put("ro", "&#12525;");
        tabKatakana.put("wa", "&#12527;");
        tabKatakana.put("wi", "&#12528;");
        tabKatakana.put("we", "&#12529;");
        tabKatakana.put("wo", "&#12530;");
        tabKatakana.put("ga", "&#12460;");
        tabKatakana.put("gi", "&#12462;");
        tabKatakana.put("gu", "&#12464;");
        tabKatakana.put("ge", "&#12466;");
        tabKatakana.put("go", "&#12468;");
        tabKatakana.put("za", "&#12470;");
        tabKatakana.put("ji", "&#12472;");
        tabKatakana.put("zu", "&#12474;");
        tabKatakana.put("ze", "&#12476;");
        tabKatakana.put("zo", "&#12478;");
        tabKatakana.put("da", "&#12480;");
        tabKatakana.put("dji", "&#12482;");
        tabKatakana.put("dzu", "&#12485;");
        tabKatakana.put("de", "&#12487;");
        tabKatakana.put("do", "&#12489;");
        tabKatakana.put("ba", "&#12496;");
        tabKatakana.put("bi", "&#12499;");
        tabKatakana.put("bu", "&#12502;");
        tabKatakana.put("be", "&#12505;");
        tabKatakana.put("bo", "&#12508;");
        tabKatakana.put("pa", "&#12497;");
        tabKatakana.put("pi", "&#12500;");
        tabKatakana.put("pu", "&#12503;");
        tabKatakana.put("pe", "&#12506;");
        tabKatakana.put("po", "&#12509;");
        tabKatakana.put("n'", "&#12531;");
        tabKatakana.put("@", "");
        tabKatakana.put("-", "    </tr>\n    <tr>\n");
        tabKatakana.put("kya", "&#12461;&#12515;");
        tabKatakana.put("kyu", "&#12461;&#12517;");
        tabKatakana.put("kyo", "&#12461;&#12519;");
        tabKatakana.put("sya", "&#12471;&#12515;");
        tabKatakana.put("syu", "&#12471;&#12517;");
        tabKatakana.put("syo", "&#12471;&#12519;");
        tabKatakana.put("cya", "&#12481;&#12515;");
        tabKatakana.put("cyu", "&#12481;&#12517;");
        tabKatakana.put("cyo", "&#12481;&#12519;");
        tabKatakana.put("nya", "&#12491;&#12515;");
        tabKatakana.put("nyu", "&#12491;&#12517;");
        tabKatakana.put("nyo", "&#12491;&#12519;");
        tabKatakana.put("hya", "&#12498;&#12515;");
        tabKatakana.put("hyu", "&#12498;&#12517;");
        tabKatakana.put("hyo", "&#12498;&#12519;");
        tabKatakana.put("mya", "&#12511;&#12515;");
        tabKatakana.put("myu", "&#12511;&#12517;");
        tabKatakana.put("myo", "&#12511;&#12519;");
        tabKatakana.put("rya", "&#12522;&#12515;");
        tabKatakana.put("ryu", "&#12522;&#12517;");
        tabKatakana.put("ryo", "&#12522;&#12519;");
        tabKatakana.put("gya", "&#12462;&#12515;");
        tabKatakana.put("gyu", "&#12462;&#12517;");
        tabKatakana.put("gyo", "&#12462;&#12519;");
        tabKatakana.put("jya", "&#12472;&#12515;");
        tabKatakana.put("jyu", "&#12472;&#12517;");
        tabKatakana.put("jyo", "&#12472;&#12519;");
        tabKatakana.put("dya", "&#12482;&#12515;");
        tabKatakana.put("dyu", "&#12482;&#12517;");
        tabKatakana.put("dyo", "&#12482;&#12519;");
        tabKatakana.put("bya", "&#12499;&#12515;");
        tabKatakana.put("byu", "&#12499;&#12517;");
        tabKatakana.put("byo", "&#12499;&#12519;");
        tabKatakana.put("pya", "&#12500;&#12515;");
        tabKatakana.put("pyu", "&#12500;&#12517;");
        tabKatakana.put("pyo", "&#12500;&#12519;");
    }

    /**
     * Retourne l'unicode trouvé sous formé String
     *
     * @return Unicode correspondant à la syllabe
     */
    @Override
    public String toString() {
        return syllabeUnicode;
    }

}

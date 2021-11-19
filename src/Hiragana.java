import java.util.*;

/**
 * Classe contenant toutes les methodes se rapportant aux syllabes Hiragana.
 */
public class Hiragana {
    protected String syllabe;
    protected String syllabeUnicode;
    protected Map<String, String> tabHiragana = new HashMap<>();

    /**
     * Construit la classe katakana, declanche methodes primordiales.
     *
     * @param syllabe syllabe à structure valide à trouver dans le hashMap.
     */
    public Hiragana(String syllabe) {
        this.syllabe = syllabe;
        remplirTabHiragana();
        obtenirUnicode();
    }

    /**
     * Obtient unicode, s'il existe , à partir de la syllabe fournie et le place dans une variable.
     */
    private void obtenirUnicode() {
        syllabe = syllabe.toLowerCase();
        if (tabHiragana.containsKey(syllabe)) {
            syllabeUnicode = tabHiragana.get(syllabe);
        } else {
            System.out.println("La syllabe Hiragana (" + syllabe + ") nest pas valide, le programme se terminera. じゃあね!");
            System.exit(-1);
        }
    }

    /**
     * Crée un hashmap de toutes les syllabes Hiragana valides avec leur unicodes.
     */
    private void remplirTabHiragana() {
        tabHiragana.put("a", "&#12354;");
        tabHiragana.put("i", "&#12356;");
        tabHiragana.put("u", "&#12358;");
        tabHiragana.put("e", "&#12360;");
        tabHiragana.put("o", "&#12362;");
        tabHiragana.put("ka", "&#12363;");
        tabHiragana.put("ki", "&#12365;");
        tabHiragana.put("ku", "&#12367;");
        tabHiragana.put("ke", "&#12369;");
        tabHiragana.put("ko", "&#12371;");
        tabHiragana.put("sa", "&#12373;");
        tabHiragana.put("shi", "&#12375;");
        tabHiragana.put("su", "&#12377;");
        tabHiragana.put("se", "&#12379;");
        tabHiragana.put("so", "&#12381;");
        tabHiragana.put("ta", "&#12383;");
        tabHiragana.put("chi", "&#12385;");
        tabHiragana.put("tsu", "&#12388;");
        tabHiragana.put("te", "&#12390;");
        tabHiragana.put("to", "&#12392;");
        tabHiragana.put("na", "&#12394;");
        tabHiragana.put("ni", "&#12395;");
        tabHiragana.put("nu", "&#12396;");
        tabHiragana.put("ne", "&#12397;");
        tabHiragana.put("no", "&#12398;");
        tabHiragana.put("ha", "&#12399;");
        tabHiragana.put("hi", "&#12402;");
        tabHiragana.put("fu", "&#12405;");
        tabHiragana.put("he", "&#12408;");
        tabHiragana.put("ho", "&#12411;");
        tabHiragana.put("ma", "&#12414;");
        tabHiragana.put("mi", "&#12415;");
        tabHiragana.put("mu", "&#12416;");
        tabHiragana.put("me", "&#12417;");
        tabHiragana.put("mo", "&#12418;");
        tabHiragana.put("ya", "&#12420;");
        tabHiragana.put("yu", "&#12422;");
        tabHiragana.put("yo", "&#12424;");
        tabHiragana.put("ra", "&#12425;");
        tabHiragana.put("ri", "&#12426;");
        tabHiragana.put("ru", "&#12427;");
        tabHiragana.put("re", "&#12428;");
        tabHiragana.put("ro", "&#12429;");
        tabHiragana.put("wa", "&#12431;");
        tabHiragana.put("wi", "&#12432;");
        tabHiragana.put("we", "&#12433;");
        tabHiragana.put("wo", "&#12434;");
        tabHiragana.put("ga", "&#12364;");
        tabHiragana.put("gi", "&#12366;");
        tabHiragana.put("gu", "&#12368;");
        tabHiragana.put("ge", "&#12370;");
        tabHiragana.put("go", "&#12372;");
        tabHiragana.put("za", "&#12374;");
        tabHiragana.put("ji", "&#12376;");
        tabHiragana.put("zu", "&#12378;");
        tabHiragana.put("ze", "&#12380;");
        tabHiragana.put("zo", "&#12382;");
        tabHiragana.put("da", "&#12384;");
        tabHiragana.put("dji", "&#12386;");
        tabHiragana.put("dzu", "&#12389;");
        tabHiragana.put("de", "&#12391;");
        tabHiragana.put("do", "&#12392;");
        tabHiragana.put("ba", "&#12400;");
        tabHiragana.put("bi", "&#12403;");
        tabHiragana.put("bu", "&#12406;");
        tabHiragana.put("be", "&#12409;");
        tabHiragana.put("bo", "&#12412;");
        tabHiragana.put("pa", "&#12401;");
        tabHiragana.put("pi", "&#12404;");
        tabHiragana.put("pu", "&#12407;");
        tabHiragana.put("pe", "&#12410;");
        tabHiragana.put("po", "&#12413;");
        tabHiragana.put("n'", "&#12435;");
        tabHiragana.put("kya", "&#12365;&#12419;");
        tabHiragana.put("kyu", "&#12365;&#12421;");
        tabHiragana.put("kyo", "&#12365;&#12423;");
        tabHiragana.put("sya", "&#12375;&#12419;");
        tabHiragana.put("syu", "&#12375;&#12421;");
        tabHiragana.put("syo", "&#12375;&#12423;");
        tabHiragana.put("cya", "&#12385;&#12419;");
        tabHiragana.put("cyu", "&#12385;&#12421;");
        tabHiragana.put("cyo", "&#12385;&#12423;");
        tabHiragana.put("nya", "&#12395;&#12419;");
        tabHiragana.put("nyu", "&#12395;&#12421;");
        tabHiragana.put("nyo", "&#12395;&#12423;");
        tabHiragana.put("hya", "&#12402;&#12419;");
        tabHiragana.put("hyu", "&#12402;&#12421;");
        tabHiragana.put("hyo", "&#12402;&#12423;");
        tabHiragana.put("mya", "&#12415;&#12419;");
        tabHiragana.put("myu", "&#12415;&#12421;");
        tabHiragana.put("myo", "&#12415;&#12423;");
        tabHiragana.put("rya", "&#12426;&#12419;");
        tabHiragana.put("ryu", "&#12426;&#12421;");
        tabHiragana.put("ryo", "&#12426;&#12423;");
        tabHiragana.put("gya", "&#12366;&#12419;");
        tabHiragana.put("gyu", "&#12366;&#12421;");
        tabHiragana.put("gyo", "&#12366;&#12423;");
        tabHiragana.put("jya", "&#12376;&#12419;");
        tabHiragana.put("jyu", "&#12376;&#12421;");
        tabHiragana.put("jyo", "&#12376;&#12423;");
        tabHiragana.put("dya", "&#12386;&#12419;");
        tabHiragana.put("dyu", "&#12386;&#12421;");
        tabHiragana.put("dyo", "&#12386;&#12423;");
        tabHiragana.put("bya", "&#12403;&#12419;");
        tabHiragana.put("byu", "&#12403;&#12421;");
        tabHiragana.put("byo", "&#12403;&#12423;");
        tabHiragana.put("pya", "&#12404;&#12419;");
        tabHiragana.put("pyu", "&#12404;&#12421;");
        tabHiragana.put("pyo", "&#12404;&#12423;");

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

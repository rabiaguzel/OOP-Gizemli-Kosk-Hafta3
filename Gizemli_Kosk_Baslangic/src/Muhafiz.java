/**
 * KİLİT 3 — MUHAFIZ
 * Konu: static değişken ve static metot
 * "GÖREV" yazan yerleri doldurun.
 */
public class Muhafiz {

    private String ad;

    // static: bu sayaç her muhafıza ayrı değil, bütün muhafızlar için TEK bir tanedir.
    private static int sayi = 0;

    public Muhafiz(String ad) {
        this.ad = ad;
        // GÖREV 3a: Yeni bir muhafız oluştu. sayi değerini 1 artırın.
        // ... buraya yazın ...
    }

    public String getAd() {
        return ad;
    }

    // static metot: nesne oluşturmadan Muhafiz.getSayi() diye çağrılır.
    public static int getSayi() {
        // GÖREV 3b: 0 yerine sayi değerini döndürün.
        return 0;
    }
}

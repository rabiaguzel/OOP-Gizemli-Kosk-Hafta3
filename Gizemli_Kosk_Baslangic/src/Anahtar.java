/**
 * KİLİT 1 — ANAHTAR
 * Konu: Yapıcılar (constructor) ve this
 * "GÖREV" yazan yerleri doldurun.
 */
public class Anahtar {

    private String renk;
    private int disSayisi;

    // Yapıcı 1: renk ve diş sayısı alır.
    public Anahtar(String renk, int disSayisi) {
        // GÖREV 1a: Parametreleri alanlara atayın.
        //   Alan adı ile parametre adı aynı olduğu için alanı this ile belirtin:
        //   this.renk = renk;   (diş sayısı için de aynısını yazın)
        // ... buraya yazın ...
    }

    // Yapıcı 2: yalnızca renk alır.
    public Anahtar(String renk) {
        // GÖREV 1b: this(...) ile Yapıcı 1'i çağırın. Diş sayısı 3 olsun.
        //   İpucu: this(renk, 3);
        // ... buraya yazın ...
    }

    public String getRenk() {
        return renk;
    }

    public int getDisSayisi() {
        return disSayisi;
    }
}

/**
 * KİLİT 2 — PUSULA
 * Konu: Kapsülleme (private alan + getter + setter)
 *
 * Kapsülleme nedir?
 *   Bir sınıfın alanını private yaparsak, başka sınıflar o alanı doğrudan değiştiremez.
 *   Alanı okumak için bir "getter" metodu, değiştirmek için bir "setter" metodu yazarız.
 *   Setter, gelen değeri kontrol edip yanlış değerleri engelleyebilir.
 *
 * "GÖREV" yazan yerleri doldurun.
 */
public class Pusula {

    // GÖREV 2a: public kelimesini private yapın.
    public int yon = 0;          // derece cinsinden yön: 0 ile 359 arası

    // Getter: yon değerini dışarıya verir.
    public int getYon() {
        // GÖREV 2b: 0 yerine yon yazın.
        return 0;
    }

    // Setter: yon değerini kontrollü şekilde değiştirir.
    public void setYon(int yeniYon) {
        if (yeniYon >= 0 && yeniYon <= 359) {
            // GÖREV 2c: Değer uygunsa yon alanına yeniYon değerini atayın.
            //   İpucu: yon = yeniYon;
            // ... buraya yazın ...
        }
        // Değer 0 ile 359 arasında değilse hiçbir şey yapılmaz, yon eski değerinde kalır.
    }
}

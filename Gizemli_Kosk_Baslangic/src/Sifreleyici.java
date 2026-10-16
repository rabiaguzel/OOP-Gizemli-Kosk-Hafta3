/**
 * ŞİFRELEYİCİ (hazır, değiştirmeyin)
 *
 * Bu sınıfta aynı adlı İKİ metot var: coz(String) ve coz(String, int).
 * Java'da aynı adla, parametreleri farklı birden fazla metot yazılabilir.
 * Buna AŞIRI YÜKLEME (overloading) denir.
 * Hangi metodun çalışacağına Java, çağrıdaki parametrelere bakarak karar verir:
 *
 *   Sifreleyici.coz("KBWB")        -> tek parametreli sürüm çalışır (her harfi 1 adım geri kaydırır)
 *   Sifreleyici.coz("MDYD", 3)     -> iki parametreli sürüm çalışır (her harfi 3 adım geri kaydırır)
 */
public class Sifreleyici {

    // Sürüm 1: tek parametre. Her harfi 1 adım geri kaydırır.
    public static String coz(String metin) {
        return kaydir(metin, -1);
    }

    // Sürüm 2: iki parametre. Her harfi "adim" kadar geri kaydırır.
    public static String coz(String metin, int adim) {
        return kaydir(metin, -adim);
    }

    // Yardımcı metot: A-Z arasındaki büyük harfleri alfabede kaydırır, diğer karakterlere dokunmaz.
    private static String kaydir(String metin, int adim) {
        StringBuilder sonuc = new StringBuilder();
        for (int i = 0; i < metin.length(); i++) {
            char c = metin.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                int yeni = (c - 'A' + adim) % 26;
                if (yeni < 0) {
                    yeni = yeni + 26;
                }
                sonuc.append((char) ('A' + yeni));
            } else {
                sonuc.append(c);
            }
        }
        return sonuc.toString();
    }
}

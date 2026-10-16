import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Programın başlangıç noktası.
 * Bu dosyada yalnızca GRUP_ADI sabitine grubunuzun adını yazın.
 */
public class Main {

    public static final String GRUP_ADI = "Grup Adı";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame pencere = new JFrame("Gizemli Kasa - " + GRUP_ADI);
                KasaPaneli panel = new KasaPaneli();
                pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                pencere.setResizable(false);
                pencere.add(panel);
                pencere.pack();
                pencere.setLocationRelativeTo(null);
                pencere.setVisible(true);
            }
        });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.lang.reflect.*;

/** Altı sahneli gizemli köşk. Öğrenciler yalnızca görev sınıflarını düzenler. */
public class KasaPaneli extends JPanel {
    private final String[] baslik={"DIŞ KAPI","İÇ KAPI","MUHAFIZLAR ODASI","ESKİ KİTAPLIK","GİZLİ DUVAR","SON KASA"};
    private final String[] aciklama={
      "Altın anahtarın iki yapıcısını onar. Kapıyı açmak için anahtarı çevir.",
      "Pusula doğru yönü göstermiyor. Alanı koru, getter ve setter'ı düzelt.",
      "Üç taş muhafız ortak sayacı bekliyor. static sayacı çalıştır.",
      "Şifreli notun sırrı: doğru aşırı yüklenmiş metodu çağır.",
      "Duvarın sabit kuralı değiştirilemez olmalı. final anahtarıdır.",
      "Beş odadan topladığın rakamları sıraya koy ve kasayı aç."};
    private final String[] dosya={"Anahtar.java","Pusula.java","Muhafiz.java","NotCozucu.java","Kurallar.java"};
    private final int[] rakam={-1,-1,-1,-1,-1};
    private int sahne=0, hatali=0; private boolean tamam=false;
    private final JLabel bilgi=new JLabel(" ",SwingConstants.CENTER);
    private final JButton ilerle=new JButton("MEKANİZMAYI DENE  →");
    private final JTextField kod=new JTextField(8);
    private final JPanel alt=new JPanel(new FlowLayout(FlowLayout.CENTER,14,12));
    public KasaPaneli(){
      setPreferredSize(new Dimension(1040,700));setLayout(new BorderLayout());setBackground(new Color(12,17,27));
      bilgi.setFont(new Font("SansSerif",Font.BOLD,15));bilgi.setForeground(new Color(236,205,141));
      alt.setOpaque(true);alt.setBackground(new Color(16,23,34));
      ilerle.setFont(new Font("SansSerif",Font.BOLD,15));ilerle.setBackground(new Color(165,126,69));
      ilerle.addActionListener(e->denetle());kod.setFont(new Font("Monospaced",Font.BOLD,22));kod.addActionListener(e->denetle());
      alt.add(ilerle);alt.add(kod);add(alt,BorderLayout.SOUTH);add(bilgi,BorderLayout.NORTH);
      ekranGuncelle();
    }
    private void ekranGuncelle(){
      kod.setVisible(sahne==5&&!tamam);ilerle.setText(sahne==5?"KASAYI AÇ":"MEKANİZMAYI DENE  →");
      bilgi.setText(tamam?"TEBRİKLER! GİZEMLİ KÖŞKÜN SIRRINI ÇÖZDÜNÜZ!":
        "BÖLÜM "+(sahne+1)+" / 6  •  "+baslik[sahne]+"  |  "+(sahne<5?dosya[sahne]:"5 haneli şifre"));
      repaint();
    }
    private boolean kontrol(int i){
      try {
       switch(i){
        case 0: Anahtar a=new Anahtar("ALTIN",8),b=new Anahtar("GUMUS");
         if(!"ALTIN".equals(a.getRenk())||a.getDisSayisi()!=8||!"GUMUS".equals(b.getRenk())||b.getDisSayisi()!=3)return false;
         rakam[3]=(a.getDisSayisi()+b.getDisSayisi())%10;return true;
        case 1: Field f=Pusula.class.getDeclaredField("yon");Pusula p=new Pusula();p.setYon(90);p.setYon(400);p.setYon(-15);
         if(!Modifier.isPrivate(f.getModifiers())||p.getYon()!=90)return false;rakam[1]=p.getYon()/10-2;return true;
        case 2: int once=Muhafiz.getSayi();new Muhafiz("Kerem");new Muhafiz("Defne");new Muhafiz("Arda");int fark=Muhafiz.getSayi()-once;
         if(fark!=3)return false;rakam[4]=fark*3;return true;
        case 3: if(!"DENEME".equals(NotCozucu.notuCoz("GHQHPH")))return false;
         rakam[0]=Anahtar.class.getDeclaredConstructors().length;return true;
        case 4: Field k=Kurallar.class.getField("DENEME_HAKKI");int m=k.getModifiers();
         if(!Modifier.isStatic(m)||!Modifier.isFinal(m)||k.getInt(null)!=3)return false;
         rakam[2]=(k.getInt(null)+1)%10;return true;
       }
      }catch(Throwable ex){return false;}return false;
    }
    private void denetle(){
      if(tamam)return;
      if(sahne<5){if(kontrol(sahne)){sahne++;bilgi.setText("Kilit açıldı! Yeni odaya geçildi.");ekranGuncelle();}
       else JOptionPane.showMessageDialog(this,"Mekanizma çalışmadı. "+dosya[sahne]+" dosyasındaki GÖREV alanlarını kontrol et.\nKaydet, yeniden derle ve programı tekrar başlat.","Henüz açılmadı",JOptionPane.WARNING_MESSAGE);
      }else{
       StringBuilder dogru=new StringBuilder();for(int n:rakam)dogru.append(n);
       if(kod.getText().trim().equals(dogru.toString())){tamam=true;ekranGuncelle();JOptionPane.showMessageDialog(this,"GİZLİ KASA AÇILDI!\n\nYOKLAMAYA İMZA AT!","KASA AÇILDI",JOptionPane.INFORMATION_MESSAGE);}
       else{hatali++;if(hatali>=3){hatali=0;JOptionPane.showMessageDialog(this,"Alarm! Üç yanlış deneme. Rakamları tekrar incele.");}else JOptionPane.showMessageDialog(this,"Yanlış şifre. Rakamları oda sırasına göre değil, verilen basamak numaralarına göre diz.");}
      }
    }
    @Override protected void paintComponent(Graphics g){
      super.paintComponent(g);Graphics2D x=(Graphics2D)g.create();x.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
      int w=getWidth(),h=getHeight();x.setPaint(new GradientPaint(0,0,new Color(13,21,36),0,h,new Color(44,31,32)));x.fillRect(0,0,w,h);
      // atmospheric light and masonry
      x.setColor(new Color(198,147,80,18));for(int j=0;j<16;j++)x.drawLine(0,55+j*42,w,55+j*42);
      for(int j=0;j<17;j++)for(int i=0;i<12;i++){x.setColor(new Color(255,220,150,9));x.drawRect(i*95+(j%2)*48,j*42,95,42);}
      x.setPaint(new RadialGradientPaint(w/2f,h/2f,360,new float[]{0f,1f},new Color[]{new Color(174,117,51,75),new Color(0,0,0,0)}));x.fillRect(0,0,w,h);
      x.setFont(new Font("Serif",Font.BOLD,34));x.setColor(new Color(237,201,138));center(x,baslik[sahne],w/2,100);
      x.setFont(new Font("SansSerif",Font.PLAIN,16));x.setColor(new Color(215,204,187));center(x,aciklama[sahne],w/2,140);
      if(sahne==0||sahne==1){
       int dw=sahne==0?360:290,dh=sahne==0?400:350,dx=(w-dw)/2,dy=180;
       x.setColor(new Color(75,52,39));x.fillRoundRect(dx-22,dy-22,dw+44,dh+44,18,18);
       x.setPaint(new GradientPaint(dx,dy,new Color(99,67,48),dx+dw,dy+dh,new Color(32,28,31)));x.fillRoundRect(dx,dy,dw,dh,8,8);
       x.setColor(new Color(166,124,70));x.setStroke(new BasicStroke(5));x.drawRoundRect(dx+17,dy+17,dw-34,dh-34,8,8);
       x.drawLine(w/2,dy+17,w/2,dy+dh-17);x.fillOval(dx+dw-60,dy+dh/2,17,17);
       x.setFont(new Font("Serif",Font.BOLD,38));center(x,sahne==0?"I":"II",w/2,dy+95);
      }else if(sahne==2){
       for(int i=0;i<3;i++){int cx=285+i*235;x.setColor(new Color(82,87,91));x.fillRoundRect(cx-60,285,120,210,38,38);x.fillOval(cx-50,220,100,110);x.setColor(new Color(221,170,82));x.fillOval(cx-25,266,12,9);x.fillOval(cx+14,266,12,9);x.setColor(new Color(92,70,54));x.fillRect(cx-85,485,170,35);}
      }else if(sahne==3){
       x.setColor(new Color(92,58,40));x.fillRect(210,185,620,365);
       for(int shelf=0;shelf<3;shelf++){int yy=220+shelf*105;x.setColor(new Color(168,112,66));x.fillRect(222,yy+75,595,12);
        for(int i=0;i<24;i++){int xx=232+i*24;x.setColor(i==12&&shelf==1?new Color(228,186,89):new Color(70+(i*19)%75,43+(i*11)%55,42+(i*7)%43));x.fillRect(xx,yy,17,75);}}
      }else if(sahne==4){
       x.setColor(new Color(78,79,78));x.fillRoundRect(280,200,480,330,15,15);x.setColor(new Color(166,127,71));x.setStroke(new BasicStroke(7));x.drawOval(410,285,220,170);
       x.setFont(new Font("Serif",Font.BOLD,48));center(x,"FINAL",520,385);
      }else{
       x.setColor(new Color(95,97,100));x.fillRoundRect(310,190,420,350,28,28);x.setColor(new Color(186,144,79));x.setStroke(new BasicStroke(9));x.drawRoundRect(330,210,380,310,15,15);
       x.drawOval(425,290,190,160);x.drawOval(459,321,122,100);x.setFont(new Font("Serif",Font.BOLD,28));center(x,tamam?"AÇILDI":"? ? ? ? ?",520,380);
       if(tamam){x.setFont(new Font("SansSerif",Font.BOLD,23));x.setColor(new Color(255,220,145));center(x,"YOKLAMAYA İMZA AT!",520,475);}
      }
      x.setColor(new Color(12,18,28,220));x.fillRoundRect(95,555,850,55,14,14);
      x.setFont(new Font("SansSerif",Font.BOLD,16));x.setColor(new Color(237,201,138));
      StringBuilder durum=new StringBuilder("BULUNAN ŞİFRE PARÇALARI:   ");for(int i=0;i<5;i++)durum.append("[").append(i+1).append(": ").append(rakam[i]<0?"?":rakam[i]).append("]  ");center(x,durum.toString(),w/2,589);
      x.dispose();
    }
    private void center(Graphics2D g,String s,int cx,int y){FontMetrics fm=g.getFontMetrics();g.drawString(s,cx-fm.stringWidth(s)/2,y);}
}

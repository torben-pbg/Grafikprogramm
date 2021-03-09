import sum.kern.*; 
/**
 * @author Torben Piepenburg
 * @version 0.1.1
 */
public class Kreis
{
    
    private Buntstift hatStift;
    private int zGroesse;
    private boolean zStatus;

    /**
     * Konstruktor für Objekte der Klasse Kreis
     */
    public Kreis( int pH, int pV, int pGroesse, int pFarbe)
    {
        zGroesse = pGroesse;
        zStatus = false;
        hatStift = new Buntstift();
        hatStift.bewegeBis(pH,pV);
        hatStift.setzeFarbe(pFarbe);
        hatStift.setzeLinienbreite(2);
    }

    public void zeichne()
    {
        hatStift.zeichneKreis(zGroesse);
    }
    
    public void loesche()
    {
        hatStift.radiere();
        hatStift.zeichneKreis(zGroesse);
        hatStift.normal();
    }

    public void bewegeUm(int pH, int pV)
    { 
        this.loesche(); 
        hatStift.bewegeBis(hatStift.hPosition() + pH, 
            hatStift.vPosition() + pV); 
        this.zeichne(); 
    }
    
    public void aktiviere()
    {
        this.loesche();
        hatStift.setzeLinienbreite(8);
        zStatus = true;
        this.zeichne();
    }
    
    public void deaktiviere()
    {
        this.loesche();
        hatStift.setzeLinienbreite(2);
        zStatus = false;
        this.zeichne();
    }

    public boolean getroffen(int pH, int pV) 
    // (pH|pV) – Mausposition 
    // Pythagoras 
    { 
        return (pH - hatStift.hPosition()) * (pH - hatStift.hPosition())  + (pV - hatStift.vPosition()) * (pV - hatStift.vPosition())  <= zGroesse * zGroesse; 
    } 
}

import sum.kern.*;
/**
 * @author Torben Piepenburg
 * @version 0.2.1
 */
public abstract class Figur
{
    private Buntstift hatStift;    
    private int zGroesse;
    private boolean zStatus;

    public Figur(int pH, int pV, int pGroesse, int pFarbe)
    {
        zGroesse = pGroesse;
        zStatus = false;
        hatStift = new Buntstift();
        hatStift.bewegeBis(pH,pV);
        hatStift.setzeFarbe(pFarbe);
        hatStift.setzeLinienbreite(2);
        this.zeichne();
    }
    
    
    public void loesche()
    {
        hatStift.radiere();
        this.zeichne();
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
    
    public void gibFrei()
    {
        hatStift.gibFrei();
    }
}

import sum.kern.*; 
/**
 * @author Torben Piepenburg
 * @version 0.2.1
 */
public class Kreis extends Figur
{
    
    public Kreis(int pH, int pV, int pGroesse, int pFarbe)
    {
        super(pH, pV, pGroesse, pFarbe);
    }
    
    
    private void zeichne()
    {
        hatStift.zeichneKreis(zGroesse);
    }

    public boolean getroffen(int pH, int pV) 
    // (pH|pV) – Mausposition 
    // Pythagoras 
    { 
        return (pH - hatStift.hPosition()) * (pH - hatStift.hPosition())  + (pV - hatStift.vPosition()) * (pV - hatStift.vPosition())  <= zGroesse * zGroesse; 
    } 
}

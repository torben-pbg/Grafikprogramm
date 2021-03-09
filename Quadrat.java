import sum.kern.*; 
/**
 * @author Torben Piepenburg
 * @version 0.2.1
 */
public class Quadrat extends Figur
{

    public Quadrat(int pH, int pV, int pGroesse, int pFarbe)
    {
        super(pH, pV, pGroesse, pFarbe);
    }

    private void zeichne()
    {
        hatStift.zeichneRechteck(zGroesse, zGroesse);
    }

    public boolean getroffen(int pH, int pV)
    { 
        return(pH >= hatStift.hPosition() && pH <= hatStift.hPosition() + zGroesse && pV >= hatStift.vPosition() && pV <=hatStift.vPosition() + zGroesse);

    } 
}

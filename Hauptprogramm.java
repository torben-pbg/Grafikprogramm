import sum.kern.*;
/**
 * @author 
 * @version 
 */
public class Hauptprogramm
{
    // Bezugsobjekte
    private Bildschirm derBildschirm;
    private Maus dieMaus;
    private Tastatur dieTastatur;
    private Kreis meinKreis1;
    private Kreis meinKreis2;
    private Kreis meinKreis3;
    private Kreis aktiverKreis;

    // Konstruktor
    public Hauptprogramm()
    {
        //Erzeugen der Kreise und des Bildschirmes
        derBildschirm = new Bildschirm(640, 360);
        dieMaus = new Maus();
        dieTastatur = new Tastatur();
        meinKreis1 = new Kreis(200, 25, 20, 600); 
        meinKreis2 = new Kreis(150, 230, 50, 1200); 
        meinKreis3 = new Kreis(180, 120, 30, 200);
    }

    // Dienste
    public void fuehreAus()
    {
        //Kreise werden gezeichnet
        meinKreis1.zeichne();
        meinKreis2.zeichne();
        meinKreis3.zeichne();

        //der erste Kreis wird Standardmaessig aktiviert
        aktiverKreis = meinKreis1;
        aktiverKreis.aktiviere();
        

        do{
            //Hauptteil des Programmes

            //Der aktivierte Kreis wird geändert
            if(dieMaus.istGedrueckt())
            {
                //Abfrage ob ein Kreis angeklickt wurde
                aktiverKreis.deaktiviere();
                if(meinKreis1.getroffen(dieMaus.hPosition(), dieMaus.vPosition()))
                {
                    //Kreis 1 wird aktiviert
                    //aktiverKreis = meinKreis1;
                }
                else if(meinKreis2.getroffen(dieMaus.hPosition(), dieMaus.vPosition()))
                {
                    //Kreis 2 wird aktiviert
                    //aktiverKreis = meinKreis2;
                }
                else if(meinKreis3.getroffen(dieMaus.hPosition(), dieMaus.vPosition()))
                {
                    //Kreis 3 wird aktiviert
                    //aktiverKreis = meinKreis3;
                }
                aktiverKreis.aktiviere();
            }

            //Der aktivierter Kreis wird mit den Pfeiltasten bewegt
            if (dieTastatur.wurdeGedrueckt())
            {
                switch (dieTastatur.zeichen())
                {
                    case Zeichen.PFEILRECHTS: aktiverKreis.bewegeUm(5,0); break;
                    case Zeichen.PFEILLINKS: aktiverKreis.bewegeUm(-5,0); break;
                    case Zeichen.PFEILOBEN: aktiverKreis.bewegeUm(0,-5); break;
                    case Zeichen.PFEILUNTEN: aktiverKreis.bewegeUm(0,5); break;
                }
                dieTastatur.weiter();
            }

        }while(!dieMaus.doppelKlick());
    }
}

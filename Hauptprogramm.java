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
    private Figur aktiveFigur;    

    private Kreis meinKreis1;
    private Kreis meinKreis2;
    private Kreis meinKreis3;
    private Quadrat meinQuadrat1;
    private Quadrat meinQuadrat2;
    private Quadrat meinQuadrat3;

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

        //der erste Kreis wird Standardmaessig aktiviert
        aktiveFigur = meinKreis1;
        aktiveFigur.aktiviere();

        do{
            //Hauptteil des Programmes

            //Der aktivierte Kreis wird geändert
            if(dieMaus.istGedrueckt())
            {
                //Abfrage ob ein Kreis angeklickt wurde
                aktiveFigur.deaktiviere();
                if(meinKreis1.getroffen(dieMaus.hPosition(), dieMaus.vPosition()))
                {
                    //Kreis 1 wird aktiviert
                    aktiveFigur = meinKreis1;
                }
                else if(meinKreis2.getroffen(dieMaus.hPosition(), dieMaus.vPosition()))
                {
                    //Kreis 2 wird aktiviert
                    aktiveFigur = meinKreis2;
                }
                else if(meinKreis3.getroffen(dieMaus.hPosition(), dieMaus.vPosition()))
                {
                    //Kreis 3 wird aktiviert
                    aktiveFigur = meinKreis3;
                }
                aktiveFigur.aktiviere();
            }

            //Der aktivierter Kreis wird mit den Pfeiltasten bewegt
            if (dieTastatur.wurdeGedrueckt())
            {
                switch (dieTastatur.zeichen())
                {
                    case Zeichen.PFEILRECHTS: aktiveFigur.bewegeUm(5,0); break;
                    case Zeichen.PFEILLINKS: aktiveFigur.bewegeUm(-5,0); break;
                    case Zeichen.PFEILOBEN: aktiveFigur.bewegeUm(0,-5); break;
                    case Zeichen.PFEILUNTEN: aktiveFigur.bewegeUm(0,5); break;
                }
                dieTastatur.weiter();
            }

        }while(!dieMaus.doppelKlick());
    }
}

package oc.wh40k.units.ae;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.RuestkammerStarter;

public class AEHellions extends Eintrag {

    private final AnzahlPanel squad;

    public AEHellions() {
        name = "Hellions";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Hellions", 5, 20, getPts("Hellion") + getPts("Splinter pods") + getPts("Hellglaive"));
        add(squad);

        seperator();

        add(new RuestkammerStarter(ID, randAbstand, cnt, new AEHelliarch(), "Helliarch"));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() > 15) {
            power = 17;
        } else if (squad.getModelle() > 10) {
            power = 13;
        } else if (squad.getModelle() > 5) {
            power = 9;
        } else {
            power = 5;
        }
    }
}
package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;

public class ORKaptinBadrukk extends Eintrag {

	private final OptionsEinzelZaehler Munigrot;

    public ORKaptinBadrukk() {

        kategorie = 1;
        name = "Kaptin Badrukk";
        grundkosten = getPts("Kaptin Badrukk");
        power = 5;

        add(ico = new oc.Picture("oc/wh40k/images/GhazghkullThraka.gif"));

        seperator();

        Munigrot = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Ammo runt", 1, getPts("Ammo runt"));
        add(Munigrot);

        seperator();

        addWarlordTraits("Freebooterz: Killa Reputation", true);

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        setUnikat(true);
    }
}

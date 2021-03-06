package oc.wh40k.units.ty;

import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CULT;
import static oc.KeyWord.GENESTEALER_CULTS;
import static oc.KeyWord.INFANTRY;
import static oc.KeyWord.MAGUS;
import static oc.KeyWord.TYRANIDS;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class TYMagus extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public TYMagus() {
    	super(TYRANIDS, GENESTEALER_CULTS, CULT, CHARACTER, INFANTRY, MAGUS);

        name = "Magus";

        grundkosten = getPts("Magus");

        power = 4;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableBroodMind();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWeapons(TYGenestealerCultRuestkammer.class, true);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

}


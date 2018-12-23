package oc.wh40k.units.im;

import static oc.KeyWord.*;
import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class IMLibrarianonBike extends Eintrag {

    public IMLibrarianonBike() {
    	super(IMPERIUM, ADEPTUS_ASTARTES, CHAPTER, CHARACTER, BIKER, PSYKER, LIBRARIAN);
        name = "Librarian on Bike";
        grundkosten = getPts("Librarian on Bike") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");
        power = 8;

        seperator();
        
        addWeapons(new IMSpaceMarinesRuestkammer(name, getKeywords()), true);

        seperator();

        RuestkammerStarter psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(2, getPsychicPowerGroug(checkBuildaVater())), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(false);
        add(psychicPowers);

        seperator();

		addWarlordTraits("", true);

        complete();
    }
}

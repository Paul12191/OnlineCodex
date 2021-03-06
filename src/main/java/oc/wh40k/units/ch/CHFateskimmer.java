package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.CHARIOT;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.FATESKIMMER;
import static oc.KeyWord.FLY;
import static oc.KeyWord.HERALD_OF_TZEENTCH;
import static oc.KeyWord.HORROR;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.TZEENTCH;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHFateskimmer extends Eintrag {

	private final RuestkammerStarter psychicPowers;

    public CHFateskimmer() {
        super(CHAOS, TZEENTCH, DAEMON, CHARACTER, CHARIOT, HORROR, FLY, PSYKER, HERALD_OF_TZEENTCH, FATESKIMMER);

        name = "Fateskimmer";
        grundkosten = getPts("Fateskimmer");
        power = 8;

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chanting Horrors", getPts("Chanting Horrors")));

        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableTzeentch();
        ((PsychicPowers) psychicPowers.getKammer()).setTzeentch(true);
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", TZEENTCH);

        complete();

    }
}

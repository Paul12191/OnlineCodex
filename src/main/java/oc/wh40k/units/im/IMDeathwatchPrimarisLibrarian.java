package oc.wh40k.units.im;

import oc.Eintrag;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.LIBRARIUS;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANGUINARY;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.INTERROMANCY;
import static oc.wh40k.units.im.ImperiumUtils.getPsychicPowerGroug;

public class IMDeathwatchPrimarisLibrarian extends Eintrag {

    public IMDeathwatchPrimarisLibrarian() {
        name = "Primaris Librarian";
        grundkosten = getPts("Primaris Librarian") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)") + getPts("Bolt pistol (DW)") + getPts("Force sword");
        power = 7;

        addPsychicPowers(2, getPsychicPowerGroug(checkBuildaVater()));

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}

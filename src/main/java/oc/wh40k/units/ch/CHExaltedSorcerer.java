package oc.wh40k.units.ch;

import oc.*;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class CHExaltedSorcerer extends Eintrag {

    private final OptionsUpgradeGruppe stave;
    private final OptionsUpgradeGruppe inferno;

    public CHExaltedSorcerer() {

        name = "Exalted Sorcerer";
        grundkosten = getPts("Exalted Sorcerer");
        power = 7;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Force stave", getPts("Force stave")));
        ogE.addElement(new OptionsGruppeEintrag("2 Power swords", getPts("Power sword") * 2));
        add(stave = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Inferno bolt pistol", getPts("Inferno bolt pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Warpflame pistol", getPts("Warpflame pistol")));
        add(inferno = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword")));

        seperator();

        addPsychicPowers(2, DARK_HERETICUS, CHANGE);

        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        inferno.alwaysSelected();
        stave.alwaysSelected();
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}

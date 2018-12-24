package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.ChaosGod.*;
import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.DARK_HERETICUS;

public class CHDaemonPrinceofChaosCSM extends Eintrag {

    private final OptionsUpgradeGruppe mark;

    public CHDaemonPrinceofChaosCSM() {
        name = "Daemon Prince of Chaos";
        grundkosten = getPts("Daemon Prince of Chaos");
        power = 10;

        ogE.addElement(new OptionsGruppeEintrag("Hellforged sword", getPts("Hellforged sword CSM")));
        ogE.addElement(new OptionsGruppeEintrag("Daemonic axe", getPts("Daemonic axe (CSM)")));
        ogE.addElement(new OptionsGruppeEintrag("Malefic talons", getPts("Malefic talons")));
        OptionsUpgradeGruppe waffe1;
        add(waffe1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        waffe1.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Warp bolter", getPts("Warp bolter")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        addPsychicPowers(1, DARK_HERETICUS);

        seperator();

        addWarlordTraits("", true);

        complete();

    }

    @Override
    public void refreshen() {
        psychicPowers.setAktiv(!mark.isSelected("Mark of Khorne") && !(mark.getAnzahl() == 0));

        PsychicPowers kammer = (PsychicPowers) psychicPowers.getKammer();
        kammer.setGod(NURGLE, mark.isSelected("Mark of Nurgle"));
        kammer.setGod(TZEENTCH, mark.isSelected("Mark of Tzeentch"));
        kammer.setGod(SLAANESH, mark.isSelected("Mark of Slaanesh"));
        
        warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) psychicPowers.getPanel().getLocation().getY() + psychicPowers.getPanel().getSize().height + 5
        );
    }
}

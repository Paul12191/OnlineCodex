package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TALongstrike extends Eintrag {

	private OptionsUpgradeGruppe o2;
	private OptionsUpgradeGruppe o3;
	
    public TALongstrike() {
        name = "Longstrike";
        überschriftSetzen = true;
        grundkosten = getPts("Longstrike");
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/KrisisKampfanzugteam.gif"));
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Railgun", getPts("Railgun")));
        ogE.addElement(new OptionsGruppeEintrag("Ion cannon", getPts("Ion cannon")));
        o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o2);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 MV1 Gun Drones", getPts("MV1 Gun Drone") * 2 + getPts("Pulse carbine") * 4));
        ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system") * 2));
        o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(o3);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Seeker missile", getPts("Seeker missile")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        addWarlordTraits("T'au: Strength of Belief", true);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
        
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
}

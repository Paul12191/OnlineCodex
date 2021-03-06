package oc.wh40k.units.ch;

import static oc.KeyWord.CHAOS;
import static oc.KeyWord.CHARACTER;
import static oc.KeyWord.DAEMON;
import static oc.KeyWord.KEEPER_OF_SECRETS;
import static oc.KeyWord.MONSTER;
import static oc.KeyWord.PSYKER;
import static oc.KeyWord.SLAANESH;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHKeeperofSecrets extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	private final RuestkammerStarter psychicPowers;

    public CHKeeperofSecrets() {
        super(CHAOS, SLAANESH, DAEMON, CHARACTER, MONSTER, PSYKER, KEEPER_OF_SECRETS);

        name = "Keeper of Secrets";
        grundkosten = 0;
        power = 13;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Keeper of Secrets with living whip", getPts("Keeper of Secrets with living whip")));
        ogE.addElement(new OptionsGruppeEintrag("Keeper of Secrets with ritual knife", getPts("Keeper of Secrets with ritual knife")));
        ogE.addElement(new OptionsGruppeEintrag("Keeper of Secrets with shining aegis", getPts("Keeper of Secrets with shining aegis")));
        ogE.addElement(new OptionsGruppeEintrag("Keeper of Secrets with sinistrous hand", getPts("Keeper of Secrets with sinistrous hand")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        addWeapons(CHWaffenkammerCD.class, false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(2);
        ((PsychicPowers) psychicPowers.getKammer()).enableSlaanesh();
        ((PsychicPowers) psychicPowers.getKammer()).setSlaanesh(true);
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();

        addWarlordTraits("", SLAANESH);

        complete();

    }
    
    @Override
    public void refreshen() {
    	o1.alwaysSelected();
    }
}

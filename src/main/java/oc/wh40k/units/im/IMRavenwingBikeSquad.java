package oc.wh40k.units.im;

import oc.*;

public class IMRavenwingBikeSquad extends Eintrag {

    private final OptionsZaehlerGruppe o1, o2;
    private final RuestkammerStarter rkBoss;
    private final RuestkammerStarter rkTrike;
    private final AnzahlPanel squad;

    public IMRavenwingBikeSquad() {
        name = "Ravenwing Bike Squad";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Ravenwing Bike Squad", 3, 8, getPts("Ravenwing Bike Squad") + getPts("Twin boltgun") + getPts("Frag grenade") + getPts("Krak grenade"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setAktiv(0, true);

        seperator();

        ogE.addAll(IMSpaceMarinesSpecialWeapons.createRK("", "", buildaVater));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMSergeant("Ravenwing Bike Squad"), "Sergeant");
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        seperator();

        rkTrike = new RuestkammerStarter(ID, randAbstand, cnt, new IMRavenwingAttackBikeKammer(), "Ravenwing Attack Bike");
        add(rkTrike);

        complete();
    }

    @Override
    public void refreshen() {
        if (!rkBoss.isSelected())
            rkBoss.setSelected(true);
        o1.setMaxAnzahl(squad.getModelle() - 1);
        if (squad.getModelle() > 6) {
            power = 11;
        } else if (squad.getModelle() > 3) {
            power = 9;
        } else {
            power = 5;
        }
        if (rkTrike.isSelected()) {
            power += 3;
        }
    }
}
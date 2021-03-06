package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ORBoyz extends Eintrag {

	private final AnzahlPanel boyz;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o1x;

	private final OptionsZaehlerGruppe boyzFK;
	private final OptionsZaehlerGruppe boyzFK2;
	private final RuestkammerStarter Boss;

    public ORBoyz() {

        kategorie = 1;

        name = "Boyz";
        grundkosten = 0;
        add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Boyz", 10, 30, getPts("Boyz")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Choppa & Slugga", getPts("Choppa") + getPts("Slugga")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        ogE.addElement(new OptionsGruppeEintrag("Shoota", getPts("Shoota")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        add(boyzFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Tankbusta-bombs", getPts("Tankbusta-bombs")));
        add(boyzFK2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "Boss Nob");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setBoyBoss(true);
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultRanged("no weapon");
        ((ORWaffenUndGeschenke) Boss.getKammer()).setDefaultCloceCombat("no weapon");
        Boss.initKammer(false, false, false, false, false);
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Boss Nob"));
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();
    }


    @Override
    public void refreshen() {
        Boss.setAbwaehlbar(true);
        o1x.setMaxAnzahl(boyz.getModelle() - (Boss.isSelected() ? 1 : 0) - o1.getAnzahl() - boyzFK.getAnzahl());
        o1x.setAnzahl(0, o1x.getMaxAnzahl());
        o1.setMaxAnzahl(boyz.getModelle() - (Boss.isSelected() ? 1 : 0) - boyzFK.getAnzahl());
        boyzFK.setMaxAnzahl(boyz.getModelle() / 10);
        boyzFK2.setMaxAnzahl(boyz.getModelle() / 10);
        if (boyz.getModelle() > 20) {
            power = 11;
        } else if (boyz.getModelle() > 10) {
            power = 7;
        } else {
            power = 4;
        }
    }
}

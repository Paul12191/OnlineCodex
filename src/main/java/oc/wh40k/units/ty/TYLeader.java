package oc.wh40k.units.ty;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TYLeader extends RuestkammerVater {

    private final String type;

    private OptionsZaehlerGruppe o1;
    private OptionsZaehlerGruppe o2;
    private OptionsEinzelUpgrade oe1;

    public TYLeader(String type) {
        this.type = type;

        checkBuildaVater();

        if ("Metamorph".equals(type)) {
            ogE.addElement(new OptionsGruppeEintrag("Rending claws", getPts("Rending claws (GSC)")));
            ogE.addElement(new OptionsGruppeEintrag("Metamorph talon", getPts("Metamorph talon")));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Metamorph talon", getPts("Metamorph talon")));
            ogE.addElement(new OptionsGruppeEintrag("Metamorph whip", getPts("Metamorph whip")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Metamorph claw", getPts("Metamorph claw")));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));
            add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bonesword (GSC)", getPts("Bonesword (GSC)")));
        } else if ("Neophyte".equals(type)) {

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lash whip and bonesword", getPts("Lash whip and bonesword")));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul")));
            ogE.addElement(new OptionsGruppeEintrag("Power pick", getPts("Power pick")));
            ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol")));
            ogE.addElement(new OptionsGruppeEintrag("Web pistol", getPts("Web pistol")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        } else if ("Acolyte".equals(type)) {

            ogE.addElement(new OptionsGruppeEintrag("Cultist knife", getPts("Cultist knife")));
            ogE.addElement(new OptionsGruppeEintrag("Bonesword", getPts("Bonesword (GSC)")));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Autopistol", getPts("Autopistol")));
            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", getPts("Hand flamer")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lash whip and bonesword", getPts("Lash whip and bonesword")));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if ("Metamorph".equals(type)) {
            o1.setAktiv(!oe1.isSelected());
            o2.setAktiv(!oe1.isSelected());
            oe1.setAktiv(!o1.isSelected() && !o2.isSelected());
        } else if ("Neophyte".equals(type)) {
            o1.setAktiv(!oe1.isSelected());
            o2.setAktiv(!oe1.isSelected());
            oe1.setAktiv(!o1.isSelected() && !o2.isSelected());
        } else if ("Acolyte".equals(type)) {
            o1.setAktiv(!oe1.isSelected());
            o2.setAktiv(!oe1.isSelected());
            oe1.setAktiv(!o1.isSelected() && !o2.isSelected());
        }
    }
}
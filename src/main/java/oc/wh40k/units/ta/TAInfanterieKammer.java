package oc.wh40k.units.ta;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAInfanterieKammer extends RuestkammerVater {

    private OptionsEinzelUpgrade o1;
    private OptionsZaehlerGruppe o4;

    public TAInfanterieKammer(
            boolean shasui,
            boolean former,
            boolean späher) {

        if (shasui) {
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Markerlight", getPts("Markerlight")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Pulse pistol", getPts("Pulse pistol")));
            seperator();
        }

        if (former) {
            ogE.addElement(new OptionsGruppeEintrag("Pulsgewehr", 4));
            ogE.addElement(new OptionsGruppeEintrag("Pulskarabiner", 4));
            add(o4 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 1));

            add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jagdmunition", 1));
        }

        if (späher) {
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Pulse pistol", getPts("Pulse pistol")));
        }

        seperator();

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (o1 != null && o4 != null) {
            o1.setAktiv(!o4.isSelected());
        }
    }
}
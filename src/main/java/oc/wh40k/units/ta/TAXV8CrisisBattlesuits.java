package oc.wh40k.units.ta;

import java.util.Vector;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TAXV8CrisisBattlesuits extends Eintrag {

	private final RuestkammerStarter ob1;
	private final Vector<RuestkammerStarter> rk;
	private OptionsZaehlerGruppe o4, o5;
	public TAXV8CrisisBattlesuits() {
        name = "XV8 Crisis Battlesuits";
        überschriftSetzen = true;
        grundkosten = 0;


        seperator();

        ob1 = createTroopChampion(TAKampfanzugKammer.class, true, "Crisis Shas'vre", "Crisis Shas'vre");
        ob1.setGrundkosten(getPts("XV8 Crisis Battlesuits"));
        add(ob1);

        seperator();

        rk = new Vector<RuestkammerStarter>();
        for (int i = 0; i < 9; i++) {
            rk.add(createTroopChampion(TAKampfanzugKammer.class, false, "Crisis Shas'ui", "Crisis Shas'ui"));
            rk.lastElement().setGrundkosten(getPts("XV8 Crisis Battlesuits"));
            add(rk.lastElement());
        }

        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("XV8-02 Iridium battlesuite", getPts("XV8-02 Crisis Iridium battlesuite")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 16));
        
        complete();
    }

    @Override
    public void refreshen() {
        rk.get(8).setAktiv(!ob1.isSelected());
        int krisisNumber = (ob1.isSelected() && ob1.isAktiv() ? 1 : 0);
        for (int i = 0; i < 9; i++) {
            krisisNumber += (rk.get(i).isSelected() && rk.get(i).isAktiv() ? 1 : 0);
        }
   
        o4.setMaxAnzahl(krisisNumber * 2);
        
        o5.getPanel().setLocation(
                (int) o5.getPanel().getLocation().getX(),
                (int) rk.lastElement().getPanel().getLocation().getY() + rk.lastElement().getPanel().getSize().height + 5
        );
        
        o4.getPanel().setLocation(
                (int) o4.getPanel().getLocation().getX(),
                (int) o5.getPanel().getLocation().getY() + o5.getPanel().getSize().height + 5
        );
        
        if (!ob1.isSelected()) {
            ((TAKampfanzugKammer) ob1.getKammer()).clearEntries();
        }

        ((TAKampfanzugKammer) ob1.getKammer()).farsight = getCountFromInformationVector("Farsight Enclave") > 0;

        boolean error = false;
        for (int i = 0; i < 9; i++) {
            if (!rk.get(i).isSelected()) {
                ((TAKampfanzugKammer) rk.get(i).getKammer()).clearEntries();
            }
            if (((TAKampfanzugKammer) rk.get(i).getKammer()).uniqueError) {
                error = true;
            }
        }

        o5.setMaxAnzahl(krisisNumber / 3);

        if (((TAKampfanzugKammer) ob1.getKammer()).uniqueError
                || error) {
            setFehlermeldung("Ausrüstung doppelt!");
        } else if (getCountFromInformationVector("FEWarscaper") > 1) {
            setFehlermeldung("Warscaper doppelt!");
        } else {
            setFehlermeldung("");
        }
    }
}

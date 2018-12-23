package oc.wh40k.units.ta;

import oc.*;

public class TAKampfanzugKammer extends RuestkammerVater {

    public boolean uniqueError = false;
    private OptionsZaehlerGruppe o1;
    private OptionsUpgradeGruppe o2;
    private OptionsUpgradeGruppeUnique o2u;
    private OptionsUpgradeGruppeUnique o3u;
    private OptionsZaehlerGruppe o4;
    public OptionsUpgradeGruppe o5;
    private OptionsUpgradeGruppe o6;
    private boolean coldstar = false;
    public boolean farsight = false;
    private boolean XV08 = false;
    private boolean XV81 = false;
    private boolean XV84 = false;
    private boolean Kommando = false;
    private boolean Multispektrum = false;
    private boolean Onager = false;
    private boolean Reinflut = false;
    private boolean Repulsor = false;
    private boolean Selbstzerstörungssystem = false;
    private boolean Waffenstörfeldemitter = false;

    private boolean seismic = false;
    private boolean mirror = false;
    private boolean earth = false;
    private boolean talisman = false;
    private boolean FusionBlades = false;
    private boolean warscaper = false;

    public TAKampfanzugKammer(
            boolean commander,
            boolean breitseite,
            boolean geist,
            boolean ghostkeel) {
        grundkosten = 25;

        // Fernkampfwaffen
        if (breitseite) {
            ogE.addElement(new OptionsGruppeEintrag("Heavy rail rifle", getPts("Heavy rail rifle")));
            ogE.addElement(new OptionsGruppeEintrag("2 High-yield missile pods", getPts("High-yield missile pod") * 2));
            add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o5.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("2 Smart missile systems", getPts("Smart missile system") * 2));
            ogE.addElement(new OptionsGruppeEintrag("2 Plasma rifles", getPts("Plasma rifle") * 2));
            add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o6.setSelected(0, true);

            seperator();

            add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Seeker missile", getPts("Seeker missile")));
        } else if (geist) {
            ogE.addElement(new OptionsGruppeEintrag("Burst cannon", getPts("Burst cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion blaster", getPts("Fusion blaster")));
            add(o5 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));
        } else if (ghostkeel) {
            ogE.addElement(new OptionsGruppeEintrag("Fusion collider", getPts("Fusion collider")));
            ogE.addElement(new OptionsGruppeEintrag("Cyclic ion raker", getPts("Cyclic ion raker")));
            add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o5.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("2 Flamer", getPts("Flamer") * 2));
            ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon") * 2));
            ogE.addElement(new OptionsGruppeEintrag("2 Fusion blaster", getPts("Fusion blaster") * 2));
            add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o6.setSelected(0, true);
        } else {
            ogE.addElement(new OptionsGruppeEintrag("Airbursting fragmentation projector", getPts("Airbursting fragmentation projector")));
            ogE.addElement(new OptionsGruppeEintrag("Burst cannon", getPts("Burst cannon")));
            ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
            ogE.addElement(new OptionsGruppeEintrag("Fusion blaster", getPts("Fusion blaster")));
            ogE.addElement(new OptionsGruppeEintrag("Missile pod", getPts("Missile pod")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma rifle", getPts("Plasma rifle")));
            if (coldstar) {
                ogE.addElement(new OptionsGruppeEintrag("High-output burst cannon", getPts("High-output burst cannon")));
            } else {
                ogE.addElement(new OptionsGruppeEintrag("Cyclic ion blaster", getPts("Cyclic ion blaster")));
            }
            add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 1));
            if (commander) {
                o1.setMaxAnzahl(4);
                if (coldstar) {
                	o1.setAnzahl(4, 1);
                	o1.setAnzahl(6, 1);
                } else {
                	o1.setAnzahl(1, 1);
                	o1.setAnzahl(4, 1);
                }
            } else {
            	o1.setAnzahl(1, 1);
            }

            seperator();
        }

        seperator();

        // Unterstützungssysteme
        if (ghostkeel) {
            ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (Ghostkeel Riptide and Stormsurge)")));
            ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system")));
            ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
            ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (Ghostkeel Riptide and Stormsurge)")));
            ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
            ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (Ghostkeel Riptide and Stormsurge)")));
            ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (Ghostkeel Riptide and Stormsurge)")));
        } else {
            ogE.addElement(new OptionsGruppeEintrag("Advanced targeting system", getPts("Advanced targeting system (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Counterfire defence system", getPts("Counterfire defence system")));
            ogE.addElement(new OptionsGruppeEintrag("Drone controller", getPts("Drone controller")));
            ogE.addElement(new OptionsGruppeEintrag("Early warning override", getPts("Early warning override (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Multi-tracker", getPts("Multi-tracker")));
            ogE.addElement(new OptionsGruppeEintrag("Shield generator", getPts("Shield generator (all other models)")));
            ogE.addElement(new OptionsGruppeEintrag("Target lock", getPts("Target lock (all other units)")));
            ogE.addElement(new OptionsGruppeEintrag("Velocity tracker", getPts("Velocity tracker (all other units)")));
        }

        add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 1));

        if (commander) {
            o2.setMaxAnzahl(4);
        }

        if (ghostkeel) {
            o2.setMaxAnzahl(2);
        }

        seperator();

        cnt = randAbstand;

        seperator();

        if (commander) {
            ogE.clear();
            ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
            ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
            ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
            add(o4 = new OptionsZaehlerGruppe(0, randAbstand + 280, cnt, "", ogE, 2));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        boolean breitseite = false;
        boolean geist = false;
        boolean ghostkeel = false;
        if (!breitseite && !geist && !ghostkeel) {
        	
        } else if (geist) {
            if (!o5.isSelected()) {
                o5.setSelected(0, true);
            }
        } else if (breitseite || ghostkeel) {

            if (!o5.isSelected()) {
                o5.setSelected(0, true);
            }
            if (!o6.isSelected()) {
                o6.setSelected(0, true);
            }
        }

        boolean commander = false;
        if (commander && !coldstar) {
            o1.setAktiv(true);
            o2.setMaxAnzahl(4);
            int selected = o1.getAnzahl() + o2.getAnzahl();
            int remaining = 4 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAnzahl(o2.getAnzahl() + remaining);
            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
        }

        if (commander && coldstar) {
            o1.setAktiv(true);
            o2.setMaxAnzahl(2);
            int selected = o2.getAnzahl() + o1.getAnzahl();
            int remaining = 4 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAnzahl(o2.getAnzahl() + remaining);
            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 2);
        }

        boolean krisisshasui = false;
        if (krisisshasui) {
            int selected = o1.getAnzahl() + o2.getAnzahl();
            int remaining = 3 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAnzahl(o2.getAnzahl() + remaining);

            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
        }

        boolean krisisshasvre = false;
        if (krisisshasvre) {
            int selected = o1.getAnzahl() + o2.getAnzahl();
            int remaining = 3 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAnzahl(o2.getAnzahl() + remaining);

            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
        }

        boolean krisisleibwache = false;
        if (krisisleibwache) {
            int selected = o1.getAnzahl() + o2.getAnzahl();
            int remaining = 3 - selected;
            o1.setMaxAnzahl(o1.getAnzahl() + remaining);
            o2.setMaxAnzahl(o2.getAnzahl() + remaining);

            o1.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
            o2.setLegal(o1.getAnzahl() + o2.getAnzahl() >= 1);
        }

        if (geist) {
            o2.setMaxAnzahl(1);
        }

        if ((BuildaHQ.getCountFromInformationVectorGlobal("TAXV08") > 1 && XV08) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TAXV81") > 1 && XV81) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TAXV84") > 1 && XV84) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TAKommando") > 1 && Kommando) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TAMultispektrum") > 1 && Multispektrum) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TAOnager") > 1 && Onager) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TAReinflut") > 1 && Reinflut) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TARepulsor") > 1 && Repulsor) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TASelbstzerstörungssystem") > 1 && Selbstzerstörungssystem) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("TAWaffenstörfeldemitter") > 1 && Waffenstörfeldemitter) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("FESeismic") > 1 && seismic) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("FEEarth") > 1 && earth) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("FETalisman") > 1 && talisman) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("FEFusion") > 1 && FusionBlades) ||
                (BuildaHQ.getCountFromInformationVectorGlobal("FEWarscaper") > 1 && warscaper)) {
            uniqueError = true;
        } else {
            uniqueError = false;
        }


    }

    @Override
    public void deleteYourself() {

        if (XV08 == true) {
            XV08 = false;
            BuildaHQ.addToInformationVectorGlobal("TAXV08", -1);
        }

        if (XV81 == true) {
            XV81 = false;
            BuildaHQ.addToInformationVectorGlobal("TAXV81", -1);
        }

        if (XV84 == true) {
            XV84 = false;
            BuildaHQ.addToInformationVectorGlobal("TAXV84", -1);
        }

        if (Kommando == true) {
            Kommando = false;
            BuildaHQ.addToInformationVectorGlobal("TAKommando", -1);
        }

        if (Multispektrum == true) {
            Multispektrum = false;
            BuildaHQ.addToInformationVectorGlobal("TAMultispektrum", -1);
        }

        if (Onager == true) {
            Onager = false;
            BuildaHQ.addToInformationVectorGlobal("TAOnager", -1);
        }

        if (Reinflut == true) {
            Reinflut = false;
            BuildaHQ.addToInformationVectorGlobal("TAReinflut", -1);
        }

        if (Repulsor == true) {
            Repulsor = false;
            BuildaHQ.addToInformationVectorGlobal("TARepulsor", -1);
        }

        if (Selbstzerstörungssystem == true) {
            Selbstzerstörungssystem = false;
            BuildaHQ.addToInformationVectorGlobal("TASelbstzerstörungssystem", -1);
        }

        if (Waffenstörfeldemitter == true) {
            Waffenstörfeldemitter = false;
            BuildaHQ.addToInformationVectorGlobal("TAWaffenstörfeldemitter", -1);
        }

        if (mirror == true) {
            mirror = false;
            BuildaHQ.addToInformationVectorGlobal("FEMirror", -1);
        }

        if (seismic == true) {
            seismic = false;
            BuildaHQ.addToInformationVectorGlobal("FESeismic", -1);
        }

        if (earth == true) {
            earth = false;
            BuildaHQ.addToInformationVectorGlobal("FEEarth", -1);
        }

        if (talisman == true) {
            talisman = false;
            BuildaHQ.addToInformationVectorGlobal("FETalisman", -1);
        }

        if (FusionBlades == true) {
            FusionBlades = false;
            BuildaHQ.addToInformationVectorGlobal("FEFusion", -1);
        }

        if (warscaper == true) {
            warscaper = false;
            BuildaHQ.addToInformationVectorGlobal("FEWarscaper", -1);
        }


        super.deleteYourself();
    }

    public void setColdstar(boolean cs) {
        coldstar = cs;
    }

    public void clearEntries() {
        boolean entryCleared = false;

        if (o1 != null && o1.isSelected()) {
            o1.setMaxAnzahl(0);
            entryCleared = true;
        }
        if (o2u != null && o2u.isSelected()) {
            o2u.deselectAll();
            entryCleared = true;
        }
        if (o3u != null && o3u.isSelected()) {
            o3u.deselectAll();
            entryCleared = true;
        }
        if (o4 != null && o4.isSelected()) {
            o4.setMaxAnzahl(0);
            entryCleared = true;
        }
        if (o5 != null && o5.isSelected()) {
            o5.deselectAll();
            entryCleared = true;
        }
        if (o6 != null && o6.isSelected()) {
            o6.deselectAll();
            entryCleared = true;
        }
        if (entryCleared) {
            RefreshListener.fireRefresh();
        }
    }
}
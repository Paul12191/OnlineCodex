package oc.wh40k.units.ch;

import oc.Eintrag;

public class CHAbaddontheDespoiler extends Eintrag {

    public CHAbaddontheDespoiler() {

        name = "Abaddon the Despoiler";
        grundkosten = getPts("Abaddon the Despoiler");
        power = 12;

        seperator();

        addWarlordTraits("Black Legion: First Amongst Traitors", false);

        complete();

    }

    @Override
    public void refreshen() {
        setUnikat(true);
        
        if(getWarlordtraits().warlordSelected) {
        	setInformationVectorValue("AdditionalCPAbaddon", 2);
        } else {
        	setInformationVectorValue("AdditionalCPAbaddon", 0);
        }
    }
}

package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.Eintrag;

public class IMOfficeroftheFleet extends Eintrag {

    public IMOfficeroftheFleet() {
    	super(IMPERIUM, ASTRA_MILITARUM, INFANTRY, CHARACTER, OFFICER, OFFICER_OF_THE_FLEET);
    	
        name = "Officer of the Fleet";
        grundkosten = getPts("Officer of the Fleet") + getPts("Laspistol");
        power = 2;

        add(ico = new oc.Picture("oc/wh40k/images/IGCaptainThanstadt.jpg"));
        
        seperator();
        
        addWeapons(IMAstraMilitarumRuestkammer.class, true);
                
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}
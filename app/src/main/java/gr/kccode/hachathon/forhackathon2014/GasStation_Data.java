package gr.kccode.hachathon.forhackathon2014;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Chris on 11/29/2014.
 */
public class GasStation_Data extends BasicData {


    public GasStation_Data(){
        super();
    }
    public GasStation_Data(int ID, LatLng point, String label){
        super(ID, point, label);
    }


}

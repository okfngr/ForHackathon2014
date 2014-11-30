package gr.kccode.hachathon.forhackathon2014;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Chris on 11/29/2014.
 */
public class Parking_Data extends BasicData {

    public Parking_Data(){
        super();
    }
    public Parking_Data(int ID, LatLng point, String label){
        super(ID, point, label);
    }

}

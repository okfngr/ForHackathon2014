package gr.kccode.hachathon.forhackathon2014;



import com.google.android.gms.maps.model.LatLng;


/**
 * Created by Chris on 11/29/2014.
 */
public class Wifi_Data extends BasicData{


    private String Description;

    public Wifi_Data(){super();}

    public Wifi_Data(int ID,LatLng point, String label, String description) {
        super(ID,point,label);
        this.setDescription(description);


    }
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}

package gr.kccode.hachathon.forhackathon2014;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Chris on 11/29/2014.
 */
public class Culture_Data extends BasicData {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(String type) {
        this.type = Type.CINEMA;
    }
    public void setType(Type type) {
        this.type = type;
    }

    public static enum Type{CINEMA, THEATER, MUSEUM};
    String label;
    private String description;
    private Type type;


    public Culture_Data(){
        super();
    }

    public Culture_Data(int ID,LatLng point, String label, String description,Type type){
        super(ID, point, label);
        this.setDescription(description);
        this.setType(type);

    }
}

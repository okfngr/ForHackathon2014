package gr.kccode.hachathon.forhackathon2014;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Chris on 11/29/2014.
 */
public class Culture_Data extends BasicData {

    private String description;
    private Type type;

    public Culture_Data() {
        super();
    }

    public Culture_Data(int ID, LatLng point, String label, String description, Type type) {
        super(ID, point, label);
        this.setDescription(description);
        this.setType(type);

    }

    public static ArrayList<BasicData> getTypes() {
        ArrayList<BasicData> bc = new ArrayList<BasicData>();
        for (Type value : Type.values()) {
            BasicData BC = new BasicData();
            BC.setLabel(value.toString());
            BC.setID(value.code());
            bc.add(BC);
        }
        return bc;
    }

    public static Type getType(int id_type) {

        for (Type value : Type.values()) {
            if (value.code() == id_type) return value;
        }
        return Type.CINEMA;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setType(String str) {
        if(str.equals("CINEMA")) {
            this.setType(Type.CINEMA);
        return;}

        if(str.equals("THEATER")) {this.setType(Type.THEATER);return;}
        if(str.equals("MUSEUM")){ this.setType(Type.MUSEUM);return;}
        this.setType(Type.ETC);



    }

    public int getTypeToId() {
        return type.code();
    }

    public static enum Type {
        CINEMA(1), THEATER(2), MUSEUM(3), ETC(4);
        int index;

        Type(int k) {
            index = k;
        }

        public int code() {
            return index;
        }
    }
}

package gr.kccode.hachathon.forhackathon2014;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Chris on 11/29/2014.
 */
public class BasicData {
    private int ID;
    private LatLng point;
    private String label;

    public BasicData() {
    }

    ;

    public BasicData(int ID, LatLng point, String Label) {
        this.setID(ID);
        this.setPoint(point);
        this.setLabel(Label);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public LatLng getPoint() {
        return point;
    }

    public void setPoint(LatLng point) {
        this.point = point;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getX() {
        return point.longitude;
    }

    public double getY() {
        return point.latitude;
    }


    public void setX(double X) {
        this.point=new LatLng(X,this.getY());
    }
    public void setY(double Y) {
        this.point=new LatLng(this.getX(),Y);
    }
}
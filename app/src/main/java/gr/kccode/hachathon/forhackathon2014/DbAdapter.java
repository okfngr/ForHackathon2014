package gr.kccode.hachathon.forhackathon2014;

/**
 * Created by Chris on 11/29/2014.
 */

import com.google.android.gms.internal.cs;
import com.google.android.gms.maps.model.LatLng;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


final class DbAdapter {
    private static DbAdapter Instance = new DbAdapter();

    private DbAdapter() {
    }

    /**
     * @return instance of this class
     */
    public static DbAdapter getInstance() {
        return Instance;
    }

    /**
     * array of hotspots
     */
    private ArrayList<BasicData> hotspots = new ArrayList<BasicData>();

    /**
     * array of Parking_Datas
     */
    private ArrayList<BasicData> parkings = new ArrayList<BasicData>();


    /**
     * array of Gashotspots
     */
    private ArrayList<BasicData> gashspots = new ArrayList<BasicData>();

    /**
     * array of dates
     */
    private ArrayList<BasicData> dates = new ArrayList<BasicData>();

    /**
     * array of timeline hotspots
     */
    private ArrayList<BasicData> culturals = new ArrayList<BasicData>();


    /**
     * dbHelper object to interact with the db
     */
    private DbHelper db;

    /**
     * The active Calendar_Data after a successful login
     */
    private Calendar_Data activeCalendar_Data;


    /**
     * Fills the arrays with data from the DB
     */
    private void fillArrays() {

        hotspots = db.getAllWifi_Data();
       parkings = db.getAllParking_Data();
        gashspots = db.getAllGasStation_Data();
        dates = db.getAllCalendar_Data();
        culturals = db.getAllCulture_Data();
    }

    /**
     * @return all the hotspots in the DB
     */
    public ArrayList<BasicData> gethotspots() {
        return this.hotspots;
    }

    /**
     * @return all the Parking_Datas in the DB
     */
    public ArrayList<BasicData> getParking_Datas() {
        return parkings;
    }


    /**
     * @return all the dates in the DB
     */
    public ArrayList<BasicData> getdates() {
        return dates;
    }

    /**
     * @return all the Gashotspots in the DB
     */
    public ArrayList<BasicData> getGashotspots() {
        return gashspots;
    }

    /**
     * @return all the timeline hotspots
     */
    public ArrayList<BasicData> getcultura() {
        return this.culturals;
    }

    /**
     * fills the db if data if the tables are empty and then fill the arrays with the data from the db
     *
     * @param db
     */
    public void setDB(DbHelper db) {
        this.db = db;
        if (!hotspots.isEmpty()) {
            this.hotspots.clear();
            this.parkings.clear();
            this.culturals.clear();
            this.gashspots.clear();

        }
        this.fillArrays();

        if(hotspots.isEmpty()){
            populateDB();
            fillArrays();

        }

    }

    /**
     *
     * @param Parking_Data_id
     * @return the hotspots that belong to the Parking_Data with this id
     */


    /**
     * Inserts the data into the tables
     */
    private void populateDB() {

        this.db.AddWifi_Data(new Wifi_Data(1,new LatLng(40.641142, 22.934721),"wifi",""));
        this.db.AddWifi_Data(new Wifi_Data(2,new LatLng(40.635650, 22.935431),"free wifi",""));
        this.db.AddWifi_Data(new Wifi_Data(3,new LatLng(40.630440, 22.942912),"The wifi",""));
        this.db.AddWifi_Data(new Wifi_Data(4,new LatLng(40.632804, 22.941331),"Dat wifi",""));
        this.db.AddWifi_Data(new Wifi_Data(5,new LatLng(40.632511, 22.947489),"sooo wifi",""));

        this.db.addParking_Data(new Parking_Data(1,new LatLng(40.641142,  22.934721),"Free Parking"));
        this.db.addParking_Data(new Parking_Data(2,new LatLng(40.635650,  22.935431),"Free Parking"));
        this.db.addParking_Data(new Parking_Data(3,new LatLng(40.630440,  22.942912),"Free Parking"));
        this.db.addParking_Data(new Parking_Data(4,new LatLng(40.632804,  22.941331),"Free Parking"));
        this.db.addParking_Data(new Parking_Data(5,new LatLng(40.632511,  22.947489),"Free Parking"));

        this.db.addGasStation_Data(new GasStation_Data(1,new LatLng(40.641142,  22.934721),"Gaass"));
        this.db.addGasStation_Data(new GasStation_Data(2,new LatLng(40.635650,  22.935431),"Expensive Gas"));
        this.db.addGasStation_Data(new GasStation_Data(3,new LatLng(40.630440,  22.942912),"Too much expensive gas"));
        this.db.addGasStation_Data(new GasStation_Data(4,new LatLng(40.632804,  22.941331),"whyy!?"));
        this.db.addGasStation_Data(new GasStation_Data(5,new LatLng(40.632511,  22.947489),"So expensive"));

        Calendar_Data cd=new Calendar_Data();
        cd.setYear(2014);
        cd.setMonth(11);
        cd.setDayOfMonth(30);
        cd.setStartTime(6,0);
        cd.setEndTime(19,00);
        cd.setLabel("HackaThess!");
        cd.setDescription("Apps for Thessaloniki");
        cd.setLink("NOW!");
        cd.setPoint(new LatLng(40.621126, 22.955502));

        this.db.addCalendar_Data(cd);

        cd=new Calendar_Data();
        cd.setYear(2014);
        cd.setMonth(12);
        cd.setDayOfMonth(25);
        cd.setStartTime(0,0);
        cd.setEndTime(23,59);
        cd.setLabel("ChristMas!!");
        cd.setDescription("Oh Christmas!");
        cd.setLink("Its christmas time!");
        cd.setPoint(new LatLng(40.621126, 22.955502));

        this.db.addCalendar_Data(cd);

        cd=new Calendar_Data();
        cd.setYear(2015);
        cd.setMonth(1);
        cd.setDayOfMonth(1);
        cd.setStartTime(0,0);
        cd.setEndTime(23,59);
        cd.setLabel("First Day of the year!");
        cd.setDescription("2015!!!!");
        cd.setLink("Happy new Year!");
        cd.setPoint(new LatLng(40.621126, 22.955502));

        this.db.addCalendar_Data(cd);




        this.db.addCulture_Data(new Culture_Data(1,new LatLng(40.633257, 22.944343),"Odeon","A cinema at the heart of the city",Culture_Data.Type.CINEMA));

        this.db.addCulture_Data(new Culture_Data(2,new LatLng(40.630440,  22.942912),"Village","A cinema at Thessaloniki's Port ",Culture_Data.Type.CINEMA));

        this.db.addCulture_Data(new Culture_Data(3,new LatLng(40.632511,  22.947489),"Aristotelion","A very Famous Theater",Culture_Data.Type.THEATER));
        this.db.addCulture_Data(new Culture_Data(4,new LatLng(40.632511,  22.947489),"Aneton","Another Famous  Theater",Culture_Data.Type.THEATER));
        this.db.addCulture_Data(new Culture_Data(5,new LatLng(40.635650,  22.935431), "Archeologicaal Museum","A museum",Culture_Data.Type.MUSEUM));



    }


    public Culture_Data getCulturebyId(int id_culture) {
        for(int i=0;i<culturals.size();i++){
            if(culturals.get(i).getID()==id_culture) return (Culture_Data)culturals.get(i);
        }
        return new Culture_Data();
    }

    public ArrayList<BasicData> getculturabyType(Culture_Data.Type type) {

        ArrayList<BasicData> bds=new ArrayList<BasicData>();

        for(int i=0; i<this.getcultura().size();i++){
            Culture_Data cd=(Culture_Data) this.getcultura().get(i);
            if(cd.getType().code()==type.code()){
                bds.add(cd);
            }
        }
        return bds;



    }

    public BasicData getdatebyId(int id) {

        for(BasicData bd: this.getdates()){
            if(bd.getID()==id) return bd;
        }
        return null;
    }

    public ArrayList<BasicData> getExistEvents(int day, int month, int year) {

        ArrayList<BasicData> bc=new ArrayList<BasicData>();

        for(int i=0; i<this.getdates().size();i++){
            Calendar_Data c=(Calendar_Data)this.getdates().get(i);
            if(c.equalDay(day,month,year)){
                bc.add(c);
            }
        }

        return bc;
    }
}

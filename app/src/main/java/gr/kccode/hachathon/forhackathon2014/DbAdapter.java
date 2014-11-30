package gr.kccode.hachathon.forhackathon2014;

/**
 * Created by Chris on 11/29/2014.
 */

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

    }


}

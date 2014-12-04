package gr.kccode.hachathon.forhackathon2014;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;

import java.sql.SQLDataException;
import java.util.ArrayList;

/**
 *
 * Extends SQLiteOpenHelper and is responsible for creating the tables of the db,
 * updating the db and deleting the db. Created 11/29/2014
 * @author Chris
 *
 */
public class DbHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "HACKATHONDB";



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * creates the tables of the db if they dont already exist
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;


        // SQL statement to create table CULTURE_DATA
        query = "CREATE TABLE IF NOT EXISTS CALENDAR_DATA ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "year INTEGER, "  +
                "month INTEGER, "+
                "dayOfMonth INTEGER, "+
                "hourStart INTEGER, "+
                "minuteStart INTEGER, "+
                "hourEnd INTEGER, "+
                "minuteEnd INTEGER, "+
                "d_x REAL, "+
                "d_y REAL, "+
                "label TEXT, "+
                "description TEXT, " +
                "link TEXT)";

        // create CULTURE DATA
        db.execSQL(query);

        // SQL statement to create table Calendar_Data
        query = "CREATE TABLE IF NOT EXISTS WIFI_DATA ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "d_x REAL, "+
                "d_y REAL, "+
                "label TEXT,"+
                "description TEXT)";

        // create Calendar_Data table
        db.execSQL(query);

        // SQL statement to create table photo
        query = "CREATE TABLE IF NOT EXISTS PARKING_DATA ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "d_x REAL, "+
                "d_y REAL, "+
                "label TEXT,"+
                "description TEXT)";

        // create photo table
        db.execSQL(query);

        // SQL statement to create table movie
        query = "CREATE TABLE IF NOT EXISTS GASSTATION_DATA ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "d_x REAL, "+
                "d_y REAL, "+
                "label TEXT,"+
                "description TEXT)";

        // create movie table
        db.execSQL(query);

        // SQL statement to create table timelinestation
        query = "CREATE TABLE IF NOT EXISTS CULTURE_DATA ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "d_x REAL, "+
                "d_y REAL, "+
                "label TEXT,"+
                "description TEXT," +
                "type TEXT)";

        // create timelinestation table
        db.execSQL(query);



    }

    /**
     * updates the db
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older route table if exists
        db.execSQL("DROP TABLE IF EXISTS CALENDAR_DATA");

        // Drop older Calendar_Data table if exists
        db.execSQL("DROP TABLE IF EXISTS WIFI_DATA");

        // Drop older photo table if exists
        db.execSQL("DROP TABLE IF EXISTS PARKING_DATA");

        // Drop older movie table if exists
        db.execSQL("DROP TABLE IF EXISTS GASSTATION_DATA");

        // Drop older timelinestation table if exists
        db.execSQL("DROP TABLE IF EXISTS CULTURE_DATA");

        

        // create fresh tables
        this.onCreate(db);

    }

   
    /**
     * adds a new entry Calendar_Data to the table Calendar_Data
     * @param calendar_data
     */
    public void addCalendar_Data(Calendar_Data calendar_data)
    {
        String table="CALENDAR_DATA";

        SQLiteDatabase db = null;
        // get reference to writable DB
        try{

            db = this.getWritableDatabase();

            //ContentValues to add key "column"/value
            ContentValues values = new ContentValues();
            values.put("year",calendar_data.getYear());
            values.put("month",calendar_data.getMonth());
            values.put("dayOfMonth",calendar_data.getDayOfMonth());
            values.put("hourStart",calendar_data.getSth());
            values.put("minuteStart",calendar_data.getStm());
            values.put("hourEnd",calendar_data.getEndh());
            values.put("minuteEnd",calendar_data.getEndm());
            values.put("d_x", calendar_data.getX());
            values.put("d_y",calendar_data.getY());
            values.put("label", calendar_data.getLabel()); // get description
            values.put("description", calendar_data.getDescription());
            values.put("link", calendar_data.getLink());


            //insert
            db.insert(table, // table
                    null, //nullColumnHack
                    values); // key/value -> keys = column names/ values = column values

        }
        finally
        {
            //close
            if (null != db)
                db.close();
        }
    }

    /**
     * adds a new entry to the table wifi_data
     * @param wifi_data
     */
    public void AddWifi_Data(Wifi_Data wifi_data)
    {
        String table="WIFI_DATA";

        SQLiteDatabase db = null;
        // get reference to writable DB
        try{
            db = this.getWritableDatabase();
            // get reference to writable DB
            db = this.getWritableDatabase();

            //ContentValues to add key "column"/value
            ContentValues values = new ContentValues();

            values.put("d_x", wifi_data.getX());
            values.put("d_y",wifi_data.getY());
            values.put("label", wifi_data.getLabel()); // get description
            values.put("description", wifi_data.getDescription());


            //insert
            db.insert(table, // table
                    null, //nullColumnHack
                    values); // key/value -> keys = column names/ values = column values

        }
        finally
        {
            //close
            if (null != db)
                db.close();
        }

    }

    
    /**
     * adds a new entry to the table movie
     * @param parking_data
     */
    public void addParking_Data(Parking_Data parking_data)
    {
        String table= "PARKING_DATA";


        SQLiteDatabase db = null;
        // get reference to writable DB
        try{
            db = this.getWritableDatabase();
            //ContentValues to add key "column"/value
            ContentValues values = new ContentValues();

            values.put("d_x", parking_data.getX());
            values.put("d_y",parking_data.getY());
            values.put("label", parking_data.getLabel()); // get description



            //insert
            db.insert(table, // table
                    null, //nullColumnHack
                    values); // key/value -> keys = column names/ values = column values
        }
        finally
        {
            //close
            if (null != db)
                db.close();
        }
    }




    /**
     *
     * @param gasStation_data
     */
    public void addGasStation_Data(GasStation_Data gasStation_data)
    {
        String table= "GASSTATION_DATA";

        SQLiteDatabase db = null;
        // get reference to writable DB
        try{
            // get reference to writable DB
            db = this.getWritableDatabase();

            //ContentValues to add key "column"/value
            ContentValues values = new ContentValues();

            values.put("d_x", gasStation_data.getX());
            values.put("d_y",gasStation_data.getY());
            values.put("label", gasStation_data.getLabel()); // get description


            //insert
            db.insert(table, // table
                    null, //nullColumnHack
                    values); // key/value -> keys = column names/ values = column values
        }
        finally
        {
            //close
            if (null != db)
                db.close();
        }
    }


    /**
     * adds a new entry to the table milestone
     * @param culture_data
     */
    public void addCulture_Data(Culture_Data culture_data)
    {
        String table="CULTURE_DATA";

        SQLiteDatabase db = null;
        // get reference to writable DB
        try{
            // get reference to writable DB
            db = this.getWritableDatabase();

            //ContentValues to add key "column"/value
            ContentValues values = new ContentValues();

            values.put("d_x", culture_data.getX());
            values.put("d_y",culture_data.getY());
            values.put("label", culture_data.getLabel()); // get description
            values.put("description", culture_data.getDescription());
            values.put("type", culture_data.getType().toString());

            //insert
            db.insert(table, // table
                    null, //nullColumnHack
                    values); // key/value -> keys = column names/ values = column values
        }
        finally
        {
            //close
            if (null != db)
                db.close();
        }
    }



    public Calendar_Data getCalendar_Data(int id)
    {
        String table="CALENDAR_DATA";

        //reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"id","year","month","dayOfMonth","hourStart","minuteStart",
                "hourEnd","minuteEnd","d_x","d_y","label","description","link"};
        //build query
        Cursor cursor =
                db.query(table, // a. table
                        columns, // column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //if we got results get the first one
        if (null != cursor)
            cursor.moveToFirst();

        //build Calendar_Data object
        Calendar_Data calendar_data = new Calendar_Data();
        calendar_data.setID(Integer.parseInt(cursor.getString(0))); //id
        calendar_data.setYear(Integer.parseInt(cursor.getString(1)));
        calendar_data.setMonth(Integer.parseInt(cursor.getString(2)));
        calendar_data.setDayOfMonth(Integer.parseInt(cursor.getString(3)));
        calendar_data.setSth(Integer.parseInt(cursor.getString(4)));
        calendar_data.setStm(Integer.parseInt(cursor.getString(5)));
        calendar_data.setEndh(Integer.parseInt(cursor.getString(6)));
        calendar_data.setEndm(Integer.parseInt(cursor.getString(7))); //name
        calendar_data.setX(Double.parseDouble(cursor.getString(8))); //name
        calendar_data.setY(Double.parseDouble(cursor.getString(9))); //name
        calendar_data.setLabel(cursor.getString(10)); //description
        calendar_data.setDescription(cursor.getString(11)); //route_id
        calendar_data.setLink(cursor.getString(12)); //point

        //return calendar_data
        return calendar_data;
    }

    /**
     * returns the wifi_data with this id
     * @param id
     * @return
     */
    public Wifi_Data getWifi_Data(int id)
    {
        String table="WIFI_DATA";

        //reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"id","d_x","d_y","label"};
        //build query
        Cursor cursor =
                db.query(table, // a. table
                        columns, // column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //if we got results get the first one
        if (null != cursor)
            cursor.moveToFirst();

        //build Calendar_Data object
        Wifi_Data wifi_data = new Wifi_Data();
        wifi_data.setID(Integer.parseInt(cursor.getString(0))); //id
        wifi_data.setX(Double.parseDouble(cursor.getString(1))); //name
        wifi_data.setY(Double.parseDouble(cursor.getString(2))); //name
        wifi_data.setLabel(cursor.getString(3)); //description


        //return wifi_data
        return wifi_data;
    }



    /**
     * Returns the movie with this id
     * @param id
     * @return
     */
    public Parking_Data getParking_Data(int id)
    {
        String table="WIFI_DATA";

        //reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"id","d_x","d_y","label"};
        //build query
        Cursor cursor =
                db.query(table, // a. table
                        columns, // column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //if we got results get the first one
        if (null != cursor)
            cursor.moveToFirst();

        //build Calendar_Data object
        Parking_Data parking_data = new Parking_Data();
        parking_data.setID(Integer.parseInt(cursor.getString(0))); //id
        parking_data.setX(Double.parseDouble(cursor.getString(1))); //name
        parking_data.setY(Double.parseDouble(cursor.getString(2))); //name
        parking_data.setLabel(cursor.getString(3)); //description


        //return parking_data
        return parking_data;
    }

    /**
     * returns the user with this id
     * @param id
     * @return
     */
    public GasStation_Data getGasStation_Data(int id)
    {
        String table="GASSTATION_DATA";

        //reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"id","d_x","d_y","label"};
        //build query
        Cursor cursor =
                db.query(table, // a. table
                        columns, // column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //if we got results get the first one
        if (null != cursor)
            cursor.moveToFirst();

        //build Calendar_Data object
        GasStation_Data gasStation_data = new GasStation_Data();
        gasStation_data.setID(Integer.parseInt(cursor.getString(0))); //id
        gasStation_data.setX(Double.parseDouble(cursor.getString(1))); //name
        gasStation_data.setY(Double.parseDouble(cursor.getString(2))); //name
        gasStation_data.setLabel(cursor.getString(3)); //description


        //return gasStation_data
        return gasStation_data;
    }

    /**
     * Returns the milestone with this id,without the milestones arraylist
     * @param id
     * @return
     */
    public Culture_Data getCulture_Data(int id)
    {
        String table="CALENDAR_DATA";

        //reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        String[] columns = {"id","d_x","d_y","label","description","type"};
        //build query
        Cursor cursor =
                db.query(table, // a. table
                        columns, // column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        //if we got results get the first one
        if (null != cursor)
            cursor.moveToFirst();

        //build Calendar_Data object
        Culture_Data culture_data = new Culture_Data();
        culture_data.setID(Integer.parseInt(cursor.getString(0))); //id
        culture_data.setX(Double.parseDouble(cursor.getString(1))); //name
        culture_data.setY(Double.parseDouble(cursor.getString(2))); //name
        culture_data.setLabel(cursor.getString(3)); //description
        culture_data.setDescription(cursor.getString(4)); //route_id
        culture_data.setType(cursor.getString(5)); //point

        //return culture_data
        return culture_data;
    }


    /**
     *
     * @return all dates in the db
     */
    public ArrayList<BasicData> getAllCalendar_Data()
    {
        String table="CALENDAR_DATA";



        //build the query
        String query = "SELECT  * FROM " + table;

        //get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //go over each row, build Calendar_Data and add it to list
        ArrayList<BasicData> dates=new ArrayList<BasicData>();
        if (cursor.moveToFirst()) {
            do {
                //build calendar_data object
                Calendar_Data calendar_data = new Calendar_Data();
                calendar_data.setID(Integer.parseInt(cursor.getString(0))); //id
                calendar_data.setYear(Integer.parseInt(cursor.getString(1)));
                calendar_data.setMonth(Integer.parseInt(cursor.getString(2)));
                calendar_data.setDayOfMonth(Integer.parseInt(cursor.getString(3)));
                calendar_data.setSth(Integer.parseInt(cursor.getString(4)));
                calendar_data.setStm(Integer.parseInt(cursor.getString(5)));
                calendar_data.setEndh(Integer.parseInt(cursor.getString(6)));
                calendar_data.setEndm(Integer.parseInt(cursor.getString(7))); //name
                calendar_data.setX(Double.parseDouble(cursor.getString(8))); //name
                calendar_data.setY(Double.parseDouble(cursor.getString(9))); //name
                calendar_data.setLabel(cursor.getString(10)); //description
                calendar_data.setDescription(cursor.getString(11)); //route_id
                calendar_data.setLink(cursor.getString(12)); //point

                dates.add(calendar_data);
            } while (cursor.moveToNext());
        }

        // return routes
        return dates;
    }

    /**
     *
     * @return all dates in the db
     */
    public ArrayList<BasicData> getAllWifi_Data()
    {
        String table="WIFI_DATA";



        //build the query
        String query = "SELECT  * FROM " + table;

        //get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //go over each row, build Calendar_Data and add it to list
        ArrayList<BasicData> wifis = new ArrayList<BasicData>();
        if (cursor.moveToFirst()) {
            do {
                //build calendar_data object
                Wifi_Data wifi_data = new Wifi_Data();
                wifi_data.setID(Integer.parseInt(cursor.getString(0))); //id
                wifi_data.setX(Double.parseDouble(cursor.getString(1))); //name
                wifi_data.setY(Double.parseDouble(cursor.getString(2))); //name
                wifi_data.setLabel(cursor.getString(3)); //description

                wifis.add(wifi_data);
            } while (cursor.moveToNext());
        }

        // return routes
        return wifis;
    }

    /**
     *
     * @return all parkings in the db
     */
    public ArrayList<BasicData> getAllParking_Data()
    {
        String table="PARKING_DATA";



        //build the query
        String query = "SELECT  * FROM " + table;

        //get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //go over each row, build Calendar_Data and add it to list
        ArrayList<BasicData> parkings = new ArrayList<BasicData>();
        if (cursor.moveToFirst()) {
            do {
                //build calendar_data object
                Parking_Data parking_data = new Parking_Data();
                parking_data.setID(Integer.parseInt(cursor.getString(0))); //id
                parking_data.setX(Double.parseDouble(cursor.getString(1))); //name
                parking_data.setY(Double.parseDouble(cursor.getString(2))); //name
                parking_data.setLabel(cursor.getString(3)); //description

                parkings.add(parking_data);
            } while (cursor.moveToNext());
        }

        // return routes
        return parkings;
    }


    /**
     *
     * @return all gasStations in the db
     */
    public ArrayList<BasicData> getAllGasStation_Data()
    {
        String table="GASSTATION_DATA";



        //build the query
        String query = "SELECT  * FROM " + table;

        //get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //go over each row, build Calendar_Data and add it to list
        ArrayList<BasicData> gasStations = new ArrayList<BasicData>();
        if (cursor.moveToFirst()) {
            do {
                //build calendar_data object
                GasStation_Data gasStation_data = new GasStation_Data();
                gasStation_data.setID(Integer.parseInt(cursor.getString(0))); //id
                gasStation_data.setX(Double.parseDouble(cursor.getString(1))); //name
                gasStation_data.setY(Double.parseDouble(cursor.getString(2))); //name
                gasStation_data.setLabel(cursor.getString(3)); //description

                gasStations.add(gasStation_data);
            } while (cursor.moveToNext());
        }

        // return routes
        return gasStations;
    }

    /**
     *
     * @return all parkings in the db
     */
    public ArrayList<BasicData> getAllCulture_Data()
    {
        String table="CULTURE_DATA";



        //build the query
        String query = "SELECT  * FROM " + table;

        //get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //go over each row, build Calendar_Data and add it to list
        ArrayList<BasicData> culturals = new ArrayList<BasicData>();
        if (cursor.moveToFirst()) {
            do {
                //build calendar_data object
                Culture_Data culture_data = new Culture_Data();
                culture_data.setID(Integer.parseInt(cursor.getString(0))); //id
                culture_data.setX(Double.parseDouble(cursor.getString(1))); //name
                culture_data.setY(Double.parseDouble(cursor.getString(2))); //name
                culture_data.setLabel(cursor.getString(3)); //description
                culture_data.setDescription(cursor.getString(4)); //route_id
                culture_data.setType(cursor.getString(5));

                culturals.add(culture_data);

            } while (cursor.moveToNext());
        }

        // return routes
        return culturals;
    }

    


    
}


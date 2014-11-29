package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;


public class MainMenu extends Activity {

    private ImageButton wifi;
    private ImageButton parking;
    private ImageButton gasStation;
    private ImageButton calendar;
    private ImageButton culture;
    private ImageButton about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main_menu);


        wifi = (ImageButton)findViewById(R.id.wifi);
        wifi.setOnClickListener(wifiButtonOnClickListener);

        parking = (ImageButton)findViewById(R.id.parking);
        parking.setOnClickListener(parkingButtonOnClickListener);

        gasStation = (ImageButton)findViewById(R.id.gasStation);
        gasStation.setOnClickListener(gasStationButtonOnClickListener);

        calendar = (ImageButton)findViewById(R.id.calendar);
        calendar.setOnClickListener(calendarButtonOnClickListener);

        culture = (ImageButton)findViewById(R.id.culture);
        culture.setOnClickListener(cultureButtonOnClickListener);

        about = (ImageButton)findViewById(R.id.about);
        about.setOnClickListener(aboutButtonOnClickListener);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Starts the wifi activity
    View.OnClickListener wifiButtonOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainMenu.this, Wifi.class);
            MainMenu.this.startActivity(intent);
        }};

    //Starts the parking activity
    View.OnClickListener parkingButtonOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainMenu.this, Parking.class);
            MainMenu.this.startActivity(intent);
        }};

    //Starts the calendar activity
    View.OnClickListener calendarButtonOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainMenu.this, Calendar.class);
            MainMenu.this.startActivity(intent);
        }};

    //Starts the culture activity
    View.OnClickListener cultureButtonOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainMenu.this, Culture.class);
            MainMenu.this.startActivity(intent);
        }};

    //Starts the gasStation activity
    View.OnClickListener gasStationButtonOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainMenu.this, GasStation.class);
            MainMenu.this.startActivity(intent);
        }};

    //Starts the about activity
    View.OnClickListener aboutButtonOnClickListener = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            Intent intent = new Intent(MainMenu.this, About.class);
            MainMenu.this.startActivity(intent);
        }};





}

package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.CalendarView;
import android.widget.Toast;

import java.util.ArrayList;


public class Calendar extends Activity {

    private CalendarView calendar;
    private ArrayList<BasicData> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_calendar);

        calendar = (CalendarView)findViewById(R.id.calendar);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){

            @Override
            public void onSelectedDayChange(CalendarView view,int year, int month, int dayOfMonth) {

                events=DbAdapter.getInstance().getExistEvents(dayOfMonth, month, year);
                if (events.isEmpty()){
                    Toast.makeText(getApplicationContext(),  getResources().getString(R.string.no_events) , Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(Calendar.this, EventsOfDay.class);
                    intent.putExtra("day", dayOfMonth);
                    intent.putExtra("month", month);
                    intent.putExtra("year", year);
                    Calendar.this.startActivity(intent);
                }
            }});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.calendar, menu);
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

}

package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

public class Event extends Activity {

    private int id;
    private TextView what;
    private TextView where;
    private TextView at;
    private TextView more;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_event);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        Calendar_Data cd = (Calendar_Data)DbAdapter.getInstance().getdatebyId(id);
        what = (TextView)findViewById(R.id.what);
        what.setText(getResources().getString(R.string.calendarWhat) + cd.getDescription());

        where = (TextView)findViewById(R.id.where);
        where.setText(getResources().getString(R.string.calendarWhere) + cd.getLabel() );

        at = (TextView)findViewById(R.id.at);
        at.setText(getResources().getString(R.string.calendarTime) + cd.getSth() + ":" + cd.getStm() + " - " + cd.getEndh() + ":" + cd.getEndm());

        more = (TextView)findViewById(R.id.more);
        more.setText(getResources().getString(R.string.calendarMore) + cd.getLink() );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.event, menu);
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

package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class Culture extends Activity {

    private ListView cultureListView;
    private ArrayList<BasicData> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_culture);

        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

        categories=Culture_Data.getTypes();

        CalendarLVA adapter = new CalendarLVA(Culture.this, categories.toArray(new BasicData[0]));
        cultureListView = (ListView) findViewById(R.id.cultureAllTypes);
        cultureListView.setAdapter(adapter);
        cultureListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                BasicData cd=(BasicData)categories.get(position);
                Intent intent = new Intent(Culture.this, CultureType.class);
                intent.putExtra("id_Type",cd.getID());
                Culture.this.startActivity(intent);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.culture, menu);
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

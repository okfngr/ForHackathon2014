package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class CultureType extends Activity {

    private ListView typeListView;
    private ArrayList<BasicData> objs;
    private int id_Type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_culture_type);
        overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);

        id_Type=this.getIntent().getIntExtra("id_Type",0);

        Toast.makeText(this,""+id_Type,Toast.LENGTH_LONG).show();
        objs = DbAdapter.getInstance().getculturabyType(Culture_Data.getType(id_Type));
        Toast.makeText(this,""+objs.size(),Toast.LENGTH_LONG).show();

        CalendarLVA adapter = new CalendarLVA(CultureType.this,objs.toArray(new BasicData[0]));
        typeListView = (ListView) findViewById(R.id.cultureType);
        typeListView.setAdapter(adapter);
        typeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                BasicData bd=objs.get(position);
                Intent intent = new Intent(CultureType.this, CultureItem.class);
                intent.putExtra("id_culture",bd.getID());
                CultureType.this.startActivity(intent);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.culture_type, menu);
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

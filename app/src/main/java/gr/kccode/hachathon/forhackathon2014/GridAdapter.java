package gr.kccode.hachathon.forhackathon2014;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kiki__000 on 29-Nov-14.
 */
public class GridAdapter extends BaseAdapter {


    private Context context;
    private final String[] menuOptions;

    public GridAdapter(Context context, String[] menuOptions) {
        this.context = context;
        this.menuOptions = menuOptions;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.menu_item, null);

            // set value into textview
            TextView textView = (TextView) gridView.findViewById(R.id.grid_item_label);
            textView.setText(menuOptions[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_item_image);

            String option = menuOptions[position];

            if (option.equals("Wifi")) {
                imageView.setImageResource(R.drawable.wifi);
            } else if (option.equals("Parking")) {
                imageView.setImageResource(R.drawable.parking);
            } else if (option.equals("Gas Station")) {
                imageView.setImageResource(R.drawable.gas_station);
            } else if (option.equals("Events")) {
                imageView.setImageResource(R.drawable.calendar);
            } else if (option.equals("Culture")) {
                imageView.setImageResource(R.drawable.culture);
            } else {
                imageView.setImageResource(R.drawable.about);
            }
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return menuOptions.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

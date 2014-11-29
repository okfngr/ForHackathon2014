package gr.kccode.hachathon.forhackathon2014;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by kiki__000 on 29-Nov-14.
 */
public class CalendarLVA  extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] options;

    public CalendarLVA(Activity context, String[] options) {
        super(context, R.layout.calendar_list_view, options);
        this.context = context;
        this.options = options;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.calendar_list_view, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.event);
        txtTitle.setText(options[position]);

        return rowView;
    }
}

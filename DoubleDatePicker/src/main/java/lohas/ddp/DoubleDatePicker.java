package lohas.ddp;

import android.app.AlertDialog;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class DoubleDatePicker extends android.support.v7.widget.AppCompatEditText{
    String[] dates = new String[2];
    public DoubleDatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean performClick() {
        showDialog();
        return true;
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.double_date_picker,null);
        builder.setView(layout);
        final AlertDialog dialog = builder.create();
        DatePicker sDP = layout.findViewById(R.id.start_dp);
        DatePicker eDP = layout.findViewById(R.id.end_dp);
        Button cBtn = layout.findViewById(R.id.cancel_btn);
        Button sBtn = layout.findViewById(R.id.confirm_btn);
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        dates[0] = year+"-"+month+"-"+day;
        dates[1] = year+"-"+month+"-"+day;
        sDP.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                dates[0] = i+"-"+(i1+1)+"-"+i2;
            }
        });
        eDP.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                dates[1] = i+"-"+(i1+1)+"-"+i2;
            }
        });
        cBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dates[0] = "";
                dates[1] = "";
                dialog.dismiss();
            }
        });
        sBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                setText(dates[0]+"～"+dates[1]);
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public String getStartDate(){
        return dates[0];
    }
    public String getEndDate(){
        return dates[1];
    }
}

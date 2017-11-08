package lohas.ddp;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.*;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class DoubleDatePicker extends android.support.v7.widget.AppCompatEditText{

    private List<View> viewList;
    private String[] dates = new String[2];

    public DoubleDatePicker(Context context) {
        super(context);
    }

    public DoubleDatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean performClick() {
        hideSoftKeyboard();
        showViewPagerDialog();
        return true;
    }

    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    private void showViewPagerDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.double_date_picker,null);
        builder.setView(layout);
        final AlertDialog dialog = builder.create();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view1 = inflater.inflate(R.layout.single_date_picker, null);
        DatePicker sDP = view1.findViewById(R.id.dp);
        View view2 = inflater.inflate(R.layout.single_date_picker,null);
        DatePicker eDP = view2.findViewById(R.id.dp);
        ViewPager vp = layout.findViewById(R.id.date_vp);
        viewList = new ArrayList<>();
        viewList.add(view1);
        viewList.add(view2);
        PagerAdapter pa = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));
                return viewList.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "开始时间";
                    case 1:
                        return "结束时间";
                    default:
                        return "";
                }
            }
        };
        vp.setAdapter(pa);
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

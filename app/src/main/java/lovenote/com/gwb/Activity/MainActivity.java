package lovenote.com.gwb.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import lovenote.com.gwb.Adapter.MyFragmentAdapter;
import lovenote.com.gwb.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout llNote;
    private LinearLayout llRemind;
    private LinearLayout llSetting;
    private ImageView imgNote;
    private ImageView imgRemind;
    private ImageView imgSetting;
    private TextView tvNote;
    private TextView tvRemind;
    private TextView tvSetting;
    private ViewPager mViewPage;

    /*private Fragment noteFragment;
    private Fragment remindFragment;
    private Fragment settingFragment;*/

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
    }


    private void initView() {
        llNote = (LinearLayout) findViewById(R.id.ll_note);
        llRemind = (LinearLayout) findViewById(R.id.ll_remind);
        llSetting = (LinearLayout) findViewById(R.id.ll_setting);
        imgNote = (ImageView) findViewById(R.id.img_note);
        imgRemind = (ImageView) findViewById(R.id.img_remind);
        imgSetting = (ImageView) findViewById(R.id.img_setting);
        tvNote = (TextView) findViewById(R.id.tv_note);
        tvRemind = (TextView) findViewById(R.id.tv_remind);
        tvSetting = (TextView) findViewById(R.id.tv_setting);

        mViewPage = (ViewPager) findViewById(R.id.vp_content);

        llNote.setOnClickListener(this);
        llRemind.setOnClickListener(this);
        llSetting.setOnClickListener(this);
    }

    private void initFragment() {

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new NoteFragment());
        fragmentList.add(new RemindFragment());
        fragmentList.add(new SettingFragment());

        mViewPage.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(), (ArrayList<Fragment>) fragmentList));
        mViewPage.setCurrentItem(0);
        updateIconBg(0);
        mViewPage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPage.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_note:
                mViewPage.setCurrentItem(0);
                updateIconBg(0);
                break;
            case R.id.ll_remind:
                mViewPage.setCurrentItem(1);
                updateIconBg(1);
                break;
            case R.id.ll_setting:
                mViewPage.setCurrentItem(2);
                updateIconBg(2);
                break;
        }
    }

    private void updateIconBg(int index){
        if(index==0){
            imgNote.setBackgroundResource(R.drawable.main_note_select);
            imgRemind.setBackgroundResource(R.drawable.main_remind_nor);
            imgSetting.setBackgroundResource(R.drawable.main_setting_nor);
            tvNote.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
            tvRemind.setTextColor(getResources().getColor(R.color.main_bottom_text_nor));
            tvSetting.setTextColor(getResources().getColor(R.color.main_bottom_text_nor));
        }else if(index == 1){
            imgNote.setBackgroundResource(R.drawable.main_note_nor);
            imgRemind.setBackgroundResource(R.drawable.main_remind_select);
            imgSetting.setBackgroundResource(R.drawable.main_setting_nor);
            tvNote.setTextColor(getResources().getColor(R.color.main_bottom_text_nor));
            tvRemind.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
            tvSetting.setTextColor(getResources().getColor(R.color.main_bottom_text_nor));
        }else if(index == 2){
            imgNote.setBackgroundResource(R.drawable.main_note_nor);
            imgRemind.setBackgroundResource(R.drawable.main_remind_nor);
            imgSetting.setBackgroundResource(R.drawable.main_setting_select);
            tvNote.setTextColor(getResources().getColor(R.color.main_bottom_text_nor));
            tvRemind.setTextColor(getResources().getColor(R.color.main_bottom_text_nor));
            tvSetting.setTextColor(getResources().getColor(R.color.main_bottom_text_select));
        }
    }
}

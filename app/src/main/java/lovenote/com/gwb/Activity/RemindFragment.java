package lovenote.com.gwb.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lovenote.com.gwb.R;

/**
 * Created by gwb on 2016/11/17.
 */
public class RemindFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_remind, container, false);
    }
}

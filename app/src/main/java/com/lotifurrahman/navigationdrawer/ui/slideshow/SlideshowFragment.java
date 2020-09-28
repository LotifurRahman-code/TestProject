package com.lotifurrahman.navigationdrawer.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lotifurrahman.navigationdrawer.R;
import com.lotifurrahman.navigationdrawer.ui.home.HomeFragment;

public class SlideshowFragment extends Fragment {
    TextView textView;
    EditText editText;
    Button button;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        textView = root.findViewById(R.id.text_home);
        editText = root.findViewById(R.id.edit_text_id);
        button = root.findViewById(R.id.button_id);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            String value = bundle.getString("key");
            textView.setText(value);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key_slide", editText.getText().toString());

                HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, homeFragment).commit();

            }
        });

        return root;
    }
}
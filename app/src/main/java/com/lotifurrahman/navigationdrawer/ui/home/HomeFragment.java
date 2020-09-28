package com.lotifurrahman.navigationdrawer.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lotifurrahman.navigationdrawer.MainAdapter;
import com.lotifurrahman.navigationdrawer.MainList;
import com.lotifurrahman.navigationdrawer.MyDBHelper;
import com.lotifurrahman.navigationdrawer.R;
import com.lotifurrahman.navigationdrawer.ui.gallery.GalleryFragment;
import com.lotifurrahman.navigationdrawer.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    TextView textView;
    EditText editText;
    Button button;

    RecyclerView recyclerView;

    MyDBHelper myDBHelper;
    ArrayList<MainList> arrayList;
    MainAdapter adapterSurahList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        textView = root.findViewById(R.id.text_home);
        editText = root.findViewById(R.id.edit_text_id);
        button = root.findViewById(R.id.button_id);


        Bundle bundle = this.getArguments();
        if (bundle != null){
            String value = bundle.getString("key_slide");
            textView.setText(value);
        }

        myDBHelper = new MyDBHelper(getContext());

        arrayList = new ArrayList<>();
        LoadSuahList(root);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", editText.getText().toString());

                SlideshowFragment slideshowFragment = new SlideshowFragment();
                slideshowFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, slideshowFragment).commit();

            }
        });

        return root;
    }


    private void LoadSuahList(View root)
    {
        recyclerView = root.findViewById(R.id.recyclerView_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        arrayList = myDBHelper.getAllSuraList();

        adapterSurahList = new MainAdapter(getContext(), arrayList);
        recyclerView.setAdapter(adapterSurahList);
    }
}
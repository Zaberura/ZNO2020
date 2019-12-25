package com.example.zno2020.ui.send;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.zno2020.R;

import java.util.List;

public class SendFragment extends Fragment {

    Button shareBtn;
    final String MY_SHARE_TEXT = "Привіт, гайда готуватись разом зі мною!\n*PlayMarketLink*";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_send, container, false);

        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, MY_SHARE_TEXT);

        shareBtn = root.findViewById(R.id.shareBtn);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(Intent.createChooser(intent, "SHARE WITH"));
            }
        });

        return root;
    }

}
package com.buildappswithdylan.quotes.category;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.buildappswithdylan.quotes.MyQuote;
import com.buildappswithdylan.quotes.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class science extends AppCompatActivity implements View.OnClickListener {
    List<String> quote_list;
    DatabaseReference datatbaseReference;
    MyQuote myQuote;
    int position=0;
    TextView quote_txt;
    Button prev_btn,next_btn;
    TextView cont_txt;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common);
        quote_txt=findViewById(R.id.quote_txt);
        prev_btn = findViewById(R.id.previous_btn);
        next_btn = findViewById(R.id.next_btn);
        cont_txt = findViewById(R.id.cont_txt);

        prev_btn.setOnClickListener(this);
        next_btn.setOnClickListener(this);


        cont_txt = findViewById(R.id.cont_txt);




        datatbaseReference= FirebaseDatabase.getInstance().getReference("science");
        myQuote=new MyQuote();
        quote_list=new ArrayList<>();
        datatbaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds :dataSnapshot.getChildren() ){
                    myQuote=ds.getValue(MyQuote.class);
                    if (myQuote != null) {
                        quote_list.add(myQuote.getS());
                    }


                }
                quote_txt.setText(quote_list.get(position));
                cont_txt.setText(position + "/" + quote_list.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"error occured",Toast.LENGTH_SHORT).show();
            }
        });





    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.previous_btn:
                previous();
                break;

            case R.id.next_btn:
                next();
                break;

        }



    }

    private void next() {
        position=(position+1)%quote_list.size();
        quote_txt.setText(quote_list.get(position));
        cont_txt.setText(position+ "/"+quote_list.size());

    }

    private void previous() {
        if (position>0){
            position=(position-1)%quote_list.size();
            quote_txt.setText(quote_list.get(position));
            cont_txt.setText(position+ "/"+quote_list.size());

        }


    }
}



















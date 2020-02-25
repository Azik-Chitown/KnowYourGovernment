package edu.depaul.knowyourgovernment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import edu.depaul.knowyourgovernment.R;

public class FotoActivity extends AppCompatActivity {

    private TextView officeTextView;
    private TextView nameTextView;
    private ImageView image;
    private String name;
    private String office;

    private String photoUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foto);
        Intent intent =getIntent();
        Bundle bd=intent.getExtras();
        officeTextView=findViewById(R.id.fotoActOffice);
        nameTextView=findViewById(R.id.textViewFotoName);
        image=findViewById(R.id.imageView);

        if (bd!=null){
            name= (String) bd.get("name");
            office=(String) bd.get("office");
            photoUrl=(String) bd.get("photoUrl");
            officeTextView.setText(office);
            nameTextView.setText(name);

            Picasso picasso = new Picasso.Builder(this).build();
            picasso.load(photoUrl)
                    .error(R.drawable.brokenimage)
                    .placeholder(R.drawable.brokenimage)
                    .into(image);

        }



    }
}

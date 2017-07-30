package uz.iutlab.restaurantmanagement;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class NewOrderActivity extends AppCompatActivity {
    String membershipType="";
    EditText spaghettiCount;
    EditText pizzaCount;
    Button saveButton;
    Button cancelButton;
    DetailsFragment details_fragment;
    String[] data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        spaghettiCount = (EditText)findViewById(R.id.newOrder_spaghettiCount);
        pizzaCount = (EditText)findViewById(R.id.newOrder_pizzaCount);
        saveButton = (Button)findViewById(R.id.newOrder_saveButton);
        cancelButton = (Button)findViewById(R.id.newOrder_cancelButton);

        details_fragment = (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.bottomFragment);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewOrderActivity.this, MainActivity.class);
                String enterTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                intent.putExtra("time",enterTime);
                intent.putExtra("sp_count",spaghettiCount.getText().toString());
                intent.putExtra("pz_count",pizzaCount.getText().toString());
                intent.putExtra("m_type",membershipType);
                setResult(RESULT_OK, intent);
                finish();


            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewOrderActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


    public void radioClick(View view) {
        if (view.getId() == R.id.newOrder_basicMembership) {
            membershipType= "Basic Membership";
            Toast.makeText(this,"Basic Membership is clicked",Toast.LENGTH_SHORT).show();


        } else if (view.getId() == R.id.newOrder_vipMembership) {
            membershipType = "Vip Membership";
            Toast.makeText(this,"Vip Membership is clicked",Toast.LENGTH_SHORT).show();

        } else {
            membershipType="";
            Toast.makeText(this,"Something else is clicked",Toast.LENGTH_SHORT).show();
        }
    }



}
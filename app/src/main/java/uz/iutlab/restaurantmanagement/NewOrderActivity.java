package uz.iutlab.restaurantmanagement;

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
                collectData();
                details_fragment.setData(data);
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


    public void collectData(){
        String enterTime = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());

        String [] array = {
                enterTime,
                spaghettiCount.getText().toString(),
                pizzaCount.getText().toString(),
                membershipType
        };
        data = array;

    }
}
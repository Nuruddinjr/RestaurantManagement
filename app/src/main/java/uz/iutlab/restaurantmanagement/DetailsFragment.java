package uz.iutlab.restaurantmanagement;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {
    TextView tableName;
    TextView enterTime;
    TextView spaghetti;
    TextView pizza;
    TextView membership;
    TextView price;

    public String getTableName() {
        return tableName.getText().toString();
    }

    public void setTableName(String tableName) {
        this.tableName.setText(tableName);
    }

    public String getEnterTime() {
        return enterTime.getText().toString();
    }

    public void setEnterTime(String enterTime) {
        this.enterTime.setText(enterTime);
    }

    public String getSpaghetti() {
        return spaghetti.getText().toString();
    }

    public void setSpaghetti(String spaghetti) {
        this.spaghetti.setText(spaghetti);
    }

    public String getPizza() {
        return pizza.getText().toString();
    }

    public void setPizza(String pizza) {
        this.pizza.setText(pizza);
    }

    public String getMembership() {
        return membership.getText().toString();
    }

    public void setMembership(String membership) {
        this.membership.setText(membership);
    }

    public String getPrice() {
        return price.getText().toString();
    }

    public void setPrice(String price) {
        this.price.setText(price);
    }


    public void setData(String [] data){
        if(data!=null){
            setEnterTime(data[0]);
            setSpaghetti(data[1]);
            setPizza(data[2]);
            setMembership(data[3]);
        }else {
            Toast.makeText(getActivity(),"No data is given",Toast.LENGTH_SHORT);
        }


    }
    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tableName = (TextView) getActivity().findViewById(R.id.detailsFragment_tableName);
        enterTime = (TextView) getActivity().findViewById(R.id.detailsFragment_enterTime);
        spaghetti = (TextView) getActivity().findViewById(R.id.detailsFragment_spaghetti);
        pizza = (TextView) getActivity().findViewById(R.id.detailsFragment_pizza);
        membership = (TextView) getActivity().findViewById(R.id.detailsFragment_membership);
        price = (TextView) getActivity().findViewById(R.id.detailsFragment_price);
    }


}

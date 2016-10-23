package compensation.compensationsystem.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import compensation.compensationsystem.Models.Company;
import compensation.compensationsystem.Models.Constants;
import compensation.compensationsystem.Models.Methods;
import compensation.compensationsystem.R;

/**
 * Created by Irina.B on 20.10.2016.
 */
public class HomeActivity extends AppCompatActivity
{
    ArrayList<Company> companies;
    ArrayList<String> represented_companies = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getIntent().hasExtra(Constants.USER_COMPANIES))
        {
            companies = getIntent().getParcelableArrayListExtra(Constants.USER_COMPANIES);
            for (Company c : companies) {
                represented_companies.add(c.getCompany_name());
            }
        }
        else
        {
            Methods.showPopUp(this,"",getResources().getString(R.string.no_company));
        }

        ListView user_companies = (ListView) findViewById(R.id.user_companies);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,represented_companies);
        user_companies.setAdapter(adapter);

    }
}

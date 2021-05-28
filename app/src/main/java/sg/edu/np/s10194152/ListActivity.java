package sg.edu.np.s10194152;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Random rand = new Random();

        /*
        AlertDialog.Builder profile  = new AlertDialog.Builder(this);
        profile.setTitle("Profile")
        .setMessage("MADness")
        .setCancelable(false)
        .setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int id) {
                Intent NewPage = new Intent(ListActivity.this, MainActivity.class);
                NewPage.putExtra("RanInt", rand.nextInt());
                startActivity(NewPage);
            }
        })
        .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        */

        //generate data
        ArrayList<User> userList = new ArrayList<>();
        for(int i = 0; i < 20; i++){
            User user1 = new User();
            user1.setName("Name-" + rand.nextInt());
            user1.setDescription("Description-" + rand.nextInt());
            user1.setFollowed(rand.nextBoolean());
            userList.add(user1);
        }

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        UsersAdapter adapter = new UsersAdapter(this, userList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        /*androidimg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile.show();
            }
        });
        androidimgbg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile.show();
            }
        }); */
    }
}
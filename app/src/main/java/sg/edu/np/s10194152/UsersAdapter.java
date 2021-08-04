package sg.edu.np.s10194152;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder>{
    ArrayList<User> userList;

    public UsersAdapter(ArrayList<User> List){ userList = List;}
    //Mandatory to Override
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item= null;
        if (viewType == 7){
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.viewholder_user,
                    parent, false);
        }
        else{
            item = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.viewholder_user_seven,
                    parent, false);
        }

        return new UserViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User u = userList.get(position);

        holder.name.setText(u.getName());
        holder.description.setText(u.getDescription());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new AlertDialog.Builder(holder.view.getContext())
                        .setTitle("Profile")
                        .setMessage(u.getName())
                        .setCancelable(false)
                        .setPositiveButton("VIEW", new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Intent mainPage = new Intent(holder.view.getContext(), MainActivity.class);
                                /*Bundle full of data on User
                                Bundle userData = new Bundle();
                                userData.putString("Name", u.getName());
                                userData.putString("Desc", u.getDescription());
                                userData.putInt("Id", u.getId());
                                userData.putBoolean("followStatus", u.isFollowed());
                                mainPage.putExtra("UserData", userData);
                                //sends data to MainActivity
                                <--- Ends here*/
                                mainPage.putExtra("id", position);
                                holder.view.getContext().startActivity(mainPage);
                            }
                        })
                        .setNegativeButton("CLOSE", null)
                        .show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    @Override
    public int getItemViewType(int position) {
        String name = userList.get(position).getName();
        if(name.charAt(name.length()-1) == '7')
        {
            return 0;
        }
        return 1;
    }
    //<--- end
}

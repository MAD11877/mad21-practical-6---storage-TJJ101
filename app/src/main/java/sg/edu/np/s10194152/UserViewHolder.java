package sg.edu.np.s10194152;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView description;
    public View view;

    public UserViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        description = itemView.findViewById(R.id.txtDescription);
        view = itemView;
    }
}

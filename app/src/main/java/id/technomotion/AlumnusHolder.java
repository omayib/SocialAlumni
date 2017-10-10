package id.technomotion;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;
import com.squareup.picasso.Picasso;

import java.util.UUID;


/**
 * Created by omayib on 18/09/17.
 */

public class AlumnusHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "AlumnusHolder";
    private TextView itemName;
    private TextView itemJob;
    private ImageView picture;
    private Person selectedPerson;

    public AlumnusHolder(View itemView) {
        super(itemView);
        itemName = (TextView) itemView.findViewById(R.id.textViewName);
        itemJob = (TextView) itemView.findViewById(R.id.textViewJob);
        picture = (ImageView) itemView.findViewById(R.id.imageViewProfile);
        itemView.setOnClickListener(this);
    }

    public void bindAlumni(Person person){
        this.selectedPerson = person;
        this.itemName.setText(person.getName());
        this.itemJob.setText(person.getJob());
        Picasso.with(this.picture.getContext()).load("http://lorempixel.com/200/200/people/"+ UUID.randomUUID().toString()).into(picture);
    }

    @Override
    public void onClick(final View v) {
//        v.getContext().startActivity(new Intent(v.getContext(),OtherActivity.class));
        OpenChannel.createChannel(new OpenChannel.OpenChannelCreateHandler() {
            @Override
            public void onResult(OpenChannel openChannel, SendBirdException e) {
                if (e != null) {
                    e.printStackTrace();
                    return;
                }
                Log.d(TAG, "onResult: "+openChannel.getName());
                Log.d(TAG, "onResult: "+openChannel.getUrl());
            }
        });
    }
}

package id.technomotion;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.qiscus.sdk.Qiscus;
import com.qiscus.sdk.data.model.QiscusChatRoom;
import com.squareup.picasso.Picasso;

import java.util.UUID;


/**
 * Created by omayib on 18/09/17.
 */

public class AlumniHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "AlumniHolder";
    private TextView itemName;
    private TextView itemJob;
    private ImageView picture;
    private Alumni selectedAlumni;

    public AlumniHolder(View itemView) {
        super(itemView);
        itemName = (TextView) itemView.findViewById(R.id.textViewName);
        itemJob = (TextView) itemView.findViewById(R.id.textViewJob);
        picture = (ImageView) itemView.findViewById(R.id.imageViewProfile);
        itemView.setOnClickListener(this);
    }

    public void bindAlumni(Alumni alumni){
        this.selectedAlumni = alumni;
        this.itemName.setText(alumni.getName());
        this.itemJob.setText(alumni.getJob());
        Picasso.with(this.picture.getContext()).load("http://lorempixel.com/200/200/people/"+ UUID.randomUUID().toString()).into(picture);
    }

    @Override
    public void onClick(final View v) {
        Qiscus.buildChatWith("andri@gmail.com")
                .withSubtitle("Consultation")
                .build(v.getContext(), new Qiscus.ChatActivityBuilderListener() {
                    @Override
                    public void onSuccess(Intent intent) {
                        v.getContext().startActivity(intent);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }
                });
    }
}

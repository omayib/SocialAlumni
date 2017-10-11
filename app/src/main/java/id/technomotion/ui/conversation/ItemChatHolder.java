package id.technomotion.ui.conversation;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBirdException;
import com.squareup.picasso.Picasso;

import java.util.UUID;

import id.technomotion.Chat;
import id.technomotion.Person;
import id.technomotion.R;

public class ItemChatHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "ItemChatHolder";
    private TextView itemSender;
    private TextView itemMessage;
    private ImageView itemAvatar;
    private Chat selectedChat;

    public ItemChatHolder(View itemView) {
        super(itemView);
        Log.d(TAG, "ItemChatHolder() called with: itemView = [" + itemView + "]");
        itemSender = (TextView) itemView.findViewById(R.id.textViewSender);
        itemMessage = (TextView) itemView.findViewById(R.id.textViewMessage);
        itemAvatar = (ImageView) itemView.findViewById(R.id.imageViewAvatar);
        itemView.setOnClickListener(this);
    }

    public void bindAlumni(Chat chat){
        Log.d(TAG, "bindAlumni: "+chat.getMessage());
        this.selectedChat = chat;
        this.itemSender.setText(chat.getSender());
        this.itemMessage.setText(chat.getMessage());
//        Picasso.with(this.itemAvatar.getContext()).load("http://lorempixel.com/200/200/people/"+ UUID.randomUUID().toString()).into(itemAvatar);
    }

    @Override
    public void onClick(final View v) {

    }
}
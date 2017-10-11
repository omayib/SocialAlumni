package id.technomotion.ui.conversation;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.technomotion.Chat;
import id.technomotion.R;

public class ConversationRecyclerAdapter extends RecyclerView.Adapter<ItemChatHolder> {
    private static final String TAG = "ConversationRecyclerAda";
    private ArrayList<Chat> chat;

    public ConversationRecyclerAdapter(ArrayList<Chat> chat) {
        this.chat = chat;
        Log.d(TAG, "ConversationRecyclerAdapter: "+chat.size());
    }

    @Override
    public ItemChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ItemChatHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(ItemChatHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder() called with: holder = [" + holder + "], position = [" + position + "]");
        Chat person = chat.get(position);
        holder.bindAlumni(person);
    }

    @Override
    public int getItemCount() {
        return this.chat.size();
    }
}
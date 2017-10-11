package id.technomotion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.UUID;

import id.technomotion.ui.conversation.ConversationRecyclerAdapter;

public class ConversationActivity extends AppCompatActivity {
    private static final String TAG = "ConversationActivity";
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private ConversationRecyclerAdapter adapter;
    private ArrayList<Chat> conversation = new ArrayList<>();
    private EditText inputMessage;
    private ImageButton buttonSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        inputMessage = (EditText) findViewById(R.id.editText);
        buttonSend = (ImageButton) findViewById(R.id.imageButton);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewConversation);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new ConversationRecyclerAdapter(conversation);
        recyclerView.setAdapter(adapter);

        for (int i = 0; i < 50; i++) {
            conversation.add(new Chat(UUID.randomUUID().toString(),"user","avatar"));
        }
        adapter.notifyDataSetChanged();
        recyclerView.scrollToPosition(conversation.size()-1);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg =   inputMessage.getText().toString();
                Chat chatCandidate = new Chat(msg,"dia","dassd");
                conversation.add(chatCandidate);
                adapter.notifyDataSetChanged();
                inputMessage.setText("");
                recyclerView.scrollToPosition(conversation.size()-1);
            }
        });
    }
}

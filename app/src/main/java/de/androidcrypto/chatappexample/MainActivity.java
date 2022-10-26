package de.androidcrypto.chatappexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private View btnSend;
    private EditText editText;
    boolean isMine = true;
    private List<ChatData> chatDatas;
    private ArrayAdapter<ChatData> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatDatas = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list_msg);
        btnSend = findViewById(R.id.btn_chat_send);
        editText = (EditText) findViewById(R.id.msg_type);
        adapter = new ChatAdapter(this, R.layout.left, chatDatas);
        listView.setAdapter(adapter);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().trim().equals("")) {
                    Toast.makeText(MainActivity.this, "please input text..", Toast.LENGTH_SHORT).show();
                } else {
                    ChatData chatData = new ChatData(editText.getText().toString(), isMine);
                    chatDatas.add(chatData);
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    if (isMine) {
                        isMine = false;
                    } else {
                        isMine = true;
                    }
                }
            }
        });
    }
}

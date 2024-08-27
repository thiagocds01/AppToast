package com.example.apptoast;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtMsg;
    Button btnMsgCurta, btnMsgLonga, btnMsgPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtMsg = findViewById(R.id.edtMsg);
        btnMsgCurta = findViewById(R.id.btnMsgCurta);
        btnMsgLonga = findViewById(R.id.btnMsgLonga);
        btnMsgPerson = findViewById(R.id.btnMsgPerson);


    }


    @Override
    public void onClick(View v) {
        String mens = edtMsg.getText().toString();
        if (v == btnMsgCurta) {
            Toast toast = Toast.makeText(this, mens, Toast.LENGTH_SHORT);
            toast.show();
        }
        if (v == btnMsgLonga) {
            Toast toast = Toast.makeText(this, mens, Toast.LENGTH_LONG);
            toast.show();
        }
        if (v == btnMsgPerson) {
            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.ic_launcher_foreground);
            Toast toast = new Toast(this);
            toast.setView(img);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.show();
        }
    }

}
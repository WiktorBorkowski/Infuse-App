package com.example.homepage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ApplicationPage extends AppCompatActivity {

    private EditText nEditTextTo;
    private EditText nEditTextSubject;
    private EditText nEditTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_page);

        nEditTextTo = findViewById(R.id.edit_text_to);
        nEditTextSubject = findViewById(R.id.edit_text_subject);
        nEditTextMessage = findViewById(R.id.edit_text_message);

    }

    public void SendMail(View view)
    {
        if(false){
            String recipientList = nEditTextTo.getText().toString();
            String[] recipients = recipientList.split(",");
            String subject = nEditTextSubject.getText().toString();
            String msg= nEditTextMessage.getText().toString();

            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, recipients);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, msg);

            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an email client"));
        }
        Log.d("Email", "Sent");
    }
}
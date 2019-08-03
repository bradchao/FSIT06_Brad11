package tw.brad.apps.brad11;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.view.LayoutInflater.from;

public class MainActivity extends AppCompatActivity {
    private EditText inputView;
    private EditText username;
    private EditText passwd;
    private AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test6(View view) {
        inputView = new EditText(this);
        new AlertDialog.Builder(this)
                .setTitle("Input ur name")
                .setView(inputView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,
                                "=> " + inputView.getText().toString(),
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }


    public void test7(View view) {
        LayoutInflater inflater =  LayoutInflater.from(this);
        View dialogView = inflater.inflate(
                R.layout.mydialog_view, null);

        username = dialogView.findViewById(R.id.item_username);
        passwd = dialogView.findViewById(R.id.item_passwd);

        View ok = dialogView.findViewById(R.id.btn_ok);
        View cancel = dialogView.findViewById(R.id.btn_cance);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickOK();
                alertDialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });

        alertDialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .create();
        alertDialog.show();

    }

    private void clickOK(){
        Toast.makeText(this, username.getText().toString() + ":" +
                passwd.getText().toString(),
                Toast.LENGTH_SHORT).show();
    }

}

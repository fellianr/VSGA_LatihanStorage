package fellia.polije.vsga_latihanstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String FILENAME = "namafile.txt";
    Button buatFile, ubahFile, bacaFile, deleteFile;
    TextView textBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buatFile = findViewById(R.id.buttonBuatFile);
        ubahFile = findViewById(R.id.buttonUbahFile);
        bacaFile = findViewById(R.id.buttonBacaFile);
        deleteFile = findViewById(R.id.buttonHapusFile);
        textBaca = findViewById(R.id.textBaca);

        buatFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
        bacaFile.setOnClickListener(this);
        deleteFile.setOnClickListener(this);
        ubahFile.setOnClickListener(this);
    }

    void buatFile (){
        String isiFile = "Coba Isi Data File Text";
        File file = new File (getFilesDir(), FILENAME);

        FileOutputStream outputStream = null;
        try{
            file.createNewFile();
            outputStream = new FileOutputStream(file, true);
            outputStream.write(isiFile.getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void hapusFile(View view){
        File file = new File (getFilesDir(), FILENAME);
        if (file.exists()){
            file.delete();
        }
    }

    @Override
    public void onClick (View v){
        jalankanPerintah(v.getId());
    }

    private void jalankanPerintah(int id) {
        switch (id){
            case R.id.buttonBuatFile:
                buatFile();
                break;
            case R.id.buttonBacaFile:
                buatFile();
                break;
            case R.id.buttonUbahFile:
                buatFile();
                break;
            case R.id.buttonHapusFile:
                buatFile();
                break;
        }
    }

    public void ubahFile(View view){
        File file = new File (getFilesDir(), FILENAME);
        if (file.exists()) {
            hapusFile(view);
            String buatFile = "File Diubah.";
        }else {
            Toast.makeText(this, "File tidak ada", Toast.LENGTH_SHORT).show();
        }
    }
}
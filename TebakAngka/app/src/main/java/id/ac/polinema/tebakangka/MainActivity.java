package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private EditText inputAngka;
	private Button Guess;
	private int RandNum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		inputAngka = findViewById(R.id.number_input);
		Guess = findViewById(R.id.guess_button);
		initRandomNumber();
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		Random angka = new Random();
		RandNum = angka.nextInt(100) + 1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		if(inputAngka.getText().toString().isEmpty()){
			Toast.makeText(this, "Inputan Kosong", Toast.LENGTH_SHORT).show();
		}else{
			String ambil = inputAngka.getText().toString();
			int fix = Integer.parseInt(ambil);
			if(fix == RandNum){
				Toast.makeText(this, "Tebakan Anda Benar", Toast.LENGTH_SHORT).show();
				Guess.setEnabled(false);
			}else if(fix < RandNum){
				Toast.makeText(this, "Tebakan Anda Terlalu kecil", Toast.LENGTH_SHORT).show();
			}else{
				Toast.makeText(this, "Tebakan Anda Terlalu besar", Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void handleReset(View view) {
		// TODO: Reset tampilan
		inputAngka.setText("");
		initRandomNumber();
		Guess.setEnabled(true);
	}
}

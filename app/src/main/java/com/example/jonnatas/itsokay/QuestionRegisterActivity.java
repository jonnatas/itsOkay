package com.example.jonnatas.itsokay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jonnatas.itsokay.config.ConfiguracaoFirebase;
import com.example.jonnatas.itsokay.model.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class QuestionRegisterActivity extends AppCompatActivity {

    private SeekBar seekBarLove;
    private SeekBar seekBarFe;
    private SeekBar seekBarTolerancia;
    private SeekBar seekBarGenerosidade;
    private SeekBar seekBarSabedoria;
    private TextView textViewLove;
    private TextView textViewFe;
    private TextView textViewTolerancia;
    private TextView textViewGenerosidade;
    private TextView textViewSabedoria;

    private EditText nascimento;
    private EditText nome;
    // Get the user
    private FirebaseAuth mAuth = ConfiguracaoFirebase.getFirebaseAuth();
    private Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_register);
        initializeVariables();

        // Initialize the textview with '0'.  = database.getReference(mAuth.getCurrentUser().getEmail().toString());
        textViewLove.setText(getString(R.string.love) + ": " + seekBarLove.getProgress() + "/" + seekBarLove.getMax());

        setSeekBarLove();
        setSeekBarFe();
        setSeekBarTolerancia();
        setSeekBarGenerosidade();
        setSeekBarSabedoria();
    }

    private void setSeekBarLove() {
        seekBarLove.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                usuario.setAmor(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewLove.setText(getString(R.string.love) + ": " + progress + "/" + seekBar.getMax());
            }
        });
    }
    private void setSeekBarFe() {
        seekBarFe.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                usuario.setFe(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewFe.setText(getString(R.string.fe) + ": " + progress + "/" + seekBar.getMax());
            }
        });
    }
    private void setSeekBarGenerosidade() {
        seekBarGenerosidade.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                usuario.setGenerosidade(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewGenerosidade.setText(getString(R.string.generosidade) + ": " + progress + "/" + seekBar.getMax());
            }
        });
    }
    private void setSeekBarSabedoria() {
        seekBarSabedoria.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                usuario.setSabedoria(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewSabedoria.setText(getString(R.string.sabedoria) + ": " + progress + "/" + seekBar.getMax());
            }
        });
    }
    private void setSeekBarTolerancia() {
        seekBarTolerancia.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                usuario.setTolerancia(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textViewTolerancia.setText(getString(R.string.tolerancia) + ": " + progress + "/" + seekBar.getMax());
            }
        });
    }

    // A private method to help us initialize our variables.
    private void initializeVariables() {
        seekBarLove = (SeekBar) findViewById(R.id.seekBarLove);
        seekBarFe = (SeekBar) findViewById(R.id.seekBarFe);
        seekBarGenerosidade = (SeekBar) findViewById(R.id.seekBarGenerosidade);
        seekBarSabedoria = (SeekBar) findViewById(R.id.seekBarSabedoria);
        seekBarTolerancia = (SeekBar) findViewById(R.id.seekBarTolerancia);

        textViewLove = (TextView) findViewById(R.id.textViewLove);
        textViewTolerancia = (TextView) findViewById(R.id.textViewTolerancia);
        textViewSabedoria = (TextView) findViewById(R.id.textViewSabedoria);
        textViewGenerosidade = (TextView) findViewById(R.id.textViewGenerosidade);
        textViewFe = (TextView) findViewById(R.id.textViewFe);

        nome = (EditText) findViewById(R.id.editTextName);
        nascimento = (EditText) findViewById(R.id.editTextNasc);
    }

    public void confirmRegister(View view){
        FirebaseUser user = mAuth.getCurrentUser();
        usuario.setId(user.getUid());
        usuario.setNome(nome.getText().toString());
        usuario.setDate(nascimento.getText().toString());
        usuario.salvar();
    }
}
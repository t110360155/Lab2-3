package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_cmora;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_text);
        tv_name = findViewById(R.id.tv_name);
        tv_winner = findViewById(R.id.tv_winner);
        tv_mmora = findViewById(R.id.tv_mmora);
        tv_cmora = findViewById(R.id.tv_cmora);
        btn_scissor = findViewById(R.id.btn_scissor);
        btn_stone = findViewById(R.id.btn_stone);
        btn_paper = findViewById(R.id.btn_paper);
        btn_mora = findViewById(R.id.btn_mora);

        btn_mora.setOnClickListener(view -> {
            if (ed_name.length() < 1) {
                tv_text.setText("Enter your name");
            } else {
                tv_name.setText(String.format("Name\n%s", ed_name.getText().toString()));
                if (btn_scissor.isChecked()) {
                    tv_mmora.setText("I throw:\nscissors");
                } else if (btn_stone.isChecked()) {
                    tv_mmora.setText("I throw:\nstone");
                } else {
                    tv_mmora.setText("I throw:\npaper");
                }
                int computer_random = (int) (Math.random() * 3);

                if (computer_random == 0) {
                    tv_cmora.setText("Computer throws:\nscissors");
                } else if (computer_random == 1) {
                    tv_cmora.setText("Computer throws:\nstone");
                } else {
                    tv_cmora.setText("Computer throws:\npaper");
                }


                if ((btn_scissor.isChecked() && computer_random == 2) ||
                        (btn_stone.isChecked() && computer_random == 0) ||
                        (btn_paper.isChecked() && computer_random == 1)) {
                    tv_winner.setText("Winner is:\n"+ed_name.getText().toString());
                    tv_text.setText("Congratulations, you won!");

                } else if ((btn_scissor.isChecked() && computer_random == 1) ||
                        (btn_stone.isChecked() && computer_random == 2) ||
                        (btn_paper.isChecked() && computer_random == 0)) {
                    tv_winner.setText("Winner is: \ncomputer");
                    tv_text.setText("What a pity, Computer won!");
                    } else {
                    tv_winner.setText("It's a draw\n");
                    tv_text.setText("It's a tie, please try again");
                }
            }

        });
    }
}

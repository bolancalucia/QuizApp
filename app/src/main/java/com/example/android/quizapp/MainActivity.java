package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int final_score = 0;
    private int share_score = 0;
    private EditText answer_three;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private CheckBox checkBox2_1;
    private CheckBox checkBox2_2;
    private CheckBox checkBox2_3;
    private CheckBox checkBox2_4;
    private CheckBox checkBox2_5;
    private CheckBox checkBox2_6;
    private CheckBox checkBox4_1;
    private CheckBox checkBox4_2;
    private CheckBox checkBox4_3;
    private CheckBox checkBox4_4;
    private CheckBox checkBox4_5;
    private CheckBox checkBox4_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submit = findViewById(R.id.btn_submit);
        Button share = findViewById(R.id.btn_share);
        answer_three = findViewById(R.id.edit_text);
        checkBox2_1 = findViewById(R.id.check_box_2_1);
        checkBox2_2 = findViewById(R.id.check_box_2_2);
        checkBox2_3 = findViewById(R.id.check_box_2_3);
        checkBox2_4 = findViewById(R.id.check_box_2_4);
        checkBox2_5 = findViewById(R.id.check_box_2_5);
        checkBox2_6 = findViewById(R.id.check_box_2_6);
        checkBox4_1 = findViewById(R.id.check_box_4_1);
        checkBox4_2 = findViewById(R.id.check_box_4_2);
        checkBox4_3 = findViewById(R.id.check_box_4_3);
        checkBox4_4 = findViewById(R.id.check_box_4_4);
        checkBox4_5 = findViewById(R.id.check_box_4_5);
        checkBox4_6 = findViewById(R.id.check_box_4_6);
        radioGroup1 = findViewById(R.id.radio_group_1);
        radioGroup2 = findViewById(R.id.radio_group_2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int answer_one = radioGroup1.getCheckedRadioButtonId();
                if (answer_one == R.id.radio_button_1_3)
                    incrementScoreByOne();

                if (checkBox2_2.isChecked() && checkBox2_3.isChecked() && checkBox2_5.isChecked() && !checkBox2_1.isChecked() && !checkBox2_4.isChecked() && !checkBox2_6.isChecked())
                    incrementScoreByThree();
                else if ((checkBox2_2.isChecked() && checkBox2_3.isChecked() && !checkBox2_5.isChecked() && !checkBox2_1.isChecked() && !checkBox2_4.isChecked() && !checkBox2_6.isChecked())
                        || (checkBox2_2.isChecked() && !checkBox2_3.isChecked() && checkBox2_5.isChecked() && !checkBox2_1.isChecked() && !checkBox2_4.isChecked() && !checkBox2_6.isChecked())
                        || (!checkBox2_2.isChecked() && checkBox2_3.isChecked() && checkBox2_5.isChecked() && !checkBox2_1.isChecked() && !checkBox2_4.isChecked() && !checkBox2_6.isChecked()))
                    incrementScoreByTwo();
                else if ((checkBox2_2.isChecked() && !checkBox2_3.isChecked() && !checkBox2_5.isChecked() && !checkBox2_1.isChecked() && !checkBox2_4.isChecked() && !checkBox2_6.isChecked())
                        || (!checkBox2_2.isChecked() && !checkBox2_3.isChecked() && checkBox2_5.isChecked() && !checkBox2_1.isChecked() && !checkBox2_4.isChecked() && !checkBox2_6.isChecked())
                        || (!checkBox2_2.isChecked() && checkBox2_3.isChecked() && !checkBox2_5.isChecked() && !checkBox2_1.isChecked() && !checkBox2_4.isChecked() && !checkBox2_6.isChecked()))
                    incrementScoreByOne();

                if (answer_three.getText().toString().toLowerCase().equals(getString(R.string.answer_3).toLowerCase()))
                    incrementScoreByTwo();

                if (checkBox4_2.isChecked() && checkBox4_4.isChecked() && checkBox4_6.isChecked() && !checkBox4_1.isChecked() && !checkBox4_3.isChecked() && !checkBox4_5.isChecked())
                    incrementScoreByThree();
                else if ((checkBox4_2.isChecked() && checkBox4_4.isChecked() && !checkBox4_6.isChecked() && !checkBox4_1.isChecked() && !checkBox4_3.isChecked() && !checkBox4_5.isChecked())
                        || (checkBox4_2.isChecked() && !checkBox4_4.isChecked() && checkBox4_6.isChecked() && !checkBox4_1.isChecked() && !checkBox4_3.isChecked() && !checkBox4_5.isChecked())
                        || (!checkBox4_2.isChecked() && checkBox4_4.isChecked() && checkBox4_6.isChecked() && !checkBox4_1.isChecked() && !checkBox4_3.isChecked() && !checkBox4_5.isChecked()))
                    incrementScoreByTwo();
                else if ((checkBox4_2.isChecked() && !checkBox4_4.isChecked() && !checkBox4_6.isChecked() && !checkBox4_1.isChecked() && !checkBox4_3.isChecked() && !checkBox4_5.isChecked())
                        || (!checkBox4_2.isChecked() && !checkBox4_4.isChecked() && checkBox4_6.isChecked() && !checkBox4_1.isChecked() && !checkBox4_3.isChecked() && !checkBox4_5.isChecked())
                        || (!checkBox4_2.isChecked() && checkBox4_4.isChecked() && !checkBox4_6.isChecked() && !checkBox4_1.isChecked() && !checkBox4_3.isChecked() && !checkBox4_5.isChecked()))
                    incrementScoreByOne();

                int answer_five = radioGroup2.getCheckedRadioButtonId();
                if (answer_five == R.id.radio_button_5_4)
                    incrementScoreByOne();

                final String score = final_score + "/" + getResources().getString(R.string.highest_score);
                Toast.makeText(getApplicationContext(), "Your score is " + score, Toast.LENGTH_SHORT).show();
                share_score = final_score;
                final_score = 0;
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setType("text/plain");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "My score is " + share_score + "/" + getResources().getString(R.string.highest_score));
                if (sendIntent.resolveActivity(getPackageManager()) != null)
                    startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.app_name)));
            }
        });
    }
    /**
     * @param outState saves score
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("share_score", share_score);
    }
    /**
     * @param savedInstanceState gets score
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        share_score = savedInstanceState.getInt("share_score");
    }
    /**
     * Adds +1 to the final score
     */
    private void incrementScoreByOne() {
        final_score++;
    }
    /**
     * Adds +2 to the final score
     */
    private void incrementScoreByTwo() {
        final_score += 2;
    }
    /**
     * Adds +3 to the final score
     */
    private void incrementScoreByThree() {
        final_score += 3;
    }
}

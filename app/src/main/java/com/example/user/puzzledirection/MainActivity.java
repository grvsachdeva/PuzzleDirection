package com.example.user.puzzledirection;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AlertDialog alertDialog1;
    public ArrayList<Question> que[];
    int playerScore = 0;
    int playerLocation = 11;
    boolean answer;
    int grd[][];
    int x=4,y=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        que=new ArrayList[8];
        addQuestion();
        grd=new int[5][5];
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                grd[i][j]=1;
            }
        }
        x=4;
        y=0;
        displayScore(playerScore);
    }
    public void buttonDisable(){
        Button a1 = (Button) findViewById(R.id.a1);
        a1.setEnabled(false);
        a1.setVisibility(View.VISIBLE);
        Button a2 = (Button) findViewById(R.id.a2);
        a2.setEnabled(false);
        a2.setVisibility(View.VISIBLE);
        Button a3 = (Button) findViewById(R.id.a3);
        a3.setEnabled(false);
        a3.setVisibility(View.VISIBLE);
        Button a4 = (Button) findViewById(R.id.a4);
        a4.setEnabled(false);
        a4.setVisibility(View.VISIBLE);
        Button a5 = (Button) findViewById(R.id.a5);
        a5.setEnabled(false);
        Button b1 = (Button) findViewById(R.id.b1);
        b1.setEnabled(false);
        b1.setVisibility(View.VISIBLE);
        Button b2 = (Button) findViewById(R.id.b2);
        b2.setEnabled(false);
        b2.setVisibility(View.VISIBLE);
        Button b3 = (Button) findViewById(R.id.b3);
        b3.setEnabled(false);
        b3.setVisibility(View.VISIBLE);
        Button b4 = (Button) findViewById(R.id.b4);
        b4.setEnabled(false);
        b4.setVisibility(View.VISIBLE);
        Button b5 = (Button) findViewById(R.id.b5);
        b5.setEnabled(false);
        b5.setVisibility(View.VISIBLE);
        Button c1 = (Button) findViewById(R.id.c1);
        c1.setEnabled(false);
        c1.setVisibility(View.VISIBLE);
        Button c2 = (Button) findViewById(R.id.c2);
        c2.setEnabled(false);
        c2.setVisibility(View.VISIBLE);
        Button c3 = (Button) findViewById(R.id.c3);
        c3.setEnabled(false);
        c3.setVisibility(View.VISIBLE);
        Button c4 = (Button) findViewById(R.id.c4);
        c4.setEnabled(false);
        c4.setVisibility(View.VISIBLE);
        Button c5 = (Button) findViewById(R.id.c5);
        c5.setEnabled(false);
        c5.setVisibility(View.VISIBLE);
        Button d1 = (Button) findViewById(R.id.d1);
        d1.setEnabled(false);
        d1.setVisibility(View.VISIBLE);
        Button d2 = (Button) findViewById(R.id.d2);
        d2.setEnabled(false);
        d2.setVisibility(View.VISIBLE);
        Button d3 = (Button) findViewById(R.id.d3);
        d3.setEnabled(false);
        d3.setVisibility(View.VISIBLE);
        Button d4 = (Button) findViewById(R.id.d4);
        d4.setEnabled(false);
        d4.setVisibility(View.VISIBLE);
        Button d5 = (Button) findViewById(R.id.d5);
        d5.setEnabled(false);
        d5.setVisibility(View.VISIBLE);
        Button e1 = (Button) findViewById(R.id.e1);
        e1.setEnabled(true);
        Button e2 = (Button) findViewById(R.id.e2);
        e2.setEnabled(false);
        e2.setVisibility(View.VISIBLE);
        Button e3 = (Button) findViewById(R.id.e3);
        e3.setEnabled(false);
        e3.setVisibility(View.VISIBLE);
        Button e4 = (Button) findViewById(R.id.e4);
        e4.setEnabled(false);
        e4.setVisibility(View.VISIBLE);
        Button e5 = (Button) findViewById(R.id.e5);
        e5.setEnabled(false);
        e5.setVisibility(View.VISIBLE);
    }
    public void displayScore(int score) {
        TextView scoreView = (TextView) findViewById(R.id.playerScore);
        scoreView.setText(String.valueOf(score));
    }

    public boolean showQuestion(String que,String op1,String op2,String op3,String op4,int ans){
        final CharSequence[] values = {op1,op2,op3,op4};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(que);
        final int i=ans;
        answer=false;
        builder.setSingleChoiceItems(values, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        // Your code when first option seletced
                        if(i==1){
                            answer=true;
                            Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        // Your code when 2nd  option seletced
                        if(i==2){
                            answer=true;
                            Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        // Your code when 3rd option seletced
                        if(i==3){
                            answer=true;
                            Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        if(i==4){
                            answer=true;
                            Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(MainActivity.this, "Wrong Answer", Toast.LENGTH_SHORT).show();
                        break;
                }
                alertDialog1.show();
                if(answer){
                    Toast.makeText(MainActivity.this, "Correct Answer", Toast.LENGTH_SHORT).show();
                }
                alertDialog1.dismiss();
            }
        });
        alertDialog1 = builder.create();
        alertDialog1.show();

        return answer;
    }
    void addQuestion() {
        Question qobj;
        for (int i = 0; i < 8; i++) {
            que[i] = new ArrayList<>();
        }
        AssetManager assetManager = getAssets();
        try {
            InputStream inputStream = assetManager.open("bio.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), Integer.parseInt(String.valueOf((in.readLine()).charAt(0))));
                que[0].add(qobj);
            }
            inputStream = assetManager.open("chem.txt");
            in = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), 2);
                in.readLine();
                que[1].add(qobj);
            }
            inputStream = assetManager.open("geo.txt");
            in = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), 2);
                in.readLine();
                que[2].add(qobj);
            }
            inputStream = assetManager.open("gk.txt");
            in = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), 2);
                que[3].add(qobj);
                in.readLine();
            }
            inputStream = assetManager.open("math.txt");
            in = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), 2);
                que[4].add(qobj);
                in.readLine();
            }
            inputStream = assetManager.open("pg.txt");
            in = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), 2);
                que[5].add(qobj);
                in.readLine();
            }
            inputStream = assetManager.open("phy.txt");
            in = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), 2);
                que[6].add(qobj);
                in.readLine();
            }
            inputStream = assetManager.open("politics.txt");
            in = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = in.readLine()) != null) {
                qobj = new Question(line, in.readLine(), in.readLine(), in.readLine(), in.readLine(), 2);
                que[7].add(qobj);
                in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void a1(View v) {
        int r=(int)Math.random()*10;
        if(showQuestion(que[0].get(r).question,que[0].get(r).A,que[0].get(r).B,que[0].get(r).C,que[0].get(r).D,que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=y=0;
            buttonDisable();
            Button a1 = (Button) findViewById(R.id.a1);
            a1.setEnabled(false);
            Button a2 = (Button) findViewById(R.id.a2);
            a2.setEnabled(true);
            a2.setVisibility(View.VISIBLE);
            Button b1 = (Button) findViewById(R.id.b1);
            b1.setEnabled(true);
            b1.setVisibility(View.VISIBLE);
        }
    }

    public void a2(View v) {
        int r=(int)Math.random()*10;
        if(showQuestion(que[0].get(r).question,que[0].get(r).A,que[0].get(r).B,que[0].get(r).C,que[0].get(r).D,que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=0;
            y=1;
            buttonDisable();
            Button a2 = (Button) findViewById(R.id.a2);
            a2.setEnabled(false);
            Button a1 = (Button) findViewById(R.id.a1);
            a1.setEnabled(true);
            a1.setVisibility(View.VISIBLE);
            Button a3 = (Button) findViewById(R.id.a3);
            a3.setEnabled(true);
            a3.setVisibility(View.VISIBLE);
            Button b2 = (Button) findViewById(R.id.b2);
            b2.setEnabled(true);
            b2.setVisibility(View.VISIBLE);
        }
    }

    public void a3(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=0;
            y=2;
            buttonDisable();
            Button a3 = (Button) findViewById(R.id.a3);
            a3.setEnabled(false);
            Button a2 = (Button) findViewById(R.id.a2);
            a2.setEnabled(true);
            a2.setVisibility(View.VISIBLE);
            Button a4 = (Button) findViewById(R.id.a4);
            a4.setEnabled(true);
            a4.setVisibility(View.VISIBLE);
            Button b3 = (Button) findViewById(R.id.b3);
            b3.setEnabled(true);
            b3.setVisibility(View.VISIBLE);
        }
    }
    public void a4(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=0;
            y=3;
            buttonDisable();
            Button a4 = (Button) findViewById(R.id.a4);
            a4.setEnabled(false);
            Button a3 = (Button) findViewById(R.id.a3);
            a3.setEnabled(true);
            a3.setVisibility(View.VISIBLE);
            Button a5 = (Button) findViewById(R.id.a5);
            a5.setEnabled(true);
            a5.setVisibility(View.VISIBLE);
            Button b4 = (Button) findViewById(R.id.b4);
            b4.setEnabled(true);
            b4.setVisibility(View.VISIBLE);
        }
    }
    public void a5(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=0;
            y=4;
            Toast toast = Toast.makeText(getApplicationContext(), "Victory!", Toast.LENGTH_SHORT);
            toast.show();
            buttonDisable();
        }
    }
    public void b1(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=1;
            y=0;
            buttonDisable();
            Button b1 = (Button) findViewById(R.id.b1);
            b1.setEnabled(false);
            Button a1 = (Button) findViewById(R.id.a1);
            a1.setEnabled(true);
            a1.setVisibility(View.VISIBLE);
            Button b2 = (Button) findViewById(R.id.b2);
            b2.setEnabled(true);
            b2.setVisibility(View.VISIBLE);
            Button c1 = (Button) findViewById(R.id.c1);
            c1.setEnabled(true);
            c1.setVisibility(View.VISIBLE);
        }
    }

    public void b2(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=1;
            y=1;
            buttonDisable();
            Button b2 = (Button) findViewById(R.id.b2);
            b2.setEnabled(false);
            Button a2 = (Button) findViewById(R.id.a2);
            a2.setEnabled(true);
            a2.setVisibility(View.VISIBLE);
            Button b1 = (Button) findViewById(R.id.b1);
            b1.setEnabled(true);
            b1.setVisibility(View.VISIBLE);
            Button b3 = (Button) findViewById(R.id.b3);
            b3.setEnabled(true);
            b3.setVisibility(View.VISIBLE);
            Button c2 = (Button) findViewById(R.id.c2);
            c2.setEnabled(true);
            c2.setVisibility(View.VISIBLE);
        }
    }
    public void b3(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=1;
            y=2;
            buttonDisable();
            Button b3 = (Button) findViewById(R.id.b3);
            b3.setEnabled(false);
            Button a3 = (Button) findViewById(R.id.a3);
            a3.setEnabled(true);
            a3.setVisibility(View.VISIBLE);
            Button b2 = (Button) findViewById(R.id.b2);
            b2.setEnabled(true);
            b2.setVisibility(View.VISIBLE);
            Button b4 = (Button) findViewById(R.id.b4);
            b4.setEnabled(true);
            b4.setVisibility(View.VISIBLE);
            Button c3 = (Button) findViewById(R.id.c3);
            c3.setEnabled(true);
            c3.setVisibility(View.VISIBLE);
        }
    }
    public void b4(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=1;
            y=3;
            buttonDisable();
            Button b4 = (Button) findViewById(R.id.b4);
            b4.setEnabled(false);
            Button a4 = (Button) findViewById(R.id.a4);
            a4.setEnabled(true);
            a4.setVisibility(View.VISIBLE);
            Button b3 = (Button) findViewById(R.id.b3);
            b3.setEnabled(true);
            b3.setVisibility(View.VISIBLE);
            Button b5 = (Button) findViewById(R.id.b5);
            b5.setEnabled(true);
            b5.setVisibility(View.VISIBLE);
            Button c4 = (Button) findViewById(R.id.c4);
            c4.setEnabled(true);
            c4.setVisibility(View.VISIBLE);
        }
    }
    public void b5(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=1;
            y=4;
            buttonDisable();
            Button b5 = (Button) findViewById(R.id.b5);
            b5.setEnabled(false);
            Button a5 = (Button) findViewById(R.id.a5);
            a5.setEnabled(true);
            a5.setVisibility(View.VISIBLE);
            Button b4 = (Button) findViewById(R.id.b4);
            b4.setEnabled(true);
            b4.setVisibility(View.VISIBLE);
            Button c5 = (Button) findViewById(R.id.c5);
            c5.setEnabled(true);
            c5.setVisibility(View.VISIBLE);
        }
    }
    public void c1(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=2;
            y=0;
            buttonDisable();
            Button c1 = (Button) findViewById(R.id.c1);
            c1.setEnabled(false);
            Button b1 = (Button) findViewById(R.id.b1);
            b1.setEnabled(true);
            b1.setVisibility(View.VISIBLE);
            Button c2 = (Button) findViewById(R.id.c2);
            c2.setEnabled(true);
            c2.setVisibility(View.VISIBLE);
            Button d1 = (Button) findViewById(R.id.d1);
            d1.setEnabled(true);
            d1.setVisibility(View.VISIBLE);
        }
    }
    public void c2(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=2;
            y=1;
            buttonDisable();
            Button c2 = (Button) findViewById(R.id.c2);
            c2.setEnabled(false);
            Button b2 = (Button) findViewById(R.id.b2);
            b2.setEnabled(true);
            b2.setVisibility(View.VISIBLE);
            Button c1 = (Button) findViewById(R.id.c1);
            c1.setEnabled(true);
            c1.setVisibility(View.VISIBLE);
            Button c3 = (Button) findViewById(R.id.c3);
            c3.setEnabled(true);
            c3.setVisibility(View.VISIBLE);
            Button d2 = (Button) findViewById(R.id.d2);
            d2.setEnabled(true);
            d2.setVisibility(View.VISIBLE);
        }
    }
    public void c3(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=2;
            y=2;
            buttonDisable();
            Button c3 = (Button) findViewById(R.id.c3);
            c3.setEnabled(false);
            Button b3 = (Button) findViewById(R.id.b3);
            b3.setEnabled(true);
            b3.setVisibility(View.VISIBLE);
            Button c2 = (Button) findViewById(R.id.c2);
            c2.setEnabled(true);
            c2.setVisibility(View.VISIBLE);
            Button c4 = (Button) findViewById(R.id.c4);
            c4.setEnabled(true);
            c4.setVisibility(View.VISIBLE);
            Button d3 = (Button) findViewById(R.id.d3);
            d3.setEnabled(true);
            d3.setVisibility(View.VISIBLE);
        }
    }
    public void c4(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=2;
            y=3;
            buttonDisable();
            Button c4 = (Button) findViewById(R.id.c4);
            c4.setEnabled(false);
            Button b4 = (Button) findViewById(R.id.b4);
            b4.setEnabled(true);
            b4.setVisibility(View.VISIBLE);
            Button c3 = (Button) findViewById(R.id.c3);
            c3.setEnabled(true);
            c3.setVisibility(View.VISIBLE);
            Button c5 = (Button) findViewById(R.id.c5);
            c5.setEnabled(true);
            c5.setVisibility(View.VISIBLE);
            Button d4 = (Button) findViewById(R.id.d4);
            d4.setEnabled(true);
            d4.setVisibility(View.VISIBLE);
        }
    }
    public void c5(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=2;
            y=4;
            buttonDisable();
            Button c5 = (Button) findViewById(R.id.c5);
            c5.setEnabled(false);
            Button b5 = (Button) findViewById(R.id.b5);
            b5.setEnabled(true);
            b5.setVisibility(View.VISIBLE);
            Button c4 = (Button) findViewById(R.id.c4);
            c4.setEnabled(true);
            c4.setVisibility(View.VISIBLE);
            Button d5 = (Button) findViewById(R.id.d5);
            d5.setEnabled(true);
            d5.setVisibility(View.VISIBLE);
        }
    }
    public void d1(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=3;
            y=0;
            buttonDisable();
            Button d1 = (Button) findViewById(R.id.d1);
            d1.setEnabled(false);
            Button c1 = (Button) findViewById(R.id.c1);
            c1.setEnabled(true);
            c1.setVisibility(View.VISIBLE);
            Button d2 = (Button) findViewById(R.id.d2);
            d2.setEnabled(true);
            d2.setVisibility(View.VISIBLE);
        }
    }
    public void d2(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=3;
            y=1;
            buttonDisable();
            Button d2 = (Button) findViewById(R.id.d2);
            d2.setEnabled(false);
            Button c2 = (Button) findViewById(R.id.c2);
            c2.setEnabled(true);
            c2.setVisibility(View.VISIBLE);
            Button d1 = (Button) findViewById(R.id.d1);
            d1.setEnabled(true);
            d1.setVisibility(View.VISIBLE);
            Button d3 = (Button) findViewById(R.id.d3);
            d3.setEnabled(true);
            d3.setVisibility(View.VISIBLE);
            Button e2 = (Button) findViewById(R.id.e2);
            e2.setEnabled(true);
            e2.setVisibility(View.VISIBLE);
        }
    }

    public void d3(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=3;
            y=2;
            buttonDisable();
            Button d3 = (Button) findViewById(R.id.d3);
            d3.setEnabled(false);
            Button c3 = (Button) findViewById(R.id.c3);
            c3.setEnabled(true);
            c3.setVisibility(View.VISIBLE);
            Button d2 = (Button) findViewById(R.id.d2);
            d2.setEnabled(true);
            d2.setVisibility(View.VISIBLE);
            Button d4 = (Button) findViewById(R.id.d4);
            d4.setEnabled(true);
            d4.setVisibility(View.VISIBLE);
            Button e3 = (Button) findViewById(R.id.e3);
            e3.setEnabled(true);
            e3.setVisibility(View.VISIBLE);
        }

    }

    public void d4(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=3;
            y=3;
            buttonDisable();
            Button d4 = (Button) findViewById(R.id.d4);
            d4.setEnabled(false);
            Button c4 = (Button) findViewById(R.id.c4);
            c4.setEnabled(true);
            c4.setVisibility(View.VISIBLE);
            Button d3 = (Button) findViewById(R.id.d3);
            d3.setEnabled(true);
            d3.setVisibility(View.VISIBLE);
            Button d5 = (Button) findViewById(R.id.d5);
            d5.setEnabled(true);
            d5.setVisibility(View.VISIBLE);
            Button e4 = (Button) findViewById(R.id.e4);
            e4.setEnabled(true);
            e4.setVisibility(View.VISIBLE);
        }
    }
    public void d5(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=3;
            y=4;
            buttonDisable();
            Button d5 = (Button) findViewById(R.id.d5);
            d5.setEnabled(false);
            Button c5 = (Button) findViewById(R.id.c5);
            c5.setEnabled(true);
            c5.setVisibility(View.VISIBLE);
            Button d4 = (Button) findViewById(R.id.d4);
            d4.setEnabled(true);
            d4.setVisibility(View.VISIBLE);
            Button e5 = (Button) findViewById(R.id.e5);
            e5.setEnabled(true);
            e5.setVisibility(View.VISIBLE);
        }
    }
    public void e1(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=4;
            y=0;
            buttonDisable();
            Button e1 = (Button) findViewById(R.id.e1);
            e1.setEnabled(false);
            Button d1 = (Button) findViewById(R.id.d1);
            d1.setEnabled(true);
            d1.setVisibility(View.VISIBLE);
            Button e2 = (Button) findViewById(R.id.e2);
            e2.setEnabled(true);
            e2.setVisibility(View.VISIBLE);
        }
    }
    public void e2(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=4;
            y=1;
            buttonDisable();
            Button e2 = (Button) findViewById(R.id.e2);
            e2.setEnabled(false);
            Button d2 = (Button) findViewById(R.id.d2);
            d2.setEnabled(true);
            d2.setVisibility(View.VISIBLE);
            Button e3 = (Button) findViewById(R.id.e3);
            e3.setEnabled(true);
            e3.setVisibility(View.VISIBLE);
        }
    }

    public void e3(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=4;
            y=2;
            buttonDisable();
            Button e3 = (Button) findViewById(R.id.e3);
            e3.setEnabled(false);
            Button d3 = (Button) findViewById(R.id.d3);
            d3.setEnabled(true);
            d3.setVisibility(View.VISIBLE);
            Button e2 = (Button) findViewById(R.id.e2);
            e2.setEnabled(true);
            e2.setVisibility(View.VISIBLE);
            Button e4 = (Button) findViewById(R.id.e4);
            e4.setEnabled(true);
            e4.setVisibility(View.VISIBLE);
        }
    }

    public void e4(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=4;
            y=3;
            buttonDisable();
            Button e4 = (Button) findViewById(R.id.e4);
            e4.setEnabled(false);
            Button d4 = (Button) findViewById(R.id.d4);
            d4.setEnabled(true);
            d4.setVisibility(View.VISIBLE);
            Button e3 = (Button) findViewById(R.id.e3);
            e3.setEnabled(true);
            e3.setVisibility(View.VISIBLE);
            Button e5 = (Button) findViewById(R.id.e5);
            e5.setEnabled(true);
            e5.setVisibility(View.VISIBLE);
        }
    }
    public void e5(View v) {
        int r = (int) Math.random() * 10;
        if (showQuestion(que[0].get(r).question, que[0].get(r).A, que[0].get(r).B, que[0].get(r).C, que[0].get(r).D, que[0].get(r).answer)) {
            playerScore += 25;
            displayScore(playerScore);
            x=4;
            y=4;
            buttonDisable();
            Button e5 = (Button) findViewById(R.id.e5);
            e5.setEnabled(false);
            Button d5 = (Button) findViewById(R.id.d5);
            d5.setEnabled(true);
            d5.setVisibility(View.VISIBLE);
            Button e4 = (Button) findViewById(R.id.e4);
            e4.setEnabled(true);
            e4.setVisibility(View.VISIBLE);
        }
    }
    public void reset(View v) {
        playerScore = 0;
        displayScore(playerScore);
        Toast toast = Toast.makeText(getApplicationContext(), "Puzzle reset.", Toast.LENGTH_SHORT);
        toast.show();
    }
    public void sss(View v){
        AStar aa=new AStar();
        aa.aStarSearch(grd,x,y,0,4);
        Toast.makeText(MainActivity.this, "Shortest path is "+aa.s, Toast.LENGTH_SHORT).show();
    }
}

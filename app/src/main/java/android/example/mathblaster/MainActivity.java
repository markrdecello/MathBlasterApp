package android.example.mathblaster;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int min = 1;
    int max = 20;
    int[] numList = new int[5];
    int total = 0;
    String display;
    TextView numbers, result;
    EditText sum_input;
    Button check, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbers = findViewById(R.id.numbers);
        result = findViewById(R.id.result);
        sum_input = findViewById(R.id.sum_input);
        check = findViewById(R.id.check);
        next = findViewById(R.id.next);

        reset(numList);
        display = numList[0] + ", " + numList[1] + ", " + numList[2] + ", " + numList[3] + ", " + numList[4];
        numbers.setText(display);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum_input.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this, "Please Enter A Number!", Toast.LENGTH_SHORT).show();
                }else if (Integer.parseInt(sum_input.getText().toString()) == total){
                    result.setVisibility(View.VISIBLE);
                    result.setText("Correct!");
                    next.setVisibility(View.VISIBLE);

                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            reset(numList);
                            display = numList[0] + ", " + numList[1] + ", " + numList[2] + ", " + numList[3] + ", " + numList[4];
                            numbers.setText(display);
                            result.setVisibility(View.INVISIBLE);
                            next.setVisibility(View.INVISIBLE);
                        }
                    });

                }else{
                    result.setVisibility(View.VISIBLE);
                    result.setText("Sorry, Try Again!");
                }
            }
        });
    }

    public int[] reset(int arr[]){
        total = 0;
        for(int i = 0; i < 5; i++){
            int random = new Random().nextInt((max - min) + 1) + min;
            arr[i] = random;
            total = total + arr[i];
        }
        return arr;
    }


}

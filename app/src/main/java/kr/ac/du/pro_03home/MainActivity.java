package kr.ac.du.pro_03home;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    int num1, num2,total;
    double n1,n2,total2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText 키패드 안뜸
        EditText none = (EditText)findViewById(R.id.input);
        none.setInputType(0);
    }

    // 숫자 및 사칙연산 입력

    public void onClick(View view) {
        EditText none = (EditText) findViewById(R.id.input);
        Button button = (Button) view;
        none.setText(none.getText().toString() + button.getText().toString());
    }


    // 한 글자씩 지우기
    public void cancle_Click(View view) {
        EditText none = (EditText)findViewById(R.id.input);
        String text = none.getText().toString();
        none.setText(text.substring(0, text.length() - 1));

        /*if(none.length() == 0){
            Toast.makeText(getApplicationContext(),"계산할 값을 입력해주세요",Toast.LENGTH_SHORT).show();
        }
        */
    }

    // AC = 모두 지우기
    public void AC_Click(View view) {
        EditText none = (EditText) findViewById(R.id.input);
        TextView none2 = (TextView) findViewById(R.id.edit_result);

        Button button = (Button) view;
        none.setText("");
        none2.setText("");
    }


    // 계산 결과(=) 버튼
    public void total_Click(View view) {
        TextView ed = (TextView) findViewById(R.id.edit_result);
        EditText none = (EditText) findViewById(R.id.input);
        Button button = (Button) view;


        String op = none.getText().toString();
        String opstr = none.getText().toString().replaceAll("\\d", ""); // 정규표현식 \d : 0~9 | \D : 숫자를 제외한 모든 문자


        switch (opstr) {
            case "+" :
                int add = op.indexOf("+");                        // (+) 인덱스 위치 찾기
                num1 = Integer.parseInt(op.substring(0,add));     // (+) 앞까지 숫자를 num1에 저장
                num2 = Integer.parseInt(op.substring(add+1));     // (+) 뒷자리 숫자를 num2에 저장
                total = num1 + num2;
                ed.setText(""+total);
                break;

            case "-" :
                int mi = op.indexOf("-");
                num1 = Integer.parseInt(op.substring(0,mi));     // (-) 앞까지 숫자를 num1에 저장
                num2 = Integer.parseInt(op.substring(mi+1));     // (-) 뒷자리 숫자를 num2에 저장
                total = num1 - num2;
                ed.setText(""+total);
                break;


            case "×" :
                int gok = op.indexOf("×");
                num1 = Integer.parseInt(op.substring(0,gok));     // (×) 앞까지 숫자를 num1에 저장
                num2 = Integer.parseInt(op.substring(gok+1));     // (×) 뒷자리 숫자를 num2에 저장
                total = num1 * num2;
                ed.setText(""+total);
                break;


            case "÷" :
                int na = op.indexOf("÷");
                n1 =  Double.parseDouble(op.substring(0,na));     // (÷) 앞까지 숫자를 num1에 저장
                n2 =  Double.parseDouble(op.substring(na+1));     // (÷) 뒷자리 숫자를 num2에 저장
                total2 = n1 / n2;
                String total2_6 = String.format("%.6f",total2); // 소수점 6자리까지
                ed.setText(""+total2_6);
                break;

            case "%" :
                int pu = op.indexOf("÷");
                num1 = Integer.parseInt(op.substring(0,pu));     // (%) 앞까지 숫자를 num1에 저장
                num2 = Integer.parseInt(op.substring(pu+1));     // (%) 뒷자리 숫자를 num2에 저장
                total2 = num1 % num2;
                ed.setText(""+total2);
                break;
        }

    }
}

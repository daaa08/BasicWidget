package com.example.da08.mainactivity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener,
        RadioGroup.OnCheckedChangeListener{

    // 위젯의 변수를 선언
    Button button, button2, button3;
    ToggleButton toggleButton;
    RadioGroup radioGroup;
    SeekBar seekBar;
    TextView sbc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯변수를 화면과 연결
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);

        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        sbc = (TextView) findViewById(R.id.sbc);



        // 클릭리스너 연결, 시스템에 넘겨줌
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        toggleButton.setOnCheckedChangeListener(this);  // 클릭 리스너가 아님
        radioGroup.setOnCheckedChangeListener(this);
        seekBar.setOnSeekBarChangeListener(listener);

    }

    @Override
    public void onClick(View v) {
        // 시스템의 이벤트 리스너를 통해 호출된다 , v에 클릭될 위젯들이 넘어옴 (다형성에 의해서 v로 인자를 받음) ,View는 최상위 클래스
        switch(v.getId()) {  // 버튼id를 불러옴
            case R.id.button:
                Toast.makeText(this, "멍멍", Toast.LENGTH_SHORT).show();  // 클릭시 실행할것  (토스트 길이 숏은4초정도.. 롱은 8초정도.. 조절은x)
                break;
            case R.id.button2:
                Toast.makeText(this, "꿀꿀", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(this, "히힝", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch(buttonView.getId()) {
            case R.id.toggleButton :
            if(isChecked) {
                Toast.makeText(this, "on", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "off", Toast.LENGTH_SHORT).show();
            }break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        if(group.getId() == R.id.RadioGroup){
                switch (checkedId){
                    case R.id.rb3 :
                    Toast.makeText(this, "on", Toast.LENGTH_SHORT).show();
                    case R.id.rb2 :
                        Toast.makeText(this, "on", Toast.LENGTH_SHORT).show();
                    case R.id. rb :
                        Toast.makeText(this, "on", Toast.LENGTH_SHORT).show();
                }
        }
    }

    SeekBar.OnSeekBarChangeListener listener = new SeekBar.OnSeekBarChangeListener() {
        // Seekbar가 여러개여도 해당 리스너만 불러오므로 변수 명과는 상관이 없음
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {  //boolean 사람이 사용했는지 여부
            sbc.setText(progress + "");  // 사용했다면 실행
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

    };
}


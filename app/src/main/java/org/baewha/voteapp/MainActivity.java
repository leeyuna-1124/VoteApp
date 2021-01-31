package org.baewha.voteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("회장 투표");

        Button btnResult; //투표종료 버튼
        final int vote[] = new int [6]; //투표결과 저장
        ImageView[] iv = new ImageView[6]; //위젯변수 저장
        int imageId[] = {R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5, R.id.iv6};
        //xml id
        final String PersonName[] = {"진저브레드씨", "킷캣씨", "롤리팝씨", "마시멜로씨",
                "오레오씨", "파이씨"};
        //후보자 문자열배열 생성

        for(int i=0; i<imageId.length; i++){ //위젯변수를 저장해서 투표결과로 배열에 넣음
            final int index;
            index = i;
            iv[index] = findViewById(imageId[index]);
            iv[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { //클릭 이벤트
                    vote[index]++; //투표수 증가
                    Toast.makeText(getApplicationContext(), PersonName[index]+"가"+vote[index]+"표 획득",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
        btnResult = findViewById(R.id.btnResult); //투표종료 버튼
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), VoteResult.class);
                intent.putExtra("vote", vote); //투표결과에 대한 정보를 intent에 저장
                intent.putExtra("PersonName", PersonName);//투표한 후보자의 이름을 저장
                startActivity(intent); //intent에 있는 정보를 저장해서 새로운 intent시작
            }
        });

    }
}
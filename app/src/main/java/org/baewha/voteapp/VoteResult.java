package org.baewha.voteapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VoteResult extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("회장선거 투표 결과");

        Intent intent = getIntent(); //intent를 가져옴
        int[] vote = intent.getIntArrayExtra("vote");//intent의 정수배열을 가져옴
        String[] str = intent.getStringArrayExtra("PersonName");//intent의 문자열 배열을 가져옴
        Integer imageFileId[] = {R.drawable.gingerbread, R.drawable.kitkat,
                R.drawable.lollipop, R.drawable.marshmallow,
                R.drawable.oreo, R.drawable.pie};

        TextView best = (TextView)findViewById(R.id.resultView);
        ImageView bestiv = (ImageView)findViewById(R.id.getImage);
        int maxEntry = 0;
        for(int i=1; i<vote.length; i++){
            if(vote[maxEntry]<vote[i])
                maxEntry = i;
        }
        best.setText(str[maxEntry]+"/"+vote[maxEntry]+"표");
        bestiv.setImageResource(imageFileId[maxEntry]);

        Button btn = findViewById(R.id.backToMain);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); //버튼을 누르면 종료
            }
    });
}

}

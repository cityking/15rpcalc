package com.example.rpcalc;

import java.io.UnsupportedEncodingException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		TextView tv_name = (TextView) findViewById(R.id.tv_name);
		TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
		TextView tv_result = (TextView) findViewById(R.id.tv_result);
		Intent intent = this.getIntent();
		String name = intent.getStringExtra("name");
		int sex = intent.getIntExtra("sex", 0);
		tv_name.setText("������"+name);
		byte[] bytes = null;
		try {
			switch (sex) {
			case 1:
				tv_sex.setText("�Ա���");
				bytes = name.getBytes("utf-8");
				break;
			case 2:
				tv_sex.setText("�Ա�Ů");
				bytes = name.getBytes("gbk");
				break;
			case 3:
				tv_sex.setText("�Ա�����");
				bytes = name.getBytes("iso-8859-1");
				break;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int total = 0;
		for (byte b : bytes) {
			int number = b & 0xff;
			total += number;
		}
		int score = total%100;
		if (score >= 90) {
			tv_result.setText("�����Ʒ�ü���"+score);
		}else if(score >= 80){
			tv_result.setText("�����Ʒ������"+score);
		}else if(score >= 60){
			tv_result.setText("�����Ʒ�ռ���"+score);
		}else{
			tv_result.setText("�����Ʒ̫����"+score);
		}
	}
}

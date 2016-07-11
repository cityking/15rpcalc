package com.example.rpcalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText et_name;
	RadioGroup rg_sex;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		et_name = (EditText) findViewById(R.id.et_name);
		rg_sex = (RadioGroup) findViewById(R.id.rg_sex);
	}
	public void click(View v){
		String name = et_name.getText().toString().trim();
		if(name.isEmpty()){
			Toast.makeText(this, "姓名不能为空", 1).show();
			return;
		}
		int checkedRadioButtonId = rg_sex.getCheckedRadioButtonId();
		int sex = 0;
		switch (checkedRadioButtonId) {
		case R.id.rb_male:
			sex = 1;
			break;
		case R.id.rb_female:
			sex = 2;
			break;
		case R.id.rb_other:
			sex = 3;
			break;
		}
		if(sex == 0){
			Toast.makeText(this, "请选择性别", 1).show();
			return;
		}
		Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
		intent.putExtra("name", name);
		intent.putExtra("sex", sex);
		startActivity(intent);
	}

}

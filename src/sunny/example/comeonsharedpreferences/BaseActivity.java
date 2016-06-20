package sunny.example.comeonsharedpreferences;

import android.app.Activity;
import android.os.Bundle;
public class BaseActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		ActivityCollector.addAtivity(this);
	}
	@Override
	protected void onDestroy(){
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}

}

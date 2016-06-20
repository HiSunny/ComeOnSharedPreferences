package sunny.example.comeonsharedpreferences;

import android.support.v7.app.ActionBarActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button mButton = (Button)findViewById(R.id.save);
		mButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				SharedPreferences.Editor mEditor = getSharedPreferences("data",MODE_PRIVATE).edit();
				mEditor.putBoolean("boolean", true);
				mEditor.putFloat("float", 0.01F);
				mEditor.putString("String", "a string");
				mEditor.commit();
				
			}
		});
		
		Button getButton = (Button)findViewById(R.id.get);
		getButton.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				SharedPreferences mSharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
				boolean boolStr = mSharedPreferences.getBoolean("boolean", false);
				float floatStr = mSharedPreferences.getFloat("float", 0.0f);
				String str = mSharedPreferences.getString("String", "str");
				TextView tv = (TextView)findViewById(R.id.tv);
				tv.setText(" str is: "+str +"\n"+ " boolean is :"+ boolStr +"\n"+" float is: "+ floatStr );
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

package sunny.example.comeonsharedpreferences;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.CheckBox;
public class LoginActivity extends BaseActivity{
	private EditText edit_username;
	private EditText edit_pass;
	private Button login_btn;
	private SharedPreferences mSharedPreferences;
	private SharedPreferences.Editor editor;
	private CheckBox mCheckBox;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
		
		mCheckBox = (CheckBox)findViewById(R.id.remember_pass);
		boolean isRemember = mSharedPreferences.getBoolean("remember_pass", false);
		edit_username = (EditText)findViewById(R.id.edit_username);
		edit_pass = (EditText)findViewById(R.id.edit_password);
		 login_btn = (Button)findViewById(R.id.login);
		 //�ٴ�����Activityʱ��checkBox isChecked()����getString()��ȡ֮ǰputString()���������
		 if(isRemember){
			 String account = mSharedPreferences.getString("account", "");
			 String password = mSharedPreferences.getString("password1", "'");
			 edit_username.setText(account);
			 edit_pass.setText(password);
			 mCheckBox.setChecked(true); 
		 }
		 login_btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View view){
				String account = edit_username.getText().toString();
				String password = edit_pass.getText().toString();
				//�˺��ǡ������͵�¼�ɹ�
				if(account.equals( "sunny")&&password.equals("1225")){
					editor = mSharedPreferences.edit();
					//�û�ѡ��checkbox
					if(mCheckBox.isChecked()){
						//����remember_pass����Ϊtrue isRemember
						editor.putBoolean("remember_pass", true);
						//����account��password
						editor.putString("account", account);
						editor.putString("password1",password);
					}else{
						//Editor android.content.SharedPreferences.Editor.clear()
						//Mark in the editor to remove all values from the preferences. 
						editor.clear();
					}
					editor.commit();
					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
					finish();
				}else{
					Toast.makeText(LoginActivity.this, "username or password wrong", Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}

}

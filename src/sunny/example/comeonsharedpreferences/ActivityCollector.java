package sunny.example.comeonsharedpreferences;

import android.app.Activity;
import java.util.List;
import java.util.ArrayList;
public class ActivityCollector {

	public static List<Activity> activitiesList = new ArrayList<Activity>();
	
	public static void addAtivity(Activity activity){
		activitiesList.add(activity);
	}
	public static void removeActivity(Activity activity){
		activitiesList.remove(activity);
	}
	public static void finishAll(){
		for(Activity activity:activitiesList){
			if(!activity.isFinishing()){
				activity.finish();
			}
		}
	}
}

package support;

import java.util.HashMap;

/**
 * The purpose of this class is to serve as utility to pass information (when necessary)
 * between two or more steps and in those cases where the steps are in different classes.
 * -
 * Add a 'private MyContext context' variable in the steps classes you want to share the information.
 * Assign the value of such variable in the constructor of the step as follows:
 * context = MyContext.getInstance()
 * -
 * Store and retrieve data using the setData and getData methods respectively.
 */

public class MyContext {

    private static final ThreadLocal<MyContext> instance = new ThreadLocal<>();
    private HashMap<String, Object> data;

    //To avoid external initialization
    private MyContext() {
        data = new HashMap<>();
    }

    public static MyContext getInstance() {
        if (instance.get() == null) {
            instance.set(new MyContext());
        }
        return instance.get();
    }

    public void setData(String key, Object value){
        data.put(key, value);
    }

    public Object getData(String key){
        return data.get(key);
    }
}

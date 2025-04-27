package echo;

import java.util.HashMap;

public class SafeTable extends HashMap<String,String> {

    // Singleton instance w/ private constructor and a getInstance() method
    private static final SafeTable table = new SafeTable();

    private SafeTable() {
        super();
    }

    public static SafeTable getInstance() {
        return table;
    }

    // Synchronized methods, thread safe
    @Override
    public synchronized String get(Object key) { 
        return super.get(key);
    }

    @Override
    public synchronized String put(String key, String value) {
        return super.put(key, value);
    }

}

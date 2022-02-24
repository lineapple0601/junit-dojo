package junit.dojo.day6;

import java.util.HashMap;
import java.util.Map;

public class HogeSingleton {

        private Map<String, String> valueByKey;

        private HogeSingleton() {
                this.valueByKey = new HashMap<String, String>();
                throw new RuntimeException();//呼べないようにわざと
        }

        public String getValue(String key) {
                return valueByKey.get(key);
        }

        public static HogeSingleton instance() {
                return HogeControlInstanceHolder.INSTANCE;
        }

        public static class HogeControlInstanceHolder {
                private static final HogeSingleton INSTANCE = new HogeSingleton();
        }

}

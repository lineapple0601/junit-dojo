package junit.dojo.day6;

import java.util.HashMap;
import java.util.Map;

public class HogeSingleton implements ISingleton {

        private Map<String, String> valueByKey;

        private HogeSingleton() {
                this.valueByKey = new HashMap<String, String>();
                throw new RuntimeException();//呼べないようにわざと
        }

        @Override
		public String getValue(String key) {
                return valueByKey.get(key);
        }

        public static ISingleton instance() {
                return HogeControlInstanceHolder.INSTANCE;
        }

        public static class HogeControlInstanceHolder {
                private static final ISingleton INSTANCE = new HogeSingleton();
        }

}

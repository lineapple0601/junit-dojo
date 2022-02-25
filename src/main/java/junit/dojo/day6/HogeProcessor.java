package junit.dojo.day6;

public class HogeProcessor {
	
        public String process(String fileType) {
                String value = createHogeSingletonValue(fileType);
                // いろいろやる的な
                return value.toLowerCase() + "_mod";
        }
        
        protected String createHogeSingletonValue(String fileType) {
        	return HogeSingleton.instance().getValue(fileType);
        }
}
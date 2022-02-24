package junit.dojo.day6;

public class HogeProcessor {
	
        public String process(String fileType) {
                String value = HogeSingleton.instance().getValue(fileType);
                // いろいろやる的な
                return value.toLowerCase() + "_mod";
        }
        
}
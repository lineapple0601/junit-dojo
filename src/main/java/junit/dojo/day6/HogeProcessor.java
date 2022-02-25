package junit.dojo.day6;

public class HogeProcessor {
	
		ISingleton singleton;
		
		public HogeProcessor(ISingleton singleton) {
			this.singleton = singleton;
		}
		
        public String process(String fileType) {
                String value = singleton.getValue(fileType);
                // いろいろやる的な
                return value.toLowerCase() + "_mod";
        }
        
}
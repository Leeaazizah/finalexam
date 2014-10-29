package default_package;

	
	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	public class ConsoleInput {

		public static String read(String message) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				System.out.print(message);
				String input = br.readLine();
				return input;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		public static int readInt(String message){
			return Integer.parseInt(read(message));
		}
		
		public static long readLong(String message){
			return Long.parseLong(read(message));
		}
	     
	}

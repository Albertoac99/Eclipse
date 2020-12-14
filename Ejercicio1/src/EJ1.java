import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class EJ1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		List<String> jvmArgs = new ArrayList<>();
		List<String> argsM = new ArrayList<>();
		
		JavaProcess.exec(Mapeador.class, jvmArgs, argsM);

		
		
	}

}

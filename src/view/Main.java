package view; //EXERCICIO 2
import java.io.IOException;
import controller.Controller;
import controller.IArquivo;

public class Main {

	public static void main(String[] args) {
		Controller m = new Controller();
		
		String dir = "C:\\TesteSO";
		String nome = "SteamCharts";
		String ext = ".csv";
		
		try {
			m.readFile(dir, nome, ext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
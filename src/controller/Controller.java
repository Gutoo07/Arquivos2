package controller; //EXERCICIO2

//import model.No;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Controller implements IArquivo {
	
	@Override
	public void createFile(String path, String nome, String ext, StringBuilder builder) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome + ext);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = false; //assim o arquivo só grava o último request, pra facilitar a sua visualização
			}
			FileWriter writer = new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter(writer);
			print.write(builder.toString());
			print.flush();
			print.close();
			writer.close();
		} else {
			throw new IOException ("Diretorio invalido.");
		}
	}
	@Override
	public void readFile(String path, String nome, String ext) throws IOException {
		File arq = new File(path, nome + ext);
		if (arq.exists() && arq.isFile()) {
			String ano = JOptionPane.showInputDialog(null,"Digite um ano desejado: ");
			String mes = JOptionPane.showInputDialog(null,"Digite um mês desejado: ");
			int media = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite uma "
										 + "média de jogadores ativos desejada: "));

			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			StringBuilder builder = new StringBuilder();
			
			String linha = buffer.readLine();
			linha = buffer.readLine();			
			
			while (linha != null) {
				String palavras[] = linha.split(",");
				
				if (palavras[1].equals(ano) && palavras[2].equals(mes) && Double.parseDouble(palavras[3]) >= media) {
					builder.append(palavras[0] + ";" + palavras[3] + "\n");					
				}
				linha = buffer.readLine();
			} 
			System.out.println(builder);
			createFile(path,"GustavoKoyanagui", ext, builder);
		} else {
			throw new IOException("Arquivo invalido.");
		}
	}
}
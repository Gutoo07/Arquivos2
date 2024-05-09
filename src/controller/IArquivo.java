package controller;

import java.io.IOException;

public interface IArquivo {
	public void createFile(String path, String nome, String ext, StringBuilder buffer) throws IOException;
	public void readFile(String path, String nome, String ext)throws IOException;
}
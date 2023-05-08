package Aplication;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		
		String path = scanner.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "123456");
			Statement statement = connection.createStatement();
			StringBuilder sb = new StringBuilder();
			String linha;
			
			while((linha = br.readLine())!= null) {
				sb.append(linha);
				String sql = sb.toString();
				statement.execute(sql);
			}
			
			System.out.println("Operação realizada com sucesso!");
			
			statement.close();
			connection.close();
			
		}catch(Exception e) {
			System.out.println("Error: " + e.getMessage());
		}finally {
			scanner.close();
			
		}
		
	}
}

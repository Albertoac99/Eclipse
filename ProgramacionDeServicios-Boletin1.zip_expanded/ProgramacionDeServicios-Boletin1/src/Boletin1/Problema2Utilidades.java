package Boletin1;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Problema2Utilidades {

public static void main(String[] args) {
		
		if(args.length==1) {
			try {
				Process process = Runtime.getRuntime().exec("cmd.exe /c net user " +args[0]+ " & cmd.exe /c if %ERRORLEVEL% EQU 0 (echo t) else (echo f)");
				InputStream inputstream = process.getInputStream();
				BufferedInputStream b = new BufferedInputStream(inputstream);
				String sCadena = "";
				int iCadena= b.read();
				boolean bCierto = false;
				while(!bCierto) {
					
						iCadena = b.read();
						if(iCadena!=-1) {
							sCadena += (char)iCadena;
						}
						else {
							bCierto = true;
						}
						}
				char ch = 't';
				try{
					if(ch == sCadena.charAt(sCadena.length()-3)) {
					System.out.println("El usuario existe");}
				}catch(StringIndexOutOfBoundsException e) {
					System.out.println("Usuario no existe");
				}
				}
			
				
			 catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(args.length==2) {
			
			try {
				Process process = Runtime.getRuntime().exec("cmd.exe /c fc " +args[0]+" " +args[1]);
				InputStream inputstream = process.getInputStream();
				BufferedInputStream b = new BufferedInputStream(inputstream);
				
				String sCadena = "";
				int iCadena= b.read();
				boolean bCierto = false;
				while(!bCierto) {
					
						iCadena = b.read();
						if(iCadena!=-1) {
							sCadena += (char)iCadena;
						}
						else {
							bCierto = true;
						}
						
					
				}
				System.out.println(sCadena);
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		else {
			System.out.println("Error");
		}

	}
}

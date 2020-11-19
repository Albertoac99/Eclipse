package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import model.Boton;
import model.Mando;

public class ContPrincipal {
	
	private Document docXML;
	private String FILE_NAME;
	private static ContPrincipal fch;
	
	public ContPrincipal(String FileName) {
		try {
		
		this.FILE_NAME=FileName;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		DOMImplementation implementation = dBuilder.getDOMImplementation();
		
		docXML = implementation.createDocument(FileName, "elemento", null);
		docXML = dBuilder.parse(FileName);
		docXML.getDocumentElement().normalize();
		
		
		
		}catch (IOException e) {
		
			System.out.println("Fallo durante el parsing"+e);
		} catch (ParserConfigurationException | SAXException e) {

			System.out.println("Fallo accediendo al fichero"+e);
		}
		
	}
	
	public static void writeDataObject(String FILE_NAME, List<Mando> listado) {
		try {
			
			ObjectOutputStream fch = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			
			for(Mando c : listado) {
				fch.writeObject(c);
			}
			
			fch.close();
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static List<Mando> readDataObject(String FILE_NAME) {
		
		
		List<Mando> listado = new ArrayList<Mando>();
		
		try {
			
			ObjectInputStream fch = new ObjectInputStream(new FileInputStream(FILE_NAME));
			
			Object obj = fch.readObject();
			
			while(obj!=null) {
				if(obj instanceof Mando) {
					listado.add((Mando) obj);
				}
				obj = fch.readObject();
			}
			
			
			
			fch.close();
		} catch (IOException e) {
			
		} catch (ClassNotFoundException e) {
			
		}
		
		return listado;
	}
	
	public static List<Mando> insercionBotones(){
		List<Mando> mandos = new ArrayList<Mando>();
		
		List<Boton> botonesMando1 = Arrays.asList(new Boton(1,"POWER", (double) 50000));
		List<Boton> botonesMando2 = Arrays.asList(new Boton(2, "GUIDE", (double) 20000));
		List<Boton> botonesMando3 = Arrays.asList(new Boton(3, "SOURCE", (double) 20000));
		List<Boton> botonesMando4 = Arrays.asList(new Boton(4, "BACK", (double) 20000));
		List<Boton> botonesMando5 = Arrays.asList(new Boton(5, "VOLUME", (double) 20000));

		mandos.add(new Mando(1,"SG1", botonesMando1));
		mandos.add(new Mando(2,"MA3", botonesMando2));
		mandos.add(new Mando(3,"PR4", botonesMando3));
		mandos.add(new Mando(4,"CCD", botonesMando4));
		mandos.add(new Mando(5,"HT1", botonesMando5));
		
		return mandos;
	}

	public void addNodeMando(Mando m) {
			Node nMando = docXML.createElement("mando");
			((Element)nMando).setAttribute("id", ""+m.getId());
			
			Node nModelo_tag = docXML.createElement("modelo");
			nModelo_tag.appendChild(docXML.createTextNode(m.getModelo()));
			
			
			
			Node nBotones_tag = null;
			for(int i = 0;i<m.getBotones().size();i++) {
			nBotones_tag = docXML.createElement("botones");
			((Element)nBotones_tag).setAttribute("id", ""+m.getBotones().get(i).getId());
			
			Node texto = docXML.createElement("texto");
			texto.appendChild(docXML.createTextNode(""+m.getBotones().get(i).getTexto()));
			
			Node pulsaVida = docXML.createElement("pulsaVida");
			pulsaVida.appendChild(docXML.createTextNode(""+m.getBotones().get(i).getpulsaVida()));
			
			
			nBotones_tag.appendChild(texto);
			nBotones_tag.appendChild(pulsaVida);
			
			}
			
			
			nMando.appendChild(nModelo_tag);
			nMando.appendChild(nBotones_tag);
			
			
			Node nRaiz = docXML.getFirstChild();
			nRaiz.appendChild(nMando);
		}

	public static void escritura(String FILE_NAME_OBJ) {
		List<Mando> mandos = new ArrayList<Mando>();
		
		mandos = ContPrincipal.insercionBotones();
		
		ContPrincipal.writeDataObject(FILE_NAME_OBJ, mandos);
		
	}

	public static void convert_file_object_to_xml(String FILE_NAME_OBJ, String FILE_NAME_XML) {
		List<Mando> lista = new ArrayList<Mando>();
		
		lista = readDataObject(FILE_NAME_OBJ);
		
		for(Mando m : lista) {
			System.out.println(m);
		}
		
		fch = new ContPrincipal(FILE_NAME_XML);
		
		for(Mando m : lista) {
			
			fch.addNodeMando(m);
			
		}
		
		fch.SaveData();
	}

	public void SaveData() {
		
		try {
			
			Transformer tr = TransformerFactory.newInstance().newTransformer();
			tr.setOutputProperty(OutputKeys.INDENT,"yes");
			tr.setOutputProperty(OutputKeys.METHOD,"xml");
			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			tr.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			//Enviar documento xml al Fichero
			
			tr.transform(new DOMSource(docXML),new StreamResult(new FileOutputStream(FILE_NAME)));
			
			
			
		} catch (TransformerConfigurationException e) {
			System.err.println("Fallo convirtiendo el xml");
		} catch (TransformerFactoryConfigurationError e) {
			System.err.println("Fallo escribiendo en el archivo");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
	}
}

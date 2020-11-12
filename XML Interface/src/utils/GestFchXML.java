package utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Alumno;

public class GestFchXML {

	
	private Document docXML;
	private String FILE_NAME;
	
	public GestFchXML(String FileName) {
		try {
			
		this.FILE_NAME=FileName;
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	
		docXML = dBuilder.parse(FileName);
		docXML.getDocumentElement().normalize();
		
		
		
		}catch (IOException e) {
		
			System.out.println("Fallo durante el parsing");
		} catch (ParserConfigurationException | SAXException e) {

			System.out.println("Fallo accediendo al fichero");
		}
		
	}
	
	
	public static void mostrarFchXML(String FILE_NAME) {
		
		try {
			File fch = new File(FILE_NAME);
		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		
			Document docXML = dBuilder.parse(fch);
			docXML.getDocumentElement().normalize();
			
			String expression = "/persona/jugador";
			
			
			XPath xPath = XPathFactory.newInstance().newXPath();
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(docXML, XPathConstants.NODESET);
		
			for(int i=0; i<nodeList.getLength(); i++) {
				
				Node nNode = nodeList.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					System.out.println("Jugador Número = " +eElement.getAttribute("numero"));
					System.out.println("        Nombre = " +eElement.getElementsByTagName("nombre").item(0).getTextContent());
					System.out.println("        Apellidos = " +eElement.getElementsByTagName("apellidos").item(0).getTextContent());
					System.out.println("        Nick = " +eElement.getElementsByTagName("nick").item(0).getTextContent());
					System.out.println("        Puntos = " +eElement.getElementsByTagName("puntos").item(0).getTextContent());
					System.out.println("");
				}
				
				
			}
			
			
			
			
			
		}catch (XPathExpressionException e) {
			
			System.out.println("Fallo aplicando la expresion (filtro).");
		
		} catch (IOException e) {
		
			System.out.println("Fallo durante el parsing");
		} catch (ParserConfigurationException | SAXException e) {

			System.out.println("Fallo accediendo al fichero");
		}
		
		
		
	}
	
	public List<Alumno> getAlumnos() {
		List<Alumno> listado = new ArrayList<Alumno>();
			
			NodeList nodeList = getNodeList("/persona/alumno");
		
			for(int i=0; i<nodeList.getLength(); i++) {
				
				Node nNode = nodeList.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					int matricula = Integer.parseInt(eElement.getAttribute("mat"));
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String apellidos = eElement.getElementsByTagName("apellidos").item(0).getTextContent();
					
					listado.add(new Alumno(matricula,nombre,apellidos));
				}
				
				
			}
			
		return listado;

	}
	
	private NodeList getNodeList(String expression) {
		NodeList nodeList = null;
		XPath xPath = XPathFactory.newInstance().newXPath();
		try {
			nodeList = (NodeList) xPath.compile(expression).evaluate(docXML, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
		
		
		return nodeList;
	}
	
	
}

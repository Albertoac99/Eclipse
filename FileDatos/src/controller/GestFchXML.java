package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Entrenador;
import model.Jugador;

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
			
			String expression = "/game/jugador";
			
			
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

	public List<Jugador> getJugadores() {
		List<Jugador> listado = new ArrayList<Jugador>();
			
			NodeList nodeList = getNodeList("/game/jugador");
		
			for(int i=0; i<nodeList.getLength(); i++) {
				
				Node nNode = nodeList.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					int numero = Integer.parseInt(eElement.getAttribute("numero"));
					String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
					String apellidos = eElement.getElementsByTagName("apellidos").item(0).getTextContent();
					String nick = eElement.getElementsByTagName("nick").item(0).getTextContent();
					int puntos = Integer.parseInt(eElement.getElementsByTagName("puntos").item(0).getTextContent());
					
					listado.add(new Jugador(numero,nombre,apellidos,nick,puntos));
				}
				
				
			}
			
		return listado;

	}

	public List<Entrenador> getEntrenadores(String FILE_NAME) {
	List<Entrenador> listado = new ArrayList<Entrenador>();
		
		
		NodeList nodeList = getNodeList("/game/entrenador");
	
		for(int i=0; i<nodeList.getLength(); i++) {
			
			Node nNode = nodeList.item(i);
			
			if(nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element)nNode;
				int colegiado = Integer.parseInt(eElement.getAttribute("colegiado"));
				String nombre = eElement.getElementsByTagName("nombre").item(0).getTextContent();
				String apellidos = eElement.getElementsByTagName("apellidos").item(0).getTextContent();
				int edad = Integer.parseInt(eElement.getElementsByTagName("edad").item(0).getTextContent());
				
				listado.add(new Entrenador(colegiado,nombre,apellidos,edad));
			}
			
			
		}
	return listado;
}

	public void addNodeJugador(Jugador j) {
	
	//Se crea un nodo tipo Element con el nombre "nombre", y quedaria asi: <nombre>
		Node nNombre_tag = docXML.createElement("nombre");
		nNombre_tag.appendChild(docXML.createTextNode(j.getNombre()));
		
		Node nApellidos_tag = docXML.createElement("apellidos");
		nApellidos_tag.appendChild(docXML.createTextNode(j.getApellidos()));
		
		Node nNick_tag = docXML.createElement("nick");
		nNick_tag.appendChild(docXML.createTextNode(j.getNick()));
		
		Node nPuntos_tag = docXML.createElement("puntos");
		nPuntos_tag.appendChild(docXML.createTextNode(""+j.getPuntos()));
		
		Node nJugador = docXML.createElement("jugador");
		((Element)nJugador).setAttribute("numero", ""+j.getNumero());
		
		nJugador.appendChild(nNombre_tag);
		nJugador.appendChild(nApellidos_tag);
		nJugador.appendChild(nNick_tag);
		nJugador.appendChild(nPuntos_tag);
		
		Node nRaiz = docXML.getFirstChild();
		nRaiz.appendChild(nJugador);
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




























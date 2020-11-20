package logic;

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

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import model.Ciudad;
import model.Comunidad;
import model.Provincia;


public class LogPrincipal {
	
	private String FILE_NAME;
	private Document docXML;
	
	public LogPrincipal(String FileName) {
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
	
	public List<Ciudad> getCiudades(String id) {
		List<Ciudad> listado = new ArrayList<Ciudad>();
			
			NodeList nodeList = getNodeList("//ciudad");
		
			for(int i=0; i<nodeList.getLength(); i++) {
				
				Node nNode = nodeList.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					String cod_ine = eElement.getAttribute("cod_ine");
					String nombre = eElement.getAttribute("nombre");
					int tmax = Integer.parseInt(eElement.getElementsByTagName("tmax").item(0).getTextContent());
					int tmin = Integer.parseInt(eElement.getElementsByTagName("tmin").item(0).getTextContent());
					
					if(cod_ine.startsWith(id)) {
						listado.add(new Ciudad(cod_ine,nombre,tmax,tmin));
					}
					
				}
				
				
			}
			
		return listado;

	}
	
	public List<Provincia> getProvincias(String idComunidad) {
		List<Provincia> listado = new ArrayList<Provincia>();
			
			NodeList nodeList = getNodeList("//provincia");
		
			for(int i=0; i<nodeList.getLength(); i++) {
				
				Node nNode = nodeList.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					String ccaa = eElement.getAttribute("ccaa");
					String id = eElement.getAttribute("id");
					String nombre = eElement.getAttribute("nombre");
					List<Ciudad> ciudades = getCiudades(id); 
					
					if(idComunidad.equals(ccaa)) {
						listado.add(new Provincia(ccaa,id,nombre,ciudades));
					}
					
				}
				
				
			}
			
		return listado;

	}
	
	public List<Comunidad> getComunidad() {
		List<Comunidad> listado = new ArrayList<Comunidad>();
			
			NodeList nodeList = getNodeList("//ccaa");
		
			for(int i=0; i<nodeList.getLength(); i++) {
				
				Node nNode = nodeList.item(i);
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element)nNode;
					String id = eElement.getAttribute("id");
					String nombre = eElement.getAttribute("nombre");
					List<Provincia> provincias = getProvincias(id); 
					
					listado.add(new Comunidad(id,nombre,provincias));
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

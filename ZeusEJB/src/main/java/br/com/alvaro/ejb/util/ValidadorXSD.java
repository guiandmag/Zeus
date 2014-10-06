package br.com.alvaro.ejb.util;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * Classe que ira efetuar a validacao de todos os arquivos
 * <b>XML</b> a partir de dado um arquivo <b>XSD</b>.
 * 
 * @author guilherme.magalhaes
 * @since 10/2014
 */
public class ValidadorXSD {
	
	final static Logger log = LoggerFactory.getLogger(ValidadorXSD.class);

	/**
	 * Metodo utilitario para validar arquivos XML, recebe o local onde esta
	 * o arquivo XSD e XML e faz toda a verificacao.
	 * 
	 * @param pathXSD
	 * @param pathXML
	 * @return
	 */
	public static boolean validarXML(String pathXSD, String pathXML) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(pathXSD));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(pathXML)));
		} catch (SAXException e) {
			String errorMsg = "Erro ao validar arquivo, contem inconsistencia!";
			log.error(errorMsg, e);
			return false;
		} catch (IOException e) {
			String errorMsg = "Erro ao consultar arquivo.";
			log.error(errorMsg, e);
			return false;
		}
		
		return true;
	}
	
}
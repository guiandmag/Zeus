package br.com.alvaro.ejb.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Teste unitario da classe @see<code>ValidadorXSD</code>.
 * 
 * @author guilherme.magalhaes
 * @since 10/2014
 */
@RunWith(JUnit4.class)
public class ValidadorXSDTest {

	/**
	 * Test method for {@link br.com.alvaro.ejb.util.ValidadorXSD#validarXML(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testValidarXML() {
		assertTrue(ValidadorXSD.validarXML("src/test/resources/xsd/Employee.xsd", "src/test/resources/xml/EmployeeRequest.xml"));
		assertTrue(ValidadorXSD.validarXML("src/test/resources/xsd/Employee.xsd", "src/test/resources/xml/EmployeeResponse.xml"));
		assertFalse(ValidadorXSD.validarXML("src/test/resources/xsd/Employee.xsd", "src/test/resources/xml/employee.xml"));
	}

}
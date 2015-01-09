package br.com.alvaro.contrato.util.sftp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * Classe para abrir e fechar conexao <b>SFTP</b>
 * com o servidor do cliente.
 * 
 * @author guilherme.magalhaes
 * @since 10/2014
 */
@RunWith(JUnit4.class)
public class SFTPConnectionTest {

	@Test
	public void SFTPClienteTest() throws JSchException {
		JSch jSch = new JSch();
		
		Session session = jSch.getSession("username", "127.0.0.1", 22);
		session.setConfig("StrictHostKeyChecking", "no");
		
		session.setPassword("1234");
		session.connect();
		
		Channel channel = session.openChannel("sftp");
		ChannelSftp sftp = (ChannelSftp) channel;
		
		sftp.connect();
		System.out.println("here i am");
		
		sftp.disconnect();
		System.out.println("here i go");
	}

}
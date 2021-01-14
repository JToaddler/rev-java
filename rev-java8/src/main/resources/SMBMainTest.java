package com.smb.text;

import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import jcifs.CIFSContext;
import jcifs.Configuration;
import jcifs.config.PropertyConfiguration;
import jcifs.context.BaseContext;
import jcifs.smb.NtlmPasswordAuthenticator;
import jcifs.smb.SmbFile;

public class SMBMainTest {

	public static void main(String... args) throws Exception {

		Properties prop = new Properties();
		prop.put("jcifs.smb.client.minVersion", "SMB1");
		prop.put("jcifs.smb.client.maxVersion", "SMB210");
		//prop.put("jcifs.smb.client.maxVersion", "SMB210");

		Configuration cfg = new PropertyConfiguration(prop);
		CIFSContext baseContext = new BaseContext(cfg);
		CIFSContext contextWithCred = baseContext.withCredentials(new NtlmPasswordAuthenticator("", ""));

		SmbFile smbFile = new SmbFile("smb://Dummy-pc//nas//test.txt", contextWithCred);

		OutputStream out = smbFile.getOutputStream();
		Files.copy(Paths.get(("./test.txt")), out);

		smbFile.setAttributes(SmbFile.GENERIC_ALL);
		smbFile.setReadWrite();

		smbFile.close();
		out.close();
	}
}
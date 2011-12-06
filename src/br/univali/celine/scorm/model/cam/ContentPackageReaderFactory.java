package br.univali.celine.scorm.model.cam;

import java.io.ByteArrayInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContentPackageReaderFactory {

	private static String version;
	private static boolean chegouVersao;
	
	public static ContentPackageReader getContentPackageReader(String fileName)
			throws Exception {
		
		return processar(new InputSource(fileName));
	}

	public static ContentPackageReader getContentPackageReader(ByteArrayInputStream bytes) throws Exception {
		return processar(new InputSource(bytes));
	}

	private static ContentPackageReader processar(InputSource inputSource) throws Exception {
		
		version = "";
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		try {
			parser.parse(
					inputSource,
					new DefaultHandler() {

						@Override
						public void characters(char[] ch, int start, int length)
								throws SAXException {
							if (chegouVersao) {
								version = new String(ch, start, length);
							}
						}
						
						@Override
						public void startElement(String uri, String localName,
								String qName, Attributes attributes)
								throws SAXException {

							if (qName.equals("schemaversion")) {
								chegouVersao = true;
							}

						}
						
						@Override
						public void endElement(String uri, String localName,
								String qName) throws SAXException {
							if (chegouVersao)
								throw new SAXException("Parando");
						}
					});
		} catch (SAXException e) {
			if (!e.getMessage().equals("Parando")) {
				throw e;
			}
		}
		if (version.equals("1.2"))
			return new ContentPackageReader12();
		else
			if (version.equals("CAM 1.3")) {
				return new ContentPackageReader20043rd();
			} else { // SCORM 2004 4th Edition
				return new br.univali.celine.scorm2004_4th.model.cam.ContentPackageReader20044th();
		}
	}

}

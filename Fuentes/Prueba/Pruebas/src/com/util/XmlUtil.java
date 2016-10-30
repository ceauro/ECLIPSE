package com.util;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XmlUtil {
	public static String toXml(Object source, Class<?> type) {
        String result;
        StringWriter sw = new StringWriter();
        try {
            JAXBContext contexto = JAXBContext.newInstance(type);
            Marshaller marshaller = contexto.createMarshaller();
            marshaller.marshal(source, sw);
            result = sw.toString();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}

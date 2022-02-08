package com.sbrf.reboot.utils;

import com.sbrf.reboot.dto.Request;
import com.sbrf.reboot.dto.Response;
import lombok.SneakyThrows;

import javax.xml.stream.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class XMLUtils {

    /*STAX*/
    @SneakyThrows
    private static String getXML(String parent, String element, String value) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = outputFactory.createXMLStreamWriter(baos);

        writer.writeStartDocument("1.0");
        writer.writeStartElement(parent);
        writer.writeStartElement(element);
        writer.writeCharacters(value);

        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();

        writer.flush();
        writer.close();

        return new String(baos.toByteArray());
    }

    @SneakyThrows
    private static String fromXML(String s, String findElement) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        XMLStreamReader reader = inputFactory.createXMLStreamReader(new ByteArrayInputStream(s.getBytes()));

        String result = new String();
        while (reader.hasNext()) {
            if (reader.next() == XMLStreamConstants.START_ELEMENT && reader.getLocalName().equals(findElement)) {
                result = reader.getElementText();
            }
        }
        return result;
    }

    public static String toXML(Request request) {
        return getXML( "Request", "atmNumber", request.getAtmNumber());
    }

    public static String toXML(Response response) {
        return getXML("Response", "statusCode", response.getStatusCode());
    }

    public static Request XMLtoRequest(String s) {
        String element = fromXML(s, "atmNumber");
        return new Request(element);
    }

    public static Response XMLtoResponse(String s) {
        String element = fromXML(s, "statusCode");
        return new Response(element);
    }
}

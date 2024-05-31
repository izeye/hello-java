package com.izeye.helloworld.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Utilities for XML.
 *
 * @author Johnny Lim
 */
public final class XmlUtils {

    public static Document parseXmlString(String xmlString) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8));
        return documentBuilder.parse(inputStream);
    }

    public static String getSingleElementTextContext(Document document, String... tagNames) {
        return getSingleElementTextContext(document.getDocumentElement(), tagNames);
    }

    public static String getSingleElementTextContext(Element element, String... tagNames) {
        Element e = getSingleElement(element, tagNames);
        return (e != null) ? e.getTextContent() : null;
    }

    public static Element getSingleElement(Element element, String tagName) {
        NodeList elements = element.getElementsByTagName(tagName);
        if (elements.getLength() != 1) {
            return null;
        }
        return (Element) elements.item(0);
    }

    private static Element getSingleElement(Element element, String... tagNames) {
        for (String tagName : tagNames) {
            Element e = getSingleElement(element, tagName);
            if (e == null) {
                return null;
            }
            element = e;
        }
        return element;
    }

    public static List<String> getArrayTextContexts(Element element, String... tagNames) {
        Element e = getSingleElement(element, tagNames);
        if (e == null) {
            return Collections.emptyList();
        }

        NodeList children = e.getChildNodes();
        int length = children.getLength();
        if (length == 0) {
            return Collections.emptyList();
        }

        List<String> values = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            Node child = children.item(i);
            if (!(child instanceof Element)) {
                continue;
            }
            values.add(child.getTextContent());
        }
        return values;
    }

    private XmlUtils() {
    }

}

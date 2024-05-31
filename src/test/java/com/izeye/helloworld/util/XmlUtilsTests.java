package com.izeye.helloworld.util;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link XmlUtils}.
 *
 * @author Johnny Lim
 */
class XmlUtilsTests {

    @Test
    void getSingleElementTextContextWithDocument() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b>1</b><c>2</c><d>3</d><d>4</d><e></e></a>";

        Document document = XmlUtils.parseXmlString(xmlString);

        assertThat(XmlUtils.getSingleElementTextContext(document, "b")).isEqualTo("1");
        assertThat(XmlUtils.getSingleElementTextContext(document, "c")).isEqualTo("2");
        assertThat(XmlUtils.getSingleElementTextContext(document, "d")).isNull();
        assertThat(XmlUtils.getSingleElementTextContext(document, "e")).isEmpty();
        assertThat(XmlUtils.getSingleElementTextContext(document, "f")).isNull();
    }

    @Test
    void getSingleElementTextContextWithDocumentWhenNested() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b><c>1</c><d>2</d></b><z><c>3</c><d>4</d></z></a>";

        Document document = XmlUtils.parseXmlString(xmlString);

        assertThat(XmlUtils.getSingleElementTextContext(document, "b", "c")).isEqualTo("1");
        assertThat(XmlUtils.getSingleElementTextContext(document, "b", "d")).isEqualTo("2");
        assertThat(XmlUtils.getSingleElementTextContext(document, "b", "e")).isNull();
        assertThat(XmlUtils.getSingleElementTextContext(document, "z", "c")).isEqualTo("3");
        assertThat(XmlUtils.getSingleElementTextContext(document, "z", "d")).isEqualTo("4");
        assertThat(XmlUtils.getSingleElementTextContext(document, "x", "c")).isNull();
    }

    @Test
    void getSingleElementTextContextWithElement() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b>1</b><c>2</c><d>3</d><d>4</d><e></e></a>";

        Document document = XmlUtils.parseXmlString(xmlString);
        Element documentElement = document.getDocumentElement();

        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "b")).isEqualTo("1");
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "c")).isEqualTo("2");
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "d")).isNull();
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "e")).isEmpty();
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "f")).isNull();
    }

    @Test
    void getSingleElementTextContextWithElementWhenNested() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b><c>1</c><d>2</d></b><z><c>3</c><d>4</d></z></a>";

        Document document = XmlUtils.parseXmlString(xmlString);
        Element documentElement = document.getDocumentElement();

        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "b", "c")).isEqualTo("1");
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "b", "d")).isEqualTo("2");
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "b", "e")).isNull();
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "z", "c")).isEqualTo("3");
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "z", "d")).isEqualTo("4");
        assertThat(XmlUtils.getSingleElementTextContext(documentElement, "x", "c")).isNull();
    }

    @Test
    void getSingleElement() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b>1</b><c>2</c></a>";

        Document document = XmlUtils.parseXmlString(xmlString);
        Element documentElement = document.getDocumentElement();

        assertThat(XmlUtils.getSingleElement(documentElement, "b").getTextContent()).isEqualTo("1");
        assertThat(XmlUtils.getSingleElement(documentElement, "c").getTextContent()).isEqualTo("2");
        assertThat(XmlUtils.getSingleElement(documentElement, "d")).isNull();
    }

    @Test
    void getArrayTextContexts() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b><values> <value>1</value> <value>2</value> </values></b><c>3</c></a>";

        Document document = XmlUtils.parseXmlString(xmlString);
        Element documentElement = document.getDocumentElement();

        assertThat(XmlUtils.getArrayTextContexts(documentElement, "b", "values")).containsExactly("1", "2");
    }

}

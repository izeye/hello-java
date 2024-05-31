package learningtest.org.w3c.dom;

import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for {@link Document}.
 *
 * @author Johnny Lim
 */
class DocumentTests {

    @Test
    void getDocumentElement() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b>1</b><c>2</c></a>";

        Document document = xmlStringToDocument(xmlString);
        Element documentElement = document.getDocumentElement();
        assertThat(documentElement.getTagName()).isEqualTo("a");

        NodeList elements = document.getElementsByTagName("b");
        assertThat(elements.getLength()).isEqualTo(1);
        assertThat(elements.item(0).getTextContent()).isEqualTo("1");
    }

    @Test
    void getElementsByTagName() throws ParserConfigurationException, IOException, SAXException {
        String xmlString = "<a><b>1</b><c>2</c></a>";

        Document document = xmlStringToDocument(xmlString);

        NodeList elements = document.getElementsByTagName("b");
        assertThat(elements.getLength()).isEqualTo(1);
        assertThat(elements.item(0).getTextContent()).isEqualTo("1");
    }

    private static Document xmlStringToDocument(String xmlString) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlString.getBytes(StandardCharsets.UTF_8));
        return documentBuilder.parse(inputStream);
    }

}

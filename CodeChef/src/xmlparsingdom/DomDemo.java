package xmlparsingdom;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.Entity;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Notation;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;

public class DomDemo {

	public static void main(String[] args) throws Exception{
		String xmlRecords = "<data id=\"1\">" +
				"<employee>" +
				"<name>A</name>"+ 
				"<title>Manager</title>" +
				"<name>B</name>"+ 
				"<title>Worker</title>" +
				"</employee>" +
				"<CEO>" +
				"<name>C</name>"+ 
				"<title>President</title>" +
				"<name>D</name>"+ 
				"<title>BisePresident</title>" +
				"</CEO>" +
				"</data>";

		DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		InputSource is = new InputSource();
		is.setCharacterStream(new StringReader(xmlRecords));
		Document doc = db.parse(is);
		write(doc);
		dump(doc);

		/*		
		NodeList nodes = doc.getElementsByTagName("employee");

		for (int i = 0; i < nodes.getLength(); i++) {
			Element element = (Element) nodes.item(i);

			NodeList name = element.getElementsByTagName("name");
			Element line = (Element) name.item(0);
			System.out.println("Name: " + getCharacterDataFromElement(line));

			NodeList title = element.getElementsByTagName("title");
			line = (Element) title.item(0);
			System.out.println("Title: " + getCharacterDataFromElement(line));
		}
		 */


	}
	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "";
	}

	private static final String TAB = "    ";

	private static void write(Document doc) throws IOException {
		outputHeading(doc);
		//		System.out.println("doc getDocumentElement : " + doc.getDocumentElement().toString());
		outputElement(doc.getDocumentElement(), "");
	}

	private static void outputHeading(Document doc) {
		System.out.print("<?xml version=\"1.0\"");
		DocumentType doctype = doc.getDoctype();
		if (doctype != null) {
			if ((doctype.getPublicId() == null) && (doctype.getSystemId() == null)) {
				System.out.println(" standalone=\"yes\"?>");
			} else {
				System.out.println(" standalone=\"no\"?>");
			}
		} else {
			System.out.println("?>");
		}
	}

	private static void outputElement(Element node, String indent) {
		System.out.print(indent + "<" + node.getTagName());
		NamedNodeMap nm = node.getAttributes();
		for (int i = 0; i < nm.getLength(); i++) {
			Attr attr = (Attr) nm.item(i);
			System.out.print(" " + attr.getName() + "=\"" + attr.getValue() + "\"");
		}
		System.out.println(">");
		NodeList list = node.getChildNodes();
		System.out.println("List Length : " + list.getLength());
		for (int i = 0; i < list.getLength(); i++)
			outputloop(list.item(i), indent + TAB);
		System.out.println(indent + "</" + node.getTagName() + ">");
	}

	private static void outputText(Text node, String indent) {
		System.out.println(indent + node.getData());
	}

	private static void outputCDATASection(CDATASection node, String indent) {
		System.out.println(indent +  node.getData());
	}

	private static void outputComment(Comment node, String indent) {
		System.out.println(indent + "<!-- " + node.getData() + " -->");
	}

	private static void outputProcessingInstructionNode(ProcessingInstruction node, String indent) {
		System.out.println(indent + "<?" + node.getTarget() + " " + node.getData() + "?>");
	}

	private static void outputloop(Node node, String indent) {
		switch (node.getNodeType()) {
		case Node.ELEMENT_NODE:
			outputElement((Element) node, indent);
			break;
		case Node.TEXT_NODE:
			outputText((Text) node, indent);
			break;
		case Node.CDATA_SECTION_NODE:
			outputCDATASection((CDATASection) node, indent);
			break;
		case Node.COMMENT_NODE:
			outputComment((Comment) node, indent);
			break;
		case Node.PROCESSING_INSTRUCTION_NODE:
			outputProcessingInstructionNode((ProcessingInstruction) node, indent);
			break;
		default:
			System.out.println("Unknown node type: " + node.getNodeType());
			break;
		}
	}

	private static void dump(Document doc) {
		dumpLoop((Node) doc, "");
	}
	/*
	  private static void dumpLoop(Node node, String indent) {
	    switch (node.getNodeType()) {
	    case Node.CDATA_SECTION_NODE:
	      System.out.println(indent + "CDATA_SECTION_NODE");
	      break;
	    case Node.COMMENT_NODE:
	      System.out.println(indent + "COMMENT_NODE");
	      break;
	    case Node.DOCUMENT_FRAGMENT_NODE:
	      System.out.println(indent + "DOCUMENT_FRAGMENT_NODE");
	      break;
	    case Node.DOCUMENT_NODE:
	      System.out.println(indent + "DOCUMENT_NODE");
	      break;
	    case Node.DOCUMENT_TYPE_NODE:
	      System.out.println(indent + "DOCUMENT_TYPE_NODE");
	      break;
	    case Node.ELEMENT_NODE:
	      System.out.println(indent + "ELEMENT_NODE");
	      break;
	    case Node.ENTITY_NODE:
	      System.out.println(indent + "ENTITY_NODE");
	      break;
	    case Node.ENTITY_REFERENCE_NODE:
	      System.out.println(indent + "ENTITY_REFERENCE_NODE");
	      break;
	    case Node.NOTATION_NODE:
	      System.out.println(indent + "NOTATION_NODE");
	      break;
	    case Node.PROCESSING_INSTRUCTION_NODE:
	      System.out.println(indent + "PROCESSING_INSTRUCTION_NODE");
	      break;
	    case Node.TEXT_NODE:
	      System.out.print(indent + "TEXT_NODE");
	      System.out.println(" : "+node.getTextContent());
	      break;
	    default:
	      System.out.println(indent + "Unknown node");
	      break;
	    }

	    NodeList list = node.getChildNodes();
	    for (int i = 0; i < list.getLength(); i++){
	      dumpLoop(list.item(i), indent + "   ");
	    }
	  }*/

	private static void dumpLoop(Node node, String indent) {
		switch (node.getNodeType()) {
		case Node.ATTRIBUTE_NODE:
			dumpAttributeNode((Attr) node, indent);
			break;
		case Node.CDATA_SECTION_NODE:
			dumpCDATASectionNode((CDATASection) node, indent);
			break;
		case Node.COMMENT_NODE:
			dumpCommentNode((Comment) node, indent);
			break;
		case Node.DOCUMENT_NODE:
			dumpDocument((Document) node, indent);
			break;
		case Node.DOCUMENT_FRAGMENT_NODE:
			dumpDocumentFragment((DocumentFragment) node, indent);
			break;
		case Node.DOCUMENT_TYPE_NODE:
			dumpDocumentType((DocumentType) node, indent);
			break;
		case Node.ELEMENT_NODE:
			dumpElement((Element) node, indent);
			break;
		case Node.ENTITY_NODE:
			dumpEntityNode((Entity) node, indent);
			break;
		case Node.ENTITY_REFERENCE_NODE:
			dumpEntityReferenceNode((EntityReference) node, indent);
			break;
		case Node.NOTATION_NODE:
			dumpNotationNode((Notation) node, indent);
			break;
		case Node.PROCESSING_INSTRUCTION_NODE:
			dumpProcessingInstructionNode((ProcessingInstruction) node, indent);
			break;
		case Node.TEXT_NODE:
			dumpTextNode((Text) node, indent);
			break;
		default:
			System.out.println(indent + "Unknown node");
			break;
		}

		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++)
			dumpLoop(list.item(i), indent + "   ");
	}

	/* Display the contents of a ATTRIBUTE_NODE */
	private static void dumpAttributeNode(Attr node, String indent) {
		System.out.println(indent + "ATTRIBUTE " + node.getName() + "=\"" + node.getValue() + "\"");
	}

	/* Display the contents of a CDATA_SECTION_NODE */
	private static void dumpCDATASectionNode(CDATASection node, String indent) {
		System.out.println(indent + "CDATA SECTION length=" + node.getLength());
		System.out.println(indent + "\"" + node.getData() + "\"");
	}

	/* Display the contents of a COMMENT_NODE */
	private static void dumpCommentNode(Comment node, String indent) {
		System.out.println(indent + "COMMENT length=" + node.getLength());
		System.out.println(indent + "  " + node.getData());
	}

	/* Display the contents of a DOCUMENT_NODE */
	private static void dumpDocument(Document node, String indent) {
		System.out.println(indent + "DOCUMENT");
	}

	/* Display the contents of a DOCUMENT_FRAGMENT_NODE */
	private static void dumpDocumentFragment(DocumentFragment node, String indent) {
		System.out.println(indent + "DOCUMENT FRAGMENT");
	}

	/* Display the contents of a DOCUMENT_TYPE_NODE */
	private static void dumpDocumentType(DocumentType node, String indent) {
		System.out.println(indent + "DOCUMENT_TYPE: " + node.getName());
		if (node.getPublicId() != null)
			System.out.println(indent + " Public ID: " + node.getPublicId());
		if (node.getSystemId() != null)
			System.out.println(indent + " System ID: " + node.getSystemId());
		NamedNodeMap entities = node.getEntities();
		if (entities.getLength() > 0) {
			for (int i = 0; i < entities.getLength(); i++) {
				dumpLoop(entities.item(i), indent + "  ");
			}
		}
		NamedNodeMap notations = node.getNotations();
		if (notations.getLength() > 0) {
			for (int i = 0; i < notations.getLength(); i++)
				dumpLoop(notations.item(i), indent + "  ");
		}
	}

	/* Display the contents of a ELEMENT_NODE */
	private static void dumpElement(Element node, String indent) {
		System.out.println(indent + "ELEMENT: " + node.getTagName());
		NamedNodeMap nm = node.getAttributes();
		for (int i = 0; i < nm.getLength(); i++)
			dumpLoop(nm.item(i), indent + "  ");
	}

	/* Display the contents of a ENTITY_NODE */
	private static void dumpEntityNode(Entity node, String indent) {
		System.out.println(indent + "ENTITY: " + node.getNodeName());
	}

	/* Display the contents of a ENTITY_REFERENCE_NODE */
	private static void dumpEntityReferenceNode(EntityReference node, String indent) {
		System.out.println(indent + "ENTITY REFERENCE: " + node.getNodeName());
	}

	/* Display the contents of a NOTATION_NODE */
	private static void dumpNotationNode(Notation node, String indent) {
		System.out.println(indent + "NOTATION");
		System.out.print(indent + "  " + node.getNodeName() + "=");
		if (node.getPublicId() != null)
			System.out.println(node.getPublicId());
		else
			System.out.println(node.getSystemId());
	}

	/* Display the contents of a PROCESSING_INSTRUCTION_NODE */
	private static void dumpProcessingInstructionNode(ProcessingInstruction node, String indent) {
		System.out.println(indent + "PI: target=" + node.getTarget());
		System.out.println(indent + "  " + node.getData());
	}

	/* Display the contents of a TEXT_NODE */
	private static void dumpTextNode(Text node, String indent) {
		System.out.println(indent + "TEXT length=" + node.getLength());
		System.out.println(indent + "  " + node.getData());
	}

}

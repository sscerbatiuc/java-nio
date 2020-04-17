package com.step.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.step.model.Employee;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.xml.sax.SAXException;

/**
 *
 * @author sscerbatiuc
 */
public class XmlIOService {

    private static final String EMPLOYEELIST_NODE = "employees";
    private static final String EMPLOYEE_NODE = "employee";
    private static final String NAME_NODE = "name";
    private static final String SURNAME_NODE = "surname";
    private static final String EMPLOYEDON_NODE = "employeed-on";

    public static void main(String[] args) throws IOException, JDOMException {
        List<Employee> arrList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrList.add(Employee.getRandomEmployee());
        }
        writeToFile(arrList);
        readFromFile();
    }

    private static void writeToFile(List<Employee> emps) throws FileNotFoundException, IOException {
        //root element
        Element root = new Element("employees");
        Document doc = new Document(root);

        for (Employee emp : emps) {
            Element employee = new Element("employee");
            employee.setAttribute(new Attribute("age", String.valueOf(emp.getAge())));
            Element name = new Element("name");
            name.setText(emp.getName()); // <-- Employee 
            
            employee.addContent(name);
            root.addContent(employee);
        }
        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());
        xmlOutput.output(doc, new FileOutputStream("D:\\employee.xml"));
//        xmlOutput.output(doc, System.out); // Console
    }

    private static void readFromFile() throws JDOMException, IOException {
        File inputFile = new File("D:\\employee.xml");
        SAXBuilder saxBuilder = new SAXBuilder(); // SAX - simple api for XML
        Document document = saxBuilder.build(inputFile);
        System.out.println("Root element :" + document.getRootElement().getName());
        Element root = document.getRootElement();

        List<Element> employees = root.getChildren("employee");
        System.out.println("----------------------------");

        for (int index = 0; index < employees.size(); index++) {
            Element employee = employees.get(index);
            Element name = employee.getChild("name");
            String nameValue = name.getText();
            System.out.println("Name: " + nameValue);
            // new Employee(nameValue, ...)
            Attribute attribute = employee.getAttribute("age");
            System.out.println("Age:" + attribute.getValue());
            System.out.println("");
        }
    }
}

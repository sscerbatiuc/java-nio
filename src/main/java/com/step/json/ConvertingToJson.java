package com.step.json;

import com.step.model.Employee;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * This class requires the simple.json jar to be added to the classpath.
 *
 * @author sscerbatiuc
 */
public class ConvertingToJson {
//
    public static void main(String[] args) {
        List<Employee> arrList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrList.add(Employee.getRandomEmployee());
        }
        writeToJsonFile(arrList);
        convertFromJson();
    }

    private static void writeToJsonFile(List<Employee> employees) {
        System.out.println("Writing JSON ----------");
        JSONArray list = new JSONArray();
        for (Employee emp : employees) {
            JSONObject obj = new JSONObject();
            obj.put("name", emp.getName());
            // Read any information required to be stored in the JSON
            // obj.put("surname", emp.getSurname());
            list.add(obj);
        }
        System.out.print(list);

        try (FileWriter file = new FileWriter("D:\\Step.json")) {
            file.write(list.toJSONString());
        } catch (IOException e) {
            System.out.println("Could not write to JSON. Reason: " + e.getMessage());
        }
    }

    private static void convertFromJson() {
        System.out.println("Reading JSON ----------");
        try (Reader reader = new FileReader("D:\\Step.json")) {
            JSONParser parser = new JSONParser();
            JSONArray jsonArr = (JSONArray) parser.parse(reader);
            System.out.println(jsonArr);

            for (int i = 0; i < jsonArr.size(); i++) {
                JSONObject employeeJson = (JSONObject) jsonArr.get(i);
                System.out.println("Name: " + employeeJson.get("name"));
                // Create new employee with the data 
                // Employee emp = new Employee(employeeJson.get("name");
            }

        } catch (IOException e) {
            System.out.println("Could not read JSON. Reason: " + e.getMessage());
        } catch (ParseException e) {
            System.out.println("Could not parse JSON. Reason: " + e.getMessage());
        }
    }
}

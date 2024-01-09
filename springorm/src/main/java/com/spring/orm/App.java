package com.spring.orm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NumberFormatException, IOException
    {	
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
        
        					/*CRUD APP*/
        	
        	try {
        		Boolean flag = true;
        		while(flag) {
	        		System.out.println("1. Add Student");
	        		System.out.println("2. Show All Students");
	        		System.out.println("3. Get a Student Details");
	        		System.out.println("4. Update Student Details");
	        		System.out.println("5. Delete Student");
	        		System.out.println("6. Exit!");
	        		
	        		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        		int input = Integer.parseInt(br.readLine());
        		
	        		switch (input) {
	    			case 1:{
	    				System.out.println("Enter Student Id:");
	    				int studentId = Integer.parseInt(br.readLine());
	    				System.out.println("Enter Student Name:");
	    				String studentName = br.readLine();
	    				System.out.println("Enter Student City:");
	    				String studentCity = br.readLine();
	    		        Student student = new Student(studentId, studentName, studentCity);
	    		        int result = studentDao.insert(student);
	    				break;
	    			}
	    			case 2:{
	    		        List<Student> allstudents = studentDao.getAllstudents();
	    		        for(Student s : allstudents) {
	    		        	System.out.println(s);
	    		        }
	    				break;
	    			}
	    			case 3:{
	    				Student student = new Student();
	    				System.out.println("Enter Student Id:");
	    				int studentId = Integer.parseInt(br.readLine());
	    				Student result = studentDao.getStudent(studentId);
	    				System.out.println(result);
	    				break;
	    			}
	    			case 4:{
	    		        System.out.println("Enter Student Id:");
	    				int studentId = Integer.parseInt(br.readLine());
	    		        System.out.println("Enter Student Name:");
	    				String studentName =br.readLine();
	    				System.out.println("Enter Student City:");
	    				String studentCity =br.readLine();
	    				Student student = new Student(studentId, studentName, studentCity);    
	    		        studentDao.updateStudent(student);
	    		        System.out.println("Record Updated");
	    				break;
	    			}
	    			case 5:
	    				int studentId = Integer.parseInt(br.readLine());
	    		        studentDao.deleteStudent(studentId);
	    		        System.out.println("Record Deleted");
	    				break;
	    			case 6:
	    				flag=false;
	    				break;
	    			default:
	    				break;
	    			}
        		}
			} catch (Exception e) {
					System.out.println("Invalid Input");
					System.out.println(e.getMessage());
			}
	        System.out.println("Bye!!!");
    }
}

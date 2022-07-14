package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

class Test1 {

	@Test
	void test01() {
	
		StudentService service=new StudentServiceImpl();
		List<Student> list=service.findStudentAll();
		for (Student student : list) {
			System.out.println(student);
		}
		
	}
	
	@Test
	void test02() {
		StudentService service=new StudentServiceImpl();
		Student student=new Student(1,"白","女",18,"银河系","3w.com");
		System.out.println(student);
		boolean result=service.updateStudent(student);
		System.out.println(result);
	}
	
	
	@Test
	void test03() {
		StudentService service=new StudentServiceImpl();
		boolean result=service.deleteStudent(1);
		System.out.println(result);
	}

}

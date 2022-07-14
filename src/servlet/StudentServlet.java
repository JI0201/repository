package servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import bean.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * Servlet implementation class Student
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {

		StudentService service =new StudentServiceImpl();
	
		
	//查询所有学院
	public void findStudentAll(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		List<Student> list=	service.findStudentAll();
		if(list!=null) {
		request.setAttribute("list", list);
		request.getRequestDispatcher("/pages/findStudent.jsp").forward(request, response);
		}
	}
	
	//根据id查询学员信息(跳转修改界面)
	public void findStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		Student  findStu=service.findStudent(id);
		request.setAttribute("student", findStu);
		request.getRequestDispatcher("/pages/updateStudent.jsp").forward(request, response);
		
	}
	
	
	//修改员工信息
	public void updateStudent(HttpServletRequest request,HttpServletResponse response) throws IllegalAccessException, InvocationTargetException, ServletException, IOException {
		Student student=new Student();
		BeanUtils.populate(student, request.getParameterMap());
		boolean result=service.updateStudent(student);
		System.out.println(result);
		if(result) {
			findStudentAll(request, response);
		}
	}
	
	
	//根据id删除学员信息
	public void deleteStudent(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		boolean result=service.deleteStudent(id);
		if(result) {
			findStudentAll(request, response);
		}
	}
}

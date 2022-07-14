package service.impl;

import java.util.List;

import bean.Student;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	StudentDao dao=new StudentDaoImpl();
	
	
	
	@Override
	public List<Student> findStudentAll() {
		// TODO Auto-generated method stub
		return dao.findStudentAll();
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return dao.updateStudent(student)>0?true:false;
	}

	@Override
	public boolean deleteStudent(int id) {
		// TODO Auto-generated method stub
		return dao.deleteStudent(id)>0?true:false;
	}

	@Override
	public Student findStudent(int id) {
		return dao.findStudent(id);
	}

	
	
	
	
}

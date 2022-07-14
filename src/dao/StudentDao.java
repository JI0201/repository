package dao;

import java.util.List;

import bean.Student;

public interface StudentDao {

	//查询所有学员信息
	List<Student> findStudentAll();
	//根据id修改学员信息
	int updateStudent(Student student);

	//根据id删除学院信息
	int deleteStudent(int id);
	
	
	//根据id查询学员
	Student findStudent(int id);
}

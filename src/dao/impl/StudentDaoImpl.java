package dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import dao.StudentDao;
import utils.BaseDao;

public class StudentDaoImpl extends BaseDao implements StudentDao {

	@Override
	public List<Student> findStudentAll() {
		connection=getcConnection();
		String sql="select * from student ";
		resultSet=findObject(sql, null);
		List<Student> list=new ArrayList<Student>();
		Student student=null;
		try {
			while(resultSet.next()) {
				student=new Student(resultSet.getInt("id"),
									resultSet.getString("name"),
									resultSet.getString("sex"),
									resultSet.getInt("age"),
									resultSet.getString("adress"),
									resultSet.getString("email"));
				list.add(student);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			closeAll(resultSet,preparedStatement,connection);
		}
		return null;
	}

	@Override
	public int updateStudent(Student student) {
		String sql="update  student set name =?,sex=? ,age=?,adress=?,email=? where id=? ";
		return updateObject(sql, student.getName(),student.getSex(),student.getAge(),student.getAdress(),student.getEmail(),student.getId());
	}

	@Override
	public int deleteStudent(int id) {
		String sql="delete from student where id=?";
		return updateObject(sql, id);
	}

	@Override
	public Student findStudent(int id) {
		connection=getcConnection();
		String sql="select * from student where id=?";
		resultSet=findObject(sql, id);
		Student student=null;
		try {
			while(resultSet.next()) {
				student=new Student(resultSet.getInt("id"),
									resultSet.getString("name"),
									resultSet.getString("sex"),
									resultSet.getInt("age"),
									resultSet.getString("adress"),
									resultSet.getString("email"));
			}
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

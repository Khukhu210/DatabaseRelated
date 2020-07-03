package com.learning.hibernate.database.HibernateDemo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.hibernate.database.HibernateDemo.entity.Person;

@Repository
public class PersonJdbcDao {
    
	@Autowired
	JdbcTemplate jdbcTemplete;
 
	public  List<Person> findAll(){
	return	jdbcTemplete.query("select * from Person", 
			new BeanPropertyRowMapper<Person>(Person.class));	
		
	}
	
	public Person findById(int id){
		return jdbcTemplete.queryForObject("select * from Person where id = ?",new Object[] {id} ,
				new BeanPropertyRowMapper<Person>(Person.class));	
			
			}
	
	
	public int insert(Person person)
	{
		return jdbcTemplete.update("insert into person (Id, Name, Location,Birthdate)" + 
	"values(?,?,?,?)",
	new Object[] { person.getId(),
			        person.getName(),
			        person.getLocation(),
			new Timestamp(person.getBirthDate().getTime())
	});
	
	}
	
	public int update(Person person)
	{
		return jdbcTemplete.update("update person "+" set Name = ?, Location =?,Birthdate = ?)" + 
	"where id = ?",
	new Object[] {
			person.getName(),
			person.getLocation(),
			new Timestamp(person.getBirthDate().getTime())
	});
	}	
	public	int deleteById(int id){
			return jdbcTemplete.update("delete from person where id = ?",new Object[] {id});
		}
	
		
}

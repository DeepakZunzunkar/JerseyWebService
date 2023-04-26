package com.dz.app.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;

import com.dz.app.dto.EmployeeDto;
import com.dz.app.model.entity.Employee;
import com.dz.app.service.EmployeeService;
import com.dz.app.utility.HibernateUtilty;

public class EmployeeServiceImpl implements EmployeeService{

	private static SessionFactory sessionFactory;
	static Employee employee=null;
	static Session session=null;
	static Transaction tx=null;
	static Integer rs=0;
	List<Employee> employees = new ArrayList<Employee>();
	ModelMapper modelMapper = new ModelMapper();
	EmployeeDto dto=new EmployeeDto();
	List<EmployeeDto> employeesDto = new ArrayList<EmployeeDto>();
	
	public EmployeeServiceImpl() {
		
		sessionFactory=HibernateUtilty.getSessionFactory();
	}

	@Override
	public Employee saveEmployee(EmployeeDto employeeDto) {
		
		employee=modelMapper.map(employeeDto, Employee.class);
		if(employee !=null) {
			
			if(sessionFactory != null) {
				
				try(Session session = sessionFactory.openSession()) {
					
					session.beginTransaction();
					Long eid=(Long) session.save(employee);
					session.getTransaction().commit();
					employee.setEid(eid);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee empTrn) {
		
		if(sessionFactory != null) {
			
			try(Session session = sessionFactory.openSession()) {
				
				session.beginTransaction();
				session.update(empTrn);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empTrn;
	}

	@Override
	public void deleteEmployee(Employee empTrn) {
		
		if(sessionFactory != null) {
			
			try(Session session = sessionFactory.openSession()) {
				
				session.beginTransaction();
				session.delete(empTrn);
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Employee findById(long eid) {
		
		if(sessionFactory != null) {
			
			try(Session session = sessionFactory.openSession()) {
				
				employee= session.get(Employee.class,eid);
/*				if(employee !=null) {
//					BeanUtils.copyProperties(dto,employee);
					dto=modelMapper.map(employee, EmployeeDto.class);
				}*/	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {

		if(sessionFactory != null) {
			
			try(Session session = sessionFactory.openSession()) {
				
				Query<Employee>  query=session.createQuery("from Employee order by eid desc",Employee.class);
				
//				query.setFirstResult(0);
//				query.setMaxResults(10);
				employees=query.getResultList();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public List<Employee> getAllEmployeesForPagination(Integer pageSize,Integer currentPage, String sortBy) {

		if(sessionFactory != null) {
			
			try(Session session = sessionFactory.openSession()) {
				
				Query<Employee>  query=session.createQuery("from Employee order by eid "+sortBy+" ",Employee.class);
				
				query.setFirstResult(currentPage);
				query.setMaxResults(pageSize);
				employees=query.getResultList();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employees;
	}

	@Override
	public Long totalEmployeeCount() {

		Long count=0l;
		try(Session session=sessionFactory.openSession()){
			
			Criteria cr = session.createCriteria(Employee.class);
				
			cr.setProjection(Projections.rowCount());
			
			count=(Long)cr.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
}

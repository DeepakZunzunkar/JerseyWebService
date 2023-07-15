package com.dz.app.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;

import com.dz.app.dto.BasePropertiesDto;
import com.dz.app.dto.EmployeeDto;
import com.dz.app.model.entity.BaseProperties;
import com.dz.app.model.entity.Employee;
import com.dz.app.response.BaseResponse;
import com.dz.app.response.BaseResponseHelper;
import com.dz.app.service.EmployeeService;
import com.dz.app.service.serviceImpl.EmployeeServiceImpl;
import com.dz.app.utility.Constant.EmployeeStatus;

@Path("employee")
public class EmployeeMatserController {

	EmployeeService eservice;

	ModelMapper modelMapper = new ModelMapper();
	EmployeeDto dto = new EmployeeDto();
	List<EmployeeDto> employeesDto = new ArrayList<EmployeeDto>();

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.TEXT_PLAIN) public String getIt() { return
	 * "hellow world!"; }
	 */

	@GET()
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeeDto> getAllEmployee() {

		eservice = new EmployeeServiceImpl();
		List<Employee> employees = eservice.getAllEmployees();
		employees.stream().forEach(emp -> {
			dto = modelMapper.map(emp, EmployeeDto.class);
			employeesDto.add(dto);
		});
		return employeesDto;
	}

	@GET()
	@Path("/{eid}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmployeeDto searchEmployee(@PathParam("eid") Long eid) {

		eservice = new EmployeeServiceImpl();
		Employee employee = eservice.findById(eid);
		if (employee != null) {
//			BeanUtils.copyProperties(dto,employee);
			dto = modelMapper.map(employee, EmployeeDto.class);
		}
		return dto;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EmployeeDto saveEmployee(EmployeeDto dto) {

		if (dto != null && dto.getEid() == null) {
			eservice = new EmployeeServiceImpl();
			dto.setBaseProperties(new BasePropertiesDto("A", new Date(), "postman", null, null));
			dto.setStatus(EmployeeStatus.ACTIVE.getEmployeeStatusCode());
			Employee employee = eservice.saveEmployee(dto);
			dto = modelMapper.map(employee, EmployeeDto.class);
		} else {
			eservice = new EmployeeServiceImpl();
			Employee sqlEmp = eservice.findById(dto.getEid());
			if (sqlEmp != null) {
				sqlEmp.getBaseProperties().setUpdatedBy("JerseyWebService-app");
				sqlEmp.getBaseProperties().setUpdatedOn(new Date());

				sqlEmp.setFirstName(dto.getFirstName());
				sqlEmp.setLastName(dto.getLastName());
				sqlEmp.setGender(dto.getGender());
				sqlEmp.setSalary(dto.getSalary());
				sqlEmp.setBirthDate(dto.getBirthDate());
				sqlEmp.setStatus(dto.getStatus());

				sqlEmp = eservice.updateEmployee(sqlEmp);
				dto = modelMapper.map(sqlEmp, EmployeeDto.class);

			} else {
				System.err.println("\nemployee not found in the system ...\n");
			}
		}
		return dto;
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EmployeeDto updtaeEmployee(EmployeeDto dto) {

		if (dto != null && dto.getEid() != null) {

			eservice = new EmployeeServiceImpl();
			Employee sqlEmp = eservice.findById(dto.getEid());
			if (sqlEmp != null) {

				sqlEmp.getBaseProperties().setUpdatedBy("jerseywebservice-app");
				sqlEmp.getBaseProperties().setUpdatedOn(new Date());

				sqlEmp.setFirstName(dto.getFirstName());
				sqlEmp.setLastName(dto.getLastName());
				sqlEmp.setGender(dto.getGender());
				sqlEmp.setSalary(dto.getSalary());
				sqlEmp.setBirthDate(dto.getBirthDate());
				sqlEmp.setStatus(dto.getStatus());

				eservice.updateEmployee(sqlEmp);

			} else {
				System.err.println("\nemployee not found in the system ...\n");
			}
		} else {
			System.err.println("\n Bad Request...\n");
		}

		return dto;
	}
	
	//wrong
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Boolean deleteEmployee(EmployeeDto dto) {

	Boolean opFlag=false;
		if (dto != null && dto.getEid() != null) {

			eservice = new EmployeeServiceImpl();
			Employee sqlEmp = eservice.findById(dto.getEid());
			if (sqlEmp != null) {
				eservice.deleteEmployee(sqlEmp);
				opFlag=true;
			} else {
				System.err.println("\nemployee not found in the system ...\n");
			}
		} else {
			System.err.println("\n Bad Request...\n");
		}
		return opFlag;
	}

	@DELETE
	@Path("/{eid}")
	public Boolean deleteByEid(@PathParam("eid") Long eid) {
		Boolean opFlag=false;
		if (eid != null) {

			eservice = new EmployeeServiceImpl();
			Employee sqlEmp = eservice.findById(eid);
			if (sqlEmp != null) {
				eservice.deleteEmployee(sqlEmp);
				opFlag=true;
			} else {
				System.err.println("\nemployee not found in the system ...\n");
			}
		} else {
			System.err.println("\n Bad Request...\n");
		}
		return opFlag;
	}
}

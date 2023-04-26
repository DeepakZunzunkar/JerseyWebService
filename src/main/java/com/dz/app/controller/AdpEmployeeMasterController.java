package com.dz.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.modelmapper.ModelMapper;

import com.dz.app.dto.EmployeeDto;
import com.dz.app.model.entity.Employee;
import com.dz.app.response.PaginationResponse;
import com.dz.app.service.EmployeeService;
import com.dz.app.service.serviceImpl.EmployeeServiceImpl;

@Path("adpEmployee")
public class AdpEmployeeMasterController {

	
	EmployeeService eservice;
	ModelMapper modelMapper = new ModelMapper();
	EmployeeDto dto = new EmployeeDto();
	List<EmployeeDto> employeesDto = new ArrayList<EmployeeDto>();
	PaginationResponse response;
	
	@GET()
	@Path("/{eid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response searchAdpEmployee(@PathParam("eid") Long eid) {

		eservice=new EmployeeServiceImpl();
		Employee sqlEmp=eservice.findById(eid);
		
		if (sqlEmp != null) {
			dto = modelMapper.map(sqlEmp, EmployeeDto.class);
		}
		/*BaseResponseHelper<EmployeeDto> resp=new BaseResponseHelper<EmployeeDto>();
		return resp.setGetResponse(dto);*/
		
//		BaseResponseHelper<EmployeeDto> resp=new BaseResponseHelper<EmployeeDto>();
		
		return Response.status(200).entity(dto).build(); 
	}

	
	@GET()
//	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdpEmployee(@DefaultValue("1") @QueryParam("pageNumber") Integer pageNumber,@DefaultValue("desc") @QueryParam("sortBy") String sortBy,@DefaultValue("10") @QueryParam("pageSize")Integer pageSize) {

		eservice = new EmployeeServiceImpl();
		response=new PaginationResponse();
		
		Long totalEmp=eservice.totalEmployeeCount();
		
		Integer currentPageStartFrom=pageNumber-1;
		currentPageStartFrom=currentPageStartFrom*pageSize;
		
		Double totalPages =(double) Math.ceil(totalEmp.doubleValue()/pageSize.doubleValue());
		
		List<Employee> employees = eservice.getAllEmployeesForPagination(pageSize,currentPageStartFrom,sortBy);
		
		employees.stream().forEach(emp -> {
			dto = modelMapper.map(emp, EmployeeDto.class);
			employeesDto.add(dto);
		});
		
		response.setTotalEmp(totalEmp);
		response.setPageSize(pageSize);
		response.setTotalPages(totalPages.longValue());
		response.setCurrentPage(pageNumber);
		response.setContent(employeesDto);
		
		return Response.status(200).entity(response).build(); 
	}
	
}

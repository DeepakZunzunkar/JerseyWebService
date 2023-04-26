package com.dz.app.utility;



/**
 * @author dz Mar 13, 2023
 *
 */

public interface Constant {

	public enum Gender {

		MALE("M"),
		FEMALE("F");
		
		private Gender() {
			System.out.println("called for each constant");
		}
		
		private String genderValue; 
		
		private Gender(String gender) {
			this.genderValue=gender;
		}
		public String getGenderValue() {
			return this.genderValue;
		}
	}
	
	public enum EmployeeStatus{
		
		ACTIVE("A"),
		ONLEAVE("L"),
		TERMINATED("T"),
		DECEASED("D");
		
		private String employeeStatusCode;
		
		private EmployeeStatus(String employeeStatus) {
			this.employeeStatusCode = employeeStatus;
		}

		public String getEmployeeStatusCode() {
			return employeeStatusCode;
		}
		
		public int indexValue() {
			return ordinal();
		}
	}
	
	public enum ResponseCode {

		SUCCESS(200),
		FAIL(201);
		
		private final int value; 

		
		ResponseCode(int responseCode) {
			this.value=responseCode;
		}
		
		public int getResponseCodeValue() {
			return this.value;
		}
	}
	
	public enum ResponseMessage {

		SUCCESS("success"),
		FAIl("fail"),
		RecordNotFound("Record Not Found ..");
		
		
		private ResponseMessage() {
			System.out.println("called for each constant");
		}
		
		private String value; 
		
		private ResponseMessage(String codeMessage) {
			this.value=codeMessage;
		}
		public String getResponseMessageValue() {
			return this.value;
		}
	}
}

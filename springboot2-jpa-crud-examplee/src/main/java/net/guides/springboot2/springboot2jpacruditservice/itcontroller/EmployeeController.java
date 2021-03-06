package net.guides.springboot2.springboot2jpacruditservice.itcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacruditservice.itexception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacruditservice.itmodel.Employee;
import net.guides.springboot2.springboot2jpacruditservice.itrepository.EmployeeRepository;
//import net.guides.springboot2.springboot2jpacruditservice.service.EmailUtilityService;
import net.guides.springboot2.springboot2jpacruditservice.service.EmailUtilityService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
//	@Autowired
//    private EmailUtilityService emailUtil;


	@GetMapping("/itservice")
	public List<Employee> getAllItservice() {
		return employeeRepository.findAll();
	}

	@GetMapping("/itservice/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/itservice")
	public Employee createEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}

//	@PostMapping("/itservice")
//    public void triggerMail(@RequestBody Employee employee){
//		employeeRepository.save(employee);
//            String messageContent ="Hi ,"+"\n"+employee.getEmpname()+" (Employee Id: "+employee.getEmpid()+ ")"
//                    +" applying leave for "+employee.getDescription()+"\n from "
//                    +"\n\n"+"Thanks,"+"\n"+employee.getEmpname(); 
//            emailUtil.sendEmailNotification(employee.getItteam()+"@stgit.com",messageContent,"Leave Intimation");           
//	}   
             
	@PutMapping("/itservice/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employee.setDescription(employeeDetails.getDescription());
		employee.setItteam(employeeDetails.getItteam());
		employee.setEmailid(employeeDetails.getEmailid());
		employee.setEmpid(employeeDetails.getEmpid());
		employee.setEmpname(employeeDetails.getEmpname());
		
//		employee.setEmailId(employeeDetails.getEmailid());
//		employee.setLastName(employeeDetails.getLastName());
//		employee.setFirstName(employeeDetails.getFirstName());
		final Employee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/itservice/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}

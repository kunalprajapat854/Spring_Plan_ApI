package in.kunal.Restcontroller;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.kunal.AppProperties.ApplicationProperties;
import in.kunal.Entity.Plan;
import in.kunal.Service.PlanServiceImp;
import in.kunal.constants.Appcontants;

@RestController
public class PlanRestController {

	public Map<String, String> messages;

	public PlanRestController(ApplicationProperties apppros, PlanServiceImp service) {
		super();
		this.messages = apppros.getMessages();
		this.service = service;
	}

	@Autowired
	private PlanServiceImp service;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getallcategories() {
		Map<Integer, String> Categories = service.getallCategories();
		return new ResponseEntity<>(Categories, HttpStatus.OK);
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {
		String response = "";
		boolean Issaved = service.savePlan(plan);
		if (Issaved) {
			response = messages.get(Appcontants.PLAN_SAVED);
		} else {
			response = messages.get(Appcontants.PLAN_SAVED_FAIL);
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getallplans() {
		List<Plan> plans = service.getallplans();
		return new ResponseEntity<List<Plan>>(plans, HttpStatus.OK);
	}

	@DeleteMapping("/plan/{pId}")
	public ResponseEntity<String> deleteplan(@PathVariable Integer pId) {
		String response = "";
		boolean isDeleted = service.delete(pId);
		if (isDeleted) {
			response = messages.get(Appcontants.DELETE_PLAN);
		} else {
			response = messages.get(Appcontants.DELETE_PLAN_FAIL);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@PutMapping("/plan")
	public ResponseEntity<String> updateplan(@RequestBody Plan plan) {
		String msg = Appcontants.EMTY_STR;
		boolean update = service.updatePlan(plan);
		if (update) {
			msg = messages.get(Appcontants.UPDATE_PLAN);
		} else {
			msg = messages.get(Appcontants.UPDATE_PLAN_FAIL);
		}
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@GetMapping("/plan/{pId}")
	public ResponseEntity<Plan> editplan(@PathVariable Integer pId) {
		Plan editPlan = service.editPlan(pId);
		return new ResponseEntity<>(editPlan, HttpStatus.OK);
	}

	@GetMapping("/switch/{pId}/{Status}")
	public ResponseEntity<String> activeSwitch(@PathVariable Integer pId, @PathVariable String Status) {
		String response = "";
		boolean active = service.planactivate(pId, Status);
		if (active) {
			response = messages.get(Appcontants.PLAN_STATUS);
		} else {
			response = messages.get(Appcontants.PLAN_STATUS_FAIL);
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}

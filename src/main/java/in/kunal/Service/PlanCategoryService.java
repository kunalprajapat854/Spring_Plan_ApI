package in.kunal.Service;

import java.util.List;
import java.util.Map;

import in.kunal.Entity.Plan;

public interface PlanCategoryService {
	
	public Map<Integer, String> getallCategories();
	
	public boolean savePlan(Plan plan);
	
	public List<Plan> getallplans();
	
	public Plan editPlan (Integer pId);
	
	public boolean updatePlan(Plan plan);
	
	public boolean delete(Integer pId);
	
	public boolean planactivate(Integer pId, String status);

}

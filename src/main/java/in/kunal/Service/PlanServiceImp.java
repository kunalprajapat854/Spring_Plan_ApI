package in.kunal.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.kunal.Entity.Category;
import in.kunal.Entity.Plan;
import in.kunal.Repository.CategoryRepository;
import in.kunal.Repository.PlanRepository;

@Service
public class PlanServiceImp implements PlanCategoryService {

	@Autowired
	private PlanRepository planrepo;

	@Autowired
	private CategoryRepository categoryrepo;

	public Map<Integer, String> getallCategories() {
		List<Category> categories = categoryrepo.findAll();

		Map<Integer, String> category = new HashMap<>();

		for (Category categry : categories) {
			category.put(categry.getCategoryId(), categry.getCategoryName());

		}
		return category;
	}

	public boolean savePlan(Plan plan) {
		Plan save = planrepo.save(plan);
//		   if(save.getpId()!=null) {
//			   return true;
//		   }
		return save.getpId() != null ? true : false;
	}

	public List<Plan> getallplans() {
		return planrepo.findAll();
	}

	public Plan editPlan(Integer pId) {
		 Optional<Plan> findById = planrepo.findById(pId);
		 if(findById.isPresent()) {
			return findById.get();
		 }
		return null;
	}

	public boolean updatePlan(Plan plan) {
		     Plan update = planrepo.save(plan);
		     if(update.getpId()!=null) {
		    	 return true;
		     }
		return false;
	}

	public boolean delete(Integer pId) {
		  try {
			  planrepo.deleteById(pId);
            return true;
		} catch (Exception e) {
			e.getStackTrace();
		}
		  return false;

	}

	public boolean planactivate(Integer pId, String Status) {
		Optional<Plan> findById = planrepo.findById(pId);
		if(findById.isPresent()) {
			Plan plan = findById.get();
			plan.setActiveSw(Status);
			planrepo.save(plan);
			return true;
		}
		return false;
	}

}

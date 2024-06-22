package in.kunal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.Plan;

public interface PlanRepository extends  JpaRepository<Plan, Integer> {

}

package in.kunal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.kunal.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

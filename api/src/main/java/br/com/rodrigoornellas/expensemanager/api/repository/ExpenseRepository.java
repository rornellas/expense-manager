package br.com.rodrigoornellas.expensemanager.api.repository;

import br.com.rodrigoornellas.expensemanager.api.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
}

package br.com.rodrigoornellas.expensemanager.api.controller.response;

import br.com.rodrigoornellas.expensemanager.api.entity.ExpenseEntity;
import lombok.Data;

import java.time.Instant;

@Data
public class ExpenseResponse {
    private final Long id;
    private final String name;
    private final String description;
    private final Instant createdAt;
    private final Double value;
    private final String tags;

    public ExpenseResponse (ExpenseEntity expense) {
        this.id = expense.getId();
        this.name = expense.getName();
        this.description = expense.getDescription();
        this.createdAt = expense.getCreatedAt();
        this.value = expense.getValue();
        this.tags = expense.getTags();
    }
}

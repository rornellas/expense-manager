package br.com.rodrigoornellas.expensemanager.api.controller.request;

import br.com.rodrigoornellas.expensemanager.api.entity.ExpenseEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@Builder
public class CreateExpenseRequest {
    @NotEmpty
    private String name;
    private String description;
    @NotNull
    private Double value;
    private String tags;

    public ExpenseEntity toExpenseEntity() {
        return new ExpenseEntity(null, this.name, this.description, Instant.now(), this.value, this.tags);
    }
}

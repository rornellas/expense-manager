package br.com.rodrigoornellas.expensemanager.api.controller;

import br.com.rodrigoornellas.expensemanager.api.controller.request.CreateExpenseRequest;
import br.com.rodrigoornellas.expensemanager.api.controller.response.ExpenseResponse;
import br.com.rodrigoornellas.expensemanager.api.controller.router.ExpenseRouter;
import br.com.rodrigoornellas.expensemanager.api.service.IExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class ExpenseController {

    private final IExpenseService expenseService;

    public ExpenseController(IExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping(ExpenseRouter.V1_LIST_ALL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<ExpenseResponse> findAll() {
        return this.expenseService.findAll();
    }

    @GetMapping(ExpenseRouter.V1_FIND_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    public Mono<ExpenseResponse> findById(@PathVariable Long id) {
        return this.expenseService.findById(id);
    }

    @PostMapping(ExpenseRouter.V1_SAVE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ExpenseResponse> create(@Valid @RequestBody CreateExpenseRequest createExpenseRequest) {
        return this.expenseService.create(createExpenseRequest);
    }

}

package br.com.rodrigoornellas.expensemanager.api.service;

import br.com.rodrigoornellas.expensemanager.api.controller.request.CreateExpenseRequest;
import br.com.rodrigoornellas.expensemanager.api.controller.response.ExpenseResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IExpenseService {
    Flux<ExpenseResponse> findAll();
    Mono<ExpenseResponse> create(CreateExpenseRequest createExpenseRequest);
    Mono<ExpenseResponse> findById(Long id);
}

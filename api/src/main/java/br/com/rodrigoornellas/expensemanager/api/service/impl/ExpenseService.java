package br.com.rodrigoornellas.expensemanager.api.service.impl;

import br.com.rodrigoornellas.expensemanager.api.controller.request.CreateExpenseRequest;
import br.com.rodrigoornellas.expensemanager.api.controller.response.ExpenseResponse;
import br.com.rodrigoornellas.expensemanager.api.exception.EntityNotFountException;
import br.com.rodrigoornellas.expensemanager.api.repository.ExpenseRepository;
import br.com.rodrigoornellas.expensemanager.api.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.Optional;

@Service
public class ExpenseService implements IExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Flux<ExpenseResponse> findAll() {
        return Flux.fromStream(this.expenseRepository.findAll()
                    .stream().map(ExpenseResponse::new));
    }

    @Override
    public Mono<ExpenseResponse> create(CreateExpenseRequest createExpenseRequest) {
        return Mono.just(
                new ExpenseResponse(
                        this.expenseRepository.save(createExpenseRequest.toExpenseEntity())
                )
        );
    }

    @Override
    public Mono<ExpenseResponse> findById(Long id) {
        return Mono.just(this.expenseRepository.findById(id))
                .filter(Optional::isPresent)
                .map(data -> new ExpenseResponse(data.get()))
                    .switchIfEmpty(Mono.error(new EntityNotFountException()));
    }
}

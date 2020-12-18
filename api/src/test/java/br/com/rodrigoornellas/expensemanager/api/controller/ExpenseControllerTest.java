package br.com.rodrigoornellas.expensemanager.api.controller;

import br.com.rodrigoornellas.expensemanager.api.controller.request.CreateExpenseRequest;
import br.com.rodrigoornellas.expensemanager.api.controller.router.ExpenseRouter;
import br.com.rodrigoornellas.expensemanager.api.exception.EntityNotFountException;
import br.com.rodrigoornellas.expensemanager.api.service.impl.ExpenseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebFluxTest(ExpenseController.class)
public class ExpenseControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ExpenseService expenseService;

    @Test
    public void test_list_all_sucess() {
        this.webTestClient.get()
                .uri(ExpenseRouter.V1_LIST_ALL).exchange().expectStatus().isOk();
    }

    @Test
    public void test_create_success() {
        CreateExpenseRequest createExpenseRequest =
                CreateExpenseRequest.builder().name("teste")
                        .tags("teste").value(1000d).description("teste").build();

        this.webTestClient.post()
                .uri(ExpenseRouter.V1_SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(createExpenseRequest), CreateExpenseRequest.class)
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    public void test_create_without_name_fail() {
        CreateExpenseRequest createExpenseRequest =
                CreateExpenseRequest.builder()
                        .tags("teste").value(1000d).description("teste").build();

        this.webTestClient.post()
                .uri(ExpenseRouter.V1_SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(createExpenseRequest), CreateExpenseRequest.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void test_create_without_value_fail() {
        CreateExpenseRequest createExpenseRequest =
                CreateExpenseRequest.builder().name("teste")
                        .tags("teste").description("teste").build();

        this.webTestClient.post()
                .uri(ExpenseRouter.V1_SAVE)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(createExpenseRequest), CreateExpenseRequest.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void test_find_success() {
        this.webTestClient.get()
            .uri(ExpenseRouter.V1_FIND_BY_ID, 1)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isOk();
    }
    @Test
    public void test_find_fail() {
        when(expenseService.findById(1l)).thenThrow(new EntityNotFountException());

        this.webTestClient.get()
                .uri(ExpenseRouter.V1_FIND_BY_ID, 1)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isNotFound();
    }

}

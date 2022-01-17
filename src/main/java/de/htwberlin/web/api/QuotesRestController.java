package de.htwberlin.web.api;

import de.htwberlin.service.QuotesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class QuotesRestController {

    private final QuotesServiceImpl quotesService;

    public QuotesRestController(QuotesServiceImpl quotesService) {
        this.quotesService = quotesService;
    }

    @GetMapping(path = "api/v1/quotes")
    public ResponseEntity<QuoteResponse> getQuote(@RequestParam("index") int index) {
        try {
            QuoteResponse quoteResponse = new QuoteResponse(quotesService.getQuote(index));
            return ResponseEntity.ok(quoteResponse);
        } catch(Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}

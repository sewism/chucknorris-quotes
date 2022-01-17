package de.htwberlin.service;

import org.springframework.stereotype.Service;

@Service
public class QuotesServiceImpl implements QuotesService {

    @Override
    public String getQuote(int index) {
        return this.QUOTES.get(index);
    }
}

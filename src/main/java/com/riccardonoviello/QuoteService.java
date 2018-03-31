package com.riccardonoviello;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@Service
public class QuoteService {
    public Flux<List<QuoteDTO>> findAll() {
        List<QuoteDTO> list1 = Arrays.asList(getQuote("Q0001"));

        List<QuoteDTO> list2 = Arrays.asList(getQuote("Q0001"),
                getQuote("Q0002"),
                getQuote("Q0003"));

        List<QuoteDTO> list3 = Arrays.asList(getQuote("Q0001"),
                getQuote("Q0002"),
                getQuote("Q0003"),
                getQuote("Q0004"),
                getQuote("Q0005", "ACCEPTED"));

        List<QuoteDTO> list4 = Arrays.asList(getQuote("Q0001"),
                getQuote("Q0002"),
                getQuote("Q0003", "DECLINED"),
                getQuote("Q0004"),
                getQuote("Q0005", "ACCEPTED"));

        List<QuoteDTO> list5 =
                Arrays.asList(getQuote("Q0001"),
                getQuote("Q0002", "ACCEPTED"),
                getQuote("Q0003", "DECLINED"),
                getQuote("Q0004"),
                getQuote("Q0005", "ACCEPTED"));

        return Flux.just(list1, list2, list3, list4, list5)
                .delayElements(Duration.ofSeconds(2));
    }


    private QuoteDTO getQuote(String ref, String status) {
        QuoteDTO quote = getQuote(ref);
        quote.setStatus(status);
        return quote;
    }
    private QuoteDTO getQuote(String ref) {
        QuoteDTO quote = new QuoteDTO();
        quote.setCustomerName("Riccardo");
        quote.setStatus("PENDING");
        quote.setQuoteReference(ref);
        return quote;
    }
}

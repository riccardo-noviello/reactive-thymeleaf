package com.riccardonoviello;

import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuoteService quoteService;

    @RequestMapping("/")
    public String index(final Model model) {
        return "index-datadriven";
    }

    @RequestMapping(value = "/loadTable")
    public String getIndexStreamTable(final Model model) {

        final Publisher<List<QuoteDTO>> quotesStream = this.quoteService.findAll();

        model.addAttribute("list",
                new ReactiveDataDriverContextVariable(quotesStream, 1));

        return "index-datadriven :: #fragment-1";
    }
}

package edu.cmu.mis.iccfb.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.QuoteService;

@RestController
public class QuoteController {
    
    @Autowired
    private QuoteService quoteService;
    
    @RequestMapping("/quote")
    public ArrayList<Quote> quote(@RequestParam(value="authorId") String authorId) {
    	ArrayList<Quote> quotes = new ArrayList<Quote>();
        
        for (Quote q: this.quoteService.findAll() ) {
            if (q.getAuthorId().equals(authorId)) {
            	quotes.add(q);
            }
        }
        return quotes;
    }
    
    @RequestMapping("/random/quote")
    public Quote random() {
    	Random random = new Random();
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        
        for (Quote q: this.quoteService.findAll() ) {
            quotes.add(q);
        }
        Quote q = quotes.get(random.nextInt(quotes.size()));
        return q;
    }
    
    @RequestMapping(value = "/quote", method = RequestMethod.POST)
    public void saveQuote(@RequestBody Quote quote) {
        System.out.println("Saving quote");
        quoteService.save(quote);
    }

}
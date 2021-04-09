package com.example.Ecosmartsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class EcosmartsystemController {

    @Autowired
    private DBTransactionRepository transactionRepository;


    @GetMapping("/")
    public String main()  {

       return "main";
    }

    @GetMapping("/edit")
    public String transactionform(Model model)  {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("transactionList", transactionRepository.getTransactionList());
        return "transactionform";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Transaction transaction) {
        transactionRepository.addTransaction(transaction);
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("transactionList", transactionRepository.getTransactionList());
        return "transactionform";
    }

    @GetMapping("/display")
    public String displayTransactions (Model model)  {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("RESIDENCE", transactionRepository.totalPerCategory("RESIDENCE"));
        model.addAttribute("PLEASURE", transactionRepository.totalPerCategory("PLEASURE"));
        model.addAttribute("TRANSPORTATION", transactionRepository.totalPerCategory("TRANSPORTATION"));
        return "display";
    }


    @GetMapping("/aboutus")
    public String aboutUs()  {
        return "aboutus";
    }
}

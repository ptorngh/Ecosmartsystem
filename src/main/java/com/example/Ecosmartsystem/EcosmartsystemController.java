package com.example.Ecosmartsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EcosmartsystemController {

    @Autowired
    private DBTransactionRepository transactionRepository;

    @Autowired
    private DBCategoryRepository categoryRepository;

    @GetMapping("/")
    public String main()  {

       return "main";
    }

    @GetMapping("/edit")
    public String transactionform(Model model)  {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("transactionList", transactionRepository.getTransactionList());
        model.addAttribute("category", new Category());
        model.addAttribute("categoryList", categoryRepository.getCategoryList());

        List<DTOtransaction> DTOtransactionList = new ArrayList<>();
        for (Transaction d:transactionRepository.getTransactionList()){
            DTOtransaction dtotransaction = new DTOtransaction(d.getId(), d.getAmount(), d.getDate(), d.getCategoryid(), categoryRepository.getCategoryName(d.getCategoryid()));
            DTOtransactionList.add(dtotransaction);
        }
        model.addAttribute("DTOtransaction", DTOtransactionList);

        return "transactionform";
    }

    @PostMapping("/save")
    public String save(Model model, @ModelAttribute Transaction transaction) {
        transactionRepository.addTransaction(transaction);
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("transactionList", transactionRepository.getTransactionList());
        model.addAttribute("category", new Category());
        model.addAttribute("categoryList", categoryRepository.getCategoryList());

        List<DTOtransaction> DTOtransactionList = new ArrayList<>();
        for (Transaction d:transactionRepository.getTransactionList()){
            DTOtransaction dtotransaction = new DTOtransaction(d.getId(), d.getAmount(), d.getDate(), d.getCategoryid(), categoryRepository.getCategoryName(d.getCategoryid()));
            DTOtransactionList.add(dtotransaction);
        }
        model.addAttribute("DTOtransaction", DTOtransactionList);

        return "transactionform";
    }

    @GetMapping("/display")
    public String displayTransactions (Model model)  {
        model.addAttribute("transaction", new Transaction());

        List<Category> cList = new ArrayList<>();

        cList = categoryRepository.getCategoryList();

        for(Category e: cList) {
            model.addAttribute(e.getName(), transactionRepository.totalPerCategory(e.getId()));

        }
        return "display";
    }


    @GetMapping("/aboutus")
    public String aboutUs()  {
        return "aboutus";
    }
}
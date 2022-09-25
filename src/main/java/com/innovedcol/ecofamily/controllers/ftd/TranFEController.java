package com.innovedcol.ecofamily.controllers.ftd;

import com.innovedcol.ecofamily.services.backend.EmployeeService;
import com.innovedcol.ecofamily.services.backend.EnterpriseService;
import com.innovedcol.ecofamily.services.backend.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class TranFEController {

    private final TransactionService transactionService;
    private final EnterpriseService enterpriseService;
    private final EmployeeService employeeService;



    @RequestMapping("/transactions")
    public String transactionsIndex(Model model, Locale locale) {
        List<?> listaTransacciones = this.transactionService.getTransactionsList();
        model.addAttribute("listaTransacciones",listaTransacciones);
        return "transactions";
    }


}

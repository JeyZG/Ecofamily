package com.innovedcol.ecofamily.controllers.ftd;

import com.innovedcol.ecofamily.services.backend.EmployeeService;
import com.innovedcol.ecofamily.services.backend.EnterpriseService;
import com.innovedcol.ecofamily.services.backend.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TranFEController {

    private final TransactionService transactionService;
    private final EnterpriseService enterpriseService;
    private final EmployeeService employeeService;



    @RequestMapping("/transactions")
    public String transactionsIndex(Model model) {
        List<?> listaTransacciones = this.transactionService.getTransactionsList();
        model.addAttribute("listaTransacciones",listaTransacciones);
        return "transactions";
    }

    @RequestMapping("/users")
    public String usersIndex(Model model) {
        List<?> listaEmpleados = this.employeeService.getEmployeesList();
        model.addAttribute("listaEmpleados",listaEmpleados);
        return "users";
    }

    @RequestMapping("/enterprises")
    public String enterprisesIndex(Model model) {
        List<?> listaEmpresas = this.enterpriseService.getEnterprisesList();
        model.addAttribute("listaEmpresas",listaEmpresas);
        return "enterprises";
    }

}

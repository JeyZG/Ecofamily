package com.innovedcol.ecofamily.controllers.ftd;

import com.innovedcol.ecofamily.entities.Enterprise;
import com.innovedcol.ecofamily.services.backend.EmployeeService;
import com.innovedcol.ecofamily.services.backend.EnterpriseService;
import com.innovedcol.ecofamily.services.backend.TransactionService;
import com.innovedcol.ecofamily.services.frontend.EntFEService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
public class EntFEController {
private final EntFEService enterpriseService;

    @RequestMapping("/enterprises")
    public String enterprisesIndex(Model model) {
        List<?> listaEmpresas = this.enterpriseService.getEnterprisesList();
        model.addAttribute("listaEmpresas",listaEmpresas);
        return "enterprises";
    }

    @GetMapping("/enterprise/new")
    public String formNuevaEmpresa(Model model){
        model.addAttribute("empresa",new Enterprise());
        return "new_enterprise";
    }

    @PostMapping("/enterprise/new/go")
    public String createEnterprise(@ModelAttribute("empresa") Enterprise e, Model model, RedirectAttributes attributes){
        String result = this.enterpriseService.createEnterprise(e);
        if(result.equals("--> Empresa creada con éxito!")) {
            attributes.addFlashAttribute("mensajeOk",result);
        }else{
            attributes.addFlashAttribute("error",result);
        }
        return "redirect:/enterprises";
        //return "enterprises";
    }

    @GetMapping("/enterprise/delete/{id}")
    public String deleteEnterprise(@PathVariable("id") Long id) {
        this.enterpriseService.deleteEnterprise(id);
        return "redirect:/enterprises";
    }

}

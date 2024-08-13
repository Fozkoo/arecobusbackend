package com.example.arecobusbackend.Controllers;
import com.example.arecobusbackend.Models.Empresa;
import com.example.arecobusbackend.Services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/empresas")

public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;


    /* TRAE LA INFORMACION DE LA EMPRESA (ID, NOMBRE, EMAIL, TELEFONO , ETC */

    @GetMapping("/getAllEmpresa")
    public List<Empresa> getAllEmpresas(){
        return empresaService.getAllEmpresas();
    }

}

package org.generation.springbasedue.RestCtrl;

import java.util.List;

import org.generation.springbasedue.Model.Dto.DocenteDto;
import org.generation.springbasedue.Services.DocenteSrv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/docente")
public class DocenteCtrl {

    @Autowired
    private DocenteSrv srv;

    @GetMapping
    public List<DocenteDto> getAll(){
        return srv.getAll();
    }

    @GetMapping("/id={id}")
    public DocenteDto getById(@PathVariable("id") int idDocente) {
        return srv.getById(idDocente);
    }
    
    @GetMapping("/materia={materia}")
    public DocenteDto getById(@PathVariable("materia") String materia) {
        return srv.getByMateria(materia);
    }
}


package org.generation.springbasedue.Services;

import java.util.ArrayList;
import java.util.List;

import org.generation.springbasedue.Model.Dto.CorsoDto;
import org.generation.springbasedue.Model.Dto.DocenteDto;
import org.generation.springbasedue.Services.Interfaces.CommonService;
import org.springframework.stereotype.Service;

@Service
public class DocenteSrv  implements CommonService<DocenteDto> {
    private List<DocenteDto> docenti;

    public DocenteSrv() {
        docenti = new ArrayList<DocenteDto>();
        caricaDocentiECorsi();
    }

    public List<DocenteDto> getAll() {
        return docenti;
    }
    
	@Override
	public List<DocenteDto> getTutti() {
		return docenti;
	}

    public DocenteDto getById(int id) {
        for (DocenteDto d : docenti) {
            if(d.getId() == id) {
                return d;
            }
        }
        return new DocenteDto();
    }
    
	@Override
	public DocenteDto getUnoPerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

    public DocenteDto getByMateria(String materia) {
        for (DocenteDto d : docenti) {
            if(d.getMateria().equalsIgnoreCase(materia)) {
                return d;
            }
        }
        return new DocenteDto();
    }

    public void caricaDocentiECorsi() {
        CorsoDto c1= new CorsoDto(1,"Generation");
        CorsoDto c2= new CorsoDto(2,"Sviluppo-Software");
        CorsoDto c3= new CorsoDto(3,"Sviluppo-Back-end");
        CorsoDto c4= new CorsoDto(4,"Sviluppo-Front-end");

        DocenteDto d1 = new DocenteDto(1,"Dario","Mennillo","Java");
        d1.addCorso(c1);
        d1.addCorso(c3);

        DocenteDto d2 = new DocenteDto(2,"Mario","Nintendo","Come-saltare-sui-funghi");
        d2.addCorso(c4);

        docenti.add(d1);
        docenti.add(d2);
    }


}

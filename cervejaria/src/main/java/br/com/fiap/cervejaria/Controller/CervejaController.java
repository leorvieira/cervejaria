package br.com.fiap.cervejaria.Controller;

import br.com.fiap.cervejaria.dto.CervejaDTO;
import br.com.fiap.cervejaria.dto.Tipo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "cervejas/leo")
public class CervejaController {


    private List<CervejaDTO> cervejaDTOList;

    public CervejaController(){

        System.out.println("passou por aqui ?");
        cervejaDTOList = new ArrayList<>();

        cervejaDTOList.add( new CervejaDTO(1, "Marca1", 3.5,Tipo.ALE, new BigDecimal(17.2), ZonedDateTime.now().minusYears(1)));
        cervejaDTOList.add( new CervejaDTO(2, "Marca2", 3.5,Tipo.WEISS, new BigDecimal(17.9), ZonedDateTime.now().minusYears(1)));
    }

/*
    @GetMapping
    public String hello(@RequestParam Integer id){

        return ("Hello World - > "+id);

    }

    @GetMapping
    public List<CervejaDTO> getAll(@RequestParam Tipo tipo){

        return cervejaDTOList.stream()
                .filter(cervejaDTO -> cervejaDTO.getTipo().equals(tipo))
                .collect(Collectors.toList());

    }
*/
    @GetMapping("all")
    public List getAll(){
        System.out.println("PASSOU AQUI");
        return cervejaDTOList;

    }

/*
    @GetMapping
    public CervejaDTO findById(@PathVariable Integer id){

        System.out.println("hahahah");
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> cervejaDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


*/

    @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public CervejaDTO findById(Integer id){

        System.out.println("hahahah");
        return cervejaDTOList.stream()
                .filter(cervejaDTO -> cervejaDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }


    @PostMapping
    @RequestMapping(method = RequestMethod.POST)

    public CervejaDTO create(@RequestBody CreateCervejaDTO createCervejaDTO){

        System.out.println("fffffff");
        CervejaDTO cervejaDTO = new CervejaDTO( createCervejaDTO, cervejaDTOList.size() + 1);
        cervejaDTOList.add(cervejaDTO);
        return cervejaDTO;

    }

    @PutMapping("{id}")
    public CervejaDTO update (@PathVariable Integer id, @RequestBody  CreateCervejaDTO createCervejaDTO){

        CervejaDTO cervejaDTO = findById(id);
        cervejaDTO.setMarca(createCervejaDTO.getMarca());
        cervejaDTO.setTipo(createCervejaDTO.getTipo());
        cervejaDTO.setPreco(createCervejaDTO.getPreco());
        cervejaDTO.setDataLancamento(createCervejaDTO.getDataLancamento());
        cervejaDTO.setTipo(createCervejaDTO.getTipo());

        return  cervejaDTO;
        }
/*
       @PatchMapping("{id}")
        public CervejaDTO update(@PathVariable Integer id, @RequestBody PrecoCervejaDTO precoCervejaDTO){

        }
*/

     @DeleteMapping("{id}")
    public void detete(@PathVariable Integer id){

        System.out.println("hehehe");
        CervejaDTO cervejaDTO = findById(id);
        cervejaDTOList.remove(cervejaDTO);
    }

}

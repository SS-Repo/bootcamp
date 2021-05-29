package com.project.bootcamp.controlller;

import com.project.bootcamp.model.dto.StockDTO;
import com.project.bootcamp.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/stock")

public class StockController {

    @Autowired
    private StockService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.save(dto));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> update(@Valid @RequestBody StockDTO dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());

    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StockDTO> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping(value = "/today",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StockDTO>> finByToday(){
        return ResponseEntity.ok(service.findByToday());
    }

    //https://digitalinnovation.one/santander-dev-week-fullstack-developer/sessao/aula-03-J0coM67GCT4?utm_source=email-dw-santander&utm_medium=ac-mautic&utm_campaign=santander&utm_source=ActiveCampaign&utm_medium=email&utm_content=N%C3%A3o+esque%C3%A7a+o+seu+compromisso+de+hoje&utm_campaign=%5BCG%5D%5BAquisi%C3%A7%C3%A3o%5D%5BSantander+Dev+Week%5D+Projeto+-+Parte+3+Fullstack+liberado+%28%2Bdescri%C3%A7%C3%A3o%29+%2B+N%C3%A3o+perca+a+live+de+hoje+-+27+05+-+10h00
    //To be continued...2:37:00
    //Host API Horuko
}

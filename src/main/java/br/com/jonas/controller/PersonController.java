package br.com.jonas.controller;

import br.com.jonas.data.vo.v1.PersonVO;
import br.com.jonas.data.vo.v2.PersonVO2;
import br.com.jonas.service.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices personServices;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonVO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(personServices.findById(id));
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonVO>> findAll() {
        return ResponseEntity.ok().body(personServices.findAll());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO save(@RequestBody PersonVO PersonVO) {
        return personServices.save(PersonVO);
    }

    @PostMapping(value = {"/v2"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO2 save(@RequestBody PersonVO2 personVO) {
        return personServices.save2(personVO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO update(@RequestBody PersonVO PersonVO) {
        return personServices.update(PersonVO);
    }

    @DeleteMapping()
    public void delete(@PathVariable Long id) {
        personServices.delete(id);
    }
}

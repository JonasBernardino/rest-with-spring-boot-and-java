package br.com.jonas.service;

import br.com.jonas.data.vo.v1.PersonVO;
import br.com.jonas.data.vo.v2.PersonVO2;
import br.com.jonas.exceptions.ResourceNotFoundException;
import br.com.jonas.mapper.DozerMapper;
import br.com.jonas.mapper.custom.PersonMapper;
import br.com.jonas.model.Person;
import br.com.jonas.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonMapper mapper;
    private final AtomicLong conter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public PersonVO findById(Long id) {
        logger.info("listing one person!");
        var entity =  repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("listing all person!");
        return DozerMapper.parseListObject(repository.findAll(), PersonVO.class) ;
    }

    public PersonVO save(PersonVO person) {
        logger.info("Save one person!");
        var entity = DozerMapper.parseObject(person, Person.class);
        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public PersonVO update(PersonVO person) {
        logger.info("Updating one person!");
        Person entity = repository.findById(person.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        var vo =  DozerMapper.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id) {
        var entity = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Id não encontrado"));
        repository.delete(entity);
    }

    public PersonVO2 save2(PersonVO2 personVO2) {
        logger.info("Save one person v2!");
        var entity = mapper.convertVoTOEntity(personVO2);
        var vo =  mapper.convertEntityToVo(repository.save(entity));
        return vo;
    }
}

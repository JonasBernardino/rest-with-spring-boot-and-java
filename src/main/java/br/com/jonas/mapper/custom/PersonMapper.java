package br.com.jonas.mapper.custom;

import br.com.jonas.data.vo.v2.PersonVO2;
import br.com.jonas.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonVO2 convertEntityToVo(Person person){
        PersonVO2 vo = new PersonVO2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setFirstName(person.getFirstName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        vo.setBirthDay(new Date());
        return vo;
    }
    public Person convertVoTOEntity(PersonVO2 personVO2){
        Person entity = new Person();
        entity.setId(personVO2.getId());
        entity.setAddress(personVO2.getAddress());
        entity.setFirstName(personVO2.getFirstName());
        entity.setLastName(personVO2.getLastName());
        entity.setGender(personVO2.getGender());
       // vo.setBirthDay(new Date());
        return entity;
    }
}

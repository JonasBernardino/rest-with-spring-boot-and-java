package br.com.jonas.service;

import br.com.jonas.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class GreetingServices {

    private final String MSG_ERROR  = "Please set a numeric value";

    public Double sum (String numOne, String numTwo){
        if(!isNumeric(numOne) || !isNumeric(numTwo)) throw new ResourceNotFoundException(MSG_ERROR);
        return convertToDouble(numOne) + convertToDouble(numTwo);
    }

    public Double multiplication (String numOne, String numTwo){
        if(!isNumeric(numOne) || !isNumeric(numTwo)) throw new ResourceNotFoundException(MSG_ERROR);
        return convertToDouble(numOne) * convertToDouble(numTwo);
    }

    public Double subtraction (String numOne, String numTwo){
        if(!isNumeric(numOne) || !isNumeric(numTwo)) throw new ResourceNotFoundException(MSG_ERROR);
        return convertToDouble(numOne) - convertToDouble(numTwo);
    }

    public Double division (String numOne, String numTwo){
        if(!isNumeric(numOne) || !isNumeric(numTwo)) throw new ResourceNotFoundException(MSG_ERROR);
        return convertToDouble(numOne) / convertToDouble(numTwo);
    }

    public Double average (String numOne, String numTwo){
        if(!isNumeric(numOne) || !isNumeric(numTwo)) throw new ResourceNotFoundException(MSG_ERROR);
        return (convertToDouble(numOne) + convertToDouble(numTwo)) / 2;
    }

    public Double square (String numOne){
        if (!isNumeric(numOne)) {
            throw new ResourceNotFoundException("Please set a numeric value");
        }
        return Math.sqrt(convertToDouble(numOne));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}

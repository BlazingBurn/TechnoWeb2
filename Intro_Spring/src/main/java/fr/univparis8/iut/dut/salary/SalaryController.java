package fr.univparis8.iut.dut.salary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public List<SalaryDto> getAllSalary() {
        return salaryService.getAll();
    }

    @GetMapping("{id}")
    public SalaryDto getSalary(@PathVariable Long id) {
        return SalaryMapper.toSalaryDto(salaryService.get(id));
    }

    @PostMapping
    public ResponseEntity<SalaryDto> createSalary(@RequestBody SalaryDto salaryDto) throws URISyntaxException {

        if(salaryDto.getId() != null) {
            throw new IllegalArgumentException("Salary id should not be populated when creating and salary");
        }

        /*Version avec stream mais a cause de la verification possiblement trop longue ne pas utiliser
        if (salaryService.verifDate(salaryDto)) {
            throw new IllegalArgumentException("Salaire existe deja pour ce mois/annee");
        }*/


        String dateVersementDu = salaryDto.getDateVersementDu();

        int count = dateVersementDu.length() - dateVersementDu.replace("-", "").length();
        String[] tab = dateVersementDu.split("-");
        if (count != 1 || tab.length != 2 || tab[0].length() != 4 || tab[1].length() != 2) {
            throw new IllegalArgumentException("Salary date invalid");
        }

        try {
            Integer.parseInt(tab[0]);
            Integer.parseInt(tab[1]);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Salary date invalid");
        }

        salaryDto.setMontantVerse(salaryDto.getMontantVerse()*salaryDto.getNbJoursTravailMois()/20);

        Salary newSalary = salaryService.create(SalaryMapper.toSalary(salaryDto));

        return ResponseEntity.ok(SalaryMapper.toSalaryDto(newSalary));
    }

    @PostMapping("batch")
    public ResponseEntity<List<SalaryDto>> createSalaryBatch(@RequestBody List<SalaryDto> salaryDtos) throws URISyntaxException {

        String dateVersementDu;
        int count;
        String[] tab;

        for (SalaryDto index: salaryDtos
        ) {
            if(index.getId() != null) {
                throw new IllegalArgumentException("Employee id should not be populated when creating and employee");
            }

            dateVersementDu = index.getDateVersementDu();
            count = dateVersementDu.length() - dateVersementDu.replace("-", "").length();
            tab = dateVersementDu.split("-");
            if (count != 1 || tab.length != 2 || tab[0].length() != 4 || tab[1].length() != 2) {
                throw new IllegalArgumentException("Salary date invalid");
            }

            try {
                Integer.parseInt(tab[0]);
                Integer.parseInt(tab[1]);
            }catch (NumberFormatException e) {
                throw new IllegalArgumentException("Salary date invalid");
            }
            index.setMontantVerse(index.getMontantVerse()*index.getNbJoursTravailMois()/20);

        }

        List<Salary> newSalaryList = salaryService.createAll(SalaryMapper.DtoToSalaryList(salaryDtos));

        return ResponseEntity.ok(SalaryMapper.toSalaryDtoList(newSalaryList));

    }

}

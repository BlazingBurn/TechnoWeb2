package fr.univparis8.iut.dut.salary;

import fr.univparis8.iut.dut.common.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.util.List;

@Service
public class SalaryService {

    private static final String NOT_FOUND_MESSAGE = "Employee with id  [ %s ] not found";

    private final SalaryRepository salaryRepository;

    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public Salary get(Long id) {
        try {
            return SalaryMapper.toSalary(salaryRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public Salary create(Salary salary) {
        return SalaryMapper.toSalary(salaryRepository.save(SalaryMapper.toSalary(salary)));
    }

    public List<Salary> createAll(List<Salary> salary) {
        return SalaryMapper.toSalaryList(salaryRepository.saveAll(SalaryMapper.toSalaryEntityList(salary)));
    }

    public List<SalaryDto> getAll() {
        List<Salary> salary = SalaryMapper.toSalaryList(salaryRepository.findAll());
        return SalaryMapper.toSalaryDtoList(salary);
    }

    /*public boolean verifDate(SalaryDto salaryDto) {
        //Version pour stream
        List<SalaryDto> listSalaryDto = getAll();
        return listSalaryDto.stream().anyMatch(x -> x.getDateVersement().getMonth().equals(salaryDto.getDateVersement().getMonth())
                                                &&
                                                x.getDateVersement().getYear() == salaryDto.getDateVersement().getYear());

    }*/

}

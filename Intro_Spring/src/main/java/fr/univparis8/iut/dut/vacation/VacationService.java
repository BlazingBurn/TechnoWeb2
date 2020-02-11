package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.common.exception.ObjectNotFoundException;

import fr.univparis8.iut.dut.employee.EmployeeMapper;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class VacationService {


    private static final String NOT_FOUND_MESSAGE = "Employee with id  [ %s ] not found";

    private final VacationRepository vacationRepository;

    public VacationService(VacationRepository vacationRepository) {
        this.vacationRepository = vacationRepository;
    }

    public VacationDay get(Long id) {
        try {
            return VacationMapper.toVacationDay(vacationRepository.getOne(id));
        } catch (PersistenceException ex) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, id));
        }
    }

    public List<VacationDayDto> create(VacationRequestDto vacation) {

        return VacationMapper.toVacationDayDtoList(VacationMapper.toVacationDayListEX(
                vacationRepository.saveAll(toVacationDayEntityList(VacationMapper.toVacationRequest(vacation)))));

    }

    public List<VacationDayEntity> toVacationDayEntityList(VacationRequest request) {

        LocalDate start = request.getDateDebut();
        LocalDate end = request.getDateFin();

        List<LocalDate> days = Stream.iterate(start, date -> date.plusDays(1))
                .filter(x->x.getDayOfWeek() != DayOfWeek.SATURDAY && x.getDayOfWeek() != DayOfWeek.SUNDAY)
                .limit(ChronoUnit.DAYS.between(start, end) + 1)
                .collect(Collectors.toList());

        List<VacationDayEntity> res = new ArrayList<>();
        for (LocalDate d : days) {
            res.add(new VacationDayEntity(request.getId(), EmployeeMapper.toEmployee(request.getEmployee()), d));
        }
        return res;

    }

    /*public List<List<VacationDayDto>> createAll(List<VacationRequestDto> vacation) {
        return VacationMapper.toVacationDayDtoList(VacationMapper.toVacationDayListEX(
                vacationRepository.saveAll(toVacationDayEntityList(VacationMapper.toVacationRequest(vacation)))));
        return VacationMapper.toVacationDayList(vacationRepository.saveAll(VacationMapper.toVacationDayEntityList(vacation)));
    }*/

    public List<VacationDayDto> getAll() {
        List<VacationDay> vacation = VacationMapper.toVacationDayList(vacationRepository.findAll());
        return VacationMapper.toVacationDayDtoList(vacation);
    }


    public List<VacationDayDto> update(VacationRequestDto request) {
        if(!vacationRepository.existsById(request.getId())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, request.getId()));
        }

        return VacationMapper.toVacationDayDtoList(VacationMapper.toVacationDayListEX(
                vacationRepository.saveAll(toVacationDayEntityList(VacationMapper.toVacationRequest(request)))));
    }

    /*public List<VacationDayDto> partialUpdate(VacationRequestDto request) {
        if(!vacationRepository.existsById(request.getId())) {
            throw new ObjectNotFoundException(String.format(NOT_FOUND_MESSAGE, request.getId()));
        }

        VacationDay currentVacation = VacationMapper.toVacationDay(vacationRepository.getOne(request.getId()));
        VacationDay mergedVacation = currentVacation.mergeWith(VacationMapper.toVacationDay()request);

        VacationDayEntity newVacation = vacationRepository.save(VacationMapper.toVacationDayEntity(mergedVacation));

        return VacationMapper.toVacationDay(newVacation);
    }*/

    public void delete(Long id) {
        if(vacationRepository.existsById(id)) {
            vacationRepository.deleteById(id);
        }
    }


}

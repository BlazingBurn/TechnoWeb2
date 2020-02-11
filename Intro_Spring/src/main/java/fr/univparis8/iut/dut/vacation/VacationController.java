package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.common.exception.IdMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/vacation")
public class VacationController {

    private final VacationService vacationService;

    @Autowired
    public VacationController(VacationService vacationService) {
        this.vacationService = vacationService;
    }

    @GetMapping
    public List<VacationDayDto> getAllVacation() {
        return vacationService.getAll();
    }

    @GetMapping("{id}")
    public VacationDayDto getVacation(@PathVariable Long id) {
        return VacationMapper.toVacationDayDto(vacationService.get(id));
    }

    @PostMapping
    public ResponseEntity<List<VacationDayDto>> createVacation(@RequestBody VacationRequestDto vacationDto) throws URISyntaxException {

        if(vacationDto.getId() != null) {
            throw new IllegalArgumentException("Vacation id should not be populated when creating and Vacation");
        }

        return ResponseEntity.ok(vacationService.create(vacationDto));
    }

    /*@PostMapping("batch")
    public ResponseEntity<List<List<VacationDayDto>>> createVacationBatch(@RequestBody List<VacationDayDto> vacationDtos) throws URISyntaxException {

        for (VacationDayDto index: vacationDtos
        ) {
            if(index.getId() != null) {
                throw new IllegalArgumentException("Employee id should not be populated when creating and employee");
            }

        }

        return  ResponseEntity.ok(vacationService.createAll(vacationDtos));

        List<VacationDay> newVacationDayList = vacationService.createAll(VacationMapper.DtoToVacationDayList(vacationDtos));

        return ResponseEntity.ok(VacationMapper.toVacationDayDtoList(newVacationDayList));

    }*/

    @PutMapping("{id}")
    public ResponseEntity<List<VacationDayDto>> updateVacation(@PathVariable Long id, @RequestBody VacationRequestDto requestDto) {
        if(requestDto.getId() == null) {
            throw new IllegalArgumentException("Employee id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(requestDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        return ResponseEntity.ok(vacationService.update(requestDto));
    }

   /* @PatchMapping("{id}")
    public VacationDayDto partialUpdateEmployee(@PathVariable Long id, @RequestBody VacationDayDto vacationDayDto) {
        if(vacationDayDto.getId() == null) {
            throw new IllegalArgumentException("Employee id should be populated for HTTP PUT method: you cannot predict its id");
        }
        if(!id.equals(vacationDayDto.getId())) {
            throw new IdMismatchException("Path id and payload id do not match");
        }

        VacationDay updatedVacationDay = vacationService.partialUpdate(VacationMapper.toVacationDay(vacationDayDto));
        return VacationMapper.toVacationDayDto(updatedVacationDay);
    }*/

    @DeleteMapping("{id}")
    public void deleteVacation(@PathVariable Long id) {
        vacationService.delete(id);
    }


}

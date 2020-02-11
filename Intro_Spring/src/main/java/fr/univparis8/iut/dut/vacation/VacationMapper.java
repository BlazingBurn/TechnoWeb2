package fr.univparis8.iut.dut.vacation;

import fr.univparis8.iut.dut.employee.EmployeeMapper;

import java.util.List;
import java.util.stream.Collectors;

public class VacationMapper {

    public static VacationRequest toVacationRequest(VacationRequestDto vacationRequestDto) {
        return VacationRequest.VacationRequestBuilder.create()
                .withId(vacationRequestDto.getId())
                .withEmployee(EmployeeMapper.toEmployee(vacationRequestDto.getEmployee()))
                .withDateDebut(vacationRequestDto.getDateDebut())
                .withDateFin(vacationRequestDto.getDateFin())
                .build();
    }

    public static VacationDayEntity toVacationDayEntity(VacationRequest vacationRequest) {
        return VacationDayEntity.VacationEntityBuilder.create()
                .withId(vacationRequest.getId())
                .withEmployee(EmployeeMapper.toEmployee(vacationRequest.getEmployee()))
                .withDay(vacationRequest.getDateDebut())
                .build();
    }///////////////////////////////////////////////////

    public static VacationDayEntity toVacationDayEntity(VacationDay vacationDay) {
        return VacationDayEntity.VacationEntityBuilder.create()
                .withId(vacationDay.getId())
                .withEmployee(EmployeeMapper.toEmployee(vacationDay.getEmployee()))
                .withDay(vacationDay.getDay())
                .build();
    }

    public static VacationDay toVacationDayEX(VacationDayEntity vacationDayEntity) {
        return VacationDay.VacationDayBuilder.create()
                .withId(vacationDayEntity.getId())
                .withDay(vacationDayEntity.getDay())
                .build();
    }

    public static VacationDay toVacationDay(VacationDayEntity vacationDayEntity) {
        return VacationDay.VacationDayBuilder.create()
                .withId(vacationDayEntity.getId())
                .withEmployee(EmployeeMapper.toEmployee(vacationDayEntity.getEmployeeEntity()))
                .withDay(vacationDayEntity.getDay())
                .build();
    }

    public static VacationDay toVacationDay(VacationDayDto vacationDayDto) {
        return VacationDay.VacationDayBuilder.create()
                .withId(vacationDayDto.getId())
                .withDay(vacationDayDto.getDay())
                .build();
    }

    public static VacationDayDto toVacationDayDto(VacationDay vacationDay) {
        return VacationDayDto.VacationDayDtoBuilder.create()
                .withId(vacationDay.getId())
                .withDay(vacationDay.getDay())
                .build();
    }

    public static List<VacationDayEntity> toVacationDayEntityList(List<VacationDay> vacationDay) {
        return vacationDay.stream()
                .map(VacationMapper::toVacationDayEntity)
                .collect(Collectors.toList());
    }

    public static List<VacationDayEntity> requestToVacationDayEntityList(List<VacationRequest> vacationRequest) {
        return vacationRequest.stream()
                .map(VacationMapper::toVacationDayEntity)
                .collect(Collectors.toList());
    }

    public static List<VacationRequest> toVacationRequestList(List<VacationRequestDto> vacationRequestDtos) {
        return vacationRequestDtos.stream()
                .map(VacationMapper::toVacationRequest)
                .collect(Collectors.toList());
    }

    public static List<VacationDay> toVacationDayList(List<VacationDayEntity> vacationDayEntities) {
        return vacationDayEntities.stream()
                .map(VacationMapper::toVacationDayEX)
                .collect(Collectors.toList());
    }

    public static List<VacationDay> toVacationDayListEX(List<VacationDayEntity> vacationDayEntities) {
        return vacationDayEntities.stream()
                .map(VacationMapper::toVacationDayEX)
                .collect(Collectors.toList());
    }

    public static List<VacationDayDto> toVacationDayDtoList(List<VacationDay> vacationDays) {
        return vacationDays.stream()
                .map(VacationMapper::toVacationDayDto)
                .collect(Collectors.toList());
    }

    public static List<VacationDay> DtoToVacationDayList(List<VacationDayDto> vacationDaysDto) {
        return vacationDaysDto.stream()
                .map(VacationMapper::toVacationDay)
                .collect(Collectors.toList());
    }

}

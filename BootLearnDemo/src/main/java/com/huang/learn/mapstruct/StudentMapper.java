package com.huang.learn.mapstruct;


import com.huang.learn.BO.StudentBo;
import com.huang.learn.DTO.StudentDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto convertToBo(StudentBo studentBo);
}

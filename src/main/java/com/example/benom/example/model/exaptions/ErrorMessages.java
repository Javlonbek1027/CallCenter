package com.example.benom.example.model.exaptions;


import static com.example.benom.example.model.exaptions.ErrorCodes.ERR_NOT_FOUND;

public interface ErrorMessages {

    String NOT_FOUND = "%s не найдено";

    String SHOULDNT_BE_NULL = "не должен быть нулевым";
    String SHOULDNT_BE_EMPTY = "не должно быть пустым";
    String ERROR_VALUE = "Введено неверное значение";

    String UNPROCESSABLE_ENTITY = "E422";

    static ErrorCodeMsg notFound(String className) {
        return new ErrorCodeMsg(ERR_NOT_FOUND, String.format(NOT_FOUND, className));
    }
}


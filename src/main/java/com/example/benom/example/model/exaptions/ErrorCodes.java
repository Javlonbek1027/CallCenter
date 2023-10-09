package com.example.benom.example.model.exaptions;

public interface ErrorCodes {

    String SUCCESS = "0000";
    String ERROR = "E000";
    String ERR_NOT_FOUND = "E101";
    String ERR_BAD_REQUEST = "E400";
    String ER_UNAUTHORIZED = "E401";
    String ERR_INTERNAL_SERVER = "E500";
    String ERR_PERSONAL_INFO_ALREADY_ADDED = "E102";
    String CARD_ALREADY_USED = "E103";
    String ERR_BLOCKED_USER = "E104";
    String THE_TIME_IS_UP = "E105";
}

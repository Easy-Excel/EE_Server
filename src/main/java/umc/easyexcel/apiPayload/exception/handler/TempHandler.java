package umc.easyexcel.apiPayload.exception.handler;

import umc.easyexcel.apiPayload.code.BaseErrorCode;
import umc.easyexcel.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}

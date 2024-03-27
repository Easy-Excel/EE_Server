package umc.easyexcel.apiPayload.exception.handler;

import umc.easyexcel.apiPayload.code.BaseErrorCode;
import umc.easyexcel.apiPayload.exception.GeneralException;

public class ShortcutKeyHandler extends GeneralException {
    public ShortcutKeyHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}

package umc.study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.study.apiPayload.code.BaseErrorCode;
import umc.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return code.getReasonHttpStatus();
    }
}

package org.test.jhcplugin;

public class ErrorMessage {

    private static final String JOB_ERROR_MEESAGE_CONTAIN = "다른직업을 가진상태입니다";
    private static final String JOB_ERROR_MEESAGE_BEGINNER = "이미 초보자 입니다";

    public static String getJobErrorMessage(int index) {

        switch (index) {
            case 1:
                return JOB_ERROR_MEESAGE_CONTAIN;

            case 2:
                return JOB_ERROR_MEESAGE_BEGINNER;
        }

        return "알수 없는 오류";
    }
}

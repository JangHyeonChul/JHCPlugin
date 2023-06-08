package org.test.jhcplugin.Valid;

public class Validator {

    // 전직서 사용시 직업이 있는지 비교
    public boolean haveYourJobCheck(String playerJobCode, String compareJobCode) {
        return playerJobCode.equals(compareJobCode);

    }
}

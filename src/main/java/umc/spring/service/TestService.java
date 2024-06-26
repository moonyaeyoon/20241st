package umc.spring.service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.exception.handler.TestHandler;

@Service
public class TestService {

    public void failedTest() {
        if (1==1) {
            throw new TestHandler(ErrorStatus._BAD_REQUEST);
        }
    }
}


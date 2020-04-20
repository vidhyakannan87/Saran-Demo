package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.Service.TwilioService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class TwilioServiceImpl implements TwilioService {

  @Value("${twilio.accountSID}")
  private String twilioAccountSID;

  @Value("${twilio.authToken}")
  private String twilioAuthToken;

  @Value("${twilio.phoneNumber}")
  private String twilioPhoneNumber;


  @PostConstruct
  public void init() {
    Twilio.init(twilioAccountSID, twilioAuthToken);
  }

  @Override
  public void sendSMS(String phoneNumber, String messageText) {

    Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(twilioPhoneNumber),
            messageText).create();

  }
}

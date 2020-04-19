package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.API.Request.StripeChargeRequest;
import com.example.Saran.Demo.Model.Student;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("/student")
public interface StudentController {

  @GetMapping
  List<Student> getAll();


  @PostMapping
  void addAStudent(@RequestBody Student student);

  @PostMapping("/{id}/payment")
  void addPayment(@PathVariable String id, @RequestBody StripeChargeRequest stripeChargeRequest) throws StripeException;

}

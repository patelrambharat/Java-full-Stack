package com.patelSons.learningProject.Service;

import com.patelSons.learningProject.DTO.PaymentRequest;
import com.patelSons.learningProject.DTO.PaymentResponse;
import com.patelSons.learningProject.Entity.PaymentEntity;
import com.patelSons.learningProject.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj){
        PaymentEntity paymentModel = paymentRepository.getPaymentById(internalRequestObj);

        //map it to response obj

        PaymentResponse paymentResponse = mapModelToResponseDTO(paymentModel);
        return paymentResponse;
    }

    private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity){
        PaymentResponse response = new PaymentResponse();
        response.setPaymentId(paymentEntity.getId());
        response.setAmount( paymentEntity.getPaymentAmount());
        response.setCurrency(paymentEntity.getPaymentCurrency());
        return response;
    }
}

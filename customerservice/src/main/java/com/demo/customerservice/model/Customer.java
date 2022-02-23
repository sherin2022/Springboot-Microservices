package com.demo.customerservice.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.time.LocalDateTime;


@Document(collection="customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    //@Min(value=1,message="Invalid Entry for customer id")
    private BigInteger customerId;

    @NotBlank(message ="Customer name cannot be black")
    private String name;

    @NotBlank(message="aadharNumber cannot be blank")
    @Size(min = 12,message="Invalid Aadhar Number")
    private String aadharNumber;

    @NotNull(message="Address field can't be blank")
    Address address;

    private long phoneNumber;

    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private AccountHolderType accountHolderType;
    private Boolean isCustomerActive;


}

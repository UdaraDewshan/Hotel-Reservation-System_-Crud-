package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerInfoDTO {
    private String id;
    private String name;
    private String phoneNo;
    private String city;
    private int age;
}


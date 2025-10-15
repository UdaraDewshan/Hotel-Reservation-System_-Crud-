package model.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StaffInfoDTO {
        private String staffId;
        private String name;
        private String role;
        private String email;
        private String phone;
        private double salary;
}

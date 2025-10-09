package model.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoomInfo_DTO {
    private String roomId;
    private String type;
    private String description;
    private double price;
}

package de.smarthome.smartux.mainDataModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class StompMessage { 
   private String type; 
   private String value; 
   private String oldType; 
   private String oldValue; 
}
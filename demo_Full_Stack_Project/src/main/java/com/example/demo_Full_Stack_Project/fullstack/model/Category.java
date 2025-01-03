/*ackage com.example.demo_Full_Stack_Project.fullstack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Category")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {

    @Id
    private String id;
    private String name;
    //(notes = "Name of the category", example = "fitness")

    private String description;
    //(notes = "Description of the category", example = "Fitness supplements")

}

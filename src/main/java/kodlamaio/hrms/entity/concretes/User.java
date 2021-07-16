package kodlamaio.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
@Inheritance(strategy=InheritanceType.JOINED)

@Data


public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    @JsonIgnore
    private int user_id;

    @Column(name="email")
   /* @Email
    @NotBlank
    @NotNull */
    private String email;


    @Column(name="password")
    // @NotBlank
    //@NotNull
    // @JsonIgnore
    private String password;

    @JsonIgnore
    @Column(name = "create_date")
    private LocalDate create_date= LocalDate.now();

    @Column(name="is_active",columnDefinition = "boolean default true")
    @JsonIgnore
    private Boolean isActive=true;


    @JsonIgnore
    @Column(name = "is_delete",columnDefinition = "boolean default false")
    private boolean isDelete=false;

}

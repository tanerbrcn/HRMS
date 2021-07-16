package kodlamaio.hrms.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "user_id")
@Table(name="candidates")

public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "national_identity")
    private String nationalIdentity;

    @Column(name = "year_birth")
    private int yearBirth;

    @Column(name = "password_repeat")
    private String passwordRepeat;

    @JsonIgnore
    @Column(name = "is_verified_by_email",columnDefinition = "boolean default false")
    private boolean isVerifiedByEmail=false;


}

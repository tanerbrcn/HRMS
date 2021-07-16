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
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "employers")
@EqualsAndHashCode(callSuper=false)
@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "user_id")
public class Employer extends User{

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "web_site")
    private String webSite;

    @Column(name = "password_repeat")
    private String passwordRepeat;

    @JsonIgnore
    @Column(name = "is_verified_by_email",columnDefinition = "boolean default false")
    private boolean isVerifiedByEmail=false;

    @JsonIgnore
    @Column(name = "is_verified_by_employee",columnDefinition = "boolean default false")
    private boolean isVerifiedByEmployee=false;



}

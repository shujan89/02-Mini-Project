package ObjectWin.com.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "course_details")
public class CourseDetails {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "course_name", length = 30)
    private String courseName;

    @Column(name = "course_category")
    private String courseCategory;

    @Column(name = "faculty_name")
    private String facultyName;

    @Column(name = "fee", length = 30)
    private Double fee;

    @Column(name = "admin_name")
    private String adminName;

    @Column(name = "admin_contact")
    private Long adminContact;

    @Column(name = "training_mode")
    private String trainingMode;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "course_status")
    private String courseStatus;

    @CreationTimestamp
    @Column(name = "creation_date",insertable = false,updatable = false)
    private LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "updation_date",insertable = false,updatable = true)
    private LocalDateTime updationDate;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "updated_by")
    private String updatedBy;

}
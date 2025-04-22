package ObjectWin.com.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@Data
@AllArgsConstructor
public class SearchInputs {

    private String courseCategory;
    private String trainingMode;
    private String facultyName;
    private LocalDateTime startsOn;

    public void setCourseCategory(String courseCategory) {
        this.courseCategory = courseCategory;
    }

    public void setTrainingMode(String trainingMode) {
        this.trainingMode = trainingMode;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public void setStartsOn(LocalDateTime startsOn) {
        this.startsOn = startsOn;
    }

    public SearchInputs() {
        super();
    }
}

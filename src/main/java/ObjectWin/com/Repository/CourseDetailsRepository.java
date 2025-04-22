package ObjectWin.com.Repository;

import ObjectWin.com.Entity.CourseDetails;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CourseDetailsRepository extends JpaRepository<CourseDetails, Integer> {

    @Query("select distinct (courseCategory) from CourseDetails")
    public Set<String> getUniqueCourseCategories();

    @Query("select distinct (facultyName) from CourseDetails")
    public Set<String> getUniqueFacultyNames();

    @Query("select distinct (trainingMode) from CourseDetails")
    public Set<String> getUniqueTrainingModes();

//    List<CourseDetails> findAll(Example<CourseDetails> example);
}

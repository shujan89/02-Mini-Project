package ObjectWin.com.Controller;

import ObjectWin.com.Repository.CourseDetailsRepository;
import ObjectWin.com.Service.CourseMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/reporting/api")
public class CourseReportOperationsController {
    @Autowired
    private CourseMgmtService courseService;

    @GetMapping("/courses")
    public ResponseEntity<?> fetchCourseCategories() {
        try {
//            user service
            Set<String> courseCategories = courseService.showAllCourseCategories();
            return new ResponseEntity<Set<String>>(courseCategories, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/training-modes")
    public ResponseEntity<?> fetchTrainingModes() {
        try {
            Set<String> trainingModes = courseService.showAllTrainingModes();
            return new ResponseEntity<Set<String>>(trainingModes, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

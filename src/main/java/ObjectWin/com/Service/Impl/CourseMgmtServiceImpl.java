package ObjectWin.com.Service.Impl;

import ObjectWin.com.Entity.CourseDetails;
import ObjectWin.com.Model.SearchInputs;
import ObjectWin.com.Model.SearchResults;
import ObjectWin.com.Repository.CourseDetailsRepository;
import ObjectWin.com.Service.CourseMgmtService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import jakarta.servlet.ServletOutputStream;
import java.io.IOException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("courseService")
public class CourseMgmtServiceImpl implements CourseMgmtService {

    @Autowired
    private CourseDetailsRepository courseRepo;

    @Override
    public Set<String> showAllCourseCategories() {
        return courseRepo.getUniqueCourseCategories();

    }

    @Override
    public Set<String> showAllTrainingModes() {
        return courseRepo.getUniqueTrainingModes();
    }

    @Override
    public Set<String> showAllFaculties() {
        return courseRepo.getUniqueFacultyNames();
    }

    @Override
    public List<SearchResults> showCourseByFilters(SearchInputs inputs) {
        CourseDetails entity = new CourseDetails();

        String category = inputs.getCourseCategory();
        if (StringUtils.hasLength(category)) {
            entity.setCourseCategory(category);
        }

        String facultyName = inputs.getFacultyName();
        if (StringUtils.hasLength(facultyName)) {
            entity.setFacultyName(facultyName);
        }

        String trainingMode = inputs.getTrainingMode();
        if (StringUtils.hasLength(trainingMode)) {
            entity.setTrainingMode(trainingMode);
        }

        LocalDateTime startDate = inputs.getStartsOn();
        if (!ObjectUtils.isEmpty(startDate)) {
            entity.setStartDate(LocalDate.from(startDate));
        }

        Example<CourseDetails> example = Example.of(entity);

        List<CourseDetails> listEntities = courseRepo.findAll(example);
        List<SearchResults> listResults = new ArrayList<>();

        for (CourseDetails course : listEntities) {
            SearchResults result = new SearchResults();
            BeanUtils.copyProperties(course, result);
            listResults.add(result);
        }

        return listResults;
    }

    @Override
    public void generatePdf(SearchInputs inputs, HttpServletResponse response) {


    }

    @Override
    public void generateExcelReport(SearchInputs inputs, HttpServletResponse response) throws IOException {
//    get the search results
        List<SearchResults> list = showCourseByFilters(inputs);

//        create Excel workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        // create a sheet
        HSSFSheet sheet = ((HSSFWorkbook) workbook).createSheet("Course Details");

        // create a row and put some cells
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("Course ID");
        row.createCell(1).setCellValue("Course Name");
        row.createCell(2).setCellValue("Course Category");
        row.createCell(3).setCellValue("Faculty Name");
        row.createCell(4).setCellValue("Course Fees");
        row.createCell(5).setCellValue("Admin contact");
        row.createCell(6).setCellValue("Training Mode");
        row.createCell(7).setCellValue("Start Date");
        row.createCell(8).setCellValue("Location");
        row.createCell(9).setCellValue("Course Status");


        // create data rows
        int i = 1;
        for (SearchResults result : list) {
            HSSFRow dataRow = sheet.createRow(i++);
            dataRow.createCell(0).setCellValue(result.getCourseId());
            dataRow.createCell(1).setCellValue(result.getCourseName());
            dataRow.createCell(2).setCellValue(result.getCourseCategory());
            dataRow.createCell(3).setCellValue(result.getFacultyName());
            dataRow.createCell(4).setCellValue(result.getFee());
            dataRow.createCell(5).setCellValue(result.getAdminContact());
            dataRow.createCell(6).setCellValue(result.getTrainingMode());
            dataRow.createCell(7).setCellValue(result.getStartDate());
            dataRow.createCell(8).setCellValue(result.getLocation());
            dataRow.createCell(9).setCellValue(result.getCourseStatus());

        }
// Set response headers
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=CourseReport.xls");

        // Write to the output stream
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
    }

    @Override
    public void generatePdfReportAllData(HttpServletResponse response) {
        // get all course data
 /*       List<CourseDetails> list = courseRepo.findAll();
//        copy list<CourseDetails> to list<SearchResults>
        List<SearchResults> searchResultsList = new ArrayList<>();
        for (CourseDetails course : list) {
            SearchResults result = new SearchResults();
            BeanUtils.copyProperties(course, result);
            searchResultsList.add(result);
        }
//        create document object(open pdf)
        Document document = new Document(PageSize.A4);
//        get pdfWriter to write to the document and response obj
        PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());

  */
    }

    @Override
    public void generateExcelReportAllData(HttpServletResponse response) {

    }
}















package ObjectWin.com.Service;

import ObjectWin.com.Model.SearchInputs;
import ObjectWin.com.Model.SearchResults;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Set;

public interface CourseMgmtService {

    public Set<String> showAllCourseCategories();
    public Set<String> showAllTrainingModes();
    public Set<String> showAllFaculties();

    public List<SearchResults> showCourseByFilters(SearchInputs Inputs);

    public void generatePdf(SearchInputs inputs, HttpServletResponse response) throws Exception;
    public void generateExcelReport(SearchInputs inputs, HttpServletResponse response)throws Exception;

    public void generatePdfReportAllData(HttpServletResponse response) throws Exception;
    public void generateExcelReportAllData(HttpServletResponse response) throws Exception;

}

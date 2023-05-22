package Controller;

import Model.IssuedBook;
import DAO.IssueBookDao;

public class IssueBookController {

    private IssueBookDao issueDAO;

    public IssueController() {
        issueDAO = new IssueBookDao();
    }

    public void addIssue(int bookID, int userID, int period, String issuedDate) {
        IssuedBook issue = new IssuedBook(bookID, userID, period, issuedDate);
        issueDAO.addIssue(issue);
    }
}

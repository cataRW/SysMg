package main.java.controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.java.MainController;
import main.java.view.admin.AdminFixedPanel;


public class AdminFixedSideController {
	AdminFixedPanel adminFixedPart;

	public AdminFixedSideController() {
		adminFixedPart = new AdminFixedPanel();
		adminFixedPart.addAddPinButtonAction(getAddPinButtonAction());
		adminFixedPart.addAssignStudentButtonAction(getAssignStudentButtonAction());
		adminFixedPart.addAssignTeacherButtonAction(getAssignTeacherButtonAction());
		adminFixedPart.addDeleteAdminButtonAction(getDeleteAdminButtonAction());
		adminFixedPart.addDeleteTeacherButtonAction(getDeleteTeacherButtonAction());
		adminFixedPart.addCreateClassButtonAction(getCreateClassButtonAction());
		adminFixedPart.addCreateCourseButtonAction(getCreateCourseButtonAction());
		adminFixedPart.addDeleteStudentButtonAction(getDeleteStudentButtonAction());

	}

    public ActionListener getDeleteAdminButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.changeAdminSecondPanel(1);
            }
        };
    }

    public ActionListener getCreateCourseButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.changeAdminSecondPanel(2);
            }
        };
    }

    public ActionListener getAddPinButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.changeAdminSecondPanel(3);
            }
        };
    }
    
    public ActionListener getCreateClassButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.changeAdminSecondPanel(4);
            }
        };
    }

    public ActionListener getAssignTeacherButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.changeAdminSecondPanel(5);
            }
        };
    }

    public ActionListener getDeleteTeacherButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.changeAdminSecondPanel(6);
            }
        };
    }

    public ActionListener getAssignStudentButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MainController.changeAdminSecondPanel(7);
            }
        };
    }

    public ActionListener getDeleteStudentButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainController.changeAdminSecondPanel(8);
            }
        };
    }

    public ActionListener getModifyClassButtonAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	MainController.changeAdminSecondPanel(9);
            }
        };
    }
    
    public AdminFixedPanel getAdminFixedPanel() {
    	return adminFixedPart;
    }
}



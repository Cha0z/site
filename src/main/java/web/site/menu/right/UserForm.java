package web.site.menu.right;

import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.Arrays;
import java.util.List;

public class UserForm extends VerticalLayout {

    private TextField username = new TextField("Name your user");
    private NativeSelect<String> adminPrivilege = new NativeSelect<>("Select None");
    private NativeSelect<String> groupDirectory = new NativeSelect<>("Select None");
    private NativeSelect<String> permissions = new NativeSelect<>();
    HorizontalLayout addUserButtons = new HorizontalLayout();
    Button addUser = new Button("Add User");
    Button addAdvancedGroup = new Button("Add Advanced Group");

    private List<String> adminPrivilegeList;

    private List<String> groupDirectoryList;

    private List<String> permissionsList;

    public UserForm() {


        fillInformationToAllList();
        adminPrivilege.setItems(adminPrivilegeList);
        groupDirectory.setItems(groupDirectoryList);
        permissions.setItems(permissionsList);


        addUserButtons.addComponents(addUser, addAdvancedGroup);
        this.addComponents(username, adminPrivilege, groupDirectory, permissions, addUserButtons);


        addUser.setStyleName(ValoTheme.BUTTON_FRIENDLY);
        addAdvancedGroup.setStyleName(ValoTheme.BUTTON_BORDERLESS);


        adminPrivilege.setWidth("10em");
        groupDirectory.setWidth("10em");
        permissions.setWidth("10em");

        this.setMargin(new MarginInfo(true, true, true, true));


    }

    private void fillInformationToAllList() {
        adminPrivilegeList = Arrays.asList("First privilege", "Second privilege");
        groupDirectoryList = Arrays.asList("Group 1", "Group 2");
        permissionsList = Arrays.asList("Read,Write", "Read", "Write");
    }
}

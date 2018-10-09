package web.site.workfield.leftverticalfield;

import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import web.site.workfield.chart.TimeChart;

import java.util.Arrays;
import java.util.List;

public class ActivityField extends VerticalLayout {

    List<String> timeList;
    TimeChart timeChart = new TimeChart();

    public ActivityField() {
        timeList = Arrays.asList("12 am", "1 am", "2 am", "3 am", "4 am", "5 am", "6 am", "7 am", "8 am", "9 am", "10 am", "11 am"
                , "12 pm", "1 pm", "2 pm", "3 pm", "4 pm", "5 pm", "6 pm", "7 pm", "8 pm", "9 pm", "10 pm", "11 pm");

        configHorizontalField();
        HorizontalLayout recentActivityField = new HorizontalLayout();
        recentActivityField.setWidth("100%");



        VerticalLayout activityMessage = new VerticalLayout();


        Label firstLine = new Label("Recent ActivityField");
        Label secondLine = new Label("number of active users on the systems");

        activityMessage.addComponents(firstLine, secondLine);

        configActivityMessage(activityMessage, firstLine, secondLine);





        HorizontalLayout timeContainer = new HorizontalLayout();
        timeContainer.setMargin(new MarginInfo(false,true,false,false));
        ComboBox<String> timeBox = new ComboBox<>();
        Label to = new Label("to");
        ComboBox<String> timeBox2 = new ComboBox<>();

        timeContainer.addComponents(timeBox, to, timeBox2);
        configTimeBox(timeBox, timeBox2);

    //    Image chart = new Image(null, new ClassResource("/dashboard.png"));



        recentActivityField.addComponents(activityMessage, timeContainer);


        this.addComponents(recentActivityField, chart);
        recentActivityField.setComponentAlignment(timeContainer,Alignment.MIDDLE_RIGHT);
        this.setComponentAlignment(chart,Alignment.MIDDLE_CENTER);


    }

    private void configActivityMessage(VerticalLayout activityMessage, Label firstLine, Label secondLine) {
        activityMessage.setMargin(new MarginInfo(false,false,false,true));
        activityMessage.setSpacing(false);
        firstLine.setStyleName(ValoTheme.LABEL_COLORED);
        firstLine.setStyleName(ValoTheme.LABEL_LARGE);
        secondLine.setStyleName(ValoTheme.LABEL_LIGHT);
        secondLine.setStyleName(ValoTheme.LABEL_SMALL);
    }

    private void configTimeBox(ComboBox<String> timeBox, ComboBox<String> timeBox2) {
        timeBox.setStyleName(ValoTheme.COMBOBOX_SMALL);
        timeBox.setItems(timeList);
        timeBox.setWidth("7em");
        timeBox2.setItems(timeList);
        timeBox2.setWidth("7em");
        timeBox2.setStyleName(ValoTheme.COMBOBOX_SMALL);
    }

    private void configHorizontalField() {
        this.setSpacing(false);
        this.setMargin(false);
    }

}
